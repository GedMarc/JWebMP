/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.base.servlets;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import za.co.mmagon.SiteBinder;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.client.Browsers;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.PreFormattedText;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.exceptions.MissingComponentException;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The base Servlet for the JWebSwing environment. Constructs each page on call
 *
 * @author Marc Magon
 * @version 1.1
 * @since 2012/10/09
 */
@Singleton
public class JWebSwingServlet extends JWDefaultServlet
{

	/**
	 * The logger for the swing Servlet
	 */
	private static final Logger log = LogFactory.getInstance().getLogger("JWebSwingServlet");
	/**
	 * The logger for the session handler Servlet
	 */
	private static final Logger SESSION_LOG = LogFactory.getInstance().getLogger("SessionHandler");

	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new JWebSwing Servlet that is not session aware
	 */
	public JWebSwingServlet()
	{
		//Nothing Needed
	}

	/**
	 * In the event of any error return this page.
	 *
	 * @param t
	 * 		The exception thrown
	 *
	 * @return The rendered HTML.
	 */
	@Provides
	@Named("ErrorPage")
	@RequestScoped
	protected Page getErrorPageHtml(Error t)
	{
		Page p = new Page();
		p.getPageFields().setTitle("ERROR : Error occured in application");
		p.getPageFields().setAuthor("Marc Magon");
		p.getPageFields().setDescription("JWebSwing Error Generated Page");
		p.getPageFields().setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
		Body b = p.getBody();
		b.add("The following error was encountered during render<br/><hr/>");
		b.add(new PreFormattedText(TextUtilities.stackTraceToString(t)));
		return p;
	}

	/**
	 * Reads the variables into the HTTP session
	 *
	 * @param request
	 *
	 * @throws MissingComponentException
	 */
	private void readRequestVariables(HttpServletRequest request) throws MissingComponentException
	{
		Page currentPage = getPageFromGuice();
		HttpSession session = GuiceContext.inject().getInstance(HttpSession.class);
		if (currentPage == null)
		{
			throw new MissingComponentException("[No Page]-[getPage() returning null in servlet class]");
		}
		if (session.isNew())
		{
			SESSION_LOG.log(Level.FINE, "[SessionID]-[{0}];[Name]-[User Login];[Action]-[Session Page Added];", request.getSession().getId());
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 * 		Servlet request
	 * @param response
	 * 		Servlet response
	 *
	 * @throws ServletException
	 * 		if a Servlet-specific error occurs
	 * @throws IOException
	 * 		if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			super.doGet(request, response);
			if (request.getHeader("Content-Type") == null || request.getHeader("Content-Type").isEmpty())
			{
				processRequest(request, response);
			}
		}
		catch (IOException | ServletException ex)
		{
			log.log(Level.SEVERE, "SwingServlet", ex);
		}
	}

	/**
	 * Processes requests for the WebSwing Servlet.
	 *
	 * @param request
	 * 		The Default Servlet request
	 * @param response
	 * 		The Default Servlet response
	 *
	 * @throws ServletException
	 * 		if a Servlet-specific error occurs
	 * @throws IOException
	 * 		if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		if (GuiceContext.isBuildingInjector())
		{
			log.fine("Guice is still building, ignoring this request");
			return;
		}

		try
		{
			readRequestVariables(request);
			readBrowserInformation(request);
			sendPage(request, response);
		}
		catch (MissingComponentException mce)
		{
			log.log(Level.SEVERE, "No Page For Servlet", mce);
			Page p = new Page();
			p.getBody().add("No Page or Body Configured for the JWebSwingServlet. [getPage()] returned nothing");
			response.getWriter().write(p.toString(true));
		}
		catch (IOException | NumberFormatException ex)
		{

			log.log(Level.SEVERE, "Couldn't Render Page in Servlet. Fatal Error.", ex);
			response.setContentType(StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE);
			try (PrintWriter out = response.getWriter())
			{
				out.println(getErrorPageHtml(ex).toString(true));
			}
			catch (IOException ex1)
			{
				log.log(Level.SEVERE, "Unable to generate page html to return!", ex1);
			}
		}
		catch (Exception t)
		{
			log.log(Level.SEVERE, "Unable to render page", t);
			response.setContentType(StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE);
			PrintWriter out = null;
			try
			{
				out = response.getWriter();
				out.println(getErrorPageHtml(t).toString(true));
			}
			catch (IOException ex1)
			{
				log.log(Level.SEVERE, "Unable to generate page html to return!", ex1);
			}
			finally
			{
				try
				{
					if (out != null)
					{
						out.close();
					}
				}
				catch (Exception e)
				{
					log.log(Level.SEVERE, null, e);
				}
			}
		}
	}

	/**
	 * Reads the user agent header into the browser object and places it for the page to render
	 *
	 * @param request
	 */
	private void readBrowserInformation(HttpServletRequest request)
	{
		String headerInformation = request.getHeader("User-Agent");
		ReadableUserAgent agent = GuiceContext.inject().getInstance(UserAgentStringParser.class).parse(headerInformation);
		getPageFromGuice().setUserAgent(agent);
		Browsers b;
		if (agent.getVersionNumber().getMajor().isEmpty() && agent.getVersionNumber().getMinor().isEmpty())
		{
			b = Browsers.getBrowserFromNameAndVersion("Edge", 13);
		}
		else
		{
			b = Browsers.getBrowserFromNameAndVersion(agent.getName(), Double.parseDouble(agent.getVersionNumber().getMajor() + "." + agent.getVersionNumber().getMinor()));
		}
		getPageFromGuice().setBrowser(b);

		if (agent.getVersionNumber().getMajor() == null || agent.getVersionNumber().getMajor().isEmpty())
		{
			log.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}];[Operating System]-[{3}];[Device Category]-[{4}];[Device]-[{5}];[CSS]-[{6}];[HTML]-[{7}];", new Object[]
					                                                                                                                                                                   {
							                                                                                                                                                                   request.getSession().getId(), b.getBrowserGroup().toString(), b.getBrowserVersion(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()
					                                                                                                                                                                   });
		}
		else
		{
			log.log(Level.INFO, "[SessionID]-[{0}];[Browser]-[{1}];[Version]-[{2}.{3}];[Operating System]-[{4}];[Device Category]-[{5}];[Device]-[{6}];[CSS]-[{7}];[HTML]-[{8}];", new Object[]
					                                                                                                                                                                       {
							                                                                                                                                                                       request.getSession().getId(), agent.getName(), agent.getVersionNumber().getMajor(), agent.getVersionNumber().getMinor(), agent.getOperatingSystem().getName(), agent.getDeviceCategory().getCategory(), agent.getDeviceCategory().getName(), b.getCapableCSSVersion(), b.getHtmlVersion()
					                                                                                                                                                                       });
		}
	}

	/**
	 * Sends the page out
	 *
	 * @param request
	 * @param response
	 *
	 * @throws IOException
	 */
	private void sendPage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType(StaticStrings.HTML_HEADER_DEFAULT_CONTENT_TYPE);
		try (PrintWriter out = response.getWriter())
		{
			Date startDate = new Date();
			StringBuilder output;
			if (!GuiceContext.isBuildingInjector())
			{
				intercept();
			}
			Page page = getPageFromGuice();
			if (page.getOptions().isGoogleMapsJSApi())
			{
				page.getBody().addJavaScriptReference(new JavascriptReference("Google Maps API Reference", 1.0, "https://maps.googleapis.com/maps/api/js?key=" + page.getOptions().getGoogleMapsJSApi()));
			}
			output = getPageHTML();

			Date endDate = new Date();
			Date transferStart = new Date();
			out.println(output);
			Date dataTransferDate = new Date();
			log.log(Level.FINE, "[SessionID]-[{0}];[Render Time]-[{1}];[Data Size]-[{2}];[Transer Time]=[{3}]", new Object[]
					                                                                                                    {
							                                                                                                    request.getSession().getId(), endDate.getTime() - startDate.getTime(), output.length(), dataTransferDate.getTime() - transferStart.getTime()
					                                                                                                    });
		}
		catch (IOException ex)
		{
			log.log(Level.SEVERE, "[Network]-[Connection Dead]", ex);
			throw ex;
		}
	}

	/**
	 * In the event of any error return this page.
	 *
	 * @param t
	 * 		The exception thrown
	 *
	 * @return The rendered HTML.
	 */
	protected Page getErrorPageHtml(Throwable t)
	{
		Page p = new Page();
		p.getPageFields().setTitle("Exception occured in application");
		p.getPageFields().setAuthor("Marc Magon");
		p.getPageFields().setDescription("JWebSwing Error Generated Page");
		p.getPageFields().setGenerator("JWebSwing - https://sourceforge.net/projects/jwebswing/");
		Body b = p.getBody();
		b.add("The following error was encountered during render<br/><hr/>");
		b.add(new PreFormattedText(TextUtilities.stackTraceToString(t)));
		return p;
	}

	/**
	 * Finds the page for the current URL
	 *
	 * @return
	 */
	private Page getPageFromGuice()
	{
		if (!GuiceContext.isBuildingInjector())
		{
			return GuiceContext.inject().getInstance(Page.class);
		}
		return new Page();
	}

	@SiteInterception
	protected void intercept()
	{
		//Interception Method
	}

	/**
	 * Return the Mobile Page HTML
	 *
	 * @param session
	 *
	 * @return
	 */
	@Provides
	@Named("MobilePage")
	@RequestScoped
	protected StringBuilder getPageMobileHTML(HttpSession session)
	{
		log.log(Level.FINE, "Started Rendering Mobile HTML");
		StringBuilder html;
		html = new StringBuilder(getPageFromGuice().toString(true));
		return html;
	}

	/**
	 * Generates the Page HTML
	 *
	 * @return
	 */
	private StringBuilder getPageHTML()
	{
		StringBuilder html;
		html = new StringBuilder(getPageFromGuice().toString(true));
		return html;
	}

	@Override
	public void destroy()
	{
		try
		{
			log.log(Level.INFO, "Destroying Servlet JWebSwing Servlet and all Static Objects");
			GuiceContext.inject().getInstance(UserAgentStringParser.class).shutdown();
			Set<Class<? extends Page>> pages = SiteBinder.getPages();
			for (Class<? extends Page> page : pages)
			{
				if (page.equals(Page.class) || Modifier.isAbstract(page.getModifiers()))
				{
					continue;
				}
				Page p = (Page) GuiceContext.getInstance(page);
				p.destroy();
			}

			GuiceContext.destroy();
			log.log(Level.INFO, "User Agent Parser Shutdown");
		}
		catch (Exception t)
		{
			log.log(Level.SEVERE, "Unable to destroy", t);
		}
		super.destroy();
	}
}

package com.jwebmp.core.implementations;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.base.servlets.JWScriptServlet;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IDynamicRenderingServlet;
import com.guicedee.guicedinjection.json.StaticStrings;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static com.guicedee.guicedinjection.GuiceContext.*;

public class JWebMPDynamicScriptRenderer
		implements IDynamicRenderingServlet<JWebMPDynamicScriptRenderer>
{
	@Override
	public String getScriptLocation(Page<?> page)
	{
		String queryParams = "";
		try
		{
			HttpServletRequest hsr = get(HttpServletRequest.class);
			queryParams = hsr.getQueryString();
		}
		catch (Throwable T)
		{
		
		}
		return JWebMPSiteBinder.getJWScriptLocation()
		                       .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?" + queryParams  + "&dt=" + LocalDateTime.now();
	}

	@Override
	public Script<?,?> renderScript(Page<?> page)
	{
		return getSiteLoaderScript();
	}

	/**
	 * Method getSiteLoaderScript returns the siteLoaderScript of this ScriptsDynamicPageConfigurator object.
	 *
	 * @return the siteLoaderScript (type Script<?,?>) of this ScriptsDynamicPageConfigurator object.
	 */
	private Script<?, ?> getSiteLoaderScript()
	{
		FileTemplates.getFileTemplate(JWScriptServlet.class, JWScriptServlet.FILE_TEMPLATE_NAME, "siteloader");
		FileTemplates.getTemplateVariables()
		             .put("SITEADDRESSINSERT", new StringBuilder(SessionHelper.getServerPath()));
		StringBuilder jsScript = FileTemplates.renderTemplateScripts(JWScriptServlet.FILE_TEMPLATE_NAME);
		if (!jsScript.toString()
		             .trim()
		             .isEmpty())
		{
			return newScript(jsScript.toString());
		}
		return new Script<>().setText("could not find site loader script");
	}

	/**
	 * Default Sort Order INTEGER.MAX - 1000
	 *
	 * @return INTEGER.MAX - 1000
	 */
	@Override
	public Integer sortOrder()
	{
		return Integer.MAX_VALUE - 1000;
	}

	@Override
	public boolean enabled()
	{
		return JQueryPageConfigurator.isRequired() && JQueryPageConfigurator.isEnabled();
	}
}

package za.co.mmagon.jwebswing.base.html;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.logging.Level;
import java.util.logging.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.CSSLinkAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HeadChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * The Header CSSLink Component
 * <p>
 * @since 2013/11/12
 * @version 1.0
 * @author MMagon
 *
 * <p>
 *
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * When used for style sheets, the link tag is supported in all major browsers.<p>
 * No real support for anything else. Definition and Usage<p>
 * <p>
 * The link tag defines the relationship between a document and an external<p>
 * resource.<p>
 * <p>
 * The link tag is most used to link to style sheets.<p>
 * <p>
 * Note: The link element is an empty element, it contains attributes only.<p>
 * <p>
 * Note: This element goes only in the head section, but it can appear any<p>
 * number of times. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Some HTML 4.01 attributes are not supported in HTML5.<p>
 * <p>
 * The "sizes" attribute is new in HTML5.<p>
 *
 */
public class CSSLink extends Component<NoChildren, CSSLinkAttributes, NoFeatures, NoEvents, Component> implements NoIDTag, NoClosingTag, HeadChildren
{

    private static final Logger LOG = LogFactory.getInstance().getLogger("<link>");
    private static final long serialVersionUID = 1L;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean themeLink;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean prettifyTheme;
    private CSSReference linkedReference;

    /**
     * Constructs a new Head Link
     *
     * @param linkedReference
     */
    public CSSLink(CSSReference linkedReference)
    {
        this(linkedReference.toString());
        this.linkedReference = linkedReference;

    }

    /**
     * The CSS file link
     *
     * @param cssFile The file to route
     */
    public CSSLink(String cssFile)
    {
        super("link", ComponentTypes.CSSLink);
        addAttribute(CSSLinkAttributes.Type, "text/css");
        addAttribute(CSSLinkAttributes.Rel, "stylesheet");
        addAttribute(CSSLinkAttributes.HRef, cssFile);
    }

    /**
     * Differences Between HTML and XHTML
     * <p>
     * In HTML the base tag has no end tag.
     * <p>
     * In XHTML the base tag must be properly closed.
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getBrowser().getHtmlVersion().name().startsWith("X"))
            {
                setInlineClosingTag(true);
                //System.out.println("Set base to close on in line tag");
            }
        }
        catch (Exception e)
        {
            LOG.log(Level.WARNING, "Unable to determine whether XHTML or HTML. Will still render correctly, just not W3 Compliant.", e);
        }

        //add theme class name
        /*
         * if (isThemeLink()) { addClass(Theme.themeClassIdentifier); }
         */
        //add theme class name
        if (isPrettifyTheme())
        {
            addClass("prettify");
        }
    }

    /**
     * Is a valid equals clause
     * <p>
     * @param obj <p>
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof CSSLink))
        {
            return false;
        }
        final CSSLink lin = (CSSLink) obj;

        return this.getAttribute(CSSLinkAttributes.HRef).equals(lin.getAttribute(CSSLinkAttributes.HRef));
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        return hash;
    }

    /**
     * TODO remove this
     *
     * @deprecated
     * @return
     */
    public boolean isThemeLink()
    {
        if (getAttribute(CSSLinkAttributes.HRef).contains("_theme"))
        {
            themeLink = true;
        }
        return themeLink;
    }

    /**
     * TODO remove this
     *
     * @deprecated
     * @param themeLink
     */
    public void setThemeLink(boolean themeLink)
    {
        this.themeLink = themeLink;
    }

    /**
     * Gets the prettify theme TODO remove this
     *
     * @deprecated
     * @return
     */
    public boolean isPrettifyTheme()
    {
        if (getAttribute(CSSLinkAttributes.HRef).contains("prettify/"))
        {
            prettifyTheme = true;
        }
        return prettifyTheme;
    }

    /**
     * Sets the prettify theme if required TODO remove this
     *
     * @deprecated
     *
     * @param prettifyTheme
     */
    public void setPrettifyTheme(boolean prettifyTheme)
    {
        this.prettifyTheme = prettifyTheme;
    }

    /**
     * Returns the linked reference if any for the link
     *
     * @return
     */
    public CSSReference getLinkedReference()
    {
        return linkedReference;
    }

    /**
     * Returns the linked reference if any for the link
     *
     * @param linkedReference
     */
    public void setLinkedReference(CSSReference linkedReference)
    {
        this.linkedReference = linkedReference;
    }

}

package za.co.mmagon.jwebswing.components.jqxwidgets.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * Implements the UI Darkness Theme
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class MetroTheme extends Theme
{

    public MetroTheme()
    {
        super("Metro Theme", "jqxmetro");
        getCssReferences().add(new CSSReference("JQXmetroTheme", 3.91, "bower_components/jqwidgets/jqwidgets/styles/jqx.metro.css", "https://jqwidgets.com/public/jqwidgets/styles/jqx.metro.css"));

    }

}
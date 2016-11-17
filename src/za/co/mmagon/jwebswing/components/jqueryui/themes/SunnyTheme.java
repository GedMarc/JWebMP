package za.co.mmagon.jwebswing.components.jqueryui.themes;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;

/**
 * The Start Theme from JQuery Theme Roller
 *
 * @since 2014/07/05
 * @version 1.0
 * @author MMagon
 *
 *
 */
class SunnyTheme extends Theme
{

    public SunnyTheme()
    {
        super("Sunny", "uisunny", "css/theming/images/theme_30_sunny.png", "", "css/theming/images/theme_30_sunny.png");
        getCssReferences().add(new CSSReference("sunnyTheme", 1.114, "css/theming/ui_sunny_theme.css", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/sunny/jquery-ui.css"));
    }
}
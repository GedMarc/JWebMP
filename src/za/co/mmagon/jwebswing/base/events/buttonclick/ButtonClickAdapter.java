package za.co.mmagon.jwebswing.base.events.buttonclick;

import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.ajax.*;
import za.co.mmagon.jwebswing.base.angular.*;
import za.co.mmagon.jwebswing.components.jqueryui.selectable.*;
import za.co.mmagon.jwebswing.components.jqxwidgets.buttongroup.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.*;

/**
 * This event is triggered when a button is clicked.
 *
 * @author Marc Magon
 */
public abstract class ButtonClickAdapter extends Event
        implements JQUISelectableEvents, JQXButtonGroupEvents
{

    private static final long serialVersionUID = 1L;
    private ButtonClickDirective directive;

    /**
     * This event is triggered when a button is clicked.
     *
     * @param component The component this click is going to be acting on
     */
    public ButtonClickAdapter(Component component)
    {
        super(EventTypes.buttonClickEvent, component);
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().getOptions().setjQueryEnabled(true);
            getComponent().getPage().getOptions().setAngularEnabled(true);
            getComponent().getPage().getAngular().addDirective(getDirective());
            component.addAttribute(AngularAttributes.ngButtonClick, "perform($event," + renderVariables() + ");");
        }
        super.preConfigure();
    }

    /**
     * Triggers on Activation
     * <p>
     * @param ajaxObject   The physical AJAX call
     * @param ajaxReceiver The physical Ajax Receiver
     */
    public abstract void onButtonClick(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

    /**
     * The method that is fired on call
     *
     * @param ajaxObject   The component that made the call
     * @param ajaxReceiver The Response Object Being Returned
     */
    @Override
    public void fireEvent(AjaxCall ajaxObject, AjaxResponse ajaxReceiver)
    {
        onButtonClick(ajaxObject, ajaxReceiver);
    }

    /**
     * Returns this directive
     *
     * @return
     */
    public ButtonClickDirective getDirective()
    {
        if (directive == null)
        {
            setDirective(new ButtonClickDirective(getComponent().getPage().getAngular()));
        }
        return directive;
    }

    /**
     * Sets this directive
     *
     * @param directive
     */
    public void setDirective(ButtonClickDirective directive)
    {
        this.directive = directive;
    }

}

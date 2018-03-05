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
package za.co.mmagon.jwebswing.events.buttonclick;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.EventTypes;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_ANGULAR_EVENT_START;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;

/**
 * This event is triggered when a button is clicked.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Button Event",
		description = "Server Side Event for Button Click Event.",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebSwing/wiki")
public abstract class ButtonClickAdapter
		extends Event
		implements Serializable
{

	private static final long serialVersionUID = 1L;
	private ButtonClickDirective directive;

	/**
	 * This event is triggered when a button is clicked.
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public ButtonClickAdapter(Component component)
	{
		super(EventTypes.buttonClickEvent, component);
	}

	/**
	 * The method that is fired on call
	 *
	 * @param ajaxObject
	 * 		The component that made the call
	 * @param ajaxReceiver
	 * 		The Response Object Being Returned
	 */
	@Override
	public void fireEvent(AjaxCall ajaxObject, AjaxResponse ajaxReceiver)
	{
		onButtonClick(ajaxObject, ajaxReceiver);
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
			AngularPageConfigurator.setRequired(true);

			getComponent().addAttribute(AngularAttributes.ngButtonClick,
			                            STRING_ANGULAR_EVENT_START + renderVariables() + STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ButtonClickAdapter))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		ButtonClickAdapter that = (ButtonClickAdapter) o;
		return Objects.equals(getComponent(), that.getComponent());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), getComponent());
	}

	/**
	 * Triggers on Activation
	 * <p>
	 *
	 * @param ajaxObject
	 * 		The physical AJAX call
	 * @param ajaxReceiver
	 * 		The physical Ajax Receiver
	 */
	public abstract void onButtonClick(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

	/**
	 * Returns this directive
	 *
	 * @return
	 */
	@NotNull
	public ButtonClickDirective getDirective()
	{
		if (directive == null)
		{
			setDirective(new ButtonClickDirective());
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

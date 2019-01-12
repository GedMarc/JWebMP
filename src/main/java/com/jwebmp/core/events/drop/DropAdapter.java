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
package com.jwebmp.core.events.drop;

import com.jwebmp.core.Component;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "DropEvent",
		description = "Server Side Event for Drop",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebMP/wiki")
public abstract class DropAdapter<J extends DropAdapter<J>>
		extends Event<GlobalFeatures, J>
		implements GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("DropEvent");

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public DropAdapter(Component component)
	{
		super(EventTypes.drop, component);

	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onDrop(call, response);
			onCall();
		}
		catch (Exception e)
		{
			DropAdapter.LOG.log(Level.SEVERE, "Error In Firing Event", e);
		}
	}

	/**
	 * Triggers on Drop
	 * <p>
	 *
	 * @param call
	 * 		The physical AJAX call
	 * @param response
	 * 		The physical Ajax Receiver
	 */
	public abstract void onDrop(AjaxCall call, AjaxResponse response);

	/**
	 * Method onCall ...
	 */
	private void onCall()
	{
		Set<IOnDropService> services = GuiceContext.instance()
		                                           .getLoader(IOnDropService.class, ServiceLoader.load(IOnDropService.class));
		services.forEach(service -> service.onCall(this));
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			onCreate();
		}
		super.preConfigure();
	}

	/**
	 * Occurs when the event is called
	 */
	@SuppressWarnings("unchecked")
	private void onCreate()
	{
		Set<IOnDropService> services = GuiceContext.instance()
		                                           .getLoader(IOnDropService.class, ServiceLoader.load(IOnDropService.class));
		services.forEach(service -> service.onCreate(this));
	}

}

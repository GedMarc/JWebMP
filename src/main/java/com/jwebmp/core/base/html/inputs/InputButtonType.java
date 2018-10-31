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
package com.jwebmp.core.base.html.inputs;

import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.attributes.InputButtonTypeAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class InputButtonType<J extends InputButtonType<J>>
		extends Input<InputButtonTypeAttributes, J>
{


	/**
	 * Constructs a new instance of a button type
	 */
	public InputButtonType()
	{
		this(null);
	}

	/**
	 * Constructs a new button with the given text
	 *
	 * @param text
	 */
	public InputButtonType(String text)
	{
		super(InputTypes.Button);
		addAttribute(InputButtonTypeAttributes.Value, text);
	}

}

/*
 * Copyright (C) 2016 GedMarc
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
package com.jwebmp.core.htmlbuilder.css.image;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;

/**
 * Any default image
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
public class ImageCSSImpl
		extends CSSImplementationAdapter<ImageCSS, ImageCSSImpl>
		implements CSSImplementationClass<ImageCSS, ImageCSSImpl>

{


	private String value;

	/**
	 * Constructs a new instance of the image CSS
	 */
	public ImageCSSImpl()
	{
	}

	/**
	 * Constructs a new image with the given URL
	 *
	 * @param url
	 */
	public ImageCSSImpl(String url)
	{
		value = url;
	}

	@Override
	@JsonValue
	public String toString()
	{
		if (value == null || value.isEmpty())
		{
			return "";
		}
		else
		{
			return "url('" + value + "')";
		}
	}

	/**
	 * Returns the raw value
	 *
	 * @return
	 */
	public String value()
	{
		return value;
	}

}

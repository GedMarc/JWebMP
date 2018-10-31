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
package com.jwebmp.core.htmlbuilder.css.heightwidth;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementTypes;

/**
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class HeightWidthCSSImpl
		extends CSSImplementationAdapter<HeightWidthCSS, HeightWidthCSSImpl>
		implements CSSImplementationClass<HeightWidthCSS, HeightWidthCSSImpl>
{


	@CSSDetail(cssName = "height",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl height;
	@CSSDetail(cssName = "height",
			cssVersion = CSSVersions.CSS21)
	private HeightSetting height$;
	@CSSDetail(cssName = "width",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl width;
	@CSSDetail(cssName = "width",
			cssVersion = CSSVersions.CSS21)
	private WidthSetting width$;
	@CSSDetail(cssName = "min-height",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl minHeight;
	@CSSDetail(cssName = "max-height",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl maxHeight;
	@CSSDetail(cssName = "min-width",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl minWidth;
	@CSSDetail(cssName = "max-width",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl maxWidth;

	/**
	 * Constructs a new Height and Width Setting
	 */
	public HeightWidthCSSImpl()
	{
		//No configuration needed
	}

	/**
	 * Sets the height of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getHeight()
	{
		return height;
	}

	/**
	 * Sets the height of an element
	 *
	 * @param Height
	 */
	public void setHeight(MeasurementCSSImpl Height)
	{
		height = Height;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setHeight(int Width)
	{
		setHeight(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setHeight(int Width, MeasurementTypes measurementType)
	{
		setHeight(new MeasurementCSSImpl(Width, measurementType));
	}

	/**
	 * Sets the height of an element
	 *
	 * @return
	 */
	public HeightSetting getHeight$()
	{
		return height$;
	}

	/**
	 * Sets the height of an element
	 *
	 * @param Height$
	 */
	public void setHeight$(HeightSetting Height$)
	{
		height$ = Height$;
	}

	/**
	 * Sets the width of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getWidth()
	{
		return width;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param Width
	 */
	public void setWidth(MeasurementCSSImpl Width)
	{
		width = Width;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setWidth(int Width)
	{
		setWidth(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setWidth(int Width, MeasurementTypes measurementType)
	{
		setWidth(new MeasurementCSSImpl(Width, measurementType));
	}

	/**
	 * Sets the width of an element
	 *
	 * @return
	 */
	public WidthSetting getWidth$()
	{
		return width$;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param Width$
	 */
	public void setWidth$(WidthSetting Width$)
	{
		width$ = Width$;
	}

	/**
	 * Sets the min height of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMinHeight()
	{
		return minHeight;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param minHeight
	 */
	public void setMinHeight(MeasurementCSSImpl minHeight)
	{
		this.minHeight = minHeight;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setMinHeight(int Width)
	{
		setMinHeight(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setMinHeight(int Width, MeasurementTypes measurementType)
	{
		setMinHeight(new MeasurementCSSImpl(Width, measurementType));
	}

	/**
	 * Sets the max height of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMaxHeight()
	{
		return maxHeight;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param maxHeight
	 */
	public void setMaxHeight(MeasurementCSSImpl maxHeight)
	{
		this.maxHeight = maxHeight;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setMaxHeight(int Width)
	{
		setMaxHeight(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setMaxHeight(int Width, MeasurementTypes measurementType)
	{
		setMaxHeight(new MeasurementCSSImpl(Width, measurementType));
	}

	/**
	 * Sets the min width of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMinWidth()
	{
		return minWidth;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param minWidth
	 */
	public void setMinWidth(MeasurementCSSImpl minWidth)
	{
		this.minWidth = minWidth;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setMinWidth(int Width)
	{
		setMinWidth(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setMinWidth(int Width, MeasurementTypes measurementType)
	{
		setMinWidth(new MeasurementCSSImpl(Width, measurementType));
	}

	/**
	 * Sets the max height of an element
	 *
	 * @return
	 */
	public MeasurementCSSImpl getMaxWidth()
	{
		return maxWidth;
	}

	/**
	 * Sets the width of an element
	 *
	 * @param maxWidth
	 */
	public void setMaxWidth(MeasurementCSSImpl maxWidth)
	{
		this.maxWidth = maxWidth;
	}

	/**
	 * Convenience method setting the inner HTML value - Default of Pixels
	 * <p>
	 *
	 * @param Width
	 * 		getWidth
	 */
	public void setMaxWidth(int Width)
	{
		setMaxWidth(Width, MeasurementTypes.Pixels);
	}

	/**
	 * Convenience method setting the getWidth
	 * <p>
	 *
	 * @param Width
	 * 		The width to set
	 * @param measurementType
	 * 		The measurement type
	 */
	public void setMaxWidth(int Width, MeasurementTypes measurementType)
	{
		setMaxWidth(new MeasurementCSSImpl(Width, measurementType));
	}

}

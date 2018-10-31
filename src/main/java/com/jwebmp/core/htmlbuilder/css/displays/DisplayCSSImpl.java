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
package com.jwebmp.core.htmlbuilder.css.displays;

import com.jwebmp.core.base.client.CSSVersions;
import com.jwebmp.core.htmlbuilder.css.CSSDetail;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationAdapter;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 * The display property is the most important CSS property for controlling layout.
 *
 * @author GedMarc
 * @since 18 Jan 2016
 */
public class DisplayCSSImpl
		extends CSSImplementationAdapter<DisplayCSS, DisplayCSSImpl>
		implements CSSImplementationClass<DisplayCSS, DisplayCSSImpl>
{


	@CSSDetail(cssName = "display",
			cssVersion = CSSVersions.CSS21)
	private Displays display;
	@CSSDetail(cssName = "cursor",
			cssVersion = CSSVersions.CSS21)
	private Cursors oursor;
	@CSSDetail(cssName = "overflow",
			cssVersion = CSSVersions.CSS21)
	private Overflows overflow;
	@CSSDetail(cssName = "overflow-x",
			cssVersion = CSSVersions.CSS21)
	private Overflows overflowX;
	@CSSDetail(cssName = "overflow-y",
			cssVersion = CSSVersions.CSS21)
	private Overflows overflowY;
	@CSSDetail(cssName = "position",
			cssVersion = CSSVersions.CSS21)
	private Positions position;
	@CSSDetail(cssName = "float",
			cssVersion = CSSVersions.CSS21)
	private Floats floatProperty;
	@CSSDetail(cssName = "z-index",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl zIndex;
	@CSSDetail(cssName = "bottom",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl bottom;
	@CSSDetail(cssName = "left",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl left;
	@CSSDetail(cssName = "displayright",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl right;
	@CSSDetail(cssName = "top",
			cssVersion = CSSVersions.CSS21)
	private MeasurementCSSImpl top;

	/**
	 * New instance of the Impl
	 */
	public DisplayCSSImpl()
	{
		//Nothing Needed
	}

	/**
	 * Sets the display Format The display Property
	 * <p>
	 * The display property specifies if/how an element is displayed.
	 * <p>
	 * Every HTML element has a default display value depending on what type of element it is. The default display value for most elements is block or inline. Block-level Elements
	 * <p>
	 * A block-level element always starts on a new line and takes up the full width available (stretches out to the left and right as far as it can). The &lt;div&gt; element is a
	 * block-level element.
	 * <p>
	 * Examples of block-level elements:
	 * <p>
	 * &lt;div&gt; &lt;h1&gt; - &lt;h6&gt;
	 * <p>
	 * &lt;form&gt; &lt;header&gt; &lt;footer&gt; &lt;section&gt;
	 * <p>
	 * Inline Elements
	 * <p>
	 * An inline element does not start on a new line and only takes up as much width as necessary.
	 * <p>
	 * This is an inline &lt;span&gt; element inside a paragraph.
	 * <p>
	 * Examples of inline elements:
	 * <p>
	 * &lt;span&gt; &lt;a&gt; &lt;img&gt;
	 *
	 * @return
	 */
	public Displays getDisplay()
	{
		return display;
	}

	/**
	 * Sets the display
	 *
	 * @param display
	 */
	public void setDisplay(Displays display)
	{
		this.display = display;
	}

	/**
	 * Sets the mouse cursor
	 *
	 * @return
	 */
	public Cursors getCursor()
	{
		return oursor;
	}

	/**
	 * Sets the overflow
	 *
	 * @return
	 */
	public Overflows getOverflow()
	{
		return overflow;
	}

	/**
	 * Sets the overflow
	 *
	 * @param overflow
	 */
	public void setOverflow(Overflows overflow)
	{
		this.overflow = overflow;
	}

	/**
	 * Sets the Horizontal getOverflow
	 *
	 * @return
	 */
	public Overflows getOverflowX()
	{
		return overflowX;
	}

	/**
	 * Sets the overflow x
	 *
	 * @param overflowX
	 */
	public void setOverflowX(Overflows overflowX)
	{
		this.overflowX = overflowX;
	}

	/**
	 * Sets the vertical overflow
	 *
	 * @return
	 */
	public Overflows getOverflowY()
	{
		return overflowY;
	}

	/**
	 * Sets the overflow y
	 *
	 * @param overflowY
	 */
	public void setOverflowY(Overflows overflowY)
	{
		this.overflowY = overflowY;
	}

	/**
	 * Sets the display position
	 *
	 * @return
	 */
	public Positions getPosition()
	{
		return position;
	}

	/**
	 * Sets the position
	 *
	 * @param position
	 */
	public void setPosition(Positions position)
	{
		this.position = position;
	}

	/**
	 * Sets the component floating
	 *
	 * @return
	 */
	public Floats getFloat()
	{
		return floatProperty;
	}

	/**
	 * Sets the float
	 *
	 * @param floatProperty
	 */
	public void setFloat(Floats floatProperty)
	{
		this.floatProperty = floatProperty;
	}

	/**
	 * Sets the Z-Index
	 *
	 * @return
	 */
	public MeasurementCSSImpl getZIndex()
	{
		return zIndex;
	}

	/**
	 * Sets the bottom margin edge for a positioned box
	 *
	 * @return
	 */
	public MeasurementCSSImpl getBottom()
	{
		return bottom;
	}

	/**
	 * Sets the bottom
	 *
	 * @param bottom
	 */
	public void setBottom(MeasurementCSSImpl bottom)
	{
		this.bottom = bottom;
	}

	/**
	 * Sets the bottom margin edge for a positioned box
	 *
	 * @return
	 */
	public MeasurementCSSImpl getLeft()
	{
		return left;
	}

	/**
	 * Sets the left
	 *
	 * @param left
	 */
	public void setLeft(MeasurementCSSImpl left)
	{
		this.left = left;
	}

	/**
	 * Sets the bottom margin edge for a positioned box
	 *
	 * @return
	 */
	public MeasurementCSSImpl getRight()
	{
		return right;
	}

	/**
	 * Sets the right
	 *
	 * @param right
	 */
	public void setRight(MeasurementCSSImpl right)
	{
		this.right = right;
	}

	/**
	 * Sets the bottom margin edge for a positioned box
	 *
	 * @return
	 */
	public MeasurementCSSImpl getTop()
	{
		return top;
	}

	/**
	 * Sets the top
	 *
	 * @param top
	 */
	public void setTop(MeasurementCSSImpl top)
	{
		this.top = top;
	}

	/**
	 * Sets the cursor
	 *
	 * @param oursor
	 */
	public void setOursor(Cursors oursor)
	{
		this.oursor = oursor;
	}

	/**
	 * Sets the z index
	 *
	 * @param zIndex
	 */
	public void setzIndex(MeasurementCSSImpl zIndex)
	{
		this.zIndex = zIndex;
	}

}

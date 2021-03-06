/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.NoFeatures;
import com.jwebmp.core.base.html.interfaces.children.TableColumnGroupChildren;
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;colgroup&gt; tag specifies a group of one or more columns in a table for formatting.<p>
 * <p>
 * The &lt;colgroup&gt; tag is useful for applying styles to entire columns, instead of repeating the styles for each cell, for each row.<p>
 * <p>
 * Note: The &lt;colgroup&gt; tag must be a child of a table element, after any &lt;caption&gt; elements and before any thead, tbody, tfoot, and tr elements.<p>
 * <p>
 * Tip: To define different properties to a column within a &lt;colgroup&gt;, use the col tag within the &lt;colgroup&gt; tag. Browser Support Element<p>
 * &lt;colgroup&gt; Yes Yes Yes Yes Yes<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * Most of the attributes in HTML 4.01 are not supported in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @since 2014/12/20
 */
public class TableColumnGroup<J extends TableColumnGroup<J>>
		extends Component<TableColumnGroupChildren, NoAttributes, NoFeatures, NoEvents, J>
{


	/**
	 * Constructs a new Table Column Group
	 */
	public TableColumnGroup()
	{
		super(ComponentTypes.TableColumnGroup);
	}

}

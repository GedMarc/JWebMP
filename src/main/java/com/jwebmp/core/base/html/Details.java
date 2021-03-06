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
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.DetailsChildren;
import com.jwebmp.core.base.html.interfaces.children.PhraseChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;details&gt; tag specifies additional details that the user can view or hide on demand.
 * <p>
 * The &lt;details&gt; tag can be used to create an interactive widget that the user can open and close. Any sort of content can be put inside the &lt;details&gt; tag.
 * <p>
 * The content of a &lt;details&gt; element should not be visible unless the open attribute is set. Browser Support
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element &lt;details&gt; 12.0 Not supported Not supported 6.0 15.0
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The &lt;details&gt; tag is new in HTML5. Tips and Notes
 * <p>
 * Tip: The &lt;summary&gt; tag is used to specify a visible heading for the details. The heading can be clicked to view/hide the details.
 * <p>
 *
 * @param <J>
 * @author GedMarc
 */
public class Details<J extends Details<J>>
		extends Component<DetailsChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements ParagraphChildren, PhraseChildren
{
	/**
	 * Constructs a new Details section.
	 */
	public Details()
	{
		super(ComponentTypes.Details);
	}
}

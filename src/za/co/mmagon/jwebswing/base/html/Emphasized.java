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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.PhraseChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;em&gt; tag is a phrase tag. It renders as emphasized text.
 * <p>
 * Tip: This tag is not deprecated, but it is possible to achieve richer effect with CSS.
 * <p>
 * <p>
 * Browser Support Element &lt;em&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * NONE.
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 */
public class Emphasized<J extends Emphasized<J>>
		extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText, NoIDTag, PhraseChildren
{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new Emphasized Text String
	 *
	 * @param text
	 */
	public Emphasized(String text)
	{
		super(ComponentTypes.Emphasized);
		setText(text);
	}
}

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
import com.jwebmp.core.base.html.interfaces.events.NoEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;output&gt; tag represents the result of a calculation (like one performed by a script). Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * &lt;output&gt; 10.0 Not supported 4.0 5.1 11.0 Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;output&gt; tag is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * @since Mar 1, 2015
 * 		<p>
 * 		No support in I.E. - can't be used, the results are not compatible - may make as a server function but the point is client side.
 */
public class Output<J extends Output<J>>
		extends Component<IComponentHierarchyBase<?,?>, NoAttributes, NoFeatures, NoEvents, J>
{


	/**
	 *
	 */
	public Output()
	{
		super(ComponentTypes.Output);
	}
}

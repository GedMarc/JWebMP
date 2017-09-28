/*
 * Copyright (C) 2015 GedMarc
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

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author GedMarc
 */
public class MapTest
{

	public MapTest()
	{
	}

	/**
	 * Test of preConfigure method, of class Map.
	 */
	@Test
	public void testPreConfigure()
	{
		System.out.println("preConfigure");
		Map instance = new Map();
		instance.setID("id");
		instance.addAttribute(GlobalAttributes.Name, "id");
		System.out.println(instance.toString(true));

		assertEquals("<map id=\"id\" name=\"id\"></map>", instance.toString(true).toString());
	}

}

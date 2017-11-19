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
package za.co.mmagon.jwebswing.base.angular.modules;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularFeature;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * @author GedMarc
 * @since 25 Jul 2016
 */
public class JWAngularModule extends AngularModuleBase
{

	private static final long serialVersionUID = 1L;
	/**
	 * The attached page
	 */
	private Page page;

	public JWAngularModule(Page component)
	{
		super("jwApp");
		setSortOrder(9999999);
		this.page = component;
	}

	public String renderFunction(Page fromComponent)
	{
		this.page = fromComponent;
		return renderFunction();
	}

	/**
	 * Overwrite the render function
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String renderFunction()
	{
		String returnable = "var " + AngularFeature.getAppName() + " = angular.module(";
		returnable += STRING_SINGLE_QUOTES + AngularFeature.getAppName() + "',";

		Set<String> moduleNames = new LinkedHashSet<>();
		List<AngularModuleBase> modules = new ArrayList<>(page.getAngular().getAngularModules());
		modules.sort((o1, o2) -> o1.compare(o1, o2));
		for (AngularModuleBase module : modules)
		{
			moduleNames.add(module.getReferenceName());
		}

		StringBuilder nameRenders = new StringBuilder();
		for (String name : moduleNames)
		{
			nameRenders.append(STRING_SINGLE_QUOTES).append(name).append("',");
		}

		if (nameRenders.indexOf(STRING_COMMNA) != -1)
		{
			nameRenders = nameRenders.deleteCharAt(nameRenders.lastIndexOf(STRING_COMMNA));
		}
		nameRenders.insert(0, StaticStrings.STRING_SQUARE_BRACE_OPEN);
		nameRenders.append(STRING_SQUARE_BRACE_CLOSED);
		returnable += nameRenders;

		returnable += ");";
		return returnable;
	}

	@Override
	public String toString()
	{
		if (this.page != null)
		{
			page.toString(true);
		}
		return super.toString();
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + page.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JWAngularModule))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JWAngularModule that = (JWAngularModule) o;

		return page.equals(that.page);
	}
}

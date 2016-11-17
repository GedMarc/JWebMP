/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.jqxwidgets.dropdownlist;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.List;

/**
 * jqxDropDownList represents a jQuery widget that contains a list of selectable items displayed in a drop-down.
 * <p>
 * @author Marc Magon
 * @since 13 Dec 2015
 * @version 1.0
 */
public class JQXDropDownList extends Div<JQXDropDownListChildren, JQXDropDownListAttributes, JQXDropDownListFeatures, JQXDropDownListEvents, JQXDropDownList>
{

    private static final long serialVersionUID = 1L;
    private JQXDropDownListFeature feature;
    private final List list;

    public JQXDropDownList()
    {
        addFeature(getFeature());
        list = new List();
    }

    public JQXDropDownListFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXDropDownListFeature(this);
        }
        return feature;
    }

    @Override
    public JQXDropDownListOptions getOptions()
    {
        return getFeature().getOptions();
    }

    public List getList()
    {
        return list;
    }

}
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
package za.co.mmagon.jwebswing.components.jqxwidgets.numberinput;

/**
 * This Class
 *
 * @author GedMarc
 * @since 20 Dec 2015
 */
public enum JQXNumberInputOptionsModes
{
    /**
     * 'simple'-the widget works as a normal textbox, but restricts the user's input to numbers
     */
    Simple,
    /**
     * 'advanced'- the number input behavior resembles a masked input with numeric mask
     */
    Advanced;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
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
package za.co.mmagon.jwebswing.htmlbuilder.css.annotations;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import java.lang.annotation.*;
import java.util.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;

/**
 *
 * @author GedMarc
 * @param <A> The annotation type
 * @param <T> The implementation class type
 *
 * @since Nov 19, 2016
 * @version 1.0
 *
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CSSImplementationAdapter<A extends Annotation, T extends CSSImplementationClass> implements CSSImplementationClass<A, T>
{

    private static final long serialVersionUID = 1L;
    /**
     * The default adapter
     */
    private static final org.apache.log4j.Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("CSSImpAdapter");
    /**
     * The properties factory
     */
    private CSSPropertiesFactory propertyFactory;

    /**
     * For implementing generic methods on CSS
     */
    public CSSImplementationAdapter()
    {

    }

    /**
     * From annotation
     *
     * @param annotation The annotation to pull from
     *
     * @return
     */
    @Override
    public T fromAnnotation(A annotation)
    {
        T newInstance = null;
        try
        {

            Map<StringBuilder, Object> fieldMapping = getPropertyFactory().processAnnotation(annotation);
            newInstance = (T) getPropertyFactory().getImplementationObject(annotation, fieldMapping);
            return newInstance;
        }
        catch (Exception ex)
        {
            if (newInstance != null)
            {
                log.error("[Field Populator]-[Failed];[Object]-[" + newInstance.getClass().getCanonicalName() + "]", ex);
            }
            else
            {
                log.error("[Field Populator]-[Failed];[Object]-[" + newInstance + "]", ex);
            }
        }
        return null;
    }

    /**
     * Returns the properties factory
     *
     * @return
     */
    protected CSSPropertiesFactory getPropertyFactory()
    {
        if (propertyFactory == null)
        {
            propertyFactory = new CSSPropertiesFactory();
        }
        return propertyFactory;
    }

    /**
     * Sets the properties factory
     *
     * @param propertyFactory
     */
    protected void setPropertyFactory(CSSPropertiesFactory propertyFactory)
    {
        this.propertyFactory = propertyFactory;
    }

    @Override
    public String toString()
    {
        try
        {
            return JavaScriptPart.getJsonObjectMapper().writeValueAsString(this);
        }
        catch (JsonProcessingException e)
        {
            log.fatal("Error in IMPL Object", e);
            return "";
        }
    }

}

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
package com.jwebmp.core.htmlbuilder.javascript;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

/**
 * Defines a section of a JavaScript part e.g. Position
 * <p>
 *
 * @author mmagon
 * @since 2014/07/09
 */
@JsonAutoDetect(fieldVisibility = ANY,
		getterVisibility = NONE,
		setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JavaScriptPart<J extends JavaScriptPart<J>>
		implements Serializable
{

	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("JavaScriptPart");
	/**
	 * Version 2
	 */
	private static final long serialVersionUID = 2L;

	@JsonProperty(value = "$jwid")
	private String referenceId;
	/**
	 * if empty braces should be rendered
	 */
	@JsonIgnore
	private boolean renderEmptyBraces = false;

	/**
	 * Constructs a new javascript part
	 */
	public JavaScriptPart()
	{
		//No configuration needed
	}

	/**
	 * Returns the object presented as a JSON strong
	 *
	 * @param o
	 *
	 * @return
	 */
	public String objectAsString(Object o)
	{
		try
		{
			return getJsonObjectMapper()
					       .writer()
					       .withoutFeatures(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)
					       .writeValueAsString(o)
					       .replaceAll("\r\n", "\n");
		}
		catch (JsonProcessingException ex)
		{
			log.log(Level.SEVERE, "Unable to Serialize as JSON Json Processing Exception", ex);
			return "";
		}
		catch (Exception ex)
		{
			log.log(Level.SEVERE, "Unable to Serialize as JSON", ex);
			return "";
		}
	}

	/**
	 * Returns the JSON Renderer
	 *
	 * @return
	 */
	public ObjectMapper getJsonObjectMapper()
	{
		return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JSON")));
	}

	/**
	 * Returns the raw function renderer
	 *
	 * @return
	 */
	public ObjectMapper getFunctionObjectMapper()
	{
		return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JSFUNCTION")));
	}

	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file
	 * 		the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(InputStream file, Class<T> clazz) throws IOException
	{
		return getJsonObjectMapper().readValue(file, clazz);
	}

	/**
	 * Read from a file
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(File file, Class<T> clazz) throws IOException
	{
		return getJsonObjectMapper().readValue(file, clazz);
	}

	/**
	 * Read from a reader
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(Reader file, Class<T> clazz) throws IOException
	{
		return getJsonObjectMapper().readValue(file, clazz);
	}

	/**
	 * Read from a content string
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(String content, Class<T> clazz) throws IOException
	{
		return getJsonObjectMapper().readValue(content, clazz);
	}

	/**
	 * Read from a URL
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> T From(URL content, Class<T> clazz) throws IOException
	{
		return getJsonObjectMapper().readValue(content, clazz);
	}

	/**
	 * Read direct from the stream
	 *
	 * @param <T>
	 * @param file
	 * 		the stream
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(InputStream file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(file, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a URL
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(URL content, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(content, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a file
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(File file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(file, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a reader
	 *
	 * @param <T>
	 * @param file
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(Reader file, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(file, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	/**
	 * Read from a content string
	 *
	 * @param <T>
	 * @param content
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public <T> List<T> FromToList(String content, Class<T> clazz) throws IOException
	{
		T list = getJsonObjectMapper().readValue(content, clazz);
		ArrayList<T> lists = new ArrayList<>();
		lists.addAll(Arrays.asList((T[]) list));
		return lists;
	}

	public String render()
	{
		return toString();
	}

	/**
	 * Returns the section of string to be applied to the JavaScript part
	 * <p>
	 *
	 * @return The string to be added to the JavaScript
	 */
	@Override
	public String toString()
	{
		String s = null;
		switch (getJavascriptType())
		{
			case Javascript:
			{
				try
				{
					s = getJavascriptObjectMapper().writeValueAsString(this);
				}
				catch (com.fasterxml.jackson.databind.JsonMappingException mapException)
				{
					log.log(Level.SEVERE, "JSON Mapping Exception!", mapException);
				}
				catch (JsonProcessingException ex)
				{
					log.log(Level.SEVERE, "Error Writing as Javascript!", ex);
				}
				break;
			}
			case JSON:
			{
				try
				{
					s = getJsonObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					log.log(Level.SEVERE, "Error Writing as JSON Data!", ex);
				}
				break;
			}
			case Function:
			{
				try
				{
					s = getJavascriptObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					log.log(Level.SEVERE, "Error Writing as Javascript Function!", ex);
				}
				break;
			}
			default:
			{
				try
				{
					s = getJsonObjectMapper().writeValueAsString(this);
				}
				catch (JsonProcessingException ex)
				{
					log.log(Level.SEVERE, "Error Writing as Default!", ex);
				}
				break;
			}
		}
		if (s != null)
		{
			if ("{ }".equals(s) && !isRenderEmptyBraces())
			{
				return "";
			}
		}
		else
		{
			return "";
		}

		s = s.replaceAll("\r\n", "\n");

		return s;
	}

	/**
	 * Set the render type
	 * <p>
	 *
	 * @return
	 */
	public JavascriptPartType getJavascriptType()
	{
		return JavascriptPartType.Javascript;
	}

	/**
	 * Returns the JavaScript renderer
	 *
	 * @return
	 */
	public ObjectMapper getJavascriptObjectMapper()
	{
		try
		{
			return GuiceContext.getInstance(Key.get(ObjectMapper.class, Names.named("JS")));
		}
		catch (NullPointerException e)
		{
			log.log(Level.SEVERE, "Cant find javascript object mapper, returning default", e);
			return new ObjectMapper();
		}
	}

	public boolean isRenderEmptyBraces()
	{
		return renderEmptyBraces;
	}

	/**
	 * If this part should render when its just empty braces
	 *
	 * @param renderEmptyBraces
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRenderEmptyBraces(boolean renderEmptyBraces)
	{
		this.renderEmptyBraces = renderEmptyBraces;
		return (J) this;
	}

	/**
	 * Renders the output in tiny format
	 *
	 * @param tiny
	 *
	 * @return
	 */
	public String toString(@SuppressWarnings("unused") boolean tiny)
	{
		String output = toString();
		output = output.replace("\n", "");
		output = output.replace("\r", "");
		output = output.replace("\t", "");
		output = output.replace("  ", "");
		output = output.replace(" : ", ":");
		return output;
	}

	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @return
	 */
	public String getReferenceId()
	{
		return referenceId;
	}

	/**
	 * Sets the JW ID to send if necessary
	 *
	 * @param referenceId
	 */
	public void setReferenceId(String referenceId)
	{
		this.referenceId = referenceId;
	}

	@JsonIgnore
	public boolean isConfigured()
	{
		return true;
	}

	@JsonIgnore
	public boolean isInitialized()
	{
		return true;
	}

	public void init()
	{
		//No configuration needed
	}

	public void preConfigure()
	{
		//No configuration needed
	}

	public void destroy()
	{
		//No configuration needed
	}
}
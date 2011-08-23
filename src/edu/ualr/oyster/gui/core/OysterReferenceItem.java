/*
 * Copyright 2011 John Talburt, Eric Nelson, Payam Mahmoudian
 *
 * This file is part of Oyster created in the 
 * ERIQ Research Center at University of Arkansas at Little Rock.
 * 
 * Oyster is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Oyster is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Oyster. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package edu.ualr.oyster.gui.core;

/**
 * OysterReferenceItem.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterReferenceItem {

	/** */
	private String name = null;

	/** */
	private String attribute = null;

	/** */
	private String format = null;

	/** */
	private String formatType = null;

	/** */
	private int start = 0;

	/** */
	private int end = 0;

	/** */
	private int pos = -1;

	/** */
	private String data = null;

	/**
	 * Creates a new instance of <code>OysterReferenceItem</code>.
	 */
	public OysterReferenceItem() {
	}

	public OysterReferenceItem(String name, String attribute) {
		this.name = name;
		this.attribute = attribute;
	}

	public OysterReferenceItem(String name, String attribute, int pos) {
		this.name = name;
		this.attribute = attribute;
		this.pos = pos;
	}

	public OysterReferenceItem(String name, String attribute, int start, int end) {
		this.name = name;
		this.attribute = attribute;
		this.start = start;
		this.end = end;
	}

	/**
	 * Returns the Attribute name for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Attribute name.
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Sets the Attribute name for this <code>OysterReferenceItem</code>.
	 * 
	 * @param attribute
	 *            the Attribute name to be set.
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Returns the Attribute format for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Attribute format.
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the Attribute format for this <code>OysterReferenceItem</code>.
	 * 
	 * @param format
	 *            the Attribute format to be set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Returns the Attribute formatType for this
	 * <code>OysterReferenceItem</code>
	 * 
	 * @return the Attribute formatType.
	 */
	public String getFormatType() {
		return formatType;
	}

	/**
	 * Sets the Attribute formatType for this <code>OysterReferenceItem</code>.
	 * 
	 * @param formatType
	 *            the Attribute formatType to be set.
	 */
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	/**
	 * Returns the Name for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Name for this <code>OysterReferenceItem</code>.
	 * 
	 * @param name
	 *            the Name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the Starting position for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Starting position.
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Sets the Starting position for this <code>OysterReferenceItem</code>.
	 * 
	 * @param start
	 *            the Starting position to be set.
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * Returns the End position for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the End position.
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * Sets the End position for this <code>OysterReferenceItem</code>.
	 * 
	 * @param end
	 *            the End position to be set.
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * Returns the Ordinal for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Ordinal
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Sets the Ordinal for this <code>OysterReferenceItem</code>.
	 * 
	 * @param pos
	 *            the Ordinal to be set.
	 */
	public void setPos(int ordinal) {
		this.pos = ordinal;
	}

	/**
	 * Returns the Data value for this <code>OysterReferenceItem</code>.
	 * 
	 * @return the Data value.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the Data value for this <code>OysterReferenceItem</code>.
	 * 
	 * @param data
	 *            the Data value to be set.
	 */
	public void setData(String data) {
		this.data = data;
	}

	@Override
	/**
	 * Returns a String representation of the <code>OysterReferenceItem</code> data.
	 * @return
	 */
	public String toString() {
		return data;
	}
}

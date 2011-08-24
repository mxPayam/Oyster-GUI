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
 * OysterAttribute.java
 * 
 * @author Payam Mahmoudian
 */

public class OysterAttribute {

	/** */
	private String name;

	/** */
	private String algorithm;

	/** */
	private boolean debug = false;

	/**
	 * Creates a new instance of <code>OysterAttribute</code>
	 */
	public OysterAttribute() {
	}

	/**
	 * Returns the Algorithm for this Attribute.
	 * 
	 * @return the Algorithm name.
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * Set the Algorithm name.
	 * 
	 * @param algorithm
	 *            the name of the Algorithm to be set.
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Returns the Attribute name as a String.
	 * 
	 * @return the Atrribute name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Attribute
	 * 
	 * @param name
	 *            the Attribute name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns whether the <code>OysterAttribute</code> is in debug mode.
	 * 
	 * @return true if the <code>OysterAttribute</code> is in debug mode,
	 *         otherwise false.
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * Enables/disables debug mode for the <code>OysterAttribute</code>.
	 * 
	 * @param debug
	 *            true to enable debug mode, false to disable it.
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@Override
	/**
	 * Returns a hash code value for the <code>OysterAttribute</code>.
	 * @return a hash code value for this object.
	 */
	public int hashCode() {
		int hash = 5;
		hash = 31 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 31 * hash
				+ (this.algorithm != null ? this.algorithm.hashCode() : 0);
		return hash;
	}

	@Override
	/**
	 * Determines of this object is equal to another object.
	 * @param obj the reference object with which to compare. 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final OysterAttribute other = (OysterAttribute) obj;
		if (!this.name.equalsIgnoreCase(other.name)
				&& (this.name == null || !this.name.equals(other.name))) {
			return false;
		}
		if (!this.algorithm.equalsIgnoreCase(other.algorithm)
				&& (this.algorithm == null || !this.algorithm
						.equals(other.algorithm))) {
			return false;
		}
		return true;
	}

	@Override
	/**
	 * Returns a String representation of the <code>OysterAttribute</code> object
	 * @return a String
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(getClass().getName());
		buf.append("[");
		buf.append("name=").append(name);
		buf.append(", algorithm=").append(algorithm);
		buf.append("]");
		return buf.toString();
	}
}

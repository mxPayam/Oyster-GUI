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
package edu.ualr.oyster.gui.utilities;

import java.util.Vector;

/**
 * OysterComparator.java
 * 
 * @author Payam Mahmoudian
 */

public class OysterComparator {

	/** */
	protected boolean debug = false;

	/** */
	protected Vector<String> matchCodes;

	/**
	 * Creates a new instance of <code>OysterComparator</code>.
	 */
	public OysterComparator() {
		matchCodes = new Vector<String>();
		matchCodes.addElement("EXACT");
		matchCodes.addElement("EXACT_IGNORE_CASE");
		matchCodes.addElement("MISSING");
	}

	/**
	 * Returns whether the <code>OysterComparator</code> is in debug mode.
	 * 
	 * @return true if the <code>OysterComparator</code> is in debug mode,
	 *         otherwise false.
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * Enables/disables debug mode for the <code>OysterComparator</code>.
	 * 
	 * @param debug
	 *            true to enable debug mode, false to disable it.
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Returns whether the match code is a valid match code for this
	 * <code>OysterComparator</code>.
	 * 
	 * @param s
	 *            match code to be checked.
	 * @return true if the <code>OysterComparator</code> is in debug mode,
	 *         otherwise false.
	 */
	public boolean isMatchCode(String s) {
		return matchCodes.contains(s.toUpperCase());
	}

	/**
	 * This method compares the source string to the target string based on this
	 * Comparators comparison parameters. If a comparison is found will return
	 * the appropriate match code string.
	 * 
	 * @param s
	 *            source String.
	 * @param t
	 *            target String.
	 * @param matchType
	 *            the type of match to perform.
	 * @return the match code found.
	 */
	public String compare(String s, String t, String matchType) {
		String result = null;
		if (s == null || (s.trim()).length() == 0) {
			result = "Missing";
		} else if (t == null || (t.trim()).length() == 0) {
			result = "Missing";
		} else if (matchType.equalsIgnoreCase("Exact") && s.equals(t)) {
			result = "Exact";
		} else if (matchType.equalsIgnoreCase("Exact_Ignore_Case")
				&& s.equalsIgnoreCase(t)) {
			result = "Exact_Ignore_Case";
		} else
			result = getMatchCode(s, t, matchType);
		return result;
	}

	/**
	 * Returns the match code for this <code>OysterComparator</code>.
	 * 
	 * @param s
	 *            source String.
	 * @param t
	 *            target String.
	 * @param matchType
	 *            the type of match to preform.
	 * @return the match code.
	 */
	public String getMatchCode(String s, String t, String matchType) {
		return "X";
	}

	public final String getAllAvailableMatchCodes() {
		StringBuffer buf = new StringBuffer();
		buf.append(getClass().getName());
		buf.append(matchCodes);
		return buf.toString();
	}

	@Override
	/**
	 * Returns a String representation of the <code>OysterComparator</code> object
	 * @return a String
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(getClass().getName());

		return buf.toString();
	}
}

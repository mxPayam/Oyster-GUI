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

/**
 * OysterErrorFormatter.java
 * 
 * @author Payam Mahmoudian
 */

public class OysterErrorFormatter {
	/**
	 * Creates a new instance of OysterErrorFormatter
	 */
	public OysterErrorFormatter() {
	}

	public static String format(Exception ex) {
		StringBuffer buf = new StringBuffer(1000);
		StackTraceElement[] ste = ex.getStackTrace();

		buf.append(ex.getMessage())
				.append(System.getProperty("line.separator"));
		buf.append(ex.toString()).append(System.getProperty("line.separator"));
		for (int i = 0; i < ste.length - 1; i++) {
			buf.append(ste[i].toString()).append(
					System.getProperty("line.separator"));
		}

		if (ste.length > 0)
			buf.append(ste[ste.length - 1].toString()).append(
					System.getProperty("line.separator"));

		return buf.toString();

	}
}

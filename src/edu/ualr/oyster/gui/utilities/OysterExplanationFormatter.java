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

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * OysterExplanationFormatter.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterExplanationFormatter extends Formatter {
	/**
	 * Creates a new instance of OysterExplanationFormatter
	 */
	public OysterExplanationFormatter() {
	}

	@Override
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		buf.append(formatMessage(rec));
		buf.append(System.getProperty("line.separator"));
		return buf.toString();

	}
}

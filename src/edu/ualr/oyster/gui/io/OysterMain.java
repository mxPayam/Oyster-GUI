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
package edu.ualr.oyster.gui.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.ualr.oyster.gui.core.OysterAttributes;
import edu.ualr.oyster.gui.utilities.OysterExplanationFormatter;

/**
 * OysterMain.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterMain {

	private boolean Debug = true;
	private boolean Explanation = false;


	// create a single instance of OysterAttributes
	OysterAttributes oysterAttributes = new OysterAttributes();
	OysterAttributesParser aParser = new OysterAttributesParser();

	/** 
	 * */
	private Logger logger = null;

	/** 
	 * */
	private Level logLevel = null;

	/** 
	 * */
	private String logFile = null;

	/** 
	 * */
	private FileHandler fileHandler = null;

	/** */
	public OysterAttributes attributes = null;
	
	public String attributesFile = null;

	/**
	 * @param logFile
	 * @param attributes
	 */
	public OysterMain(String attributeFile, String logFile) {
		super();
		this.attributesFile = attributeFile;
		this.logFile = logFile;
		//InitializeLogger();
		

	}	

	@SuppressWarnings("unused")
	private void InitializeLogger() {
		logger = Logger.getLogger(getClass().getName());

		// remove root handlers and disable any references to root handlers
		logger.setUseParentHandlers(false);
		Logger globalLogger = Logger.getLogger("global");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		// add handlers
		try {
			fileHandler = new FileHandler(logFile, 10000, 1);
		} catch (SecurityException e1) {
			System.out.println("FileHandler SecurityException!");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("FileHandler IOException!");
			e1.printStackTrace();
		}
		try {
			fileHandler.setEncoding("UTF8");
		} catch (SecurityException e1) {
			System.out.println("setEncoding SecurityException!");
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			System.out.println("setEncoding IOException!");
			e1.printStackTrace();
		}
		logger.addHandler(fileHandler);

		logger.addHandler(fileHandler);

		if (Debug && Explanation) {
			logLevel = Level.FINEST;
		} else if (Debug && !Explanation) {
			logLevel = Level.FINE;
		} else if (!Debug && Explanation) {
			logLevel = Level.INFO;
		} else if (!Debug && !Explanation) {
			logLevel = Level.SEVERE;
		}

		// set level and formatter
		logger.setLevel(logLevel);
		OysterExplanationFormatter formatter = new OysterExplanationFormatter();
		fileHandler.setFormatter(formatter);
	}
}

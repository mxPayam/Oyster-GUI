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

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.ualr.oyster.gui.utilities.OysterComparator;
import edu.ualr.oyster.gui.utilities.OysterExplanationFormatter;

/**
 * Maintain the list the valid names for identity attributes Responsibilities:
 * <ul>
 * <li>Access and load the text file or table containing the list valid names</li>
 * <li>Allow other objects to verify that a name is valid</li>
 * </ul>
 * OysterAttributes.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterAttributes {

	private String system = "";

	private static Hashtable<OysterAttribute, OysterComparator> attrComp;

	/** */
	// private static ArrayList<OysterRule> identityRules = null;

	private boolean debug = false;

	private Logger logger = null;

	private FileHandler fileHandler = null;

	/**
	 * Creates a new instance of <code>OysterAttributes</code>.
	 */
	public OysterAttributes() {
		attrComp = new Hashtable<OysterAttribute, OysterComparator>();
		// identityRules = new ArrayList<OysterRule>();
	}

	/**
	 * Creates a new instance of <code>OysterAttributes</code>.
	 * 
	 * @param logFile
	 * @param logLevel
	 */
	public OysterAttributes(String logFile, Level logLevel) {
		attrComp = new Hashtable<OysterAttribute, OysterComparator>();
		// identityRules = new ArrayList<OysterRule>();

		try {
			// initialize logger
			logger = Logger.getLogger(getClass().getName());
			fileHandler = new FileHandler(logFile, true);

			// add handlers
			logger.addHandler(fileHandler);

			// set level and formatter
			logger.setLevel(logLevel);
			OysterExplanationFormatter formatter = new OysterExplanationFormatter();
			fileHandler.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the system name for this <code>OysterAttributes</code>.
	 * 
	 * @return the system name.
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * Sets the system name for this <code>OysterAttributes</code>.
	 * 
	 * @param system
	 *            the system name to be set.
	 */
	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * Returns the Attribute Comparator list for this
	 * <code>OysterAttributes</code>.
	 * 
	 * @return the Attribute Comparator list.
	 */
	public Hashtable<OysterAttribute, OysterComparator> getAttrComp() {
		return attrComp;
	}

	/**
	 * Sets the Attribute Comparator list for this <code>OysterAttributes</code>
	 *  
	 * @param aAttrComp
	 *            the Attribute Comparator list to be set.
	 */
	public void setAttrComp(
			Hashtable<OysterAttribute, OysterComparator> aAttrComp) {
		attrComp = aAttrComp;
	}

	/**
	 * Returns whether the <code>OysterAttribute</code> is contained in the
	 * <code>OysterAttributes</code>.
	 * 
	 * @param attribute
	 *            the <code>OysterAttribute</code> to check for.
	 * @return true if the <code>OysterAttribute</code> is present, otherwise
	 *         false.
	 */
	public boolean isOysterAttribute(OysterAttribute attribute) {
		return attrComp.containsKey(attribute);
	}

	/**
	 * The method returns the <code>OysterComparator</code> for this
	 * <code>OysterAttribute</code>.
	 * 
	 * @param attribute
	 *            the <code>OysterAttribute</code> to search for.
	 * @return the <code>OysterComparator</code> if present, otherwise null.
	 */
	public OysterComparator getComparator(OysterAttribute attribute) {
		OysterComparator oc = null;
		oc = attrComp.get(attribute);
		return oc;
	}

	/**
	 * The method returns the <code>OysterComparator</code> for this
	 * OysterAttribute name.
	 * 
	 * @param attributeName
	 *            the named OysterAttribute to search for.
	 * @return the <code>OysterComparator</code> if present, otherwise null.
	 */
	public OysterComparator getComparator(String attributeName) {
		OysterComparator oc = null;
		for (Iterator<OysterAttribute> it = attrComp.keySet().iterator(); it
				.hasNext();) {
			OysterAttribute oa = it.next();
			if (oa.getName().equalsIgnoreCase(attributeName)) {
				oc = attrComp.get(oa);
				break;
			}
		}
		return oc;
	}

	/**
	 * Returns the identity rules for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the identity rules.
	 */
	// public ArrayList<OysterRule> getIdentityRules () {
	// return identityRules;
	// }

	/**
	 * Sets the identity rules for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aIdentityRules
	 *            the identity rules to be set.
	 */
	// public void setIdentityRules (ArrayList<OysterRule> aIdentityRules) {
	// identityRules = aIdentityRules;
	// }

	/**
	 * Returns whether the <code>OysterAttributes</code> is in debug mode.
	 * 
	 * @return true if the <code>OysterAttributes</code> is in debug mode,
	 *         otherwise false.
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * Enables/disables debug mode for the <code>OysterAttributes</code>.
	 * 
	 * @param debug
	 *            true to enable debug mode, false to disable it.
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Adds the specified <code>OysterAttribute</code> to the HashMap,
	 * increasing its size by one.
	 * 
	 * @param attribute
	 *            the <code>OysterAttribute</code> to be added.
	 */
	public void addAttribute(OysterAttribute attribute) {
		addAttribute(attribute, new OysterComparator());
	}

	/**
	 * Adds the specified <code>OysterAttribute</code> and
	 * <code>OysterComparator</code> to the HashMap, increasing its size by one.
	 * 
	 * @param attribute
	 *            the <code>OysterAttribute</code> to be added.
	 * @param comparator
	 *            the <code>OysterComparator</code> to be added.
	 */
	public void addAttribute(OysterAttribute attribute,
			OysterComparator comparator) {
		attrComp.put(attribute, comparator);
	}

	/**
	 * Adds the specified rule to the end of this ArrayList, increasing its size
	 * by one.
	 * 
	 * @param rule
	 *            the rule to be added.
	 */
	// public void addOysterRule(OysterRule rule){
	// identityRules.add(rule);
	// }
}

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

//import edu.ualr.oyster.gui.OysterSourceReader; 
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Interface to a set of entity references as implemented by the system
 * Responsibilities:
 * <ul>
 * <li>Convert an XML description of a reference source from to an
 * OysterReferenceSource object</li>
 * <li>Allows other objects to read the references in the source in sequential
 * order</li>
 * </ul>
 * OysterReferenceSource.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterReferenceSource {
	/** */
	// private OysterSourceReader sourceReader = null;

	/** */
	//private boolean debug = false;

	/** */
	private static String sourceName = null;

	/** */
	private static String sourcePath = null;

	/** */
	private static String sourceType = null;

	/** */
	private static String delimiter = null;

	/** */
	private static String qualifier = null;

	/** */
	private static boolean label = false;

	/** */
	private static String server = null;
	
	/** */
	private static String table = null;

	/** */
	private static String port = null;

	/** */
	private static String sid = null;

	/** */
	private static String userID = null;

	/** */
	private static String passwd = null;

	/** */
	private static String connectionType = "ODBC";

	/** */
	private static ArrayList<OysterReferenceItem> referenceItems = null;

	/**
	 * Creates a new instance of <code>OysterReferenceSource</code>
	 */
	public OysterReferenceSource() {
		referenceItems = new ArrayList<OysterReferenceItem>();
	}

	// /**
	// * Returns the <code>OysterSourceReader</code> for this
	// * <code>OysterReferenceSource</code>
	// *
	// * @return the <code>OysterSourceReader</code>
	// */
	// public OysterSourceReader getSourceReader() {
	// return sourceReader;
	// }
	//
	// /**
	// * Sets the <code>OysterSourceReader</code> for this
	// * <code>OysterReferenceSource</code>
	// *
	// * @param aSourceReader
	// * the <code>OysterSourceReader</code> to be set.
	// */
	// public void setSourceReader(OysterSourceReader aSourceReader) {
	// this.sourceReader = aSourceReader;
	// }

	/**
	 * Returns the source name for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the source name.
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * Sets the source name for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aSourceName
	 *            the source name to be set.
	 */
	public void setSourceName(String aSourceName) {
		sourceName = aSourceName;
	}

	/**
	 * Returns the source path for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the source path.
	 */
	public String getSourcePath() {
		return sourcePath;
	}

	/**
	 * Sets the source path for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aSourcePath
	 *            the source path to be set.
	 */
	public void setSourcePath(String aSourcePath) {
		sourcePath = aSourcePath;
	}

	/**
	 * Returns the source type for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the source type.
	 */
	public String getSourceType() {
		return sourceType;
	}

	/**
	 * Sets the source type for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aSourceType
	 *            The source type to be set.
	 */
	public void setSourceType(String aSourceType) {
		sourceType = aSourceType;
	}

	/**
	 * Returns the delimiter for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the delimiter.
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * Sets the delimiter for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aDelimiter
	 *            the delimiter to be set.
	 */
	public void setDelimiter(String aDelimiter) {
		delimiter = aDelimiter;
	}

	/**
	 * Returns the text qualifier for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the qualifier.
	 */
	public String getQualifier() {
		return qualifier;
	}

	/**
	 * Sets the text qualifier for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aQualifier
	 *            the text qualifier to be set.
	 */
	public void setQualifier(String aQualifier) {
		qualifier = aQualifier;
	}

	/**
	 * Returns whether the OysterReferenceSource file has a header.
	 * 
	 * @return true if the OysterReferenceSource file has a header, otherwise
	 *         false.
	 */
	public boolean isLabel() {
		return label;
	}

	/**
	 * Enables/disables debug mode for the OysterReferenceSource.
	 * 
	 * @param aLabel
	 *            true to enable debug mode, false to disable it.
	 */
	public void setLabel(boolean aLabel) {
		label = aLabel;
	}

	/**
	 * Returns the server address for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the server address.
	 */
	public String getServer() {
		return server;
	}

	/**
	 * Sets the server address for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aServer
	 *            the server address to be set.
	 */
	public void setServer(String aServer) {
		server = aServer;
	}

	/**
	 * Returns the port number for the server for this
	 * <code>OysterReferenceSource</code>.
	 * 
	 * @return the port number.
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port number for the server for this
	 * <code>OysterReferenceSource</code>.
	 * 
	 * @param aPort
	 *            the port number to be set.
	 */
	public void setPort(String aPort) {
		port = aPort;
	}

	/**
	 * Returns the Database name (SID) for this
	 * <code>OysterReferenceSource</code>.
	 * 
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * Sets the Database name (SID) for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aSid
	 *            the database name to be set.
	 */
	public void setSid(String aSid) {
		sid = aSid;
	}

	/**
	 * Returns the UserID for the <code>OysterReferenceSource</code>.
	 * 
	 * @return the userID.
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Sets the UserID for the <code>OysterReferenceSource</code>.
	 * 
	 * @param aUserID
	 *            the UserID to be set.
	 */
	public void setUserID(String aUserID) {
		userID = aUserID;
	}

	/**
	 * Returns the password for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the password.
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * Sets the password for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aPasswd
	 *            the password to be set.
	 */
	public void setPasswd(String aPasswd) {
		passwd = aPasswd;
	}

	/**
	 * Returns the connection type for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the connection type to be returned.
	 */
	public String getConnectionType() {
		return connectionType;
	}

	/**
	 * Sets the connection type for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aConnectionType
	 *            the connection type to be set.
	 */
	public void setConnectionType(String aConnectionType) {
		connectionType = aConnectionType;
	}

	/**
	 * Returns the reference items for this <code>OysterReferenceSource</code>.
	 * 
	 * @return the reference items.
	 */
	public ArrayList<OysterReferenceItem> getOysterReferenceItems() {
		return referenceItems;
	}

	/**
	 * Returns a <code>ReferenceItem</code> that matches the input itemName
	 * 
	 * @param itemName
	 * @return matched <code>ReferenceItem</code>.
	 */
	public OysterReferenceItem getOysterReferenceItemByItemName(String itemName) {
		OysterReferenceItem ri = null;

		for (Iterator<OysterReferenceItem> it = referenceItems.iterator(); it
				.hasNext();) {
			ri = it.next();

			if (itemName.equalsIgnoreCase(ri.getName()))
				break;
		}
		return ri;
	}

	/**
	 * Sets the reference items for this <code>OysterReferenceSource</code>.
	 * 
	 * @param aReferenceItems
	 *            the reference Items to be set.
	 */
	public void setOysterReferenceItem(
			ArrayList<OysterReferenceItem> aReferenceItems) {
		referenceItems = aReferenceItems;
	}

	/**
	 * 
	 * @return
	 */
	public int getNextReference() {
		return 0;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getValueAtPosition(int index) {
		return null;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	public String getValueOfltem(String item) {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String getRecordImage() {
		return null;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getAttributeOfPosition(int index) {
		return null;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	public String getPositionOfltem(String item) {
		return null;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	public String getAttrOfltem(String item) {
		return null;
	}

//	/**
//	 * Returns whether the <code>OysterReferenceSource</code> is in debug mode.
//	 * 
//	 * @return true if the <code>OysterReferenceSource</code> is in debug mode,
//	 *         otherwise false.
//	 */
//	public boolean isDebug() {
//		return debug;
//	}

//	/**
//	 * Enables/disables debug mode for the <code>OysterReferenceSource</code>.
//	 * 
//	 * @param debug
//	 *            true to enable debug mode, false to disable it.
//	 */
//	public void setDebug(boolean debug) {
//		this.debug = debug;
//	}

	/**
	 * Adds the specified reference item to the end of this ArrayList,
	 * increasing its size by one.
	 * 
	 * @param item
	 *            the item to be added.
	 */
	public void addOysterReferenceItem(OysterReferenceItem item) {
		referenceItems.add(item);
	}

	/**
	 * @param table the table to set
	 */
	public static void setTable(String aTable) {
		table = aTable;
	}

	/**
	 * @return the table
	 */
	public static String getTable() {
		return table;
	}
}

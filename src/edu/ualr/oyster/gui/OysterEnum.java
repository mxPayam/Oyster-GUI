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
package edu.ualr.oyster.gui;

/**
 * OysterEnum.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterEnum {

	public static enum SourceType {
		None, FileFixed, FileDelim, Database
	}

	public static enum CaptureMode {

		/**
		 * -Allows for a Link index to be created and saved with new OysterIDs
		 * assigned to references. -Allows for Identities to be saved in an XML
		 * format if an IdentityOutput location is specified.
		 */
		Yes,
		/**
		 * -Does not allow OYSTER to assign any new OysterID values. -Only a
		 * link file may be created. -Only OysterIDs already defined in an
		 * IdentityInput file can be assigned to references in a Source if the
		 * reference is determined to identify the same identity.
		 */
		No
	}

	public static enum ConnectionType {

		ODBC, MySQL, PostgreSQL, Oracle, MSSQL, MSAccess
	}

	/**
	 * The Explanation flag turns on the log file and writes out an explanation
	 * of what is happening when OYSTER runs.
	 * 
	 */
	public static enum LogExplanation {

		On, Off
	}

	/**
	 * The Debug flag turns on the "IdentityCaptureOutput.idty.emap" and
	 * "IdentityCaptureOutput.idty.indx" files and it adds more detail to the
	 * log file.
	 * 
	 */
	public static enum LogDebug {

		On, Off
	}

	public static enum EREngineType {

		/**
		 * Tells OYSTER to use the original R-Swoosh engine to perform ER.
		 * Faster when a low percentage of duplicate records are expected to be
		 * processed.
		 * 
		 * Uses Attribute-Based Matching
		 */
		RSwooshStandard,
		/**
		 * Tells OYSTER to use an enhanced R-Swoosh engine to perform ER. Faster
		 * when a high percentage of duplicate records are expected to be
		 * processed across multiple sources.
		 * 
		 * Uses Attribute-Based Matching
		 */
		RSwooshEnhanced,
		/**
		 * Tells OYSTER to use the Fellegi-Sunter record-linking model to
		 * perform ER. This is not a modification of the R-Swoosh engine.
		 * FSCluster is a completely different method of performing ER and may
		 * produce different results when compared with the results of
		 * RSwooshStandard or RSwooshEnhanced.
		 * 
		 * Uses Record-Based Matching
		 */
		FSCluster
	}

	/**
	 * Type attribute - This attribute is required. If it is omitted OYSTER will
	 * stop running without producing any user facing error.
	 * 
	 */
	public static enum IdentityInputType {

		/**
		 * When Type is assigned the value of 'None' IdentityInput has only the
		 * Type attribute.
		 */
		None,
		/**
		 * When Type is assigned the value of 'TextFile' the IdentityInput tag
		 * has only the Type attribute.The start and end tag enclose character
		 * data that represents the absolute path to the text file containing
		 * the XML formatted identities.
		 */
		TextFile,
		/**
		 * When Type is assigned the value of 'Database' the IdentityInput tag
		 * may have up to five additional attributes: Type, Server, Port, SID,
		 * UserID, Passwd
		 */
//		Database
	}

	public static enum IdentityOutputType {

		/**
		 * When Type is assigned the value of 'None' IdentityOutput has only the
		 * Type attribute.
		 */
		None,
		/**
		 * When Type is assigned the value of 'TextFile' the IdentityOutput tag
		 * has only the Type attribute. The start and end tag enclose character
		 * data that represents the absolute path to the text file that will be
		 * created to contain the XML formatted identities for the OYSTER run.
		 */
		TextFile,
		/**
		 * NOTE: Output to a DBMS is not currently implemented but will be
		 * supported in the future.
		 */
		// Database
	}

	public static enum LinkOutputType {

		/**
		 * When Type is assigned the value of 'TextFile' the LinkOutput tag has
		 * only the Type attribute. The start and end tag enclose character data
		 * that represents the absolute path to the text file that will be
		 * created to contain the link index created for the OYSTER run.
		 */
		TextFile,
		/**
		 * NOTE: Output to a DBMS is not currently implemented but will be
		 * supported in the future.
		 */
		// Database
	}
}

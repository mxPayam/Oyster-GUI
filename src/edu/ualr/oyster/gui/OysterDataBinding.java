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
 * OysterDataBinding.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterDataBinding {
	private String tagSource;

	public class DatabaseConfig {

		private String tag = "";

		/**
		 * @param tagsource
		 */
		public DatabaseConfig(String tagsource) {
			super();
			setTag(tag);
		}

		/**
		 * @param tagsource
		 *            the tagsource to set
		 */
		private void setTag(String tagsource) {
			tagSource = tagsource;
		}

		/**
		 * @return the tagSource
		 */
		public String getTag() {
			return tagSource;
		}
		
		/**
		 * Must be assigned the address of the database server to be used: DNS
		 * Name or IP address
		 */
		private String Server = "";

		/**
		 * @return the server
		 */
		public String getServer() {
			return Server;
		}

		/**
		 * @param server
		 *            the server to set
		 */
		public void setServer(String server) {
			Server = server;
		}

		/**
		 * Must be assigned the port number on which the database server will
		 * respond to requests.
		 */
		private String Port = "";

		/**
		 * @return the port
		 */
		public String getPort() {
			return Port;
		}

		/**
		 * @param port
		 *            the port to set
		 */
		public void setPort(String port) {
			Port = port;
		}

		/**
		 * Must be assigned the name of the database in which the XML identities
		 * are stored on the server.
		 */
		private String SID = "";

		/**
		 * @return the sID
		 */
		public String getSID() {
			return SID;
		}

		/**
		 * @param sID
		 *            the sID to set
		 */
		public void setSID(String sID) {
			SID = sID;
		}

		/**
		 * Must be assigned the name of the user with access to the required
		 * data.
		 */
		private String UserID = "";

		/**
		 * @return the userID
		 */
		public String getUserID() {
			return UserID;
		}

		/**
		 * @param userID
		 *            the userID to set
		 */
		public void setUserID(String userID) {
			UserID = userID;
		}

		/**
		 * Must be assigned the Password associated to the user given as the
		 * values of the UserID attribute.
		 */
		private String Password = "";

		/**
		 * @return the password
		 */
		public String getPassword() {
			return Password;
		}

		/**
		 * @param password
		 *            the password to set
		 */
		public void setPasswdord(String password) {
			Password = password;
		}

		/**
		 * The start and end tag enclose character data that represents the
		 * table name in which the (ex. identity input) will be written.
		 */
		private String TableName = "";

		/**
		 * @return the tableName
		 */
		public String getTableName() {
			return TableName;
		}

		/**
		 * @param tableName
		 *            the tableName to set
		 */
		public void setTableName(String tableName) {
			TableName = tableName;
		}


		private String ConnectionType = "";
		
		/**
		 * @param connectionType the connectionType to set
		 */
		public void setConnectionType(String connectionType) {
			ConnectionType = connectionType;
		}

		/**
		 * @return the connectionType
		 */
		public String getConnectionType() {
			return ConnectionType;
		}
	}
	
	// public class TextFileConfig {
	//
	// }

}

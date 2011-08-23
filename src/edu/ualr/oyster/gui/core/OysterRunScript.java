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

import edu.ualr.oyster.gui.OysterEnum.CaptureMode;
import edu.ualr.oyster.gui.OysterEnum.EREngineType;
import edu.ualr.oyster.gui.OysterEnum.IdentityInputType;
import edu.ualr.oyster.gui.OysterEnum.IdentityOutputType;
import edu.ualr.oyster.gui.OysterEnum.LinkOutputType;
import edu.ualr.oyster.gui.OysterEnum.LogDebug;
import edu.ualr.oyster.gui.OysterEnum.LogExplanation;

/**
 * The OysterRunScript tag has no attributes. This is the root element and thus
 * the start and end tag encloses all other elements in the document. All other
 * elements are considered child elements to this root element. The
 * OysterRunScript tag can enclose seven tags:
 * <ul>
 * <li>Settings</li>
 * <li>LogFile</li>
 * <li>EREngine</li>
 * <li>AttributePath</li>
 * <li>IdentityInput</li>
 * <li>IdentityOutput</li>
 * <li>LinkOutput</li>
 * <li>ReferenceSources</li>
 * <li>Source</li>
 * </ul>
 * OysterRunScript.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterRunScript {
	/**
	 * All the OYSTER XML documents begin with an XML declaration and a comment
	 * section. The XML declaration is required and must be included exactly as
	 * follows:
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?>
	 * 
	 * The comments section is optional but should be included in the file. The
	 * following is the suggested format of the comments section:
	 * 
	 * <!-- Document : RunScript.xml Created on : Author : Description: Purpose
	 * of the document follows. -->
	 * 
	 */
	public static class Comments {

		private String document = "";
		private String createdOn = "";
		private String author = "";
		private String description = "";

		/**
		 * @return the document
		 */
		public String getDocument() {
			return document;
		}

		/**
		 * @param document
		 *            the document to set
		 */
		public void setDocument(String cDocument) {
			this.document = cDocument;
		}

		/**
		 * @return the createdOn
		 */
		public String getCreatedOn() {
			return createdOn;
		}

		/**
		 * @param createdOn
		 *            the createdOn to set
		 */
		public void setCreatedOn(String cCreatedOn) {
			this.createdOn = cCreatedOn;
		}

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		/**
		 * @param author
		 *            the author to set
		 */
		public void setAuthor(String cAuthor) {
			this.author = cAuthor;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String cDescription) {
			this.description = cDescription;
		}
	}

	/**
	 * The Settings tag directs what information is written to the Oyster.log
	 * file that is created during each OYSTER run. It also directs what
	 * additional output files are generated during the run.
	 * 
	 */
	public static class LogSettings {

		private LogExplanation explanation;
		private LogDebug debug;

		/**
		 * @param explanation
		 *            the explanation to set
		 */
		public void setLogExplanation(LogExplanation explanation) {
			this.explanation = explanation;
		}

		/**
		 * @param debug
		 *            the debug to set
		 */
		public void setLogDebug(LogDebug debug) {
			this.debug = debug;
		}

		/**
		 * @return the explanation
		 */
		public LogExplanation getLogExplanation() {
			return this.explanation;
		}

		/**
		 * @return the debug
		 */
		public LogDebug getLogDebug() {
			return this.debug;
		}
	}

	/**
	 * The LogFile tag directs where the log file for the run is stored, the
	 * number of log files that can be created before OYSTER round-robins and
	 * overwrites the first file, and the allowed size of the log file. The
	 * start and end tag enclose character data that represents the absolute
	 * path to the generated log files.
	 */
	public static class LogFile {

		/**
		 * Defines the number of log files that can be created for the run.
		 */
		private int num;
		/**
		 * Defines the max size of each generated log file.
		 */
		private int size;
		/**
		 * The LogFile directory where the log file for the run is stored.
		 */
		private String logDirectory;

		/**
		 * @return the num
		 */
		public int getNum() {
			return this.num;
		}

		/**
		 * @param num
		 *            the num to set
		 */
		public void setNum(int num) {
			this.num = num;
		}

		/**
		 * @return the size
		 */
		public int getSize() {
			return this.size;
		}

		/**
		 * @param size
		 *            the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}

		/**
		 * @param logDirectory
		 *            the logDirectory to set
		 */
		public void setLogDirectory(String logDirectory) {
			this.logDirectory = logDirectory;
		}

		/**
		 * @return the logDirectory
		 */
		public String getLogDirectory() {
			return this.logDirectory;
		}
	}

	/**
	 * The EREngine tag is used to define which entity resolution engine should
	 * be used for the defined OYSTER run.
	 */
	public static class EREngine {

		private EREngineType type;

		/**
		 * @return the type
		 */
		public EREngineType getType() {
			return this.type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(EREngineType type) {
			this.type = type;
		}
	}

	/**
	 * The AttributePath tag has no attributes. The start and end tag enclose
	 * character data that represents the absolute path to the OYSTER Attributes
	 * script, described in the OysterAttributes section. The AttributePath tag
	 * and the absolute path to the attributes file are required or the OYSTER
	 * run will produce the error: '##ERROR: Reference Items and Attributes do
	 * not match.'
	 * 
	 */
	public static class AttributePath {

		private String attributePath;

		/**
		 * @return the attributepath
		 */
		public String getAttributePath() {
			return attributePath;
		}

		/**
		 * @param attributepath
		 *            the attributepath to set
		 */
		public void setAttributePath(String attributepath) {
			attributePath = attributepath;
		}
	}

	/**
	 * The IdentityInput tag specifies where the Identities to be used as input
	 * are stored. These identities are stored in an XML format generated by a
	 * previous OYSTER run. The identities XML can be stored in and read from a
	 * text file or a database table.
	 */
	public static class IdentityInput {

		private IdentityInputType type;

		/**
		 * @return the type
		 */
		public IdentityInputType getType() {
			return this.type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(IdentityInputType type) {
			this.type = type;
		}

		private String absolutePath;

		/**
		 * @return the absolutePath
		 */
		public String getAbsolutePath() {
			return this.absolutePath;
		}

		/**
		 * @param absolutePath
		 *            the absolutePath to set
		 */
		public void setAbsolutePath(String absolutePath) {
			this.absolutePath = absolutePath;
		}

		private StringBuffer databaseProperties = new StringBuffer();

		/**
		 * @return the databaseProperties
		 */
		public StringBuffer getDatabaseProperties() {
			return this.databaseProperties;
		}

		/**
		 * @param databaseProperties
		 *            the databaseProperties to set
		 */
		public void setDatabaseProperties(StringBuffer databaseProperties) {
			this.databaseProperties = databaseProperties;
		}

		/**
		 * @param databaseProperties
		 *            the databaseProperties to append
		 */
		public void appendDatabaseProperties(String databaseProperties) {
			this.databaseProperties.append(databaseProperties);
		}
	}

	/**
	 * The IdentityOutput tag specifies where the Identities defined during the
	 * OYSTER run will be stored.
	 * 
	 */
	public static class IdentityOutput {

		private IdentityOutputType type;

		/**
		 * @return the type
		 */
		public IdentityOutputType getType() {
			return this.type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(IdentityOutputType type) {
			this.type = type;
		}

		private String absolutePath;

		/**
		 * @return the absolutepath
		 */
		public String getAbsolutePath() {
			return this.absolutePath;
		}

		/**
		 * @param absolutepath
		 *            the absolutepath to set
		 */
		public void setAbsolutePath(String absolutepath) {
			this.absolutePath = absolutepath;
		}
	}

	/**
	 * The LinkOutput tag specifies where the link index created during the
	 * OYSTER run will be stored. A link output is required for every OYSTER
	 * run.
	 */
	public static class LinkOutput {

		private LinkOutputType type;

		/**
		 * @return the type
		 */
		public LinkOutputType getType() {
			return this.type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(LinkOutputType type) {
			this.type = type;
		}

		private String absolutePath;

		/**
		 * @return the absolutepath
		 */
		public String getAbsolutePath() {
			return this.absolutePath;
		}

		/**
		 * @param absolutepath
		 *            the absolutepath to set
		 */
		public void setAbsolutePath(String absolutepath) {
			this.absolutePath = absolutepath;
		}
	}

	/**
	 * The ReferenceSources tag has no attributes. The start and end tag enclose
	 * a series of Source tags, that are children of the ReferenceSources tag.
	 */
	public static class ReferenceSources {

		Source[] sourceList;

		/**
		 * Multiple Source tags can be included in the RunScript. There should
		 * be one Source tag for every SourceDescriptor defined for the OYSTER
		 * run.
		 */
		public static class Source {

			private static CaptureMode capture;

			/**
			 * @param capture
			 *            the capture to set
			 */
			public void setCapture(CaptureMode capture) {
				Source.capture = capture;
			}

			/**
			 * @return the capture
			 */
			public CaptureMode getCapture() {
				return Source.capture;
			}

			private static String sourceDescriptorPath;

			/**
			 * @param sourceDescriptorPath
			 *            the sourceDescriptorPath to set
			 */
			public void setSourceDescriptorPath(String sourceDescriptorPath) {
				Source.sourceDescriptorPath = sourceDescriptorPath;
			}

			/**
			 * @return the sourceDescriptorPath
			 */
			public String getSourceDescriptorPath() {
				return Source.sourceDescriptorPath;
			}
		}
	}
}

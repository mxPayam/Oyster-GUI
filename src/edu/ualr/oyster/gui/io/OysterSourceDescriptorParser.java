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

import edu.ualr.oyster.gui.utilities.OysterErrorFormatter;
import edu.ualr.oyster.gui.core.OysterReferenceSource;
import edu.ualr.oyster.gui.core.OysterReferenceItem;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * OysterXMLParser.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterSourceDescriptorParser extends OysterXMLParser {
	/** */
	static OysterReferenceSource sourceDescriptor = null;

	/** */
	ArrayList<OysterReferenceItem> items = null;

	/** */
	OysterReferenceItem referenceItem = null;

	/** */
	private String parent = "";

	/**
	 * Creates a new instance of <code>OysterSourceDescriptorParser</code>.
	 */
	public OysterSourceDescriptorParser() {
		sourceDescriptor = new OysterReferenceSource();
	}

	/**
	 * Called when the Parser starts parsing the Current XML File. Handle any
	 * document specific initialization code here.
	 * 
	 * @throws org.xml.sax.SAXException
	 */
	public void startDocument() throws org.xml.sax.SAXException {
	}

	/**
	 * Called when the Parser Completes parsing the Current XML File. Handle any
	 * document specific clean up code here.
	 * 
	 * @throws org.xml.sax.SAXException
	 */
	public void endDocument() throws org.xml.sax.SAXException {
	}

	/**
	 * Called when the starting of the Element is reached. For Example if we
	 * have Tag called <Title> ... </Title>, then this method is called when
	 * <Title> tag is Encountered while parsing the Current XML File. The attrs
	 * Parameter has the list of all Attributes declared for the Current Element
	 * in the XML File.
	 * 
	 * @param namespaceURI
	 *            uri for this namespace
	 * @param lName
	 *            local xml name
	 * @param qName
	 *            qualified xml name
	 * @param attrs
	 *            list of all Attributes declared for the Current Element
	 * @throws org.xml.sax.SAXException
	 */
	public void startElement(String namespaceURI, String lName, String qName,
			Attributes attrs) throws org.xml.sax.SAXException {
		String eName = lName; // element name
		if ("".equals(eName))
			eName = qName;

		if (eName.equalsIgnoreCase("OysterSourceDescriptor")) {
			sourceDescriptor = new OysterReferenceSource();
			parent = eName;
		} else if (eName.equalsIgnoreCase("ReferenceItems")) {
			items = new ArrayList<OysterReferenceItem>();
		} else if (eName.equalsIgnoreCase("Item")) {
			referenceItem = new OysterReferenceItem();
			parent = eName;
		} else if (eName.equalsIgnoreCase("Term")) {
			parent = eName;
		}

		// get XML attributes
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				String aName = attrs.getLocalName(i);
				// Attr name
				if ("".equals(aName))
					aName = attrs.getQName(i);

				String token = attrs.getValue(i).trim();

				if (aName.equalsIgnoreCase("Name")) {
					if (parent.equalsIgnoreCase("OysterSourceDescriptor"))
						sourceDescriptor.setSourceName(attrs.getValue(i));
					else if (parent.equalsIgnoreCase("Item"))
						referenceItem.setName(token);
				} else if (aName.equalsIgnoreCase("Type")) {
					sourceDescriptor.setSourceType(token);
				} else if (aName.equalsIgnoreCase("Char")) {
					sourceDescriptor.setDelimiter(token);
				} else if (aName.equalsIgnoreCase("Qual")) {
					sourceDescriptor.setQualifier(token);
				} else if (aName.equalsIgnoreCase("Labels")) {
					if (token.equalsIgnoreCase("Y"))
						sourceDescriptor.setLabel(true);
					else
						sourceDescriptor.setLabel(false);
				} else if (aName.equalsIgnoreCase("Server")) {
					sourceDescriptor.setServer(token);
				} else if (aName.equalsIgnoreCase("Port")) {
					sourceDescriptor.setPort(token);
				} else if (aName.equalsIgnoreCase("SID")) {
					sourceDescriptor.setSid(token);
				} else if (aName.equalsIgnoreCase("UserID")) {
					sourceDescriptor.setUserID(token);
				} else if (aName.equalsIgnoreCase("Passwd")) {
					sourceDescriptor.setPasswd(token);
				} else if (aName.equalsIgnoreCase("CType")) {
					sourceDescriptor.setConnectionType(token);
				} else if (aName.equalsIgnoreCase("Attribute")) {
					referenceItem.setAttribute(token);
				} else if (aName.equalsIgnoreCase("Format")) {
					referenceItem.setFormat(token);
				} else if (aName.equalsIgnoreCase("FormatType")) {
					referenceItem.setFormatType(token);
				} else if (aName.equalsIgnoreCase("Pos")) {
					referenceItem.setPos(Integer.parseInt(token));
				} else if (aName.equalsIgnoreCase("Start")) {
					referenceItem.setStart(Integer.parseInt(token));
				} else if (aName.equalsIgnoreCase("End")) {
					referenceItem.setEnd(Integer.parseInt(token));
				}
			}
		}
	}

	/**
	 * Called when the Ending of the current Element is reached. For example in
	 * the above explanation, this method is called when </Title> tag is reached
	 * 
	 * @param namespaceURI
	 *            uri for this namespace
	 * @param sName
	 * @param qName
	 *            qualified xml name
	 * @throws org.xml.sax.SAXException
	 */
	public void endElement(String namespaceURI, String sName, String qName)
			throws org.xml.sax.SAXException {
		String eName = sName; // element name
		if ("".equals(eName))
			eName = qName;

		if (eName.equalsIgnoreCase("OysterSourceDescriptor")) {
		} else if (eName.equalsIgnoreCase("Source")) {
			sourceDescriptor.setSourcePath(data);
		} else if (eName.equalsIgnoreCase("ReferenceItems")) {
			sourceDescriptor.setOysterReferenceItem(items);
		} else if (eName.equalsIgnoreCase("Item")) {
			items.add(referenceItem);
			parent = "";
		}
	}

	/**
	 * This method is the main entry point for the SAX Parser.
	 * 
	 * @param file
	 *            the XML file to be parsed.
	 * @return <code>OysterReferenceSource</code> containing data from the file.
	 */
	public static OysterReferenceSource parse(File file) {
		// Use an instance of ourselves as the SAX event handler
		DefaultHandler handler = new OysterSourceDescriptorParser();
		// Use the default (non-validating) parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);

		try {
			// Set up output stream
			setOut(new OutputStreamWriter(System.out, "UTF8"));

			// Parse the input
			SAXParser saxParser = factory.newSAXParser();

			saxParser.parse(file, handler);
		} catch (Exception ex) {
			Logger.getLogger(OysterSourceDescriptorParser.class.getName()).log(
					Level.SEVERE, OysterErrorFormatter.format(ex), ex);
		}

		return sourceDescriptor;
	}

	// FIXME: Need to add Parser Level and XML Level validation
	// i.e. if source is of type database attributes must be Name and Attribute
	// only
}

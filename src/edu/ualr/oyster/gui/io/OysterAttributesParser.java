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

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import edu.ualr.oyster.gui.core.OysterAttribute;
import edu.ualr.oyster.gui.core.OysterAttributes;
import edu.ualr.oyster.gui.utilities.OysterErrorFormatter;

/**
 * OysterAttributesParser.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterAttributesParser extends OysterXMLParser {

	/** */
	private static OysterAttributes attributes = new OysterAttributes();

	/** */
	private OysterAttribute attribute = null;

	/** */
	// ArrayList<OysterRule> identityRules = null;

	/** */
	// OysterRule rule = null;

	/** */
	String termItem = null;

	/** */
	String matchResult = null;

	/** */
	private String parent = "";

	/**
	 * Creates a new instance of <code>OysterAttributesParser</code>.
	 */
	public OysterAttributesParser() {
		super();
	}

	/**
	 * Returns the <code>OysterAttributes</code> for this
	 * <code>OysterAttributesParser</code>.
	 * 
	 * @return the <code>OysterAttributes</code>.
	 */
	public OysterAttributes getAttributes() {
		return attributes;
	}

	/**
	 * Sets the <code>OysterAttributes</code> for this
	 * <code>OysterAttributesParser</code>.
	 * 
	 * @param attributes
	 *            the <code>OysterAttributes</code> to be set.
	 */
	public static void setAttributes(OysterAttributes oAttributes) {
		attributes = oAttributes;
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

		if (eName.equalsIgnoreCase("OysterAttributes")) {
			parent = eName;
		} else if (eName.equalsIgnoreCase("Attribute")) {
			attribute = new OysterAttribute();
			parent = eName;
		}
		// else if (eName.equalsIgnoreCase("IdentityRules")){
		// identityRules = new ArrayList<OysterRule>();
		// }
		// else if (eName.equalsIgnoreCase("Rule")){
		// rule = new OysterRule();
		// parent = eName;
		// }

		// get XML attributes
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				String aName = attrs.getLocalName(i);
				// attributes name
				if ("".equals(aName))
					aName = attrs.getQName(i);

				String token = attrs.getValue(i).trim();

				if (aName.equalsIgnoreCase("System")) {
					attributes.setSystem(token);
					//System.out.println("System: " + token);
				}

				else if (aName.equalsIgnoreCase("Item")) {
					if (parent.equalsIgnoreCase("Attribute")) {
						attribute.setName(token);
						// prep so that no nulls exist for any item that is set.
						attribute.setAlgorithm("");
					} else {
						termItem = token;
					}
				} else if (aName.equalsIgnoreCase("Algo")) {
					attribute.setAlgorithm(token);
				}
				// else if(aName.equalsIgnoreCase("Ident")){
				// rule.setRuleIdentifer(token);
				// }
				else if (aName.equalsIgnoreCase("MatchResult")) {
					matchResult = token;
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

		if (eName.equalsIgnoreCase("Attribute")) {
			attributes.addAttribute(attribute);
			parent = "";
		}
		// else if (eName.equalsIgnoreCase("IdentityRules")){
		// attributes.setIdentityRules(identityRules);
		// }
		// else if (eName.equalsIgnoreCase("Rule")){
		// this.identityRules.add(rule);
		// }
		// else if (eName.equalsIgnoreCase("Term")){
		// rule.getTermList().put(termItem, matchResult);
		// parent = "";
		// }
	}

	/**
	 * This method is the main entry point for the SAX Parser.
	 * 
	 * @param file
	 *            the XML file to be parsed.
	 * @return <code>OysterAttributes</code> containing data from the file.
	 */
	public static OysterAttributes parse(File file) {
		// Use an instance of ourselves as the SAX event handler
		DefaultHandler handler = new OysterAttributesParser();
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
			Logger.getLogger(OysterAttributesParser.class.getName()).log(Level.SEVERE,
			 OysterErrorFormatter.format(ex), ex);
		}
		//JOptionPane.showMessageDialog(null, attributes.getSystem());
		return attributes;
	}

	public OysterAttribute getAttribute() {
		return attribute;
	}
}

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
import java.io.Writer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * OysterXMLParser.java
 * 
 * @author Payam Mahmoudian
 */
public abstract class OysterXMLParser extends DefaultHandler {
	/** */
	String data = null;

	/** */
	private static Writer out;

	/** */
	public OysterXMLParser() {
	}

	/**
	 * Returns the Writer for this <code>OysterXMLParser</code>.
	 * 
	 * @return the Writer.
	 */
	public Writer getOut() {
		return null;
	}

	/**
	 * Returns the Writer for this <code>OysterXMLParser</code>.
	 * 
	 * @param aOut
	 *            the Writer to be set.
	 */
	public static void setOut(Writer aOut) {
		out = aOut;
	}

	@Override
	/**
	 * Called when the Parser starts parsing the Current XML File. Handle any
	 * document specific initialization code here.
	 * @throws org.xml.sax.SAXException
	 */
	public abstract void startDocument() throws org.xml.sax.SAXException;

	@Override
	/**
	 * Called when the Parser Completes parsing the Current XML File. Handle any
	 * document specific clean up code here.
	 * @throws org.xml.sax.SAXException
	 */
	public abstract void endDocument() throws org.xml.sax.SAXException;

	@Override
	/**
	 * Called when the starting of the Element is reached. For Example if we have
	 * Tag called <Title> ... </Title>, then this method is called when <Title>
	 * tag is Encountered while parsing the Current XML File. The attrs Parameter 
	 * has the list of all Attributes declared for the Current Element in the 
	 * XML File.
	 * @param namespaceURI uri for this namespace
	 * @param lName local xml name
	 * @param qName qualified xml name
	 * @param attrs list of all Attributes declared for the Current Element
	 * @throws org.xml.sax.SAXException
	 */
	public abstract void startElement(String namespaceURI, String lName,
			String qName, Attributes attrs) throws org.xml.sax.SAXException;

	@Override
	/**
	 * Called when the Ending of the current Element is reached. For example in 
	 * the above explanation, this method is called when </Title> tag is reached
	 * @param namespaceURI uri for this namespace
	 * @param sName
	 * @param qName qualified xml name
	 * @throws org.xml.sax.SAXException
	 */
	public abstract void endElement(String namespaceURI, String sName,
			String qName) throws org.xml.sax.SAXException;

	@Override
	/**
	 * While Parsing the XML file, if extra characters like space or enter Character
	 * are encountered then this method is called. If you don't want to do anything
	 * special with these characters, then you can normally leave this method blank.
	 */
	public void characters(char[] buf, int offset, int len)
			throws org.xml.sax.SAXException {
		String s = new String(buf, offset, len);
		data = s.trim();
	}

	@Override
	/**
	 * In the XML File if the parser encounters a Processing Instruction which is
	 * declared like this  <?ProgramName:BooksLib QUERY="author, isbn, price"?> 
	 * Then this method is called where Target parameter will have
	 * "ProgramName:BooksLib" and data parameter will have  QUERY="author, isbn,
	 *  price". You can invoke a External Program from this Method if required. 
	 */
	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	/**
	 * Helper convience method to output data for testing.
	 * 
	 * @param s
	 *            the string to be output.
	 * @throws org.xml.sax.SAXException
	 */
	protected void emit(String s) throws org.xml.sax.SAXException {
		try {
			out.write(s);
			out.flush();
		} catch (IOException e) {
			throw new SAXException("I/O error", e);
		}
	}

	/**
	 * Helper convience method to output data for testing.
	 * 
	 * @throws org.xml.sax.SAXException
	 */
	protected void nl() throws org.xml.sax.SAXException {
		String lineEnd = System.getProperty("line.separator");
		try {
			out.write(lineEnd);
		} catch (IOException e) {
			throw new SAXException("I/O error", e);
		}
	}

}

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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLTreeViewer.java
 * 
 * @author Payam Mahmoudian
 */
public class XMLTreeViewer extends DefaultHandler {

	/**
	 * @return the xmlJTree
	 */
	public JTree getXmlJTree() {
		return xmlJTree;
	}

	private JTree xmlJTree;

	DefaultTreeModel treeModel;
	int lineCounter;
	DefaultMutableTreeNode base = new DefaultMutableTreeNode("XML Viewer");
	static XMLTreeViewer treeViewer = null;
	JTextField txtFile = null;

	@Override
	public void startElement(String uri, String localName, String tagName,
			Attributes attr) throws SAXException {

		DefaultMutableTreeNode current = new DefaultMutableTreeNode(tagName);

		base.add(current);
		base = current;

		for (int i = 0; i < attr.getLength(); i++) {
			DefaultMutableTreeNode currentAtt = new DefaultMutableTreeNode(
					attr.getLocalName(i) + " = " + attr.getValue(i));
			base.add(currentAtt);
		}
	}

	public void skippedEntity(String name) throws SAXException {
		System.out.println("Skipped Entity: '" + name + "'");
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		base = new DefaultMutableTreeNode("Oyster XML Viewer");
		((DefaultTreeModel) xmlJTree.getModel()).setRoot(base);
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {

		String s = new String(ch, start, length).trim();
		if (!s.equals("")) {
			DefaultMutableTreeNode current = new DefaultMutableTreeNode(
					"Descrioption : " + s);
			base.add(current);

		}
	}

	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {

		base = (DefaultMutableTreeNode) base.getParent();
	}

	// public static void main(String[] args) {
	// treeViewer = new XMLTreeViewer();
	// // treeViewer.xmlSetUp();
	// treeViewer.createUI();
	//
	// }

	@Override
	public void endDocument() throws SAXException {
		// Refresh JTree
		((DefaultTreeModel) xmlJTree.getModel()).reload();
		expandAll(xmlJTree);
	}

	public void expandAll(JTree tree) {
		int row = 0;
		while (row < tree.getRowCount()) {
			tree.expandRow(row);
			row++;
		}
	}

	public void xmlSetUp(File xmlFile) {
		try {
			SAXParserFactory fact = SAXParserFactory.newInstance();
			SAXParser parser = fact.newSAXParser();
			parser.parse(xmlFile, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JPanel createUI(File file) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		treeModel = new DefaultTreeModel(base);
		xmlJTree = new JTree(treeModel);

		JScrollPane scrollPane = new JScrollPane(xmlJTree);

		JFrame XMLViewerFrame = new JFrame();
		XMLViewerFrame.setTitle("Oyster XML Tree Viewer");

		JPanel pnl = new JPanel();
		pnl.setLayout(null);

		xmlSetUp(file);

		scrollPane.setBounds(0, 50, 500, 600);
		pnl.add(scrollPane);

		XMLViewerFrame.add(pnl);
		XMLViewerFrame.setBounds(500, 50, 500, 600);
		XMLViewerFrame.setSize(500, 700);
		XMLViewerFrame.setVisible(true);
		XMLViewerFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return pnl;
	}
}
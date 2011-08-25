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

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ualr.oyster.gui.core.OysterAttributes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * OysterXML.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterXML {

	XMLTreeViewer treeViewer = new XMLTreeViewer();
	private OysterAttributes oysterAttributes = new OysterAttributes();
	
	private JFrame frame;
	private JButton btnSelectAttributesFile;
	private JButton btnSelectLogFile;

	public String logFile;
	public String attributeFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					OysterXML window = new OysterXML();				
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OysterXML() {		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnSelectAttributesFile());
		frame.getContentPane().add(getBtnSelectLogFile());
	}

	private JButton getBtnSelectLogFile() {
		if (btnSelectLogFile == null) {
			btnSelectLogFile = new JButton("Select Log File..");
			btnSelectLogFile.addActionListener(new BtnSelectLogFileAction());
			btnSelectLogFile.setBounds(10, 11, 109, 23);
		}
		return btnSelectLogFile;
	}

	private JButton getBtnSelectAttributesFile() {
		if (btnSelectAttributesFile == null) {
			btnSelectAttributesFile = new JButton("Select Attributes File..");
			btnSelectAttributesFile
					.addActionListener(new BtnSelectAttributesFile());
			btnSelectAttributesFile.setBounds(10, 45, 139, 23);
		}
		return btnSelectAttributesFile;
	}

	private class BtnSelectLogFileAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Open text file
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("log file", "txt");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				logFile = file.getAbsolutePath();
			}
		}
	}

	private class BtnSelectAttributesFile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Open xml file
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("xml files", "xml");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				attributeFile = file.getAbsolutePath();
				treeViewer.createUI(file);
			
			
			OysterMain oMain = new OysterMain(attributeFile, logFile);
			//oMain.aParser.parse(file);
			//oMain.attributes.getSystem();	
			oMain.aParser.parse(file);
			
			System.out.println("System oysterAttributes : " + oysterAttributes.getSystem() + "-----" + oMain.attributes.getSystem());
			}
		}
	}
}

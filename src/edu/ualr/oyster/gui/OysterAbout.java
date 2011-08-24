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

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dimension;

/**
 * OysterAbout.java 
 * @author Payam Mahmoudian 
 */
@SuppressWarnings("serial")
public class OysterAbout extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSs;
	private JTextArea txtrCopyright;
	private JTextArea txtrThisLibraryIs;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
//		try {
//			OysterAbout dialog = new OysterAbout();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	//}

	/**
	 * Create the dialog.
	 */
	public OysterAbout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OysterAbout.class.getResource("/edu/ualr/oyster/gui/icon.png")));
		setTitle("About Oyster");
		setBounds(400, 120, 717, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLabel());
		contentPanel.add(getLblSs());
		contentPanel.add(getTxtrThisLibraryIs());
		contentPanel.add(getTxtrCopyright());
	}

	private JLabel getLblSs() {
		if (lblSs == null) {
			lblSs = new JLabel("");
			lblSs.setIcon(new ImageIcon("C:\\Users\\iThink\\Pictures\\oyster-splash.jpg"));
			lblSs.setBounds(0, 0, 301, 399);
		}
		return lblSs;
	}
	private JTextArea getTxtrCopyright() {
		if (txtrCopyright == null) {
			txtrCopyright = new JTextArea();
			txtrCopyright.setEditable(false);
			txtrCopyright.setBackground(SystemColor.menu);
			txtrCopyright.setFont(new Font("Arial", Font.BOLD, 12));
			txtrCopyright.setText("Oyster GUI Scriptor\r\n\r\nVersion: 0.3.1\r\nBuild id: 20110924-0227\r\n\r\n(c) Copyright 2011 John Talburt, Eric Nelson, Payam Mahmoudian\r\n\r\nThis Software is part of Oyster created in the \r\nERIQ Research Center at University of Arkansas at Little Rock");
			txtrCopyright.setRows(20);
			txtrCopyright.setBounds(311, 11, 380, 145);
		}
		return txtrCopyright;
	}
	private JTextArea getTxtrThisLibraryIs() {
		if (txtrThisLibraryIs == null) {
			txtrThisLibraryIs = new JTextArea();
			txtrThisLibraryIs.setEditable(false);
			txtrThisLibraryIs.setBackground(SystemColor.menu);
			txtrThisLibraryIs.setFont(new Font("Calibri", Font.PLAIN, 12));
			txtrThisLibraryIs.setText("Oyster is free software; you can redistribute it and/or\r\nmodify it under the terms of the GNU Lesser General Public\r\nLicense as published by the Free Software Foundation; either\r\nversion 3 of the License, or (at your option) any later version.\r\n\r\nOyster is distributed in the hope that it will be useful,\r\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\r\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  \r\nSee the GNU Lesser General Public License for more details.\r\n\r\nYou can receive a copy of the GNU Lesser General Public License from\r\nhttp://www.gnu.org/licenses/lgpl.html\r\n");
			txtrThisLibraryIs.setRows(20);
			txtrThisLibraryIs.setBounds(311, 167, 380, 211);
		}
		return txtrThisLibraryIs;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(OysterAbout.class.getResource("/edu/ualr/oyster/gui/icon64.png")));
			label.setBounds(614, 11, 64, 64);
		}
		return label;
	}
}

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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

/**
 * OysterSourceDescriptor.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterSourceDescriptor extends JFrame {

	/**
	 * Serialization Version Unique Identifier
	 */
	private static final long serialVersionUID = 530175026563156561L;

	/**
	 * Create the frame.
	 */
	private JPanel contentPane;

	public OysterSourceDescriptor() {
		setTitle("Oyster Source Descriptor");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(132, 85, 177, 77);
		contentPane.add(formattedTextField);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(41, 31, 89, 23);
		contentPane.add(btnNewButton);

	}
}

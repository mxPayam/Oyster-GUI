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

/**
 * OysterAbout.java 
 * @author Payam Mahmoudian 
 */
@SuppressWarnings("serial")
public class OysterAbout extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSs;
	private JButton okButton;

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
		setBounds(400, 120, 318, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblSs());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonAction());
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(205, Short.MAX_VALUE)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addGap(16))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	private JLabel getLblSs() {
		if (lblSs == null) {
			lblSs = new JLabel("");
			lblSs.setIcon(new ImageIcon("C:\\Users\\iThink\\Pictures\\oyster-splash.jpg"));
			lblSs.setBounds(0, 0, 301, 399);
		}
		return lblSs;
	}
	private class OkButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
}

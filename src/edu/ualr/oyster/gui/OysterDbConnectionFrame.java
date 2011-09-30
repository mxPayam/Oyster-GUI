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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import edu.ualr.oyster.gui.OysterEnum.ConnectionType;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * OysterDbConnectionFrame.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterDbConnectionFrame extends JFrame {

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * Serialization Version Unique Identifier
	 */
	private static final long serialVersionUID = -7400876107012543611L;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// OysterDbConnectionFrame frame = new OysterDbConnectionFrame();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */

	private static JFrame DBFrame;
	private static JPanel contentPane;

	private static JTextField textServer;
	private static JTextField textTable;
	private static JTextField textSID;
	private static JTextField textUsername;
	private static JTextField textPort;
	private static JTextField passwordPassword;
	private static JComboBox comboBox;
	private static String tag;
	private String flag = "";

	public JButton btnOK;
	public JButton btnCancel;

	public OysterDbConnectionFrame(String tagsource) {

		super();
		
		tag = tagsource;
		setResizable(false);
		setTitle(tag + " DB Config");
		
		this.setAlwaysOnTop(true);
		this.setBounds(800, 300, 274, 402);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int middleX = 1920;
		int middleY = 1080;
		
		Dimension d = contentPane.getPreferredSize();
		contentPane.setLocation(middleX - (d.width / 2), middleY
				- (d.height / 2)); // if you have your own middle point use this
									// function, otherwise delete this line

		JPanel panel_DatabaseType = new JPanel();
		panel_DatabaseType.setBounds(20, 18, 230, 60);
		panel_DatabaseType.setBorder(new TitledBorder(null, "Database Type",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DatabaseType.setLayout(null);

		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if( comboBox.getSelectedItem().toString() == "MSAccess" )
				{
					textServer.setEnabled(false);
					textPort.setEnabled(false);
				}
				else
				{
					textServer.setEnabled(true);
					textPort.setEnabled(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(ConnectionType.values()));
		comboBox.setBounds(12, 27, 206, 20);
		
		
		panel_DatabaseType.add(comboBox);

		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean error = CheckDBValues();

				if (!error){
				flag = setDatabaseConfiguration();
				OysterDbConnectionFrame.this.dispose();
				edu.ualr.oyster.gui.OysterRun.btnSourceDescriptor_RefreshDb.doClick();
				}
				
				
			}
		});
		btnOK.setBounds(50, 336, 94, 25);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edu.ualr.oyster.gui.OysterRun.comboBoxSourceDescriptor_AddSourceType.setEnabled(true);
				OysterDbConnectionFrame.this.dispose();
			}
		});
		btnCancel.setBounds(156, 336, 94, 25);

		JPanel panel_Authentication = new JPanel();
		panel_Authentication.setBounds(20, 202, 230, 121);
		panel_Authentication.setBorder(new TitledBorder(null, "Authentication",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Authentication.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 27, 56, 16);
		panel_Authentication.add(lblUsername);

		textUsername = new JTextField();
		textUsername.setBounds(83, 25, 135, 20);
		panel_Authentication.add(textUsername);
		textUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(26, 56, 53, 16);
		panel_Authentication.add(lblPassword);

		JButton btnTest = new JButton("Test");
		btnTest.setEnabled(false);
		btnTest.setBounds(124, 85, 94, 23);
		panel_Authentication.add(btnTest);

		JPanel panel_ServerConfig = new JPanel();
		panel_ServerConfig.setBounds(20, 91, 230, 98);
		panel_ServerConfig.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ServerConfig.setLayout(null);

		JLabel lblServer = new JLabel("Server:");
		lblServer.setBounds(15, 12, 45, 16);
		panel_ServerConfig.add(lblServer);

		textServer = new JTextField();
		textServer.setBounds(60, 10, 158, 20);
		textServer.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textServer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_ServerConfig.add(textServer);
		textServer.setColumns(10);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(25, 38, 25, 16);
		panel_ServerConfig.add(lblPort);

		textPort = new JTextField();
		textPort.setBounds(60, 36, 39, 20);
		panel_ServerConfig.add(textPort);
		textPort.setColumns(10);

		JLabel lblSid = new JLabel("SID:");
		lblSid.setBounds(123, 38, 32, 16);
		panel_ServerConfig.add(lblSid);

		textSID = new JTextField();
		textSID.setBounds(149, 36, 69, 20);
		panel_ServerConfig.add(textSID);
		textSID.setColumns(10);

		passwordPassword = new JTextField();
		passwordPassword.setBounds(83, 55, 135, 20);
		panel_Authentication.add(passwordPassword);
		contentPane.add(panel_Authentication);
		contentPane.add(panel_ServerConfig);

		JLabel lblTable = new JLabel("Table:");
		lblTable.setBounds(18, 64, 32, 16);
		panel_ServerConfig.add(lblTable);

		textTable = new JTextField();
		textTable.setBounds(60, 62, 158, 20);
		panel_ServerConfig.add(textTable);
		textTable.setColumns(10);
		contentPane.add(panel_DatabaseType);
		contentPane.add(btnOK);
		contentPane.add(btnCancel);

		
	}

	private boolean CheckDBValues() {
		boolean error = false;
		
		if (comboBox.getSelectedIndex() < 5){
			if (textServer.getText().trim().equals("") || textServer.getText() == null){
				JOptionPane.showMessageDialog(contentPane, "Please enter a server address!", "Error!", 0);
				error = true;
			}else 
				if (textPort.getText().trim().equals("") || textPort.getText() == null){
					JOptionPane.showMessageDialog(contentPane, "Please enter a server port number!", "Error!", 0);
					error = true;
			}else
				if (textTable.getText().trim().equals("") || textTable.getText() == null){
					JOptionPane.showMessageDialog(contentPane, "Please enter a database table name!", "Error!", 0);
					error = true;
			}
			
		}
		
		
		return error;
	}

	public void showDatabaseFrame(String tag) {
		try {
			OysterDbConnectionFrame dbFrame = new OysterDbConnectionFrame(tag);
			dbFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * // TODO Add description
	 */
	public String setDatabaseConfiguration() {

		// OuterClass.InnerClass innerObject = outerObject.new InnerClass();

		if (tag == "IdentityInput") {
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput
					.setServer(textServer.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput.setSID(textSID
					.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput
					.setPort(textPort.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput
					.setUserID(textUsername.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput
					.setPasswdord(passwordPassword.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput
					.setTableName(textTable.getText());
		} else if (tag == "RefrenceSource") {
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource
					.setServer(textServer.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource.setSID(textSID
					.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource
					.setPort(textPort.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource
					.setUserID(textUsername.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource
					.setPasswdord(passwordPassword.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource
					.setTableName(textTable.getText());
			edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource.setConnectionType( comboBox.getSelectedItem().toString() );
		}

		return tag;
		// JOptionPane.showMessageDialog(rootPane, "IdentityInput: " +
		// edu.ualr.oyster.gui.OysterRun.dbConfigIdentityInput.getTableName() +
		// "\n" + "RefrenceSource: " +
		// edu.ualr.oyster.gui.OysterRun.dbConfigRefrenceSource.getTableName());

	}
}

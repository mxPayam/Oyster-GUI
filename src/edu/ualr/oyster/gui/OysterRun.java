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

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.Option;

import edu.ualr.oyster.gui.OysterEnum.EREngineType;
import edu.ualr.oyster.gui.OysterEnum.IdentityInputType;
import edu.ualr.oyster.gui.OysterEnum.IdentityOutputType;
import edu.ualr.oyster.gui.OysterEnum.LinkOutputType;
import edu.ualr.oyster.gui.OysterEnum.LogDebug;
import edu.ualr.oyster.gui.OysterEnum.LogExplanation;
import edu.ualr.oyster.gui.OysterEnum.SourceType;
import edu.ualr.oyster.gui.core.OysterAttribute;
import edu.ualr.oyster.gui.core.OysterAttributes;
import edu.ualr.oyster.gui.core.OysterReferenceSource;
import edu.ualr.oyster.gui.core.OysterRunScript;
import edu.ualr.oyster.gui.io.OysterAttributesParser;
import edu.ualr.oyster.gui.io.OysterSourceDescriptorParser;
import edu.ualr.oyster.gui.io.XMLTreeViewer;
import edu.ualr.oyster.gui.utilities.OysterComparator;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

/**
 * OysterRun.java
 * 
 * @author Payam Mahmoudian
 */
public class OysterRun {

	private JFrame frm_OysterGUIScriptor;
	private JTabbedPane tabbedPane_Oyster;

	/**
	 * Define OysterAttributes Fields
	 */
	private JPanel panel_OysterAttributes;
	private JPanel panelAttributes_Comment;
	private JTextField textFieldAttributes_Document;
	private JTextField textFieldAttributes_CreatedOn;
	private JTextField textFieldAttributes_Author;
	private JLabel labelAttributes_Description;
	private JLabel labelAttributes_Author;
	private JLabel labelAttributes_CreatedOn;
	private JLabel labelAttributes_Document;
	private JTextArea textAreaAttributes_Description;

	/**
	 * Define OysterSourceDescriptor Fields
	 */
	private JPanel panel_OysterSourceDescriptor;
	private JPanel panelSourceDescriptor_Comment;
	private JTextField textFieldSourceDescriptor_Document;
	private JTextField textFieldSourceDescriptor_CreatedOn;
	private JTextField textFieldSourceDescriptor_Author;
	private JLabel labelSourceDescriptor_Description;
	private JLabel labelSourceDescriptor_Author;
	private JLabel labelSourceDescriptor_CreatedOn;
	private JLabel labelSourceDescriptor_Document;
	private JTextArea textAreaSourceDescriptor_Description;

	/**
	 * Define OysterRunScript Fields
	 */
	private JPanel panel_OysterRunScript;
	private JPanel panelRunScript_Comment;
	private JTextField textFieldRunScript_Document;
	private JTextField textFieldRunScript_CreatedOn;
	private JTextField textFieldRunScript_Author;
	private JLabel labelRunScript_Description;
	private JLabel labelRunScript_Author;
	private JLabel labelRunScript_CreatedOn;
	private JLabel labelRunScript_Document;
	private JTextArea textAreaRunScript_Description;
	private JPanel panelRunScript_LogSettings;
	private JLabel labelRunScript_Explanation;
	private JComboBox comboBoxRunScript_Explanation;
	private JLabel labelRunScript_LogFileNum;
	private JSpinner spinnerRunScript_LogFileNum;
	private JTextField textFieldRunScript_LogFileSize;
	private JLabel labelRunScript_LogFileSize;
	private JComboBox comboBoxRunScript_Debug;
	private JLabel labelRunScript_Debug;
	private JLabel labelRunScript_LogDirectory;
	private JTextField textFieldRunScript_LogDirectory;
	private JButton btnRunScript_LogDirSelect;
	private JPanel panelRunScript_Run;
	private JLabel labelRunScript_EngineType;
	private JComboBox comboBoxRunScript_EngineType;
	private JButton btnRunScript_CreateRunScript;
	private JPanel panelRunScript_IdentityInput;
	private JPanel panelRunScript_IdentityOutput;
	private JPanel panelRunScript_LinkOutput;
	private JLabel labelRunScript_IdentityInputType;
	private JComboBox comboBoxRunScript_IdentityInputType;
	private JTextField textRunScript_IdentityInputPath;
	private JButton btnRunScript_IdentityInputSelect;
	private JLabel labelRunScript_IdentityOutputType;
	private JComboBox comboBox_RunScript_IdentityOutputType;
	private JTextField textRunScript_IdentityOutputPath;
	private JButton btnRunScript_IdentityOutputSelect;
	private JTextField textRunScript_LinkOutputPath;
	private JButton btnRunScript_LinkOutputSelect;
	private JLabel labelRunScript_LinkOutputPath;
	private JButton btnAttributes_XMLfileSelect;
	private JTextField textAttributes_XMLfilePath;

	/**
	 * TODO : Should I Change to Private ?
	 */

	public static OysterDataBinding dbBindingIdentityInput = new OysterDataBinding();
	public static OysterDataBinding dbBindingRefrenceSource = new OysterDataBinding();

	public static OysterDataBinding.DatabaseConfig dbConfigIdentityInput = dbBindingIdentityInput.new DatabaseConfig(
			"IdentityInput");
	public static OysterDataBinding.DatabaseConfig dbConfigRefrenceSource = dbBindingRefrenceSource.new DatabaseConfig(
			"IdentityInput");

	public OysterDbConnectionFrame dbFrameIdentityInput = new OysterDbConnectionFrame(
			"IdentityInput");
	public OysterDbConnectionFrame dbFrameRefrenceSource = new OysterDbConnectionFrame(
			"RefrenceSource");

	OysterRunScript.Comments comment = new OysterRunScript.Comments();
	OysterRunScript.LogSettings logSettings = new OysterRunScript.LogSettings();
	OysterRunScript.LogFile logFile = new OysterRunScript.LogFile();
	OysterRunScript.AttributePath attributePath = new OysterRunScript.AttributePath();
	OysterRunScript.EREngine erEngine = new OysterRunScript.EREngine();
	OysterRunScript.IdentityInput identityInput = new OysterRunScript.IdentityInput();
	OysterRunScript.IdentityOutput identityOutput = new OysterRunScript.IdentityOutput();
	OysterRunScript.LinkOutput linkOutput = new OysterRunScript.LinkOutput();

	private OysterReferenceSource referenceSource = new OysterReferenceSource();
	private OysterAttributes attributes = new OysterAttributes();

	private StringBuffer OysterRunScriptXml = new StringBuffer("");
	private StringBuffer OysterSourceDescriptorXml = new StringBuffer("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OysterRun window = new OysterRun();
					window.frm_OysterGUIScriptor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OysterRun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm_OysterGUIScriptor = new JFrame();
		Color color = new Color(230, 230, 230);
		frm_OysterGUIScriptor.getContentPane().setBackground(color);
		frm_OysterGUIScriptor.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						OysterRun.class
								.getResource("/edu/ualr/oyster/gui/icon.png")));
		frm_OysterGUIScriptor.setTitle("Oyster GUI Scriptor");
		frm_OysterGUIScriptor.setBounds(100, 100, 1155, 562);
		frm_OysterGUIScriptor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(
				frm_OysterGUIScriptor.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addComponent(getToolBar(),
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										875, Short.MAX_VALUE)
								.addComponent(getLabel_ERIQlogo()))
				.addComponent(getTabbedPane_OysterScriptor(),
						GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				getToolBar(),
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																getLabel_ERIQlogo()))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												getTabbedPane_OysterScriptor(),
												GroupLayout.PREFERRED_SIZE,
												458, GroupLayout.PREFERRED_SIZE)));
		frm_OysterGUIScriptor.getContentPane().setLayout(groupLayout);
		frm_OysterGUIScriptor.setJMenuBar(getMenuBar());
	}

	/**
	 * Create OysterScriptor TabbedPane
	 */
	private JTabbedPane getTabbedPane_OysterScriptor() {
		if (tabbedPane_Oyster == null) {
			tabbedPane_Oyster = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_Oyster.addTab("Oyster Attributes", null,
					getPanel_OysterAttributes(), null);
			tabbedPane_Oyster.addTab("Oyster SourceDescriptor", null,
					getPanel_OysterSourceDescriptor(), null);
			tabbedPane_Oyster.addTab("Oyster RunScript", null,
					getPanel_OysterRunScript(), null);
		}
		return tabbedPane_Oyster;
	}

	/**
	 * Create Oyster Attributes Panel
	 */
	private JPanel getPanel_OysterAttributes() {
		if (panel_OysterAttributes == null) {
			panel_OysterAttributes = new JPanel();
			panel_OysterAttributes
					.addComponentListener(new Panel_OysterAttributesComponent());
			panel_OysterAttributes.setLayout(null);
			panel_OysterAttributes.add(getPanelAttributes_Comment());
			panel_OysterAttributes.add(getPanelAttributes_XMLfilePath());
		}
		return panel_OysterAttributes;
	}

	private JPanel getPanelAttributes_Comment() {
		if (panelAttributes_Comment == null) {
			panelAttributes_Comment = new JPanel();
			panelAttributes_Comment.setBounds(10, 11, 355, 193);
			panelAttributes_Comment.setBorder(new TitledBorder(null, "Comment",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelAttributes_Comment.setDoubleBuffered(false);
			GroupLayout gl_panelAttributes_Comment = new GroupLayout(
					panelAttributes_Comment);
			gl_panelAttributes_Comment
					.setHorizontalGroup(gl_panelAttributes_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelAttributes_Comment
											.createSequentialGroup()
											.addGroup(
													gl_panelAttributes_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(31)
																			.addComponent(
																					getLabelAttributes_Author())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldAttributes_CreatedOn(),
																					GroupLayout.DEFAULT_SIZE,
																					265,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(11)
																			.addComponent(
																					getLabelAttributes_Description())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextAreaAttributes_Description(),
																					GroupLayout.DEFAULT_SIZE,
																					265,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(16)
																			.addComponent(
																					getLabelAttributes_Document())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldAttributes_Document(),
																					GroupLayout.DEFAULT_SIZE,
																					265,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(10)
																			.addComponent(
																					getLabelAttributes_CreatedOn())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldAttributes_Author(),
																					GroupLayout.DEFAULT_SIZE,
																					265,
																					Short.MAX_VALUE)))
											.addContainerGap()));
			gl_panelAttributes_Comment
					.setVerticalGroup(gl_panelAttributes_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelAttributes_Comment
											.createSequentialGroup()
											.addGroup(
													gl_panelAttributes_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(3)
																			.addComponent(
																					getLabelAttributes_Document()))
															.addComponent(
																	getTextFieldAttributes_Document(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panelAttributes_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(9)
																			.addComponent(
																					getLabelAttributes_CreatedOn()))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldAttributes_Author(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGroup(
													gl_panelAttributes_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(9)
																			.addComponent(
																					getLabelAttributes_Author()))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldAttributes_CreatedOn(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGroup(
													gl_panelAttributes_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(13)
																			.addComponent(
																					getLabelAttributes_Description())
																			.addGap(41))
															.addGroup(
																	gl_panelAttributes_Comment
																			.createSequentialGroup()
																			.addGap(6)
																			.addComponent(
																					getTextAreaAttributes_Description(),
																					GroupLayout.DEFAULT_SIZE,
																					72,
																					Short.MAX_VALUE)
																			.addContainerGap()))));
			panelAttributes_Comment.setLayout(gl_panelAttributes_Comment);
		}
		return panelAttributes_Comment;
	}

	private JLabel getLabelAttributes_Description() {
		if (labelAttributes_Description == null) {
			labelAttributes_Description = new JLabel();
			labelAttributes_Description.setText("Description:");
		}
		return labelAttributes_Description;
	}

	private JLabel getLabelAttributes_Author() {
		if (labelAttributes_Author == null) {
			labelAttributes_Author = new JLabel();
			labelAttributes_Author.setText("Author:");
		}
		return labelAttributes_Author;
	}

	private JLabel getLabelAttributes_CreatedOn() {
		if (labelAttributes_CreatedOn == null) {
			labelAttributes_CreatedOn = new JLabel();
			labelAttributes_CreatedOn.setText("Created on:");
		}
		return labelAttributes_CreatedOn;
	}

	private JLabel getLabelAttributes_Document() {
		if (labelAttributes_Document == null) {
			labelAttributes_Document = new JLabel();
			labelAttributes_Document.setText("Document:");
		}
		return labelAttributes_Document;
	}

	private JTextField getTextFieldAttributes_Document() {
		if (textFieldAttributes_Document == null) {
			textFieldAttributes_Document = new JTextField();
			textFieldAttributes_Document.setText("OysterAttributes.xml");
			textFieldAttributes_Document
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldAttributes_Document;
	}

	private JTextField getTextFieldAttributes_Author() {
		if (textFieldAttributes_CreatedOn == null) {
			textFieldAttributes_CreatedOn = new JTextField();
			textFieldAttributes_CreatedOn
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldAttributes_CreatedOn;
	}

	private JTextField getTextFieldAttributes_CreatedOn() {
		if (textFieldAttributes_Author == null) {
			textFieldAttributes_Author = new JTextField();
			textFieldAttributes_Author.setText("Payam Mahmoudian");
			textFieldAttributes_Author
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldAttributes_Author;
	}

	private JTextArea getTextAreaAttributes_Description() {
		if (textAreaAttributes_Description == null) {
			textAreaAttributes_Description = new JTextArea();
			textAreaAttributes_Description.setBorder(UIManager
					.getBorder("TitledBorder.border"));
			textAreaAttributes_Description.setBackground(UIManager
					.getColor("controlHighlight"));
		}
		return textAreaAttributes_Description;
	}

	/**
	 * Create Oyster SourceDescriptor Panel
	 */
	private JPanel getPanel_OysterSourceDescriptor() {
		if (panel_OysterSourceDescriptor == null) {
			panel_OysterSourceDescriptor = new JPanel();
			panel_OysterSourceDescriptor
					.addComponentListener(new Panel_OysterSourceDescriptorComponent());
			panel_OysterSourceDescriptor.setLayout(null);
			panel_OysterSourceDescriptor
					.add(getPanelSourceDescriptor_Comment());
			panel_OysterSourceDescriptor
					.add(getPanelSourceDescriptor_AddSource());
			panel_OysterSourceDescriptor
					.add(getPanelSourceDescriptor_DeleteSource());
			panel_OysterSourceDescriptor
					.add(getPanelSourceDescriptor_AddTextFile());
			panel_OysterSourceDescriptor
					.add(getPanelSourceDescriptor_Sources());
		}
		return panel_OysterSourceDescriptor;
	}

	private JPanel getPanelSourceDescriptor_Comment() {
		if (panelSourceDescriptor_Comment == null) {
			panelSourceDescriptor_Comment = new JPanel();
			panelSourceDescriptor_Comment.setBounds(10, 11, 355, 193);
			panelSourceDescriptor_Comment.setBorder(new TitledBorder(null,
					"Comment", TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			panelSourceDescriptor_Comment.setDoubleBuffered(false);
			GroupLayout gl_panelSourceDescriptor_Comment = new GroupLayout(
					panelSourceDescriptor_Comment);
			gl_panelSourceDescriptor_Comment
					.setHorizontalGroup(gl_panelSourceDescriptor_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_Comment
											.createSequentialGroup()
											.addGroup(
													gl_panelSourceDescriptor_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(16)
																			.addComponent(
																					getLabelSourceDescriptor_Document())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldSourceDescriptor_Document(),
																					GroupLayout.DEFAULT_SIZE,
																					260,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(10)
																			.addComponent(
																					getLabelSourceDescriptor_CreatedOn())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldSourceDescriptor_Author(),
																					GroupLayout.DEFAULT_SIZE,
																					260,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(31)
																			.addComponent(
																					getLabelSourceDescriptor_Author())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldSourceDescriptor_CreatedOn(),
																					GroupLayout.DEFAULT_SIZE,
																					260,
																					Short.MAX_VALUE))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(11)
																			.addComponent(
																					getLabelSourceDescriptor_Description())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextAreaSourceDescriptor_Description(),
																					GroupLayout.DEFAULT_SIZE,
																					260,
																					Short.MAX_VALUE)))
											.addContainerGap()));
			gl_panelSourceDescriptor_Comment
					.setVerticalGroup(gl_panelSourceDescriptor_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_Comment
											.createSequentialGroup()
											.addGroup(
													gl_panelSourceDescriptor_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(3)
																			.addComponent(
																					getLabelSourceDescriptor_Document()))
															.addComponent(
																	getTextFieldSourceDescriptor_Document(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panelSourceDescriptor_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(9)
																			.addComponent(
																					getLabelSourceDescriptor_CreatedOn()))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldSourceDescriptor_Author(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGroup(
													gl_panelSourceDescriptor_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(9)
																			.addComponent(
																					getLabelSourceDescriptor_Author()))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldSourceDescriptor_CreatedOn(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGroup(
													gl_panelSourceDescriptor_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addGap(13)
																			.addComponent(
																					getLabelSourceDescriptor_Description()))
															.addGroup(
																	gl_panelSourceDescriptor_Comment
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextAreaSourceDescriptor_Description(),
																					GroupLayout.DEFAULT_SIZE,
																					73,
																					Short.MAX_VALUE)))
											.addContainerGap()));
			panelSourceDescriptor_Comment
					.setLayout(gl_panelSourceDescriptor_Comment);
		}
		return panelSourceDescriptor_Comment;
	}

	private JLabel getLabelSourceDescriptor_Description() {
		if (labelSourceDescriptor_Description == null) {
			labelSourceDescriptor_Description = new JLabel();
			labelSourceDescriptor_Description.setText("Description:");
		}
		return labelSourceDescriptor_Description;
	}

	private JLabel getLabelSourceDescriptor_Author() {
		if (labelSourceDescriptor_Author == null) {
			labelSourceDescriptor_Author = new JLabel();
			labelSourceDescriptor_Author.setText("Author:");
		}
		return labelSourceDescriptor_Author;
	}

	private JLabel getLabelSourceDescriptor_CreatedOn() {
		if (labelSourceDescriptor_CreatedOn == null) {
			labelSourceDescriptor_CreatedOn = new JLabel();
			labelSourceDescriptor_CreatedOn.setText("Created on:");
		}
		return labelSourceDescriptor_CreatedOn;
	}

	private JLabel getLabelSourceDescriptor_Document() {
		if (labelSourceDescriptor_Document == null) {
			labelSourceDescriptor_Document = new JLabel();
			labelSourceDescriptor_Document.setText("Document:");
		}
		return labelSourceDescriptor_Document;
	}

	private JTextField getTextFieldSourceDescriptor_Document() {
		if (textFieldSourceDescriptor_Document == null) {
			textFieldSourceDescriptor_Document = new JTextField();
			textFieldSourceDescriptor_Document
					.setText("OysterSourceDescriptor.xml");
			textFieldSourceDescriptor_Document
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldSourceDescriptor_Document;
	}

	private JTextField getTextFieldSourceDescriptor_Author() {
		if (textFieldSourceDescriptor_CreatedOn == null) {
			textFieldSourceDescriptor_CreatedOn = new JTextField();
			textFieldSourceDescriptor_CreatedOn
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldSourceDescriptor_CreatedOn;
	}

	private JTextField getTextFieldSourceDescriptor_CreatedOn() {
		if (textFieldSourceDescriptor_Author == null) {
			textFieldSourceDescriptor_Author = new JTextField();
			textFieldSourceDescriptor_Author.setText("Payam Mahmoudian");
			textFieldSourceDescriptor_Author
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldSourceDescriptor_Author;
	}

	private JTextArea getTextAreaSourceDescriptor_Description() {
		if (textAreaSourceDescriptor_Description == null) {
			textAreaSourceDescriptor_Description = new JTextArea();
			textAreaSourceDescriptor_Description.setBorder(UIManager
					.getBorder("TitledBorder.border"));
			textAreaSourceDescriptor_Description.setBackground(UIManager
					.getColor("controlHighlight"));
		}
		return textAreaSourceDescriptor_Description;
	}

	/**
	 * Create Oyster RunScript Panel
	 */
	private JPanel getPanel_OysterRunScript() {
		if (panel_OysterRunScript == null) {
			panel_OysterRunScript = new JPanel();
			panel_OysterRunScript
					.addComponentListener(new Panel_OysterRunScriptComponent());
			panel_OysterRunScript.setLayout(null);
			panel_OysterRunScript.add(getPanelRunScript_Comment());
			panel_OysterRunScript.add(getPanelRunScript_LogSettings());
			panel_OysterRunScript.add(getPanelRunScript_IdentityInput());
			panel_OysterRunScript.add(getPanelRunScript_IdentityOutput());
			panel_OysterRunScript.add(getPanelRunScript_Run());
			panel_OysterRunScript.add(getPanelRunScript_LinkOutput());
			panel_OysterRunScript.add(getPanelRunScript_ReferenceSources());
			panel_OysterRunScript.add(getPanelRunScript_Attributes());
		}
		return panel_OysterRunScript;
	}

	private JPanel getPanelRunScript_Comment() {
		if (panelRunScript_Comment == null) {
			panelRunScript_Comment = new JPanel();
			panelRunScript_Comment.setBounds(10, 11, 355, 193);
			panelRunScript_Comment.setBorder(new TitledBorder(null, "Comment",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRunScript_Comment.setDoubleBuffered(false);
			GroupLayout gl_panelRunScript_Comment = new GroupLayout(
					panelRunScript_Comment);
			gl_panelRunScript_Comment
					.setHorizontalGroup(gl_panelRunScript_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_Comment
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	getLabelRunScript_Description(),
																	Alignment.TRAILING)
															.addComponent(
																	getLabelRunScript_Author(),
																	Alignment.TRAILING)
															.addComponent(
																	getLabelRunScript_CreatedOn(),
																	Alignment.TRAILING)
															.addComponent(
																	getLabelRunScript_Document(),
																	Alignment.TRAILING))
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	getTextFieldRunScript_Document(),
																	GroupLayout.DEFAULT_SIZE,
																	253,
																	Short.MAX_VALUE)
															.addComponent(
																	getTextFieldRunScript_Author(),
																	GroupLayout.DEFAULT_SIZE,
																	253,
																	Short.MAX_VALUE)
															.addComponent(
																	getTextFieldRunScript_CreatedOn(),
																	GroupLayout.DEFAULT_SIZE,
																	253,
																	Short.MAX_VALUE)
															.addComponent(
																	getTextAreaRunScript_Description(),
																	Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE,
																	253,
																	Short.MAX_VALUE))
											.addContainerGap()));
			gl_panelRunScript_Comment
					.setVerticalGroup(gl_panelRunScript_Comment
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_Comment
											.createSequentialGroup()
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_Document())
															.addComponent(
																	getTextFieldRunScript_Document(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_CreatedOn())
															.addComponent(
																	getTextFieldRunScript_Author(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_Author())
															.addComponent(
																	getTextFieldRunScript_CreatedOn(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addGroup(
													gl_panelRunScript_Comment
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_Description())
															.addComponent(
																	getTextAreaRunScript_Description(),
																	GroupLayout.DEFAULT_SIZE,
																	62,
																	Short.MAX_VALUE))
											.addGap(11)));
			panelRunScript_Comment.setLayout(gl_panelRunScript_Comment);
		}
		return panelRunScript_Comment;
	}

	private JLabel getLabelRunScript_Description() {
		if (labelRunScript_Description == null) {
			labelRunScript_Description = new JLabel();
			labelRunScript_Description.setText("Description:");
		}
		return labelRunScript_Description;
	}

	private JLabel getLabelRunScript_Author() {
		if (labelRunScript_Author == null) {
			labelRunScript_Author = new JLabel();
			labelRunScript_Author.setText("Author:");
		}
		return labelRunScript_Author;
	}

	private JLabel getLabelRunScript_CreatedOn() {
		if (labelRunScript_CreatedOn == null) {
			labelRunScript_CreatedOn = new JLabel();
			labelRunScript_CreatedOn.setText("Created on:");
		}
		return labelRunScript_CreatedOn;
	}

	private JLabel getLabelRunScript_Document() {
		if (labelRunScript_Document == null) {
			labelRunScript_Document = new JLabel();
			labelRunScript_Document.setText("Document:");
		}
		return labelRunScript_Document;
	}

	private JTextField getTextFieldRunScript_Document() {
		if (textFieldRunScript_Document == null) {
			textFieldRunScript_Document = new JTextField();
			textFieldRunScript_Document.setText("OysterRunScript.xml");
			textFieldRunScript_Document
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldRunScript_Document;
	}

	private JTextField getTextFieldRunScript_Author() {
		if (textFieldRunScript_CreatedOn == null) {
			textFieldRunScript_CreatedOn = new JTextField();
			textFieldRunScript_CreatedOn
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldRunScript_CreatedOn;
	}

	private JTextField getTextFieldRunScript_CreatedOn() {
		if (textFieldRunScript_Author == null) {
			textFieldRunScript_Author = new JTextField();
			textFieldRunScript_Author.setText("Payam Mahmoudian");
			textFieldRunScript_Author
					.setBackground(SystemColor.controlHighlight);
		}
		return textFieldRunScript_Author;
	}

	private JTextArea getTextAreaRunScript_Description() {
		if (textAreaRunScript_Description == null) {
			textAreaRunScript_Description = new JTextArea();
			textAreaRunScript_Description.setBorder(UIManager
					.getBorder("TitledBorder.border"));
			textAreaRunScript_Description.setBackground(UIManager
					.getColor("controlHighlight"));
		}
		return textAreaRunScript_Description;
	}

	private JPanel getPanelRunScript_LogSettings() {
		if (panelRunScript_LogSettings == null) {
			panelRunScript_LogSettings = new JPanel();
			panelRunScript_LogSettings.setBounds(371, 11, 325, 193);
			panelRunScript_LogSettings.setBorder(new TitledBorder(null,
					"Log Settings", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GroupLayout gl_panelRunScript_LogSettings = new GroupLayout(
					panelRunScript_LogSettings);
			gl_panelRunScript_LogSettings
					.setHorizontalGroup(gl_panelRunScript_LogSettings
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_LogSettings
											.createSequentialGroup()
											.addGroup(
													gl_panelRunScript_LogSettings
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(10)
																			.addComponent(
																					getLabelRunScript_Explanation())
																			.addGap(10)
																			.addComponent(
																					getComboBoxRunScript_Explanation(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(18)
																			.addComponent(
																					getLabelRunScript_LogFileNum())
																			.addGap(9)
																			.addComponent(
																					getSpinnerRunScript_LogFileNum(),
																					GroupLayout.PREFERRED_SIZE,
																					39,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(35)
																			.addComponent(
																					getLabelRunScript_Debug())
																			.addGap(10)
																			.addComponent(
																					getComboBoxRunScript_Debug(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(20)
																			.addComponent(
																					getLabelRunScript_LogFileSize())
																			.addGap(9)
																			.addComponent(
																					getTextFieldRunScript_LogFileSize(),
																					GroupLayout.PREFERRED_SIZE,
																					67,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(10)
																			.addComponent(
																					getLabelRunScript_LogDirectory())
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getTextFieldRunScript_LogDirectory(),
																					GroupLayout.PREFERRED_SIZE,
																					188,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					getBtnRunScript_LogDirSelect())))
											.addContainerGap()));
			gl_panelRunScript_LogSettings
					.setVerticalGroup(gl_panelRunScript_LogSettings
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_LogSettings
											.createSequentialGroup()
											.addGap(11)
											.addGroup(
													gl_panelRunScript_LogSettings
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(3)
																			.addComponent(
																					getLabelRunScript_Explanation()))
															.addComponent(
																	getComboBoxRunScript_Explanation(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(6)
																			.addComponent(
																					getLabelRunScript_LogFileNum()))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(3)
																			.addComponent(
																					getSpinnerRunScript_LogFileNum(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(10)
											.addGroup(
													gl_panelRunScript_LogSettings
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					getLabelRunScript_Debug()))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(1)
																			.addComponent(
																					getComboBoxRunScript_Debug(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					getLabelRunScript_LogFileSize()))
															.addComponent(
																	getTextFieldRunScript_LogFileSize(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panelRunScript_LogSettings
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(50)
																			.addComponent(
																					getLabelRunScript_LogDirectory()))
															.addGroup(
																	gl_panelRunScript_LogSettings
																			.createSequentialGroup()
																			.addGap(47)
																			.addGroup(
																					gl_panelRunScript_LogSettings
																							.createParallelGroup(
																									Alignment.BASELINE)
																							.addComponent(
																									getTextFieldRunScript_LogDirectory(),
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.DEFAULT_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									getBtnRunScript_LogDirSelect()))))
											.addGap(2)));
			panelRunScript_LogSettings.setLayout(gl_panelRunScript_LogSettings);
		}
		return panelRunScript_LogSettings;
	}

	private JLabel getLabelRunScript_Explanation() {
		if (labelRunScript_Explanation == null) {
			labelRunScript_Explanation = new JLabel();
			labelRunScript_Explanation.setText("Explanation:");
		}
		return labelRunScript_Explanation;
	}

	private JComboBox getComboBoxRunScript_Explanation() {
		if (comboBoxRunScript_Explanation == null) {
			comboBoxRunScript_Explanation = new JComboBox();
			comboBoxRunScript_Explanation.setModel(new DefaultComboBoxModel(
					LogExplanation.values()));
			comboBoxRunScript_Explanation.setSelectedIndex(1);
		}
		return comboBoxRunScript_Explanation;
	}

	private JLabel getLabelRunScript_LogFileNum() {
		if (labelRunScript_LogFileNum == null) {
			labelRunScript_LogFileNum = new JLabel();
			labelRunScript_LogFileNum.setText("LogFile Num:");
		}
		return labelRunScript_LogFileNum;
	}

	private JSpinner getSpinnerRunScript_LogFileNum() {
		if (spinnerRunScript_LogFileNum == null) {
			spinnerRunScript_LogFileNum = new JSpinner();
			spinnerRunScript_LogFileNum.setModel(new SpinnerNumberModel(
					new Integer(1), new Integer(0), null, new Integer(1)));
		}
		return spinnerRunScript_LogFileNum;
	}

	private JTextField getTextFieldRunScript_LogFileSize() {
		if (textFieldRunScript_LogFileSize == null) {
			textFieldRunScript_LogFileSize = new JTextField();
			textFieldRunScript_LogFileSize.setText("100000000");
		}
		return textFieldRunScript_LogFileSize;
	}

	private JLabel getLabelRunScript_LogFileSize() {
		if (labelRunScript_LogFileSize == null) {
			labelRunScript_LogFileSize = new JLabel();
			labelRunScript_LogFileSize.setText("LogFile Size:");
		}
		return labelRunScript_LogFileSize;
	}

	private JComboBox getComboBoxRunScript_Debug() {
		if (comboBoxRunScript_Debug == null) {
			comboBoxRunScript_Debug = new JComboBox();
			comboBoxRunScript_Debug.setModel(new DefaultComboBoxModel(LogDebug
					.values()));
			comboBoxRunScript_Debug.setSelectedIndex(1);
		}
		return comboBoxRunScript_Debug;
	}

	private JLabel getLabelRunScript_Debug() {
		if (labelRunScript_Debug == null) {
			labelRunScript_Debug = new JLabel();
			labelRunScript_Debug.setText("Debug:");
		}
		return labelRunScript_Debug;
	}

	private JLabel getLabelRunScript_LogDirectory() {
		if (labelRunScript_LogDirectory == null) {
			labelRunScript_LogDirectory = new JLabel("Path:");
		}
		return labelRunScript_LogDirectory;
	}

	private JTextField getTextFieldRunScript_LogDirectory() {
		if (textFieldRunScript_LogDirectory == null) {
			textFieldRunScript_LogDirectory = new JTextField();
			textFieldRunScript_LogDirectory
					.setText(" Absolute Path to Log Directory");
			textFieldRunScript_LogDirectory.setEnabled(false);
		}
		return textFieldRunScript_LogDirectory;
	}

	private JButton getBtnRunScript_LogDirSelect() {
		if (btnRunScript_LogDirSelect == null) {
			btnRunScript_LogDirSelect = new JButton();
			btnRunScript_LogDirSelect
					.addActionListener(new BtnRunScript_LogDirSelectAction());
			btnRunScript_LogDirSelect.setText("Select..");
		}
		return btnRunScript_LogDirSelect;
	}

	private JPanel getPanelRunScript_Run() {
		if (panelRunScript_Run == null) {
			panelRunScript_Run = new JPanel();
			panelRunScript_Run.setBounds(829, 284, 295, 116);
			panelRunScript_Run.setBorder(new TitledBorder(null, "Run",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panelRunScript_Run = new GroupLayout(
					panelRunScript_Run);
			gl_panelRunScript_Run
					.setHorizontalGroup(gl_panelRunScript_Run
							.createParallelGroup(Alignment.TRAILING)
							.addGroup(
									gl_panelRunScript_Run
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getLabelRunScript_EngineType())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getComboBoxRunScript_EngineType(),
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap(55,
													Short.MAX_VALUE))
							.addGroup(
									gl_panelRunScript_Run
											.createSequentialGroup()
											.addContainerGap(112,
													Short.MAX_VALUE)
											.addComponent(
													getBtnRunScript_CreateRunScript())
											.addContainerGap()));
			gl_panelRunScript_Run
					.setVerticalGroup(gl_panelRunScript_Run
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_Run
											.createSequentialGroup()
											.addGap(5)
											.addGroup(
													gl_panelRunScript_Run
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_EngineType())
															.addComponent(
																	getComboBoxRunScript_EngineType(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addComponent(
													getBtnRunScript_CreateRunScript(),
													GroupLayout.DEFAULT_SIZE,
													35, Short.MAX_VALUE)
											.addContainerGap()));
			panelRunScript_Run.setLayout(gl_panelRunScript_Run);
		}
		return panelRunScript_Run;
	}

	private JLabel getLabelRunScript_EngineType() {
		if (labelRunScript_EngineType == null) {
			labelRunScript_EngineType = new JLabel();
			labelRunScript_EngineType.setText("ER Engine:");
		}
		return labelRunScript_EngineType;
	}

	private JComboBox getComboBoxRunScript_EngineType() {
		if (comboBoxRunScript_EngineType == null) {
			comboBoxRunScript_EngineType = new JComboBox();
			comboBoxRunScript_EngineType.setFont(new Font("Tahoma", Font.PLAIN,
					12));
			comboBoxRunScript_EngineType.setModel(new DefaultComboBoxModel(
					EREngineType.values()));
			comboBoxRunScript_EngineType.setSelectedIndex(2);
		}
		return comboBoxRunScript_EngineType;
	}

	private JButton getBtnRunScript_CreateRunScript() {
		if (btnRunScript_CreateRunScript == null) {
			btnRunScript_CreateRunScript = new JButton();
			btnRunScript_CreateRunScript
					.addActionListener(new BtnRunScript_CreateRunScriptAction());
			btnRunScript_CreateRunScript.setText("Create RunScript");
		}
		return btnRunScript_CreateRunScript;
	}

	private JPanel getPanelRunScript_IdentityInput() {
		if (panelRunScript_IdentityInput == null) {
			panelRunScript_IdentityInput = new JPanel();
			panelRunScript_IdentityInput.setBounds(10, 210, 426, 85);
			panelRunScript_IdentityInput.setBorder(new TitledBorder(null,
					"Identity Input", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GroupLayout gl_panelRunScript_IdentityInput = new GroupLayout(
					panelRunScript_IdentityInput);
			gl_panelRunScript_IdentityInput
					.setHorizontalGroup(gl_panelRunScript_IdentityInput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_IdentityInput
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getLabelRunScript_IdentityInputType())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getComboBoxRunScript_IdentityInputType(),
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getTextRunScript_IdentityInputPath(),
													GroupLayout.DEFAULT_SIZE,
													295, Short.MAX_VALUE)
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getBtnRunScript_IdentityInputSelect())
											.addContainerGap()));
			gl_panelRunScript_IdentityInput
					.setVerticalGroup(gl_panelRunScript_IdentityInput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_IdentityInput
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelRunScript_IdentityInput
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelRunScript_IdentityInputType())
															.addComponent(
																	getComboBoxRunScript_IdentityInputType(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getTextRunScript_IdentityInputPath(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getBtnRunScript_IdentityInputSelect()))
											.addContainerGap(20,
													Short.MAX_VALUE)));
			panelRunScript_IdentityInput
					.setLayout(gl_panelRunScript_IdentityInput);
		}
		return panelRunScript_IdentityInput;
	}

	private JPanel getPanelRunScript_IdentityOutput() {
		if (panelRunScript_IdentityOutput == null) {
			panelRunScript_IdentityOutput = new JPanel();
			panelRunScript_IdentityOutput.setBounds(10, 315, 426, 84);
			panelRunScript_IdentityOutput.setBorder(new TitledBorder(null,
					"Identity Output", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GroupLayout gl_panelRunScript_IdentityOutput = new GroupLayout(
					panelRunScript_IdentityOutput);
			gl_panelRunScript_IdentityOutput
					.setHorizontalGroup(gl_panelRunScript_IdentityOutput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_IdentityOutput
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getLabelRunScript_IdentityOutputType())
											.addGap(4)
											.addComponent(
													getComboBox_RunScript_IdentityOutputType(),
													GroupLayout.PREFERRED_SIZE,
													71,
													GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(
													getTextRunScript_IdentityOutputPath(),
													GroupLayout.DEFAULT_SIZE,
													295, Short.MAX_VALUE)
											.addGap(6)
											.addComponent(
													getBtnRunScript_IdentityOutputSelect(),
													GroupLayout.PREFERRED_SIZE,
													69,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap()));
			gl_panelRunScript_IdentityOutput
					.setVerticalGroup(gl_panelRunScript_IdentityOutput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_IdentityOutput
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelRunScript_IdentityOutput
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panelRunScript_IdentityOutput
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					getLabelRunScript_IdentityOutputType()))
															.addGroup(
																	gl_panelRunScript_IdentityOutput
																			.createSequentialGroup()
																			.addGap(1)
																			.addComponent(
																					getComboBox_RunScript_IdentityOutputType(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panelRunScript_IdentityOutput
																			.createSequentialGroup()
																			.addGap(1)
																			.addComponent(
																					getTextRunScript_IdentityOutputPath(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE))
															.addComponent(
																	getBtnRunScript_IdentityOutputSelect()))
											.addContainerGap(19,
													Short.MAX_VALUE)));
			panelRunScript_IdentityOutput
					.setLayout(gl_panelRunScript_IdentityOutput);
		}
		return panelRunScript_IdentityOutput;
	}

	private JPanel getPanelRunScript_LinkOutput() {
		if (panelRunScript_LinkOutput == null) {
			panelRunScript_LinkOutput = new JPanel();
			panelRunScript_LinkOutput.setBounds(446, 210, 373, 85);
			panelRunScript_LinkOutput.setBorder(new TitledBorder(null,
					"Link Output", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GroupLayout gl_panelRunScript_LinkOutput = new GroupLayout(
					panelRunScript_LinkOutput);
			gl_panelRunScript_LinkOutput
					.setHorizontalGroup(gl_panelRunScript_LinkOutput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_LinkOutput
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getLabelRunScript_LinkOutputPath())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getTextRunScript_LinkOutputPath(),
													GroupLayout.DEFAULT_SIZE,
													236, Short.MAX_VALUE)
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getBtnRunScript_LinkOutputSelect(),
													GroupLayout.PREFERRED_SIZE,
													69,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap()));
			gl_panelRunScript_LinkOutput
					.setVerticalGroup(gl_panelRunScript_LinkOutput
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_LinkOutput
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelRunScript_LinkOutput
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getTextRunScript_LinkOutputPath(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getLabelRunScript_LinkOutputPath())
															.addComponent(
																	getBtnRunScript_LinkOutputSelect()))
											.addContainerGap(22,
													Short.MAX_VALUE)));
			panelRunScript_LinkOutput.setLayout(gl_panelRunScript_LinkOutput);
		}
		return panelRunScript_LinkOutput;
	}

	private JLabel getLabelRunScript_IdentityInputType() {
		if (labelRunScript_IdentityInputType == null) {
			labelRunScript_IdentityInputType = new JLabel("Type:");
		}
		return labelRunScript_IdentityInputType;
	}

	private JComboBox getComboBoxRunScript_IdentityInputType() {
		if (comboBoxRunScript_IdentityInputType == null) {
			comboBoxRunScript_IdentityInputType = new JComboBox();
			comboBoxRunScript_IdentityInputType
					.addActionListener(new ComboBoxRunScript_IdentityInputTypeAction());
			comboBoxRunScript_IdentityInputType
					.setModel(new DefaultComboBoxModel(IdentityInputType
							.values()));
		}
		return comboBoxRunScript_IdentityInputType;
	}

	private JTextField getTextRunScript_IdentityInputPath() {
		if (textRunScript_IdentityInputPath == null) {
			textRunScript_IdentityInputPath = new JTextField();
			textRunScript_IdentityInputPath.setEnabled(false);
			textRunScript_IdentityInputPath
					.setText(" Absolute Path to Oyster Identity Input");
			textRunScript_IdentityInputPath.setColumns(10);
		}
		return textRunScript_IdentityInputPath;
	}

	private JButton getBtnRunScript_IdentityInputSelect() {
		if (btnRunScript_IdentityInputSelect == null) {
			btnRunScript_IdentityInputSelect = new JButton("Select..");
			btnRunScript_IdentityInputSelect
					.addActionListener(new BtnRunScript_IdentityInputSelectAction());
			btnRunScript_IdentityInputSelect.setEnabled(false);
		}
		return btnRunScript_IdentityInputSelect;
	}

	private JLabel getLabelRunScript_IdentityOutputType() {
		if (labelRunScript_IdentityOutputType == null) {
			labelRunScript_IdentityOutputType = new JLabel("Type:");
		}
		return labelRunScript_IdentityOutputType;
	}

	private JComboBox getComboBox_RunScript_IdentityOutputType() {
		if (comboBox_RunScript_IdentityOutputType == null) {
			comboBox_RunScript_IdentityOutputType = new JComboBox();
			comboBox_RunScript_IdentityOutputType
					.addActionListener(new ComboBox_RunScript_IdentityOutputTypeAction());
			comboBox_RunScript_IdentityOutputType
					.setModel(new DefaultComboBoxModel(IdentityOutputType
							.values()));
		}
		return comboBox_RunScript_IdentityOutputType;
	}

	private JTextField getTextRunScript_IdentityOutputPath() {
		if (textRunScript_IdentityOutputPath == null) {
			textRunScript_IdentityOutputPath = new JTextField();
			textRunScript_IdentityOutputPath
					.setText(" Absolute Path to Oyster Identity Output");
			textRunScript_IdentityOutputPath.setEnabled(false);
			textRunScript_IdentityOutputPath.setColumns(10);
		}
		return textRunScript_IdentityOutputPath;
	}

	private JButton getBtnRunScript_IdentityOutputSelect() {
		if (btnRunScript_IdentityOutputSelect == null) {
			btnRunScript_IdentityOutputSelect = new JButton("Select..");
			btnRunScript_IdentityOutputSelect
					.addActionListener(new BtnRunScript_IdentityOutputSelectAction());
			btnRunScript_IdentityOutputSelect.setEnabled(false);
		}
		return btnRunScript_IdentityOutputSelect;
	}

	private JTextField getTextRunScript_LinkOutputPath() {
		if (textRunScript_LinkOutputPath == null) {
			textRunScript_LinkOutputPath = new JTextField();
			textRunScript_LinkOutputPath
					.setText(" Absolute Path to Oyster Link Output");
			textRunScript_LinkOutputPath.setEnabled(false);
			textRunScript_LinkOutputPath.setColumns(10);
		}
		return textRunScript_LinkOutputPath;
	}

	private JButton getBtnRunScript_LinkOutputSelect() {
		if (btnRunScript_LinkOutputSelect == null) {
			btnRunScript_LinkOutputSelect = new JButton("Select..");
			btnRunScript_LinkOutputSelect
					.addActionListener(new BtnRunScript_LinkOutputSelectAction());
		}
		return btnRunScript_LinkOutputSelect;
	}

	private JLabel getLabelRunScript_LinkOutputPath() {
		if (labelRunScript_LinkOutputPath == null) {
			labelRunScript_LinkOutputPath = new JLabel("Path:");
		}
		return labelRunScript_LinkOutputPath;
	}

	private JButton getBtnAttributes_XMLfileSelect() {
		if (btnAttributes_XMLfileSelect == null) {
			btnAttributes_XMLfileSelect = new JButton("Select..");
			btnAttributes_XMLfileSelect
					.addActionListener(new BtnAttributes_XMLfileSelectAction());
		}
		return btnAttributes_XMLfileSelect;
	}

	private JTextField getTextAttributes_XMLfilePath() {
		if (textAttributes_XMLfilePath == null) {
			textAttributes_XMLfilePath = new JTextField();
			textAttributes_XMLfilePath.setEnabled(false);
			textAttributes_XMLfilePath
					.setText(" Absolute Path to OysterAttributes.xml File");
			textAttributes_XMLfilePath.setColumns(10);
		}
		return textAttributes_XMLfilePath;
	}

	XMLTreeViewer treeViewer = new XMLTreeViewer();
	private JPanel panelSourceDescriptor_AddSource;
	private JComboBox comboBoxSourceDescriptor_AddSourceType;
	private JPanel panelSourceDescriptor_Sources;
	private JTabbedPane tabbedPaneSourceDescriptor_Sources;
	private JMenuBar menuBar;
	private JMenuItem mntmExit;
	private JMenuItem mntmSave;
	private JMenu mnFileMenu;
	private JSeparator separator;
	private JToolBar toolBar;
	private JButton btnSave;
	private JPanel panelSourceDescriptor_AddTextFile;
	private JPanel panelSourceDescriptor_DeleteSource;
	private JPanel panelAttributes_XMLfilePath;
	private JButton btnSourceDescriptor_AddFileSelect;
	private JTextField textSourceDescriptor_AddFilePath;
	private JLabel label_ERIQ;
	private JMenu mnHelp;
	private JMenuItem mntmAboutOyster;
	private JScrollPane scrollPaneRunScript_ReferenceSources;
	private JTable tableRunScript_ReferenceSources;
	private JScrollPane scrollPaneSourceDescriptor_Database;
	private JTable tableSourceDescriptor_Database;
	private JScrollPane scrollPaneSourceDescriptor_FileDelim;
	private JTable tableSourceDescriptor_FileDelim;
	private JScrollPane scrollPaneSourceDescriptor_FileFixed;
	private JTable tableSourceDescriptor_FileFixed;

	private class BtnAttributes_XMLfileSelectAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			// Open xml file
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("XML Files", "xml");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Open file");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textAttributes_XMLfilePath.setText(file.getPath());
				treeViewer.createUI(file);

				// OysterAttributes attributes = new OysterAttributes();
				// attributes = OysterAttributesParser.parse(file);
				//
				// OysterSourceDescriptorParser.parse(file.getAbsolutePath());
				//
				// Hashtable<OysterAttribute, OysterComparator> attrComp =
				// attributes
				// .getAttrComp();
				// // Show all Attribute in hash table.
				//
				// Enumeration<OysterAttribute> Attributes;
				// Attributes = attrComp.keys();
				// while (Attributes.hasMoreElements()) {
				// String str = (String) Attributes.nextElement().getName();
				// System.out.println(str);
				// }
			}
		}
	}

	private JPanel getPanelSourceDescriptor_AddSource() {
		if (panelSourceDescriptor_AddSource == null) {
			panelSourceDescriptor_AddSource = new JPanel();
			panelSourceDescriptor_AddSource.setBounds(10, 325, 136, 74);
			panelSourceDescriptor_AddSource.setBorder(new TitledBorder(null,
					"Add Source", TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			GroupLayout gl_panelSourceDescriptor_AddSource = new GroupLayout(
					panelSourceDescriptor_AddSource);
			gl_panelSourceDescriptor_AddSource
					.setHorizontalGroup(gl_panelSourceDescriptor_AddSource
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_AddSource
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(getLblSourceType())
											.addPreferredGap(
													ComponentPlacement.RELATED,
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(
													getComboBoxSourceDescriptor_AddSourceType(),
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap()));
			gl_panelSourceDescriptor_AddSource
					.setVerticalGroup(gl_panelSourceDescriptor_AddSource
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panelSourceDescriptor_AddSource
											.createSequentialGroup()
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addGroup(
													gl_panelSourceDescriptor_AddSource
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLblSourceType())
															.addComponent(
																	getComboBoxSourceDescriptor_AddSourceType(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(26)));
			panelSourceDescriptor_AddSource
					.setLayout(gl_panelSourceDescriptor_AddSource);
		}
		return panelSourceDescriptor_AddSource;
	}

	private JComboBox getComboBoxSourceDescriptor_AddSourceType() {
		if (comboBoxSourceDescriptor_AddSourceType == null) {
			comboBoxSourceDescriptor_AddSourceType = new JComboBox();
			comboBoxSourceDescriptor_AddSourceType
					.addActionListener(new ComboBoxSourceDescriptor_SourceTypeAction());
			comboBoxSourceDescriptor_AddSourceType
					.setModel(new DefaultComboBoxModel(SourceType.values()));
		}
		return comboBoxSourceDescriptor_AddSourceType;
	}

	private JPanel getPanelSourceDescriptor_Sources() {
		if (panelSourceDescriptor_Sources == null) {
			panelSourceDescriptor_Sources = new JPanel();
			panelSourceDescriptor_Sources.setBounds(375, 11, 749, 388);
			panelSourceDescriptor_Sources.setBorder(new TitledBorder(null,
					"Sources", TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			panelSourceDescriptor_Sources.setLayout(null);
			panelSourceDescriptor_Sources
					.add(getTabbedPaneSourceDescriptor_Sources());
			panelSourceDescriptor_Sources
					.add(getPanelSourceDescriptor_SourcesDetail());
			panelSourceDescriptor_Sources
					.add(getBtnSourceDescriptor_CreateSourcedescriptor());
			panelSourceDescriptor_Sources
					.add(getBtnSourceDescriptor_RefreshDb());
			panelSourceDescriptor_Sources
					.add(getBtnSourceDescriptor_LoadAttributesFile());
		}
		return panelSourceDescriptor_Sources;
	}

	private JTabbedPane getTabbedPaneSourceDescriptor_Sources() {
		if (tabbedPaneSourceDescriptor_Sources == null) {
			tabbedPaneSourceDescriptor_Sources = new JTabbedPane(
					JTabbedPane.TOP);

			tabbedPaneSourceDescriptor_Sources.setBounds(30, 32, 687, 144);

			tabbedPaneSourceDescriptor_Sources.addTab("Databases", null,
					getScrollPaneSourceDescriptor_Database(), null);
			tabbedPaneSourceDescriptor_Sources.addTab("Fixed Text Files", null,
					getScrollPaneSourceDescriptor_FileFixed(), null);
			tabbedPaneSourceDescriptor_Sources.addTab("Delimited Text Files",
					null, getScrollPaneSourceDescriptor_FileDelim(), null);

			tabbedPaneSourceDescriptor_Sources.setSelectedIndex(2);
		}
		return tabbedPaneSourceDescriptor_Sources;
	}

	private JScrollPane getScrollPaneSourceDescriptor_Database() {
		if (scrollPaneSourceDescriptor_Database == null) {
			scrollPaneSourceDescriptor_Database = new JScrollPane();
			scrollPaneSourceDescriptor_Database
					.addFocusListener(new ScrollPaneSourceDescriptor_DatabaseFocus());
			scrollPaneSourceDescriptor_Database
					.addComponentListener(new ScrollPaneSourceDescriptor_DatabaseComponent());
			scrollPaneSourceDescriptor_Database
					.setViewportView(getTableSourceDescriptor_Database());
		}
		return scrollPaneSourceDescriptor_Database;
	}

	private JTable getTableSourceDescriptor_Database() {

		if (tableSourceDescriptor_Database == null) {
			tableSourceDescriptor_Database = new JTable();
			tableSourceDescriptor_Database.setRowMargin(0);
			tableSourceDescriptor_Database.setRowHeight(20);
			tableSourceDescriptor_Database.setBackground(UIManager
					.getColor("TabbedPane.light"));
			tableSourceDescriptor_Database
					.setSelectionBackground(Color.LIGHT_GRAY);

			tableSourceDescriptor_Database.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null,
							null, null }, }, new String[] { "Source Name",
							"Server", "Port", "SID", "Table", "Username",
							"Password", "Connection Type" }) {
				Class[] columnTypes = new Class[] { String.class, String.class,
						Object.class, Object.class, Object.class, Object.class,
						Object.class, Object.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tableSourceDescriptor_Database.getColumnModel().getColumn(0)
					.setPreferredWidth(82);
			tableSourceDescriptor_Database.getColumnModel().getColumn(0)
					.setMaxWidth(100);
			tableSourceDescriptor_Database.getColumnModel().getColumn(1)
					.setPreferredWidth(90);
			tableSourceDescriptor_Database.getColumnModel().getColumn(2)
					.setPreferredWidth(50);
			tableSourceDescriptor_Database.getColumnModel().getColumn(3)
					.setPreferredWidth(65);
			tableSourceDescriptor_Database.getColumnModel().getColumn(4)
					.setPreferredWidth(80);
			tableSourceDescriptor_Database.getColumnModel().getColumn(5)
					.setPreferredWidth(77);
			tableSourceDescriptor_Database.getColumnModel().getColumn(6)
					.setPreferredWidth(76);
			tableSourceDescriptor_Database.getColumnModel().getColumn(7)
					.setPreferredWidth(95);
		}

		return tableSourceDescriptor_Database;
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFileMenu());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new MntmExitAction());
		}
		return mntmExit;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setPreferredSize(new Dimension(100, 22));
		}
		return mntmSave;
	}

	private JMenu getMnFileMenu() {
		if (mnFileMenu == null) {
			mnFileMenu = new JMenu("File");
			mnFileMenu.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
			mnFileMenu.add(getMntmSave());
			mnFileMenu.add(getSeparator());
			mnFileMenu.add(getMntmExit());
		}
		return mnFileMenu;
	}

	private class MntmExitAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			Color color = new Color(230, 230, 230);
			toolBar.setBackground(color);
			toolBar.add(getBtnSave());
		}
		return toolBar;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			Color color = new Color(230, 230, 230);
			btnSave.setBackground(color);
			btnSave.addActionListener(new BtnSaveAction());
			btnSave.setFocusable(false);
			btnSave.setIcon(new ImageIcon(
					OysterRun.class
							.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return btnSave;
	}

	private class ComboBoxSourceDescriptor_SourceTypeAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {

			String RefrenceSourceType = comboBoxSourceDescriptor_AddSourceType
					.getSelectedItem().toString();
			if ("None".equals(RefrenceSourceType)) {

				panelSourceDescriptor_AddTextFile.setVisible(false);
				comboBoxSourceDescriptor_AddSourceType
						.setSelectedItem(OysterEnum.SourceType.None);

				btnSourceDescriptor_RefreshDb.setVisible(false);

			} else if ("FileFixed".equals(RefrenceSourceType)) {

				textSourceDescriptor_AddFilePath
						.setText("  Absolute Path to Fixed Text File");
				panelSourceDescriptor_AddTextFile.setVisible(true);

				btnSourceDescriptor_RefreshDb.setVisible(false);

			} else if ("FileDelim".equals(RefrenceSourceType)) {

				textSourceDescriptor_AddFilePath
						.setText("  Absolute Path to Delimited Text File");

				panelSourceDescriptor_AddTextFile.setVisible(true);

				btnSourceDescriptor_RefreshDb.setVisible(false);

			} else if ("Database".equals(RefrenceSourceType)) {

				tabbedPaneSourceDescriptor_Sources.setSelectedIndex(0);
				panelSourceDescriptor_AddTextFile.setVisible(false);
				btnSourceDescriptor_DeleteSourceName.setEnabled(true);
				comboBoxSourceDescriptor_AddSourceType
						.setSelectedItem(OysterEnum.SourceType.None);

				comboBoxSourceDescriptor_AddSourceType.setEnabled(false);

				tabbedPaneSourceDescriptor_Sources.setEnabledAt(0, true);
				tabbedPaneSourceDescriptor_Sources.setEnabledAt(1, false);
				tabbedPaneSourceDescriptor_Sources.setEnabledAt(2, false);

				dbFrameRefrenceSource.showDatabaseFrame("RefrenceSource");

				btnSourceDescriptor_RefreshDb.setVisible(true);
			}
		}
	}

	private String setSourceDescriptor_DatebaseConfig() {
		if (tableSourceDescriptor_Database_RowNum == 0) {
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getServer(),
					tableSourceDescriptor_Database_RowNum, 0);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getPort(),
					tableSourceDescriptor_Database_RowNum, 1);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getSID(),
					tableSourceDescriptor_Database_RowNum, 2);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getUserID(),
					tableSourceDescriptor_Database_RowNum, 3);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getPassword(),
					tableSourceDescriptor_Database_RowNum, 4);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getTableName(),
					tableSourceDescriptor_Database_RowNum, 5);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getConnectionType(),
					tableSourceDescriptor_Database_RowNum, 6);
			tabbedPaneSourceDescriptor_Sources.setSelectedIndex(0);

			tableSourceDescriptor_Database_RowNum++;
		} else {
			tableSourceDescriptor_Database_RowNum = 0;

			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getServer(),
					tableSourceDescriptor_Database_RowNum, 0);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getPort(),
					tableSourceDescriptor_Database_RowNum, 1);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getSID(),
					tableSourceDescriptor_Database_RowNum, 2);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getUserID(),
					tableSourceDescriptor_Database_RowNum, 3);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getPassword(),
					tableSourceDescriptor_Database_RowNum, 4);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getTableName(),
					tableSourceDescriptor_Database_RowNum, 5);
			tableSourceDescriptor_Database.setValueAt(
					dbConfigRefrenceSource.getConnectionType(),
					tableSourceDescriptor_Database_RowNum, 6);
			tabbedPaneSourceDescriptor_Sources.setSelectedIndex(0);
		}
		return null;
	}

	private JPanel getPanelSourceDescriptor_AddTextFile() {
		if (panelSourceDescriptor_AddTextFile == null) {
			panelSourceDescriptor_AddTextFile = new JPanel();
			panelSourceDescriptor_AddTextFile.setVisible(false);
			panelSourceDescriptor_AddTextFile.setBounds(10, 260, 355, 54);
			panelSourceDescriptor_AddTextFile.setBorder(new TitledBorder(null,
					"", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panelSourceDescriptor_AddTextFile = new GroupLayout(
					panelSourceDescriptor_AddTextFile);
			gl_panelSourceDescriptor_AddTextFile
					.setHorizontalGroup(gl_panelSourceDescriptor_AddTextFile
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_AddTextFile
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getBtnSourceDescriptor_AddFileSelect())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getTextSourceDescriptor_AddFilePath(),
													GroupLayout.DEFAULT_SIZE,
													248, Short.MAX_VALUE)
											.addContainerGap()));
			gl_panelSourceDescriptor_AddTextFile
					.setVerticalGroup(gl_panelSourceDescriptor_AddTextFile
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_AddTextFile
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelSourceDescriptor_AddTextFile
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getBtnSourceDescriptor_AddFileSelect())
															.addComponent(
																	getTextSourceDescriptor_AddFilePath(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			panelSourceDescriptor_AddTextFile
					.setLayout(gl_panelSourceDescriptor_AddTextFile);
		}
		return panelSourceDescriptor_AddTextFile;
	}

	private JPanel getPanelSourceDescriptor_DeleteSource() {
		if (panelSourceDescriptor_DeleteSource == null) {
			panelSourceDescriptor_DeleteSource = new JPanel();
			panelSourceDescriptor_DeleteSource.setBounds(156, 325, 209, 74);
			panelSourceDescriptor_DeleteSource.setBorder(new TitledBorder(null,
					"Delete Source", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			GroupLayout gl_panelSourceDescriptor_DeleteSource = new GroupLayout(
					panelSourceDescriptor_DeleteSource);
			gl_panelSourceDescriptor_DeleteSource
					.setHorizontalGroup(gl_panelSourceDescriptor_DeleteSource
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_DeleteSource
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getLabelSourceDescriptor_SourceName())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getBtnSourceDescriptor_DeleteSourceName())
											.addContainerGap(15,
													Short.MAX_VALUE)));
			gl_panelSourceDescriptor_DeleteSource
					.setVerticalGroup(gl_panelSourceDescriptor_DeleteSource
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelSourceDescriptor_DeleteSource
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													gl_panelSourceDescriptor_DeleteSource
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getLabelSourceDescriptor_SourceName())
															.addComponent(
																	getBtnSourceDescriptor_DeleteSourceName()))
											.addContainerGap(13,
													Short.MAX_VALUE)));
			panelSourceDescriptor_DeleteSource
					.setLayout(gl_panelSourceDescriptor_DeleteSource);
		}
		return panelSourceDescriptor_DeleteSource;
	}

	private JPanel getPanelAttributes_XMLfilePath() {
		if (panelAttributes_XMLfilePath == null) {
			panelAttributes_XMLfilePath = new JPanel();
			panelAttributes_XMLfilePath.setBounds(10, 215, 355, 64);
			panelAttributes_XMLfilePath.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panelAttributes_XMLfilePath = new GroupLayout(
					panelAttributes_XMLfilePath);
			gl_panelAttributes_XMLfilePath
					.setHorizontalGroup(gl_panelAttributes_XMLfilePath
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelAttributes_XMLfilePath
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													getBtnAttributes_XMLfileSelect())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getTextAttributes_XMLfilePath(),
													GroupLayout.DEFAULT_SIZE,
													248, Short.MAX_VALUE)
											.addContainerGap()));
			gl_panelAttributes_XMLfilePath
					.setVerticalGroup(gl_panelAttributes_XMLfilePath
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panelAttributes_XMLfilePath
											.createSequentialGroup()
											.addContainerGap(17,
													Short.MAX_VALUE)
											.addGroup(
													gl_panelAttributes_XMLfilePath
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getTextAttributes_XMLfilePath(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getBtnAttributes_XMLfileSelect()))
											.addContainerGap()));
			panelAttributes_XMLfilePath
					.setLayout(gl_panelAttributes_XMLfilePath);
		}
		return panelAttributes_XMLfilePath;
	}

	private JButton getBtnSourceDescriptor_AddFileSelect() {
		if (btnSourceDescriptor_AddFileSelect == null) {
			btnSourceDescriptor_AddFileSelect = new JButton("Select..");
			btnSourceDescriptor_AddFileSelect
					.addActionListener(new BtnSourceDescriptor_AddFileSelectAction());
		}
		return btnSourceDescriptor_AddFileSelect;
	}

	private JTextField getTextSourceDescriptor_AddFilePath() {
		if (textSourceDescriptor_AddFilePath == null) {
			textSourceDescriptor_AddFilePath = new JTextField();
			textSourceDescriptor_AddFilePath.setEnabled(false);
			textSourceDescriptor_AddFilePath
					.setText(" Absolute Path to Source Descriptor xml File");
			textSourceDescriptor_AddFilePath.setColumns(10);
		}
		return textSourceDescriptor_AddFilePath;
	}

	private int tableSourceDescriptor_FileDelim_RowNum = 0;
	private int tableSourceDescriptor_FileFixed_RowNum = 0;
	private int tableSourceDescriptor_Database_RowNum = 0;
	
	private int tableRunScript_ReferenceSources_RowNum = 0;
	
	private int tableSourceDescriptor_DetailFileDelim_RowNum = 0;
	private int tableSourceDescriptor_DetailFileFixed_RowNum = 0;
	private int tableSourceDescriptor_DetailDatabase_RowNum = 0;

	private JPanel panelRunScript_ReferenceSources;
	private JButton btnRunScript_ReferenceSourcesLoad;
	private JPanel panelSourceDescriptor_SourcesDetail;
	private JScrollPane scrollPaneSourceDescriptor_DetailFileFixed;
	private JTable tableSourceDescriptor_DetailFileFixed;
	private JScrollPane scrollPaneSourceDescriptor_DetailFileDelim;
	private JTable tableSourceDescriptor_DetailFileDelim;
	private JPanel panelRunScript_Attributes;
	private JTextField textRunScript_AttributesPath;
	private JButton btnRunScript_AttributesSelect;
	private JLabel labelRunScript_AttributesPath;
	private JScrollPane scrollPaneSourceDescriptor_DetailDatabase;
	private JTable tableSourceDescriptor_DetailDatabase;
	private JLabel labelSourceDescriptor_SourceName;
	private JButton btnSourceDescriptor_DeleteSourceName;
	private JLabel lblSourceType;
	private JButton btnSourceDescriptor_CreateSourcedescriptor;
	private JButton btnSourceDescriptor_RefreshDb;
	private JButton btnSourceDescriptor_LoadAttributesFile;

	private class BtnSourceDescriptor_AddFileSelectAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("Text Files", "txt");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Open Source File");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textSourceDescriptor_AddFilePath.setText(file.getPath());
			}
			String OysterRefrenceSourceType = comboBoxSourceDescriptor_AddSourceType
					.getSelectedItem().toString();

			if ("FileDelim".equals(OysterRefrenceSourceType)) {
				if (ret == JFileChooser.APPROVE_OPTION) {
					tabbedPaneSourceDescriptor_Sources.setEnabledAt(2, true);

					tableSourceDescriptor_FileDelim.setValueAt(
							textSourceDescriptor_AddFilePath.getText(),
							tableSourceDescriptor_FileDelim_RowNum, 1);
					tableSourceDescriptor_FileDelim.setValueAt(
							"FileDelim Source",
							tableSourceDescriptor_FileDelim_RowNum, 0);
					tabbedPaneSourceDescriptor_Sources.setSelectedIndex(2);
					panelSourceDescriptor_AddTextFile.setVisible(false);
					comboBoxSourceDescriptor_AddSourceType.setSelectedIndex(0);
					tableSourceDescriptor_FileDelim_RowNum = 0;
					comboBoxSourceDescriptor_AddSourceType.setEnabled(false);
					btnSourceDescriptor_DeleteSourceName.setEnabled(true);

					tabbedPaneSourceDescriptor_Sources.setEnabledAt(1, false);
					tabbedPaneSourceDescriptor_Sources.setEnabledAt(0, false);
				}
			} else if ("FileFixed".equals(OysterRefrenceSourceType)) {
				if (ret == JFileChooser.APPROVE_OPTION) {
					tabbedPaneSourceDescriptor_Sources.setEnabledAt(1, true);

					tableSourceDescriptor_FileFixed.setValueAt(
							textSourceDescriptor_AddFilePath.getText(),
							tableSourceDescriptor_FileFixed_RowNum, 1);
					tableSourceDescriptor_FileFixed.setValueAt(
							"FileFixed Source",
							tableSourceDescriptor_FileFixed_RowNum, 0);
					tabbedPaneSourceDescriptor_Sources.setSelectedIndex(1);
					panelSourceDescriptor_AddTextFile.setVisible(false);
					comboBoxSourceDescriptor_AddSourceType.setSelectedIndex(0);
					tableSourceDescriptor_FileFixed_RowNum = 0;
					comboBoxSourceDescriptor_AddSourceType.setEnabled(false);
					btnSourceDescriptor_DeleteSourceName.setEnabled(true);

					tabbedPaneSourceDescriptor_Sources.setEnabledAt(2, false);
					tabbedPaneSourceDescriptor_Sources.setEnabledAt(0, false);
				}
			}
		}
	}

	private class BtnRunScript_LogDirSelectAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Open directory
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnVal = chooser.showOpenDialog(chooser);

			if (returnVal != JFileChooser.CANCEL_OPTION) {
				textFieldRunScript_LogDirectory.setText(chooser
						.getSelectedFile().getPath());
			}
			textFieldRunScript_LogDirectory.setEnabled(true);
		}
	}

	private class ComboBoxRunScript_IdentityInputTypeAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {
			String IdentityInputType = comboBoxRunScript_IdentityInputType
					.getSelectedItem().toString();
			if ("None".equals(IdentityInputType)) {
				textRunScript_IdentityInputPath.setEnabled(false);
				btnRunScript_IdentityInputSelect.setEnabled(false);
				textRunScript_IdentityInputPath
						.setText(" Absolute Path to Oyster Identity Input");
			} else if ("TextFile".equals(IdentityInputType)) {
				btnRunScript_IdentityInputSelect.setEnabled(true);
			} else if ("Database".equals(IdentityInputType)) {
				textRunScript_IdentityInputPath.setEnabled(false);
				btnRunScript_IdentityInputSelect.setEnabled(false);

				dbFrameIdentityInput.showDatabaseFrame("IdentityInput");
				btnRunScript_IdentityInputSelect.setEnabled(false);

				textRunScript_IdentityInputPath
						.setText("Database Selected for Identity Input");
			}
		}
	}

	private class ComboBox_RunScript_IdentityOutputTypeAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {
			String IdentityOutputType = comboBox_RunScript_IdentityOutputType
					.getSelectedItem().toString();
			if ("None".equals(IdentityOutputType)) {
				textRunScript_IdentityOutputPath.setEnabled(false);
				btnRunScript_IdentityOutputSelect.setEnabled(false);
				textRunScript_IdentityOutputPath
						.setText(" Absolute Path to Oyster Identity Output");
			} else if ("TextFile".equals(IdentityOutputType)) {
				btnRunScript_IdentityOutputSelect.setEnabled(true);
			} else if ("Database".equals(IdentityOutputType)) {
				textRunScript_IdentityOutputPath.setEnabled(false);
				btnRunScript_IdentityOutputSelect.setEnabled(false);

				/**
				 * TODO : Database not supported
				 */

				textRunScript_IdentityOutputPath
						.setText(" Database Connection Selected for Identity Input");
			}
		}
	}

	private class BtnRunScript_IdentityInputSelectAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Open file
			JFileChooser fileopen = new JFileChooser();
			fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileFilter filter = new FileNameExtensionFilter(
					"Oyster IdentityInput", "txt");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select IdentityInput");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textRunScript_IdentityInputPath.setText(file.getPath());
				textRunScript_IdentityInputPath.setEnabled(true);
			}
		}
	}

	private class BtnRunScript_IdentityOutputSelectAction implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Open file
			JFileChooser fileopen = new JFileChooser();
			fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileFilter filter = new FileNameExtensionFilter(
					"Oyster IdentityOutput", "idty");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select IdentityOutput");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textRunScript_IdentityOutputPath.setText(file.getPath());
				textRunScript_IdentityOutputPath.setEnabled(true);
			}
		}
	}

	private class BtnRunScript_LinkOutputSelectAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Open file
			JFileChooser fileopen = new JFileChooser();
			fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileFilter filter = new FileNameExtensionFilter(
					"Oyster LinkOutput", "link");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select LinkOutput");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textRunScript_LinkOutputPath.setText(file.getPath());
				textRunScript_LinkOutputPath.setEnabled(true);
			}
		}
	}

	private class BtnRunScript_AttributesSelectAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Open file
			JFileChooser fileopen = new JFileChooser();
			fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			FileFilter filter = new FileNameExtensionFilter(
					"Oyster Attributes", "xml");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Select Attributes");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();
				textRunScript_AttributesPath.setText(file.getPath());
				textRunScript_AttributesPath.setEnabled(true);
			}
		}
	}

	private class BtnSaveAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (panel_OysterAttributes.isShowing()) {
				saveAttributes();
			}

			if (panel_OysterSourceDescriptor.isShowing()) {
				saveSourceDescriptor();
				// Save OysterSourceDescriptor
				JFileChooser chooser = new JFileChooser();

				FileFilter filter = new FileNameExtensionFilter("XML Files",
						"xml");
				chooser.addChoosableFileFilter(filter);
				chooser.setDialogTitle("Save Oyster " + "\n"
						+ "SourceDescriptor");

				chooser.showSaveDialog(chooser);

				File fileRunScript = chooser.getSelectedFile();

				// Create file if it does not exist
				try {
					boolean success = fileRunScript.createNewFile();
					if (success) {
						// File did not exist and was created
						FileWriter fstream = new FileWriter(fileRunScript);
						BufferedWriter out = new BufferedWriter(fstream);
						// /out.write(OysterRunScriptXml.toString());
						out.close();
						JOptionPane
								.showMessageDialog(frm_OysterGUIScriptor,
										"Oyster SourceDescriptor xml File created successfully.");
					} else {
						// File already exists
						JOptionPane.showMessageDialog(frm_OysterGUIScriptor,
								"Oyster SourceDescriptor xml File already exists."
										+ "\n" + "Change Document Name!");
					}
				} catch (Exception eRS) {
					// TODO: handle exception
				}
			}

			if (panel_OysterRunScript.isShowing()) {

				// Save OysterRunScript to a xml file
				JFileChooser chooser = new JFileChooser();

				FileFilter filter = new FileNameExtensionFilter("XML Files",
						"xml");
				chooser.addChoosableFileFilter(filter);
				chooser.setDialogTitle("Save Oyster " + "\n" + "RunScript");

				chooser.showSaveDialog(chooser);

				File fileRunScript = chooser.getSelectedFile();

				// Create file if it does not exist
				try {
					boolean success = fileRunScript.createNewFile();
					if (success) {
						// File did not exist and was created
						FileWriter fstream = new FileWriter(fileRunScript);
						BufferedWriter out = new BufferedWriter(fstream);
						out.write(OysterRunScriptXml.toString());
						out.close();
						JOptionPane
								.showMessageDialog(frm_OysterGUIScriptor,
										"Oyster RunScript xml File created successfully.");
					} else {
						// File already exists
						JOptionPane.showMessageDialog(frm_OysterGUIScriptor,
								"Oyster RunScript xml File already exists."
										+ "\n" + "Change Document Name!");
					}
				} catch (Exception eRS) {
					// TODO: handle exception
				}
			}
		}
	}

	/**
	 * 
	 */
	private void saveAttributes() {
		// TODO Auto-generated method stub
		JOptionPane
				.showMessageDialog(frm_OysterGUIScriptor, "saveAttributes()");
	}

	/**
	 * 
	 */
	private void saveSourceDescriptor() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(frm_OysterGUIScriptor,
				"saveSourceDescriptor()");
	}

	private void saveRunScript() {
		// Make a new Date object. It will be initialized to
		// the current time.
		if (textFieldRunScript_CreatedOn.getText().isEmpty()) {
			Date now = new Date();
			textFieldRunScript_CreatedOn.setText(now.toString());
		}
		/*
		 * TODO /* Comments
		 */
		comment.setAuthor(textFieldRunScript_Author.getText());
		comment.setCreatedOn(textFieldRunScript_CreatedOn.getText());
		comment.setDescription(textAreaAttributes_Description.getText());
		comment.setDocument(textFieldRunScript_Document.getText());
		/*
		 * Log Settings
		 */
		logFile.setLogDirectory(textFieldRunScript_LogDirectory.getText());
		logFile.setSize(Integer.parseInt(textFieldRunScript_LogFileSize
				.getText()));
		logFile.setNum(Integer.parseInt(spinnerRunScript_LogFileNum.getValue()
				.toString()));
		logSettings.setLogExplanation((LogExplanation
				.valueOf(comboBoxRunScript_Explanation.getSelectedItem()
						.toString())));
		logSettings.setLogDebug((LogDebug.valueOf(comboBoxRunScript_Debug
				.getSelectedItem().toString())));
		/*
		 * EREngine Type
		 */
		erEngine.setType(EREngineType.valueOf(comboBoxRunScript_EngineType
				.getSelectedItem().toString()));
		/*
		 * Attribute Path
		 */
		attributePath.setAttributePath(textRunScript_AttributesPath.getText());
		/*
		 * Link Output
		 */
		linkOutput.setAbsolutePath(textRunScript_LinkOutputPath.getText());
		/*
		 * Identity Input
		 */
		identityInput.setType((IdentityInputType
				.valueOf(comboBoxRunScript_IdentityInputType.getSelectedItem()
						.toString())));
		if (identityInput.getType() == IdentityInputType.TextFile) {
			identityInput.setAbsolutePath(textRunScript_IdentityInputPath
					.getText());
		} else if (identityInput.getType() == IdentityInputType.Database) {
			identityInput.appendDatabaseProperties("<IdentityInput Type=\"");
			identityInput.appendDatabaseProperties(IdentityInputType.Database
					.toString());
			identityInput.appendDatabaseProperties("\" Server=\"");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getServer());
			identityInput.appendDatabaseProperties("\" Port=\"");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getPort());
			identityInput.appendDatabaseProperties("\" SID=\"");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getSID());
			identityInput.appendDatabaseProperties("\" UserID=\"");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getUserID());
			identityInput.appendDatabaseProperties("\" Passwd=\"");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getPassword());
			identityInput.appendDatabaseProperties("\">");
			identityInput.appendDatabaseProperties(dbConfigIdentityInput
					.getTableName());
			identityInput.appendDatabaseProperties("</IdentityInput>");
		}

		/*
		 * Identity Output
		 */
		identityOutput.setType((IdentityOutputType
				.valueOf(comboBox_RunScript_IdentityOutputType
						.getSelectedItem().toString())));
		identityOutput.setAbsolutePath(textRunScript_IdentityOutputPath
				.getText());

		/*
		 * Reference Sources
		 */

		// ArrayList<OysterReferenceItem> referenceItems = referenceSource
		// .getOysterReferenceItems();
		//
		// // Add all referenceItems in ArrayList.
		// Iterator<OysterReferenceItem> referenceItem =
		// referenceItems.iterator();
		// while (referenceItem.hasNext()) {
		//
		// // CaptureMode
		// System.out.println(referenceItem.next().getAttribute()
		// + referenceItem.next().getData());
		// }

	}

	private class BtnRunScript_CreateRunScriptAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			createRunScript();
		}
	}

	private void createRunScript() {
		saveRunScript();
		// clear the Stringbuffer content
		OysterRunScriptXml.delete(0, OysterRunScriptXml.length());

		// XML Declaration and Comments
		OysterRunScriptXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("<!--");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("Document: ");
		OysterRunScriptXml.append(comment.getDocument());
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("Created on: ");
		OysterRunScriptXml.append(comment.getCreatedOn());
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("Author: ");
		OysterRunScriptXml.append(comment.getAuthor());
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("Description: ");
		OysterRunScriptXml.append(comment.getDescription());
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("-->");
		OysterRunScriptXml.append("\n");

		// <OysterRunScript> start Tag
		OysterRunScriptXml.append("<OysterRunScript>");
		OysterRunScriptXml.append("\n");

		// Log Settings
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<Settings Explanation=\""
				+ logSettings.getLogExplanation() + "\" Debug=\""
				+ logSettings.getLogDebug() + "\" />");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<LogFile Num=\"").append(logFile.getNum())
				.append("\" Size=\"").append(logFile.getSize()).append("\">")
				.append(logFile.getLogDirectory())
				.append("\\Run_%g.log</LogFile>");

		// EREngine Type
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<EREngine Type=\"")
				.append(erEngine.getType()).append("\" />");

		// Attributes Path
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<!-- Attributes read from file only -->");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<AttributePath>")
				.append(attributePath.getAttributePath())
				.append("</AttributePath>");

		// Identity Input
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<!-- Identity Input Selection -->");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		if (identityInput.getType() == IdentityInputType.None) {
			OysterRunScriptXml.append("<IdentityInput Type=\""
					+ IdentityInputType.None.toString() + "\">"
					+ "</IdentityInput>");
		} else if (identityInput.getType() == IdentityInputType.TextFile) {
			OysterRunScriptXml.append("<IdentityInput Type=\""
					+ IdentityInputType.TextFile.toString() + "\">"
					+ identityInput.getAbsolutePath() + "</IdentityInput>");
		} else if (identityInput.getType() == IdentityInputType.Database) {
			OysterRunScriptXml
					.append("<IdentityInput Type=\""
							+ IdentityInputType.Database + "\" Server=\""
							+ dbConfigIdentityInput.getServer() + "\" Port=\""
							+ dbConfigIdentityInput.getPort() + "\" SID=\""
							+ dbConfigIdentityInput.getSID() + "\" UserID=\""
							+ dbConfigIdentityInput.getUserID()
							+ "\" Passwd=\""
							+ dbConfigIdentityInput.getPassword() + "\">"
							+ dbConfigIdentityInput.getTableName()
							+ "</IdentityInput>");
		}

		// Identity Output
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml
				.append("<!-- Identity Output Selection (Only needed when CaptureMode=On) -->");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		if (identityOutput.getType() == IdentityOutputType.None) {
			OysterRunScriptXml.append("<IdentityOutput Type=\""
					+ IdentityOutputType.None.toString() + "\">"
					+ "</IdentityOutput>");
		} else if (identityOutput.getType() == IdentityOutputType.TextFile) {
			OysterRunScriptXml.append("<IdentityOutput Type=\""
					+ IdentityOutputType.TextFile.toString() + "\">"
					+ identityOutput.getAbsolutePath() + "</IdentityOutput>");
			// + "\\IdentityOutput.idty</IdentityOutput>");
		}

		// Link Output
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml
				.append("<!-- Link Output Selection (Only needed when CaptureMode=On) -->");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<LinkOutput Type=\""
				+ LinkOutputType.TextFile.toString() + "\">"
				+ linkOutput.getAbsolutePath()
				// + "\\LinkOutput.link</LinkOutput>");
				+ "</LinkOutput>");

		// Reference Sources
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<!-- Sources to Run -->");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("<ReferenceSources>");

		// Reference Items
		for (int i = 0; i < tableRunScript_ReferenceSources_RowNum; i++) {
			if (tableRunScript_ReferenceSources.getValueAt(i, 0) != null)
				if (tableRunScript_ReferenceSources.getValueAt(i, 0).toString() == "true") {
					// CaptureMode
					String capture = "No";
					if (tableRunScript_ReferenceSources.getValueAt(i, 4) != null)
						if (tableRunScript_ReferenceSources.getValueAt(i, 4)
								.toString() == "true")
							capture = "Yes";
					// Path
					OysterRunScriptXml.append("\n");
					OysterRunScriptXml.append("    ");
					OysterRunScriptXml.append("    ");
					OysterRunScriptXml.append("<Source Capture=\"" + capture
							+ "\">"
							+ tableRunScript_ReferenceSources.getValueAt(i, 3)
							+ "</Source>");
				}
		}
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("    ");
		OysterRunScriptXml.append("</ReferenceSources>");
		OysterRunScriptXml.append("\n");
		OysterRunScriptXml.append("</OysterRunScript>");

		JOptionPane.showMessageDialog(frm_OysterGUIScriptor,
				OysterRunScriptXml.toString());

		btnSave.setEnabled(true);
		btnSave.setToolTipText(null);
	}

	private JLabel getLabel_ERIQlogo() {
		if (label_ERIQ == null) {
			label_ERIQ = new JLabel("");
			label_ERIQ.setIcon(new ImageIcon(OysterRun.class
					.getResource("/edu/ualr/oyster/gui/eriq.png")));
		}
		return label_ERIQ;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAboutOyster());
		}
		return mnHelp;
	}

	private JMenuItem getMntmAboutOyster() {
		if (mntmAboutOyster == null) {
			mntmAboutOyster = new JMenuItem("About Oyster");
			mntmAboutOyster.addActionListener(new MntmAboutOysterAction());
		}
		return mntmAboutOyster;
	}

	private class MntmAboutOysterAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				OysterAbout dialog = new OysterAbout();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private class Panel_OysterAttributesComponent extends ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			btnSave.setText("Save Attributes");
			btnSave.setEnabled(false);
		}
	}

	private class Panel_OysterSourceDescriptorComponent extends
			ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			btnSave.setEnabled(false);
			btnSave.setText("Save SourceDescriptor");
			btnSave.setToolTipText("First Create SourceDescriptor");
		}
	}

	private class Panel_OysterRunScriptComponent extends ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			btnSave.setEnabled(false);
			btnSave.setText("Save RunScript");
			btnSave.setToolTipText("First Create RunScript");
		}
	}

	private JScrollPane getScrollPaneRunScript_ReferenceSources() {
		if (scrollPaneRunScript_ReferenceSources == null) {
			scrollPaneRunScript_ReferenceSources = new JScrollPane();
			scrollPaneRunScript_ReferenceSources.setBounds(10, 75, 398, 107);
			scrollPaneRunScript_ReferenceSources.setOpaque(false);
			scrollPaneRunScript_ReferenceSources.setViewportBorder(null);
			scrollPaneRunScript_ReferenceSources
					.setViewportView(getTableRunScript_ReferenceSources());
		}
		return scrollPaneRunScript_ReferenceSources;
	}

	private JTable getTableRunScript_ReferenceSources() {
		if (tableRunScript_ReferenceSources == null) {
			tableRunScript_ReferenceSources = new JTable();
			tableRunScript_ReferenceSources.setBackground(UIManager
					.getColor("TabbedPane.light"));
			tableRunScript_ReferenceSources
					.setSelectionBackground(Color.LIGHT_GRAY);
			tableRunScript_ReferenceSources.setRowHeight(20);
			tableRunScript_ReferenceSources.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null },
							{ null, null, null, null, null },
							{ null, null, null, null, null },
							{ null, null, null, null, null }, }, new String[] {
							"Select", "Source Name", "Source Type",
							"File Path", "Capture" }) {
				Class[] columnTypes = new Class[] { Boolean.class,
						String.class, String.class, String.class, Boolean.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tableRunScript_ReferenceSources.getColumnModel().getColumn(0)
					.setResizable(false);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(0)
					.setPreferredWidth(40);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(0)
					.setMinWidth(40);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(0)
					.setMaxWidth(40);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(1)
					.setMaxWidth(75);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(2)
					.setPreferredWidth(70);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(2)
					.setMaxWidth(70);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(3)
					.setPreferredWidth(80);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(4)
					.setPreferredWidth(50);
			tableRunScript_ReferenceSources.getColumnModel().getColumn(4)
					.setMaxWidth(50);
		}
		return tableRunScript_ReferenceSources;
	}

	private JScrollPane getScrollPaneSourceDescriptor_FileDelim() {
		if (scrollPaneSourceDescriptor_FileDelim == null) {
			scrollPaneSourceDescriptor_FileDelim = new JScrollPane();
			scrollPaneSourceDescriptor_FileDelim
					.addComponentListener(new ScrollPaneSourceDescriptor_FileDelimComponent());
			scrollPaneSourceDescriptor_FileDelim
					.setViewportView(getTableSourceDescriptor_FileDelim());
		}
		return scrollPaneSourceDescriptor_FileDelim;
	}

	private JTable getTableSourceDescriptor_FileDelim() {
		if (tableSourceDescriptor_FileDelim == null) {
			tableSourceDescriptor_FileDelim = new JTable();
			tableSourceDescriptor_FileDelim
					.setSelectionBackground(Color.LIGHT_GRAY);
			tableSourceDescriptor_FileDelim.setBackground(UIManager
					.getColor("TabbedPane.light"));
			tableSourceDescriptor_FileDelim.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null }, },
					new String[] { "Source Name",
							"Absolute Path to Delimited Text File",
							"Delimiter", "Qualifier", "Labels" }) {
				Class[] columnTypes = new Class[] { String.class, String.class,
						String.class, String.class, Boolean.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { true, false, true,
						true, true };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tableSourceDescriptor_FileDelim.getColumnModel().getColumn(0)
					.setPreferredWidth(93);
			tableSourceDescriptor_FileDelim.getColumnModel().getColumn(0)
					.setMaxWidth(100);
			tableSourceDescriptor_FileDelim.getColumnModel().getColumn(1)
					.setPreferredWidth(306);
			tableSourceDescriptor_FileDelim.setRowHeight(20);
		}
		return tableSourceDescriptor_FileDelim;
	}

	private JScrollPane getScrollPaneSourceDescriptor_FileFixed() {
		if (scrollPaneSourceDescriptor_FileFixed == null) {
			scrollPaneSourceDescriptor_FileFixed = new JScrollPane();
			scrollPaneSourceDescriptor_FileFixed
					.addComponentListener(new ScrollPaneSourceDescriptor_FileFixedComponent());
			scrollPaneSourceDescriptor_FileFixed
					.setViewportView(getTableSourceDescriptor_FileFixed());
		}
		return scrollPaneSourceDescriptor_FileFixed;
	}

	private JTable getTableSourceDescriptor_FileFixed() {
		if (tableSourceDescriptor_FileFixed == null) {
			tableSourceDescriptor_FileFixed = new JTable();
			tableSourceDescriptor_FileFixed
					.setSelectionBackground(Color.LIGHT_GRAY);
			tableSourceDescriptor_FileFixed.setRowHeight(20);
			tableSourceDescriptor_FileFixed.setBackground(UIManager
					.getColor("TabbedPane.light"));
			tableSourceDescriptor_FileFixed
					.setModel(new DefaultTableModel(new Object[][] { { null,
							null }, }, new String[] { "Source Name",
							"Absolute Path to Fixed Text File" }) {
						Class[] columnTypes = new Class[] { String.class,
								String.class };

						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}

						boolean[] columnEditables = new boolean[] { true, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			tableSourceDescriptor_FileFixed.getColumnModel().getColumn(0)
					.setPreferredWidth(96);
			tableSourceDescriptor_FileFixed.getColumnModel().getColumn(0)
					.setMaxWidth(100);
			tableSourceDescriptor_FileFixed.getColumnModel().getColumn(1)
					.setPreferredWidth(245);
		}
		return tableSourceDescriptor_FileFixed;
	}

	private JPanel getPanelRunScript_ReferenceSources() {
		if (panelRunScript_ReferenceSources == null) {
			panelRunScript_ReferenceSources = new JPanel();
			panelRunScript_ReferenceSources.setBorder(new TitledBorder(
					UIManager.getBorder("TitledBorder.border"),
					"Reference Sources", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelRunScript_ReferenceSources.setBounds(706, 11, 418, 193);
			panelRunScript_ReferenceSources.setLayout(null);
			panelRunScript_ReferenceSources
					.add(getBtnRunScript_ReferenceSourcesLoad());
			panelRunScript_ReferenceSources
					.add(getScrollPaneRunScript_ReferenceSources());
		}
		return panelRunScript_ReferenceSources;
	}

	private JButton getBtnRunScript_ReferenceSourcesLoad() {
		if (btnRunScript_ReferenceSourcesLoad == null) {
			btnRunScript_ReferenceSourcesLoad = new JButton(
					"Load Source Descriptor File");
			btnRunScript_ReferenceSourcesLoad
					.addActionListener(new BtnRunScript_ReferenceSourcesLoadAction());
			btnRunScript_ReferenceSourcesLoad.setBounds(10, 26, 163, 38);
		}
		return btnRunScript_ReferenceSourcesLoad;
	}

	private class BtnRunScript_ReferenceSourcesLoadAction implements
			ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Open File
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(
					"Oyster Source Descriptor", "xml");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Load Source Descriptor File");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();

				treeViewer.createUI(file);

				referenceSource = OysterSourceDescriptorParser.parse(file);
				// ArrayList<OysterReferenceItem> referenceItems =
				// referenceSource
				// .getOysterReferenceItems();
				//
				// // Show all referenceItems in ArrayList.
				// Iterator<OysterReferenceItem> referenceItem = referenceItems
				// .iterator();
				// while (referenceItem.hasNext()) {
				// System.out.println(referenceItem.next().getAttribute()
				// + referenceItem.next().getData());
				// }

				tableRunScript_ReferenceSources.setValueAt(
						referenceSource.getSourceName(),
						tableRunScript_ReferenceSources_RowNum, 1);
				tableRunScript_ReferenceSources.setValueAt(
						referenceSource.getSourceType(),
						tableRunScript_ReferenceSources_RowNum, 2);
				tableRunScript_ReferenceSources.setValueAt(
						file.getAbsolutePath(),
						tableRunScript_ReferenceSources_RowNum, 3);

				tableRunScript_ReferenceSources_RowNum++;
			}
		}
	}

	private JPanel getPanelSourceDescriptor_SourcesDetail() {
		if (panelSourceDescriptor_SourcesDetail == null) {
			panelSourceDescriptor_SourcesDetail = new JPanel();
			panelSourceDescriptor_SourcesDetail.setBorder(new TitledBorder(
					null, "Detail", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			panelSourceDescriptor_SourcesDetail.setBounds(30, 187, 527, 177);
			panelSourceDescriptor_SourcesDetail.setLayout(null);
			panelSourceDescriptor_SourcesDetail
					.add(getScrollPaneSourceDescriptor_DetailFileDelim());
			panelSourceDescriptor_SourcesDetail
					.add(getScrollPaneSourceDescriptor_DetailDatabase());
			panelSourceDescriptor_SourcesDetail
					.add(getScrollPaneSourceDescriptor_DetailFileFixed());
		}
		return panelSourceDescriptor_SourcesDetail;
	}

	private JScrollPane getScrollPaneSourceDescriptor_DetailFileFixed() {
		if (scrollPaneSourceDescriptor_DetailFileFixed == null) {
			scrollPaneSourceDescriptor_DetailFileFixed = new JScrollPane();
			scrollPaneSourceDescriptor_DetailFileFixed.setVisible(false);
			scrollPaneSourceDescriptor_DetailFileFixed.setBounds(50, 26, 452,
					127);
			scrollPaneSourceDescriptor_DetailFileFixed
					.setViewportView(getTableSourceDescriptor_DetailFileFixed());
		}
		return scrollPaneSourceDescriptor_DetailFileFixed;
	}

	private JTable getTableSourceDescriptor_DetailFileFixed() {
		if (tableSourceDescriptor_DetailFileFixed == null) {
			tableSourceDescriptor_DetailFileFixed = new JTable();
			tableSourceDescriptor_DetailFileFixed
					.setBackground(SystemColor.control);
			tableSourceDescriptor_DetailFileFixed
					.setSelectionBackground(SystemColor.controlHighlight);
			tableSourceDescriptor_DetailFileFixed.setRowHeight(20);
			tableSourceDescriptor_DetailFileFixed
					.setModel(new DefaultTableModel(new Object[][] {
							{ null, null, null, null },
							{ null, null, null, null },
							{ null, null, null, null },
							{ null, null, null, null },
							{ null, null, null, null }, }, new String[] {
							"Name", "Attribute", "Start", "End" }));
		}
		return tableSourceDescriptor_DetailFileFixed;
	}

	private JScrollPane getScrollPaneSourceDescriptor_DetailFileDelim() {
		if (scrollPaneSourceDescriptor_DetailFileDelim == null) {
			scrollPaneSourceDescriptor_DetailFileDelim = new JScrollPane();
			scrollPaneSourceDescriptor_DetailFileDelim.setVisible(false);
			scrollPaneSourceDescriptor_DetailFileDelim.setBounds(50, 26, 452,
					127);
			scrollPaneSourceDescriptor_DetailFileDelim
					.setViewportView(getTableSourceDescriptor_DetailFileDelim());
		}
		return scrollPaneSourceDescriptor_DetailFileDelim;
	}

	private JTable getTableSourceDescriptor_DetailFileDelim() {
		if (tableSourceDescriptor_DetailFileDelim == null) {
			tableSourceDescriptor_DetailFileDelim = new JTable();
			tableSourceDescriptor_DetailFileDelim
					.setSelectionBackground(SystemColor.controlHighlight);
			tableSourceDescriptor_DetailFileDelim
					.setBackground(SystemColor.control);
			tableSourceDescriptor_DetailFileDelim.setRowHeight(20);
			tableSourceDescriptor_DetailFileDelim
					.setModel(new DefaultTableModel(new Object[][] {
							{ null, null, null }, { null, null, null },
							{ null, null, null }, { null, null, null },
							{ null, null, null }, }, new String[] { "Name",
							"Attribute", "Pos" }));
		}
		return tableSourceDescriptor_DetailFileDelim;
	}

	private class ScrollPaneSourceDescriptor_FileFixedComponent extends
			ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			getScrollPaneSourceDescriptor_Database().setVisible(false);
			getScrollPaneSourceDescriptor_DetailFileDelim().setVisible(false);
			getScrollPaneSourceDescriptor_DetailFileFixed().setVisible(true);
		}
	}

	private class ScrollPaneSourceDescriptor_FileDelimComponent extends
			ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			getScrollPaneSourceDescriptor_DetailDatabase().setVisible(false);
			getScrollPaneSourceDescriptor_DetailFileDelim().setVisible(true);
			getScrollPaneSourceDescriptor_DetailFileFixed().setVisible(false);
		}
	}

	private class ScrollPaneSourceDescriptor_DatabaseComponent extends
			ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent arg0) {
			getScrollPaneSourceDescriptor_DetailDatabase().setVisible(true);
			getScrollPaneSourceDescriptor_DetailFileDelim().setVisible(false);
			getScrollPaneSourceDescriptor_DetailFileFixed().setVisible(false);
		}
	}

	private JPanel getPanelRunScript_Attributes() {
		if (panelRunScript_Attributes == null) {
			panelRunScript_Attributes = new JPanel();
			panelRunScript_Attributes.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"),
					"Oyster Attributes File", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelRunScript_Attributes.setBounds(446, 315, 373, 84);
			GroupLayout gl_panelRunScript_Attributes = new GroupLayout(
					panelRunScript_Attributes);
			gl_panelRunScript_Attributes
					.setHorizontalGroup(gl_panelRunScript_Attributes
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_Attributes
											.createSequentialGroup()
											.addGap(12)
											.addComponent(
													getLabelRunScript_AttributesPath())
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getTextRunScript_AttributesPath(),
													GroupLayout.DEFAULT_SIZE,
													234, Short.MAX_VALUE)
											.addPreferredGap(
													ComponentPlacement.RELATED)
											.addComponent(
													getBtnRunScript_AttributesSelect())
											.addContainerGap()));
			gl_panelRunScript_Attributes
					.setVerticalGroup(gl_panelRunScript_Attributes
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panelRunScript_Attributes
											.createSequentialGroup()
											.addGap(18)
											.addComponent(
													getLabelRunScript_AttributesPath()))
							.addGroup(
									gl_panelRunScript_Attributes
											.createSequentialGroup()
											.addGap(15)
											.addGroup(
													gl_panelRunScript_Attributes
															.createParallelGroup(
																	Alignment.BASELINE)
															.addComponent(
																	getTextRunScript_AttributesPath(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getBtnRunScript_AttributesSelect()))));
			panelRunScript_Attributes.setLayout(gl_panelRunScript_Attributes);
		}
		return panelRunScript_Attributes;
	}

	private JTextField getTextRunScript_AttributesPath() {
		if (textRunScript_AttributesPath == null) {
			textRunScript_AttributesPath = new JTextField();
			textRunScript_AttributesPath.setEnabled(false);
			textRunScript_AttributesPath
					.setText(" Absolute Path to Oyster Attributes File");
			textRunScript_AttributesPath.setColumns(10);
		}
		return textRunScript_AttributesPath;
	}

	private JButton getBtnRunScript_AttributesSelect() {
		if (btnRunScript_AttributesSelect == null) {
			btnRunScript_AttributesSelect = new JButton("Select..");
			btnRunScript_AttributesSelect
					.addActionListener(new BtnRunScript_AttributesSelectAction());
		}
		return btnRunScript_AttributesSelect;
	}

	private JLabel getLabelRunScript_AttributesPath() {
		if (labelRunScript_AttributesPath == null) {
			labelRunScript_AttributesPath = new JLabel("Path:");
		}
		return labelRunScript_AttributesPath;
	}

	private JScrollPane getScrollPaneSourceDescriptor_DetailDatabase() {
		if (scrollPaneSourceDescriptor_DetailDatabase == null) {
			scrollPaneSourceDescriptor_DetailDatabase = new JScrollPane();
			scrollPaneSourceDescriptor_DetailDatabase.setVisible(false);
			scrollPaneSourceDescriptor_DetailDatabase.setBounds(50, 26, 452,
					127);
			scrollPaneSourceDescriptor_DetailDatabase
					.setViewportView(getTableSourceDescriptor_DetailDatabase());
		}
		return scrollPaneSourceDescriptor_DetailDatabase;
	}

	private JTable getTableSourceDescriptor_DetailDatabase() {
		if (tableSourceDescriptor_DetailDatabase == null) {
			tableSourceDescriptor_DetailDatabase = new JTable();
			tableSourceDescriptor_DetailDatabase
					.setBackground(SystemColor.control);
			tableSourceDescriptor_DetailDatabase
					.setSelectionBackground(SystemColor.controlHighlight);
			tableSourceDescriptor_DetailDatabase.setRowHeight(20);
			tableSourceDescriptor_DetailDatabase
					.setModel(new DefaultTableModel(new Object[][] {
							{ null, null }, { null, null }, { null, null },
							{ null, null }, { null, null }, }, new String[] {
							"Name", "Attribute" }));
		}
		return tableSourceDescriptor_DetailDatabase;
	}

	private JLabel getLabelSourceDescriptor_SourceName() {
		if (labelSourceDescriptor_SourceName == null) {
			labelSourceDescriptor_SourceName = new JLabel(
					"Delete Existing Source?");
		}
		return labelSourceDescriptor_SourceName;
	}

	private JButton getBtnSourceDescriptor_DeleteSourceName() {
		if (btnSourceDescriptor_DeleteSourceName == null) {
			btnSourceDescriptor_DeleteSourceName = new JButton("Yes");
			btnSourceDescriptor_DeleteSourceName
					.addActionListener(new BtnSourceDescriptor_DeleteSourceNameAction());
			btnSourceDescriptor_DeleteSourceName.setEnabled(false);
		}
		return btnSourceDescriptor_DeleteSourceName;
	}

	private JLabel getLblSourceType() {
		if (lblSourceType == null) {
			lblSourceType = new JLabel("Type:");
		}
		return lblSourceType;
	}

	private class BtnSourceDescriptor_DeleteSourceNameAction implements
			ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SourceDescriptorTab_ResetSources();
			btnSourceDescriptor_DeleteSourceName.setEnabled(false);
			comboBoxSourceDescriptor_AddSourceType.setEnabled(true);

			tabbedPaneSourceDescriptor_Sources.setEnabledAt(0, true);
			tabbedPaneSourceDescriptor_Sources.setEnabledAt(1, true);
			tabbedPaneSourceDescriptor_Sources.setEnabledAt(2, true);

			btnSourceDescriptor_RefreshDb.setVisible(false);
		}

		/**
		 * Reset Sources in all SourceDescriptor tables
		 */
		private void SourceDescriptorTab_ResetSources() {

			tableSourceDescriptor_Database.selectAll();

			DefaultTableModel dmdb = (DefaultTableModel) tableSourceDescriptor_Database
					.getModel();

			for (int i = 0; i < dmdb.getColumnCount(); i++) {
				dmdb.setValueAt(null, 0, i);
			}

			tableSourceDescriptor_FileFixed.selectAll();

			DefaultTableModel dmff = (DefaultTableModel) tableSourceDescriptor_FileFixed
					.getModel();

			for (int i = 0; i < dmff.getColumnCount(); i++) {
				dmff.setValueAt(null, 0, i);
			}

			tableSourceDescriptor_FileDelim.selectAll();

			DefaultTableModel dmfd = (DefaultTableModel) tableSourceDescriptor_FileDelim
					.getModel();

			for (int i = 0; i < dmfd.getColumnCount(); i++) {
				dmfd.setValueAt(null, 0, i);
			}
		}
	}

	private JButton getBtnSourceDescriptor_CreateSourcedescriptor() {
		if (btnSourceDescriptor_CreateSourcedescriptor == null) {
			btnSourceDescriptor_CreateSourcedescriptor = new JButton(
					"Create  SourceDescriptor");
			btnSourceDescriptor_CreateSourcedescriptor
					.addActionListener(new BtnSourceDescriptor_CreateSourcedescriptorAction());
			btnSourceDescriptor_CreateSourcedescriptor.setBounds(575, 328, 153,
					36);
		}
		return btnSourceDescriptor_CreateSourcedescriptor;
	}
	
	private OysterReferenceSource oysterReferenceSource = new OysterReferenceSource();
	
	private class BtnSourceDescriptor_CreateSourcedescriptorAction implements
			ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {		
			

			
			
			if (tabbedPaneSourceDescriptor_Sources.getSelectedIndex() == 0) {
				oysterReferenceSource.setSourceType("Databse");
				oysterReferenceSource.setSourceName((String)tableSourceDescriptor_DetailDatabase.getValueAt(0, 0));
				
			}
			else if (tabbedPaneSourceDescriptor_Sources.getSelectedIndex() == 1){
				oysterReferenceSource.setSourceType("FileFixed");
			}
			else if (tabbedPaneSourceDescriptor_Sources.getSelectedIndex() == 2) {
				oysterReferenceSource.setSourceType("FileDelim");
			}
			
//			oysterReferenceSource.setSourceName(aSourceName);
//			
//			oysterReferenceSource.setServer(aServer);
//			oysterReferenceSource.setPort(aPort);
//			oysterReferenceSource.setSid(aSid);
//			oysterReferenceSource.setTable(aTable);
//			oysterReferenceSource.setUserID(aUserID);
//			oysterReferenceSource.setPasswd(aPasswd);			
//			oysterReferenceSource.setConnectionType(aConnectionType);
//			
//			oysterReferenceSource.setSourcePath(aSourcePath);
//			
//			oysterReferenceSource.setDelimiter(aDelimiter);
//			oysterReferenceSource.setQualifier(aQualifier);			
//			oysterReferenceSource.setLabel(aLabel);

			JOptionPane
			.showMessageDialog(frm_OysterGUIScriptor,
					oysterReferenceSource.getSourceName());
			
			btnSave.setEnabled(true);
		}
	}

	private class ScrollPaneSourceDescriptor_DatabaseFocus extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			setSourceDescriptor_DatebaseConfig();
		}
	}

	private JButton getBtnSourceDescriptor_RefreshDb() {
		if (btnSourceDescriptor_RefreshDb == null) {
			btnSourceDescriptor_RefreshDb = new JButton(
					"Refresh Database Config");
			btnSourceDescriptor_RefreshDb.setVisible(false);
			btnSourceDescriptor_RefreshDb.setBounds(575, 234, 153, 36);
			btnSourceDescriptor_RefreshDb
					.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSourceDescriptor_RefreshDb
					.addActionListener(new BtnRefreshAction());
		}
		return btnSourceDescriptor_RefreshDb;
	}

	private class BtnRefreshAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			setSourceDescriptor_DatebaseConfig();
		}
	}

	private JButton getBtnSourceDescriptor_LoadAttributesFile() {
		if (btnSourceDescriptor_LoadAttributesFile == null) {
			btnSourceDescriptor_LoadAttributesFile = new JButton(
					"Load Attributes File");
			btnSourceDescriptor_LoadAttributesFile
					.addActionListener(new BtnSourceDescriptor_LoadAttributesFileAction());
			btnSourceDescriptor_LoadAttributesFile.setBounds(575, 281, 153, 36);
		}
		return btnSourceDescriptor_LoadAttributesFile;
	}

	private class BtnSourceDescriptor_LoadAttributesFileAction implements
			ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// Open File
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(
					"Oyster Attributes", "xml");
			fileopen.addChoosableFileFilter(filter);
			File file = null;

			int ret = fileopen.showDialog(null, "Load Attributes File");

			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileopen.getSelectedFile();

				treeViewer.createUI(file);

				attributes = OysterAttributesParser.parse(file);
				
				Hashtable<OysterAttribute, OysterComparator> attrComp = attributes
						.getAttrComp();
				// Show all Attribute in the hash table.

				Enumeration<OysterAttribute> Attributes;
				Attributes = attrComp.keys();
				int i=0;
				String[] str = {""}; 
				while (Attributes.hasMoreElements()) {
					str[i] =  Attributes.nextElement().getName();
					//System.out.println(str[i]);
					tableSourceDescriptor_DetailFileFixed.setValueAt(
							str[i],
							tableSourceDescriptor_DetailFileFixed_RowNum, 1);
					tableSourceDescriptor_DetailFileFixed_RowNum++;
					
					tableSourceDescriptor_DetailFileDelim.setValueAt(
							str[i],
							tableSourceDescriptor_DetailFileDelim_RowNum, 1);
					tableSourceDescriptor_DetailFileDelim_RowNum++;
					
					tableSourceDescriptor_DetailDatabase.setValueAt(
							str[i],
							tableSourceDescriptor_DetailDatabase_RowNum, 1);
					tableSourceDescriptor_DetailDatabase_RowNum++;
				}
			}
		}
	}
}

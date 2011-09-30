package edu.ualr.oyster.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;

public class XMLSaver extends JDialog {
	
	private JTextArea jta = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(jta);
	private JPanel buttonPane;
	

	public XMLSaver() {
		setBounds(100, 100, 833, 599);
		this.setAlwaysOnTop(true);
		this.setBounds(550, 300, 800, 700);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(scrollPane);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Save XML");
				okButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						SaveFile();
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Close();
						
					}
					
				});
				cancelButton.setSize(new Dimension(79, 23));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
	}

	public void setXML(String str){
		jta.setText(str);
		jta.setEditable(false);
		
	}
	
	private void SaveFile() {
		
		JFileChooser chooser = new JFileChooser();

		FileFilter filter = new FileNameExtensionFilter("XML Files",
				"xml");
		chooser.addChoosableFileFilter(filter);
		chooser.setDialogTitle("Save XML File");

		if (chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {

			File fileRunScript = chooser.getSelectedFile();
			String filePath = fileRunScript.getPath();
			if (!filePath.toLowerCase().endsWith(".xml")) {
				fileRunScript = new File(filePath + ".xml");
			}
			// Create file if it does not exist
			try {
				boolean success = fileRunScript.createNewFile();
				if (success) {
					// File did not exist and was created
					FileWriter fstream = new FileWriter(fileRunScript);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write(jta.getText());
					out.close();
					JOptionPane
							.showMessageDialog(this,
									"File created successfully.");
					this.dispose();
				} else {
					// File already exists
					JOptionPane.showMessageDialog(
							this,
							"XML file already exists."
									+ "\n" + "Change Document Name!");
				}
			} catch (Exception eRS) {
				// TODO: handle exception
			}
		}
		
	
	}

	private void Close() {
		this.dispose();
	}
}

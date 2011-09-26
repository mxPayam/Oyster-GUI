package edu.ualr.oyster.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Font;

public class OysterRunScriptPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public OysterRunScriptPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setDoubleBuffered(false);
		panel.setBounds(10, 11, 355, 193);
		add(panel);
		
		JLabel label = new JLabel();
		label.setText("Description:");
		
		JLabel label_1 = new JLabel();
		label_1.setText("Author:");
		
		JLabel label_2 = new JLabel();
		label_2.setText("Created on:");
		
		JLabel label_3 = new JLabel();
		label_3.setText("Document:");
		
		textField = new JTextField();
		textField.setBackground(SystemColor.controlHighlight);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.controlHighlight);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.controlHighlight);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.controlHighlight);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 355, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, Alignment.TRAILING)
						.addComponent(label_1, Alignment.TRAILING)
						.addComponent(label_2, Alignment.TRAILING)
						.addComponent(label_3, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 193, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(706, 11, 418, 193);
		add(panel_1);
		
		JButton button = new JButton("Load Source Descriptor File");
		button.setBounds(10, 26, 163, 23);
		panel_1.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 60, 398, 122);
		panel_1.add(scrollPane);
		
		JButton button_1 = new JButton("Remove Source Descriptor");
		button_1.setBounds(196, 26, 163, 23);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(371, 11, 325, 193);
		add(panel_2);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Explanation:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSelectedIndex(1);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Number of Log Files:");
		
		JSpinner spinner = new JSpinner();
		
		JLabel label_6 = new JLabel();
		label_6.setText("Debug:");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSelectedIndex(1);
		
		JLabel label_7 = new JLabel();
		label_7.setText("Log File Size Limit:");
		
		textField_3 = new JTextField();
		textField_3.setText("100000000");
		
		JLabel label_8 = new JLabel("Path:");
		
		textField_4 = new JTextField();
		textField_4.setText(" Absolute Path to Log Directory");
		textField_4.setEnabled(false);
		
		JButton button_2 = new JButton();
		button_2.setText("Select..");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 325, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(10)
							.addComponent(label_4)
							.addGap(10)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_5)
							.addGap(9)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(35)
							.addComponent(label_6)
							.addGap(10)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(label_7)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(10)
							.addComponent(label_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 193, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(label_5))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(3)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(4)
							.addComponent(label_6))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(4)
							.addComponent(label_7))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(50)
							.addComponent(label_8))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2))))
					.addGap(2))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 210, 426, 85);
		add(panel_3);
		
		JLabel label_9 = new JLabel("Type:");
		
		JComboBox comboBox_2 = new JComboBox();
		
		textField_5 = new JTextField();
		textField_5.setText(" Absolute Path to Oyster Identity Input");
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		
		JButton button_3 = new JButton("Select..");
		button_3.setEnabled(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 426, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_3)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 85, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(446, 210, 373, 85);
		add(panel_4);
		
		JLabel label_10 = new JLabel("Path:");
		
		textField_6 = new JTextField();
		textField_6.setText(" Absolute Path to Oyster Link Output");
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		
		JButton button_4 = new JButton("Create");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 373, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 85, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10)
						.addComponent(button_4))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(829, 284, 295, 116);
		add(panel_5);
		
		JLabel label_11 = new JLabel();
		label_11.setText("ER Engine:");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setSelectedIndex(2);
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton button_5 = new JButton();
		button_5.setText("Preview Run Script");
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 295, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_11)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(button_5)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 116, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button_5, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(446, 315, 373, 84);
		add(panel_6);
		
		JLabel label_12 = new JLabel("Path:");
		
		textField_7 = new JTextField();
		textField_7.setText(" Absolute Path to Oyster Attributes File");
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		
		JButton button_6 = new JButton("Select..");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 373, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(12)
					.addComponent(label_12)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_6)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 84, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(18)
					.addComponent(label_12))
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6)))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 315, 426, 84);
		add(panel_7);
		
		JLabel label_13 = new JLabel("Type:");
		
		JComboBox comboBox_4 = new JComboBox();
		
		textField_8 = new JTextField();
		textField_8.setText(" Absolute Path to Oyster Identity Output");
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		
		JButton button_7 = new JButton("Create");
		button_7.setEnabled(false);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 426, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_13)
					.addGap(4)
					.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 84, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(4)
							.addComponent(label_13))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_7))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);

	}

}

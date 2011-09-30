package edu.ualr.oyster.gui;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;

import edu.ualr.oyster.gui.OysterEnum.MatchType;

public class OysterAttributesPanel extends JPanel {


	
	/*
	 * Graphical Item Construction
	 */
	
	private JTextField txt_Author;
	private JTextField txt_Document;
	private JTextField txt_CreatedOn;
	private JTextField txt_RuleName;
	private OysterAttributesPanel attributes;
	private OysterTable tbl_Attributes;
	private OysterTable tbl_Rules;
	
	public OysterAttributesPanel() {
		setLocation(-862, -11);
		setLayout(null);
		
		JPanel pnl_Comments = new JPanel();
		pnl_Comments.setBorder(new TitledBorder(null, "Comments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Comments.setDoubleBuffered(false);
		pnl_Comments.setBounds(10, 11, 355, 163);
		add(pnl_Comments);
		
		JLabel lbl_Author = new JLabel();
		lbl_Author.setText("Author:");
		
		txt_Author = new JTextField();
		txt_Author.setBackground(SystemColor.controlHighlight);
		
		JLabel lbl_Description = new JLabel();
		lbl_Description.setText("Description:");
		
		JTextArea txta_Description = new JTextArea();
		txta_Description.setBackground(SystemColor.controlHighlight);
		
		JLabel lbl_Document = new JLabel();
		lbl_Document.setText("Document:");
		
		txt_Document = new JTextField();
		txt_Document.setBackground(SystemColor.controlHighlight);
		
		JLabel lbl_CreatedOn = new JLabel();
		lbl_CreatedOn.setText("Created on:");
		
		txt_CreatedOn = new JTextField();
		txt_CreatedOn.setBackground(SystemColor.controlHighlight);
		GroupLayout gl_pnl_Comments = new GroupLayout(pnl_Comments);
		gl_pnl_Comments.setHorizontalGroup(
			gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
				.addGap(0, 355, Short.MAX_VALUE)
				.addGroup(gl_pnl_Comments.createSequentialGroup()
					.addGroup(gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(31)
							.addComponent(lbl_Author)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_Author, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(11)
							.addComponent(lbl_Description)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txta_Description, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(16)
							.addComponent(lbl_Document)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_Document, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl_CreatedOn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_CreatedOn, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pnl_Comments.setVerticalGroup(
			gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
				.addGap(0, 159, Short.MAX_VALUE)
				.addGroup(gl_pnl_Comments.createSequentialGroup()
					.addGroup(gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_Document))
						.addComponent(txt_Document, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(9)
							.addComponent(lbl_CreatedOn))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_CreatedOn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(9)
							.addComponent(lbl_Author))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_Author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_pnl_Comments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(13)
							.addComponent(lbl_Description))
						.addGroup(gl_pnl_Comments.createSequentialGroup()
							.addGap(6)
							.addComponent(txta_Description, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addGap(34))
		);
		pnl_Comments.setLayout(gl_pnl_Comments);
		
		JPanel pnl_Rules = new JPanel();
		pnl_Rules.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Rules.setLayout(null);
		pnl_Rules.setBounds(385, 11, 435, 360);
		add(pnl_Rules);
		
		JScrollPane sp_Rules = new JScrollPane();
		sp_Rules.setBounds(0, 38, 434, 277);
		pnl_Rules.add(sp_Rules);
		
		tbl_Rules = new OysterTable();
		tbl_Rules.setRowHeight(20);
		tbl_Rules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp_Rules.setViewportView(tbl_Rules);
		
		JButton btn_AddTerm = new JButton("Add Term");
		btn_AddTerm.setBounds(29, 325, 79, 23);
		btn_AddTerm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_Rules.AddDetailRow();
			}
			
		});
		pnl_Rules.add(btn_AddTerm);
		
		JButton btn_RemoveTerm = new JButton("Remove Term");
		btn_RemoveTerm.setBounds(113, 325, 99, 23);
		btn_RemoveTerm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tbl_Rules.ClearSelectedRow();
			}		
		});
		pnl_Rules.add(btn_RemoveTerm);
		
		JButton btn_ClearTerms = new JButton("Clear Terms");
		btn_ClearTerms.setBounds(217, 325, 89, 23);
		btn_ClearTerms.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_Rules.ClearTable();
			}
		});
		pnl_Rules.add(btn_ClearTerms);
		
		JButton btn_CreateRule = new JButton("Create Rule");
		btn_CreateRule.setBounds(311, 325, 89, 23);
		btn_CreateRule.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Create Rule conversion to Tree
			}	
		});
		pnl_Rules.add(btn_CreateRule);
		
		JLabel lbl_RuleName = new JLabel("Rule Name:");
		lbl_RuleName.setBounds(44, 7, 84, 20);
		pnl_Rules.add(lbl_RuleName);
		
		txt_RuleName = new JTextField();
		txt_RuleName.setColumns(10);
		txt_RuleName.setBounds(106, 7, 269, 20);
		pnl_Rules.add(txt_RuleName);
		
		JPanel pnl_RulesOverview = new JPanel();
		pnl_RulesOverview.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_RulesOverview.setLayout(null);
		pnl_RulesOverview.setBounds(840, 11, 284, 360);
		add(pnl_RulesOverview);
		
		JButton btn_RemoveRule = new JButton("Remove Rule");
		btn_RemoveRule.setBounds(7, 325, 95, 23);
		btn_RemoveRule.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Add OysterTree Logic
			}
			
		});
		pnl_RulesOverview.add(btn_RemoveRule);
		
		JButton btn_EditRule = new JButton("Edit Rule");
		btn_EditRule.setBounds(107, 325, 75, 23);
		btn_EditRule.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Add Edit Rule Logic
			}
			
		});
		pnl_RulesOverview.add(btn_EditRule);
		
		JButton btn_ClearRules = new JButton("Clear Rules");
		btn_ClearRules.setBounds(187, 325, 87, 23);
		btn_ClearRules.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Add OysterTree Logic
			}
			
		});
		pnl_RulesOverview.add(btn_ClearRules);
		
		JScrollPane sp_RulesOverview = new JScrollPane();
		sp_RulesOverview.setBounds(0, 0, 283, 315);
		pnl_RulesOverview.add(sp_RulesOverview);
		
		JTree tree_RulesOverview = new JTree();
		sp_RulesOverview.setViewportView(tree_RulesOverview);
		
		JButton btn_PreviewAttributes = new JButton("Preview Attribues XML");
		btn_PreviewAttributes.setBounds(980, 382, 144, 28);
		btn_PreviewAttributes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				* XMLFormer();
				* TODO: Add XMLForming Logic
				*/
			}
			
		});
		add(btn_PreviewAttributes);
		
		JPanel pnl_Attributes = new JPanel();
		pnl_Attributes.setBorder(new TitledBorder(null, "Attributes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Attributes.setLayout(null);
		pnl_Attributes.setBounds(10, 176, 355, 196);
		add(pnl_Attributes);
		
		JButton btn_CreateAttribute = new JButton("Create Attribute");
		btn_CreateAttribute.setBounds(5, 159, 111, 23);
		btn_CreateAttribute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_Attributes.AddDetailRow();
				tbl_Attributes.getCellEditor(0,0).addCellEditorListener(new CellEditorListener(){

					@Override
					public void editingCanceled(ChangeEvent arg0) {
						System.out.println("Editing Cancelled: " + arg0);
						
					}

					@Override
					public void editingStopped(ChangeEvent arg0) {
						System.out.println("Editing Stopped: " + arg0);
						SetColumnRenderers();
						
					}
					
				});
			}
			
		});
		pnl_Attributes.add(btn_CreateAttribute);
		
		JScrollPane sp_Attributes = new JScrollPane();
		sp_Attributes.setBounds(3, 0, 350, 148);
		pnl_Attributes.add(sp_Attributes);
		
		tbl_Attributes = new OysterTable();
		tbl_Attributes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_Attributes.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				System.out.println("Focus Gained: " + arg0);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				System.out.println("Focus Lost: " + arg0);
				SetColumnRenderers();
			}
			
		});
		sp_Attributes.setViewportView(tbl_Attributes);
		
		JButton btn_RemoveAttribute = new JButton("Remove Attribute");
		btn_RemoveAttribute.setBounds(121, 159, 117, 23);
		btn_RemoveAttribute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_Attributes.ClearSelectedRow();
			}
			
		});
		pnl_Attributes.add(btn_RemoveAttribute);
		
		JButton btn_ClearAttributes = new JButton("Clear Attributes");
		btn_ClearAttributes.setBounds(241, 159, 108, 23);
		btn_ClearAttributes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_Attributes.ClearTable();
			}
		});
		pnl_Attributes.add(btn_ClearAttributes);
		
		
		/*
		 * Initialization Methods
		 */
		
		SetTableModels();
		SetColumnRenderers();
	}
	
	public OysterAttributesPanel getPanel() {
		if (attributes != null){
			return attributes;
		}
		else{
			attributes = new OysterAttributesPanel();
			return attributes;
		}
		
	}
	
	private void SetTableModels(){
		
		tbl_Attributes.setTableModel(2, new String[] {"Attribute", "Algorithm"}, new Class[] {String.class, String.class});
		tbl_Rules.setTableModel(2, new String[] {"Attribute", "Match"}, new Class[] {JComboBox.class, JComboBox.class});
		
	}
	
	private void SetColumnRenderers(){
		
		tbl_Rules.setComboBoxRenderer( 0, getAttributeOptions() );
		tbl_Rules.setComboBoxRenderer( 1, getMatchOptions() );
	}
	
	
	private String[] getAttributeOptions(){

		String[] str = new String[ tbl_Attributes.getRowCount() ];
		
		for (int i = 0; i < tbl_Attributes.getRowCount(); i++){
			str[i] = (String) tbl_Attributes.getModel().getValueAt(i, 0);
		}
		return str;
	}
	
	private String[] getMatchOptions(){
		
		String[] str = {"Exact", "Missing", "Transpose", "Close"};
			
		/* No Enum Support? */
		//OysterEnum.MatchType;
		return str;
	}
	

	/*
	 * Code Behind
	 */
	
	private void AddToSelection(){
		
	}
	
	private void AddAttribute(){
		
	}
	
	private void CreateRule(){
		
	}
	
	
	
}

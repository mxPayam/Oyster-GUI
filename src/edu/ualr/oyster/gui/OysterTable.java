package edu.ualr.oyster.gui;


import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableCell;



public class OysterTable extends JTable{

//	@Override
//	public TableCellEditor getCellEditor(int row, int column) {
//	   Object value = super.getValueAt(row, column);
//	   if(value != null) {
//	      if(value instanceof JComboBox) {
//	           return (TableCellEditor) new ComboBoxEditor().getTableCellEditorComponent(this, value, true, row, column);
//	      }
//	            return getDefaultEditor(value.getClass());
//	   }
//	   return super.getCellEditor(row, column);
//	}
	
	public void ClearSelectedRow()
	{
	
		DefaultTableModel dftm = (DefaultTableModel) this.getModel();
		if (this.getSelectedRowCount() < 2){
			if (this.getSelectedRow() > -1){
				dftm.removeRow( this.getSelectedRow() );	
			}
		}else if (this.getSelectedRowCount() > 1){
		
			int[] rowsSelected = new int[ this.getSelectedRowCount() ];
			
			for (int i = 0; i < rowsSelected.length; i++){
				dftm.removeRow(rowsSelected[i]);
			}
		}
		
	}
	
	public void ClearTable() {
		DefaultTableModel dftm = (DefaultTableModel) this.getModel();
		
		while (dftm.getRowCount() > 0) {
			dftm.removeRow(0);
		}
	}

	public void AddDetailRow(int rowNum){
		
		DefaultTableModel tm = (DefaultTableModel) this.getModel();
		Object[] insertion = {};
		tm.insertRow(rowNum, insertion);
		
	}
	
	public void AddDetailRow(){

		DefaultTableModel tm = (DefaultTableModel) this.getModel();
		Object[] insertion = {};
		
		tm.insertRow(this.getRowCount(), insertion);;
	
		
	}

	public void FillTable(){
		
	}

	public TableModel getTableModel(int columns, String[] columnNames, final Class[] columnClasses){
		DefaultTableModel dftm = new DefaultTableModel(
			columnNames, this.getRowCount()){
			
			public Class getColumnClass (int columnIndex){
				
				return columnClasses[columnIndex];
			}
					
		};
		
		return dftm;
	}
	
	public void setTableModel(int columns, String[] columnNames, final Class[] columnClasses){
		DefaultTableModel dftm = new DefaultTableModel(
			columnNames, this.getRowCount()){
			
			public Class getColumnClass (int columnIndex){
				
				return columnClasses[columnIndex];
			}
					
		};
		
		this.setModel(dftm);
	}

	public void setComboBoxRenderer(int colNum, String[] items){
		
		TableColumn col = this.getColumnModel().getColumn(colNum);
		col.setCellEditor( new javax.swing.DefaultCellEditor( new JComboBox(items) ) );
		col.setCellRenderer( new ComboBoxRenderer(items) );
		
	}
	
	public class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
		   
		public ComboBoxRenderer(String[] items) {
		        super(items);
		    }
		    
		 public Component getTableCellRendererComponent(JTable table, Object value,
		            boolean isSelected, boolean hasFocus, int row, int column) {
		        if (isSelected) {
		            setForeground(table.getSelectionForeground());
		            super.setBackground(table.getSelectionBackground());
		        } else {
		            setForeground(table.getForeground());
		            setBackground(table.getBackground());
		        }
	
		        setSelectedItem(value);
		        return this;
		    }
		}
	
	public void setComboBoxEditor(int row, int col){
		
		
	}
	
	public class ComboBoxEditor extends AbstractCellEditor implements TableCellEditor{

		@Override
		public void addCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cancelCellEditing() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getCellEditorValue() {
			return this.getCellEditorValue();
		}

		@Override
		public boolean isCellEditable(EventObject anEvent) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void removeCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub	
		}

		@Override
		public boolean shouldSelectCell(EventObject anEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Component getTableCellEditorComponent(JTable t, Object value,
				boolean isSelected, int row, int col) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}

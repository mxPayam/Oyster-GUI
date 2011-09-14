package edu.ualr.oyster.gui;



import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;


public class OysterTable extends JTable{

	@Override
	public TableCellEditor getCellEditor(int row, int column) {
	   Object value = super.getValueAt(row, column);
	   if(value != null) {
	      if(value instanceof JComboBox) {
	           return new DefaultCellEditor((JComboBox)value);
	      }
	            return getDefaultEditor(value.getClass());
	   }
	   return super.getCellEditor(row, column);
	}
	
	
	private void ClearSelectedRow()
	{
	
		DefaultTableModel dftm = (DefaultTableModel) this.getModel();
		if ( this.getSelectedRow() > -1 ){
			dftm.removeRow( this.getSelectedRow() );	
		}
		//TODO: Add support for multiple rows.
	}
	
	private void ClearTable() {
		DefaultTableModel dftm = (DefaultTableModel) this.getModel();
		
		while (dftm.getRowCount() > 0) {
			dftm.removeRow(0);
		}
	}

	private void AddDetailRow(int rowNum){
		
		DefaultTableModel tm = (DefaultTableModel) this.getModel();
		Object[] insertion = {};
		tm.insertRow(rowNum, insertion);
		
	}

	private void FillTable(){
		
	}

}

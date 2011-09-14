package edu.ualr.oyster.gui;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class TableConstraintChecker {


	public static class InUse{
		private ArrayList<Integer> problemRows;
		private ArrayList<Integer> problemNumbers;
		
		private boolean matchFound = false;
		private boolean hasNullsOrEmpties = false;
		private boolean hasInvertedRange = false;
		private boolean hasOverlapRange = false;
		private boolean hasDuplicates = false;
		
		public ArrayList<Integer> getRows(){
			return problemRows;
		}
		
		public ArrayList<Integer> getNumbers(){	
			return problemNumbers;
		}
		
		public boolean isMatchFound(){
			return matchFound;
		}
		
		public boolean hasNullsOrEmpties(){
			return hasNullsOrEmpties;
		}
		
		public boolean hasInvertedRange(){
			return hasInvertedRange;
		}
		
		public boolean hasOverlapRange(){
			return hasOverlapRange;
		}
		
		public boolean hasDuplicates(){
			return hasDuplicates;
		}
		private void setProblemRows(ArrayList<Integer> problems){
			problemRows = problems;
		}
		
		private void setProblemNumbers(ArrayList<Integer> problems){
			problemNumbers = problems;
		}
		
		private void setMatchFound(boolean b){
			matchFound = b;
		}
		
		private void setNullsOrEmpties(boolean b){
			hasNullsOrEmpties = b;
		}
	
		private void setInvertedRange(boolean b){
			hasInvertedRange = b;
		}
		
		private void setOverlapRange(boolean b){
			hasOverlapRange = b;
		}
		
		private void setDuplicateFound(boolean b){
			hasDuplicates = b;
		}
		
		public void setFalse(){
			matchFound = false;
		}
	}
	

	public InUse CheckRanges(JTable t){

		InUse used = new InUse();
		
		boolean problemFound = false;
		boolean duplicateFound = false;
		boolean overlapFound = false;
		boolean invertedRange = false;
		int rows = t.getRowCount();
		int[][] ranges = new int[rows][2];
		
		ArrayList<Integer> problemNumbersList = null;
		ArrayList<Integer> problemRowsList = null;
		
		
		//Add table to array[][]
			for (int i = 0; i < rows; i++){
				ranges[i][0] = (Integer) t.getModel().getValueAt(i, 2);
				ranges[i][1] = (Integer) t.getModel().getValueAt(i, 3);
			}
	
		for (int i=0; i < ranges.length; i++){
			for (int j=0; j < ranges[i].length; j++){
				int n = ranges[i][j];

					for (int k=0; k < ranges.length; k++){
						for(int h=0; h < ranges[k].length; h++){
							if( (i!=k && h!=j) || (i==k && h!=j)){
								if (ranges[k][h] == n){
									duplicateFound = true;
									problemFound = true;
								}
								
								if( n > ranges[k][0] && n < ranges[k][1]){
									overlapFound = true;
									problemFound = true;
								}
								
							}
						}
					}
				
			}
		}
		
		for (int i=0; i < ranges.length; i++){
			if(ranges[i][0] > ranges[i][1]){
				invertedRange = true;
				problemFound = true;
			}
		}
			
		//TODO: Add error Rows and Number to problems

		if (problemFound){
			used.setOverlapRange(overlapFound);
			used.setMatchFound(problemFound);
			used.setInvertedRange(invertedRange);
			used.setDuplicateFound(duplicateFound);
			used.setProblemNumbers(problemNumbersList);
			used.setProblemRows(problemRowsList);		 
		}

		return used;
	}
	
	
	public InUse CheckMatches(JTable t){
		InUse used = new InUse();
		
		boolean problemFound = false;
		int rows = t.getRowCount();
		int[] rowValues = new int[rows];
		ArrayList<Integer> problemRows = new ArrayList<Integer>();
		
		//Load row values into rowValues
		for (int i=0; i < rows; i++){
			rowValues[i] = (Integer) t.getModel().getValueAt(i, 2);
		}

		
		for (int i=0; i < rowValues.length; i++){
			for ( int n=0; n < rowValues.length; n++){
				if (i != n){
					if (rowValues[i] == rowValues[n]){
						problemFound = true;
						problemRows.add(n);
					}
				}
			}
		}
		
		if (problemFound){
			used.setMatchFound(true);
			used.setProblemRows(problemRows);		 
		}
		
		return used; 
	}
	

	public InUse CheckNames(JTable t){
		InUse used = new InUse();
		
		int rows = t.getRowCount();
		String[] rowValues = new String[rows];
		boolean problemFound = false;
		boolean hasNullOrEmpties = false;
		ArrayList<Integer> problemRows = new ArrayList<Integer>();
		
		for (int i=0; i < rows; i++){
			rowValues[i] = (String) t.getModel().getValueAt(i, 0);
			
			if (rowValues[i] != null){
				rowValues[i].trim();
				
				if ( rowValues[i].equals("") ){
					rowValues[i] = null;
				}
			}
			
		}
		
		for (int i=0; i < rowValues.length; i++){
			for ( int n=0; n < rowValues.length; n++){
				if (rowValues.length > 1){
					if (i != n){
						if ( (rowValues[i] == null) || (rowValues[n] == null) ){
							hasNullOrEmpties = true;
							problemFound = true;
							break;
						}
						else if (rowValues[i].equals(rowValues[n])){
							problemFound = true;
							problemRows.add(n);
						}
					}
				}
				else{
					if ( (rowValues[i] == null) || (rowValues[n] == null) ){
						hasNullOrEmpties = true;
						problemFound = true;
						break;
					}
				}
			}
		}
		
		if (problemFound){
			used.setMatchFound(true);
			used.setNullsOrEmpties(hasNullOrEmpties); 
			used.setProblemRows(problemRows);
		}
		
		return used;
	}

	
	public InUse CheckAttributes(JTable t){
		InUse used = new InUse();
		
		int rows = t.getRowCount();
		String[] rowValues = new String[rows];
		boolean problemFound = false;
		boolean hasNullOrEmpties = false;
		ArrayList<Integer> problemRows = new ArrayList<Integer>();
		
		for (int i=0; i < rows; i++){
			rowValues[i] = t.getCellEditor(i, 1).getCellEditorValue().toString();

			if (rowValues[i] != null){
				rowValues[i].trim();
				
				if ( rowValues[i].equals("") ){
					rowValues[i] = null;
				}
			}
			
		}
		
		for (int i=0; i < rowValues.length; i++){
			for ( int n=0; n < rowValues.length; n++){
				if (rowValues.length > 1){
					if (i != n){
						if ( (rowValues[i] == null) || (rowValues[n] == null) ){
							hasNullOrEmpties = true;
							problemFound = true;
							break;
						}
					}
				}
				else{
					if ( (rowValues[i] == null) || (rowValues[n] == null) ){
						hasNullOrEmpties = true;
						problemFound = true;
						break;
					}
				}
			}
		}
		
		if (problemFound){
			used.setMatchFound(true);
			used.setNullsOrEmpties(hasNullOrEmpties); 
			used.setProblemRows(problemRows);
		}
		
		return used;
	}
}

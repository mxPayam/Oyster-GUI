package edu.ualr.oyster.gui;

import java.util.ArrayList;

import edu.ualr.oyster.gui.core.OysterAttributes;
import edu.ualr.oyster.gui.core.OysterReferenceItem;
import edu.ualr.oyster.gui.core.OysterReferenceSource;
import edu.ualr.oyster.gui.core.OysterRunScript;

public class XMLFormer {

	public String FormAttributes(OysterRunScript.Comments commentSourceDescriptor, OysterAttributes attributes){
		
		StringBuffer attributesXML = new StringBuffer(""); 
		attributesXML.delete(0, attributesXML.length());
		
		attributesXML.append( FormComments(commentSourceDescriptor) );
		
		
		
		return attributesXML.toString();
	}
	
	public String FormSourceDescriptor(OysterRunScript.Comments commentSourceDescriptor, OysterReferenceSource oysterReferenceSource){

		StringBuffer sourceDescriptorXML = new StringBuffer(""); 
		sourceDescriptorXML.delete(0, sourceDescriptorXML.length());
		
		sourceDescriptorXML.append( FormComments(commentSourceDescriptor) );

		
		// <OysterRunScript> start Tag
		sourceDescriptorXML.append("<OysterSourceDescriptor>");
		sourceDescriptorXML.append("\n");
		sourceDescriptorXML.append("    ");
		sourceDescriptorXML.append("<!-- Types of Sources (Only one can be defined) -->");
		sourceDescriptorXML.append("\n");
		sourceDescriptorXML.append("    ");

		String sourceType = oysterReferenceSource.getSourceType();
		
		if (sourceType == "Database") {
		
			sourceDescriptorXML.append("<Source Type=\"Database\" SID=\"" + oysterReferenceSource.getSid() + "\" UserID=\"" 
					+ oysterReferenceSource.getUserID() + "\" Passwd=\"" + oysterReferenceSource.getPasswd() + "\" CType=\"" 
					+ oysterReferenceSource.getConnectionType() + "\">" + oysterReferenceSource.getTable() + "</Source>");
					
		} else if (sourceType == "FileFixed") {
			sourceDescriptorXML
			.append("<Source Type=\"FileFixed\">"
					+ oysterReferenceSource.getSourcePath()
					+ "</Source>");
			
		} else if (sourceType == "FileDelim") {
			String label;
			if(oysterReferenceSource.isLabel())
				label = "Y";
			else
				label = "N";
			
			sourceDescriptorXML.append("<Source Type=\"FileDelim\" Char=\""
							+ oysterReferenceSource.getDelimiter()
							+ "\" Qual=\""
							+ oysterReferenceSource.getQualifier()
							+ "\" Labels=\"" + label + "\">"
							+ oysterReferenceSource.getSourcePath()
							+ "</Source>");
		}
			sourceDescriptorXML.append("\n");
			sourceDescriptorXML.append("\n");
			sourceDescriptorXML.append("    ");
			sourceDescriptorXML.append("<!-- Items in Source (One for each item in the source including reference identifier) -->");
			sourceDescriptorXML.append("\n");
			sourceDescriptorXML.append("    ");
			sourceDescriptorXML.append("<ReferenceItems>");
			sourceDescriptorXML.append("\n");
			
			
			// Add Items
			sourceDescriptorXML.append("    ");
			
			ArrayList<OysterReferenceItem> oysterReferenceItem = oysterReferenceSource
			.getOysterReferenceItems();
		
		if ( sourceType == "Database") {
			for (int i = 0; i < oysterReferenceItem.size(); i++) {
				sourceDescriptorXML.append("    ");
				sourceDescriptorXML.append("<Item Name=\""
						+ oysterReferenceItem.get(i).getName());
				sourceDescriptorXML.append("\" Attribute=\""
						+ oysterReferenceItem.get(i).getAttribute());
				sourceDescriptorXML.append("\"/>");
				sourceDescriptorXML.append("\n");			
				sourceDescriptorXML.append("    ");		
			}
		} else if ( sourceType == "FileFixed" ) {
			for (int i = 0; i < oysterReferenceItem.size(); i++) {
				sourceDescriptorXML.append("    ");
				sourceDescriptorXML.append("<Item Name=\""
						+ oysterReferenceItem.get(i).getName());
				sourceDescriptorXML.append("\" Attribute=\""
						+ oysterReferenceItem.get(i).getAttribute());
				sourceDescriptorXML.append("\" Start=\""
						+ oysterReferenceItem.get(i).getStart());
				sourceDescriptorXML.append("\" End=\""
						+ oysterReferenceItem.get(i).getEnd());
				sourceDescriptorXML.append("\"/>");
				sourceDescriptorXML.append("\n");			
				sourceDescriptorXML.append("    ");
			}
		} else if ( sourceType == "FileDelim" ) {			
			for (int i = 0; i < oysterReferenceItem.size(); i++) {
				sourceDescriptorXML.append("    ");
				sourceDescriptorXML.append("<Item Name=\""
						+ oysterReferenceItem.get(i).getName());
				sourceDescriptorXML.append("\" Attribute=\""
						+ oysterReferenceItem.get(i).getAttribute());
				sourceDescriptorXML.append("\" Pos=\""
						+ oysterReferenceItem.get(i).getPos());
				sourceDescriptorXML.append("\"/>");
				sourceDescriptorXML.append("\n");			
				sourceDescriptorXML.append("    ");				
			}
		}
		
		sourceDescriptorXML.append("</ReferenceItems>");
		sourceDescriptorXML.append("\n");
		sourceDescriptorXML.append("</OysterSourceDescriptor>");
				
				
		return sourceDescriptorXML.toString();
	}

	public String FormRun(OysterRunScript.Comments commentSourceDescriptor, OysterRunScript runScript){
		
		StringBuffer runXML = new StringBuffer(""); 	
		runXML.delete(0, runXML.length());
		
		runXML.append( FormComments(commentSourceDescriptor) );
		
		
		return runXML.toString();
	}
	
	public String FormComments(OysterRunScript.Comments commentDescriptor){
		
		StringBuffer commentsXML = new StringBuffer(""); 
		commentsXML.delete(0, commentsXML.length());
		
		
		commentsXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		commentsXML.append("\n");
		commentsXML.append("<!--");
		commentsXML.append("\n");
		commentsXML.append("    ");
		commentsXML.append("Document: ");
		commentsXML.append(commentDescriptor.getDocument());
		commentsXML.append("\n");
		commentsXML.append("    ");
		commentsXML.append("Created on: ");
		commentsXML.append(commentDescriptor.getCreatedOn());
		commentsXML.append("\n");
		commentsXML.append("    ");
		commentsXML.append("Author: ");
		commentsXML.append(commentDescriptor.getAuthor());
		commentsXML.append("\n");
		commentsXML.append("    ");
		commentsXML.append("Description: ");
		commentsXML.append(commentDescriptor.getDescription());
		commentsXML.append("\n");
		commentsXML.append("-->");
		commentsXML.append("\n");
		
		
		return commentsXML.toString();
	}
}

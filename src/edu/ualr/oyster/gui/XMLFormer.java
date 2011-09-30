package edu.ualr.oyster.gui;

import java.util.ArrayList;

import edu.ualr.oyster.gui.OysterEnum.IdentityInputType;
import edu.ualr.oyster.gui.OysterEnum.IdentityOutputType;
import edu.ualr.oyster.gui.OysterEnum.LinkOutputType;
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

	public String FormRun(OysterRunScript.Comments commentRunScript, 
			OysterRunScript.LogSettings logSettings, OysterRunScript.LogFile logFile, OysterRunScript.AttributePath attributePath,
			OysterRunScript.EREngine erEngine, OysterRunScript.IdentityInput identityInput,OysterRunScript.IdentityOutput identityOutput,
			OysterRunScript.LinkOutput linkOutput, OysterTable tableRunScript_ReferenceSources){
		
		StringBuffer runXML = new StringBuffer(""); 	
		runXML.delete(0, runXML.length());
		
		runXML.append( FormComments(commentRunScript) );
		// clear the StringBuffer content
		runXML.delete(0, runXML.length());

		// XML Declaration and Comments
		runXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		runXML.append("\n");
		runXML.append("<!--");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("Document: ");
		runXML.append(commentRunScript.getDocument());
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("Created on: ");
		runXML.append(commentRunScript.getCreatedOn());
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("Author: ");
		runXML.append(commentRunScript.getAuthor());
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("Description: ");
		runXML.append(commentRunScript.getDescription());
		runXML.append("\n");
		runXML.append("-->");
		runXML.append("\n");

		// <OysterRunScript> start Tag
		runXML.append("<OysterRunScript>");
		runXML.append("\n");

		// Log Settings
		runXML.append("    ");
		runXML.append("<Settings Explanation=\""
				+ logSettings.getLogExplanation() + "\" Debug=\""
				+ logSettings.getLogDebug() + "\" />");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("    ");
		runXML.append("    ");
		runXML.append("<LogFile Num=\"").append(logFile.getNum())
				.append("\" Size=\"").append(logFile.getSize()).append("\">")
				.append(logFile.getLogDirectory())
				.append("\\Run_%g.log</LogFile>");

		// EREngine Type
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<EREngine Type=\"")
				.append(erEngine.getType()).append("\" />");

		// Attributes Path
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<!-- Attributes read from file only -->");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<AttributePath>")
				.append(attributePath.getAttributePath())
				.append("</AttributePath>");

		// Identity Input
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<!-- Identity Input Selection -->");
		runXML.append("\n");
		runXML.append("    ");
		if (identityInput.getType() == IdentityInputType.None) {
			runXML.append("<IdentityInput Type=\""
					+ IdentityInputType.None.toString() + "\">"
					+ "</IdentityInput>");
		} else if (identityInput.getType() == IdentityInputType.TextFile) {
			runXML.append("<IdentityInput Type=\""
					+ IdentityInputType.TextFile.toString() + "\">"
					+ identityInput.getAbsolutePath() + "</IdentityInput>");
		}
		// else if (identityInput.getType() == IdentityInputType.Database) {
		// runXML
		// .append("<IdentityInput Type=\""
		// + IdentityInputType.Database + "\" Server=\""
		// + dbConfigIdentityInput.getServer() + "\" Port=\""
		// + dbConfigIdentityInput.getPort() + "\" SID=\""
		// + dbConfigIdentityInput.getSID() + "\" UserID=\""
		// + dbConfigIdentityInput.getUserID()
		// + "\" Passwd=\""
		// + dbConfigIdentityInput.getPassword() + "\">"
		// + dbConfigIdentityInput.getTableName()
		// + "</IdentityInput>");
		// }

		// Identity Output
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML
				.append("<!-- Identity Output Selection (Only needed when CaptureMode=On) -->");
		runXML.append("\n");
		runXML.append("    ");
		
		if (identityOutput.getType() == IdentityOutputType.None ||  identityOutput.getType() == null) {
			runXML.append("<IdentityOutput Type=\""
					+ IdentityOutputType.None.toString() + "\">"
					+ "</IdentityOutput>");
		} else if (identityOutput.getType() == IdentityOutputType.TextFile) {
			runXML.append("<IdentityOutput Type=\""
					+ IdentityOutputType.TextFile.toString() + "\">"
					+ identityOutput.getAbsolutePath() + "</IdentityOutput>");
			// + "\\IdentityOutput.idty</IdentityOutput>");
		}

		// Link Output
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML
				.append("<!-- Link Output Selection (Only needed when CaptureMode=On) -->");
		runXML.append("\n");
		runXML.append("    ");
		if ( linkOutput.getAbsolutePath().trim().equals("Absolute Path to Oyster Link Output") || linkOutput.getAbsolutePath().trim().equals("") ){
			
		}
		else{
		runXML.append("<LinkOutput Type=\""
				+ LinkOutputType.TextFile.toString() + "\">"
				+ linkOutput.getAbsolutePath()
				// + "\\LinkOutput.link</LinkOutput>");
				+ "</LinkOutput>");
		}

		// Reference Sources
		runXML.append("\n");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<!-- Sources to Run -->");
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("<ReferenceSources>");

		// Reference Items
		for (int i = 0; i < tableRunScript_ReferenceSources.getRowCount(); i++) {
			// if (tableRunScript_ReferenceSources.getValueAt(i, 0) != null)
			String capture = "No";
			if (tableRunScript_ReferenceSources.getValueAt(i, 0).toString() == "true") {
				// CaptureMode
				if (tableRunScript_ReferenceSources.getValueAt(i, 0) != null)
					if (tableRunScript_ReferenceSources.getValueAt(i, 0)
							.toString() == "true")
						capture = "Yes";
			}
			// Path
			runXML.append("\n");
			runXML.append("    ");
			runXML.append("    ");
			runXML.append("<Source Capture=\"" + capture + "\">"
					+ tableRunScript_ReferenceSources.getValueAt(i, 3)
					+ "</Source>");

		}
		runXML.append("\n");
		runXML.append("    ");
		runXML.append("</ReferenceSources>");
		runXML.append("\n");
		runXML.append("</OysterRunScript>");

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

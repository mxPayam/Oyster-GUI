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
package edu.ualr.oyster.gui.utilities;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * OysterFileFilter.java
 * 
 * @author Payam Mahmoudian
 */
public final class OysterFileFilter extends FileFilter {

	// Private variables.
	private String description;
	private String filename;

	/**
	 * Constructor. Creates new instance of this class, which will be used to
	 * filter files. The JFileChooser will see only files which name is the same
	 * as the filename given this constructor as a parameter.
	 * 
	 * @param filename
	 *            which should be only seen while opening a file.
	 * @param description
	 *            of this filter.
	 */
	OysterFileFilter(String filename, String description) {
		super();
		this.filename = filename;
		this.description = description;
	}

	/**
	 * This method implements FileFilter accept() method.
	 * 
	 * @return true if found folder or selected file, otherwise returns false.
	 */
	@Override
	public boolean accept(File file) {
		return file.isDirectory() || file.getName().compareTo(filename) == 0;
	}

	/**
	 * This method implements FileFilter getDescription() method. It returns
	 * string which is used in file chooser menu to describe filter implemented
	 * in accept() method.
	 * 
	 * @return FileFilter description.
	 */
	@Override
	public String getDescription() {
		return description;

	}
}

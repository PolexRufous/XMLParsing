package handlers;

import org.xml.sax.helpers.DefaultHandler;

import entities.Computer;

public abstract class HandlerForParsing extends DefaultHandler {

	protected boolean isFileChecked;
	protected Computer computer;
	
	public boolean isFileChecked() {
		return isFileChecked;
	};
	
	public Computer getComputer() {
		return computer;
	}
	
}

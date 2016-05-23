package handlers;

import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleHandlerForSAXParsing extends HandlerForParsing {

	private static final Logger consoleLogger = ProjectLogger.getConsoleLogger();
	
	public SimpleHandlerForSAXParsing() {
		this.isFileChecked = true;
	}
	
	
	//********************************
	//Exceptions checking handling
	//********************************
	
	@Override
	public void warning(SAXParseException e) {
		consoleLogger.warn("warn: " + getMessagePoint(e) + "-" + e.getMessage());
		this.isFileChecked = false;
	}
	
	@Override
	public void error(SAXParseException e) {
		consoleLogger.error("error: " + getMessagePoint(e) + " - " + e.getMessage());
		consoleLogger.catching(e);
		this.isFileChecked = false;
	}
		
	@Override
	public void fatalError(SAXParseException e) {
		consoleLogger.fatal("fatalError: " + getMessagePoint(e) + " - " + e.getMessage());
		this.isFileChecked = false;
	}
		
	private String getMessagePoint(SAXParseException e) {
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
	
	//********************************
	//Parsing methods handling
	//********************************
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
		
}

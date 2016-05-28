package readers;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import entities.Computer;
import handlers.HandlerForParsing;
import handlers.ProjectExceptionHandler;
import handlers.SimpleConsoleExceptionHandler;
import handlers.SimpleHandlerForSAXParsing;

public class SAXComputerReader implements ComputerReader {

	private Computer computer;
	private ProjectExceptionHandler exceptionHandler;
	
	public SAXComputerReader() {
		exceptionHandler = new SimpleConsoleExceptionHandler();
	}
	
	public Computer generateCompInstance(String xmlFileName) {

		XMLReader reader;
		HandlerForParsing handler;
		
		try {
			reader = XMLReaderFactory.createXMLReader();
			handler = new SimpleHandlerForSAXParsing();
			
			reader.setContentHandler(handler);
			reader.parse(xmlFileName);
			
			computer = handler.getComputer();
			
			return getCompInstanse();
			
			} catch (SAXException | IOException e) {
				exceptionHandler.logException(e);
			}
		
		return null;
	}

	public Computer getCompInstanse() {
		return computer;
	}

}

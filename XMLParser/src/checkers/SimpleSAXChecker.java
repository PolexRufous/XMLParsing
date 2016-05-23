package checkers;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import handlers.HandlerForParsing;
import handlers.ProjectExceptionHandler;
import handlers.SimpleConsoleExceptionHandler;
import handlers.SimpleHandlerForSAXParsing;

public class SimpleSAXChecker {

	private String xmlFileName;
	private String xmlSchemaFileName;
	private ProjectExceptionHandler exceptionHandler;
	
	public SimpleSAXChecker(String xmlFileName, String xmlSchemaFileName){
		this.xmlFileName = xmlFileName;
		this.xmlSchemaFileName = xmlSchemaFileName;
		exceptionHandler = new SimpleConsoleExceptionHandler();
	}
	

	public boolean check(){
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		SAXParserFactory saxParserFactory;
		SAXParser parser;
		HandlerForParsing handler;
		
		try {
			schema = factory.newSchema(new File(xmlSchemaFileName));
			saxParserFactory = SAXParserFactory.newInstance();
			saxParserFactory.setSchema(schema);
			saxParserFactory.setNamespaceAware(true);
			
			parser = saxParserFactory.newSAXParser();
			handler = new SimpleHandlerForSAXParsing();
			
			parser.parse(xmlFileName, handler);
			
			return handler.isFileChecked();
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			exceptionHandler.logException(e);
		}
		
		return false;
	}
	
}

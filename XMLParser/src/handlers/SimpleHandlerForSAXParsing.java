package handlers;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import javax.xml.namespace.QName;

import entities.AbstractType;
import entities.Computer;
import entities.Device;
import entities.ExtPort;
import entities.External;
import entities.Group;
import entities.IntPort;
import entities.Internal;
import helpers.ComputerTagEnum;
import helpers.Messanger;

public class SimpleHandlerForSAXParsing extends HandlerForParsing {

	private static final Logger consoleLogger = ProjectLogger.getConsoleLogger();

	private Device device;
	private AbstractType type;
	private ComputerTagEnum currentTag = null;

	
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
		computer = new Computer();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (localName.equalsIgnoreCase("device")) {
			device = new Device();
			device.setId(attributes.getValue("id"));
			device.setCritical(Boolean.valueOf(attributes.getValue("critical")));
		} else if (localName.equalsIgnoreCase("externalType")) {
			type = new External();
			((External) type).setExtPower(Boolean.valueOf(attributes.getValue("extPower")));
		} else if (localName.equalsIgnoreCase("internalType")) {
			type = new Internal();
		} else {
			currentTag = ComputerTagEnum.valueOf(localName.toUpperCase());
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

		String text = new String(ch, start, length).trim();
		if(text.isEmpty()) return;
				
		if (currentTag.equals(ComputerTagEnum.NAME)) {
			device.setName(text);
		} else if (currentTag.equals(ComputerTagEnum.ORIGIN)) {
			device.setOrigin(text);
		} else if (currentTag.equals(ComputerTagEnum.PRICE)) {
			device.setPrice(new BigInteger(text));
		} else if (currentTag.equals(ComputerTagEnum.COOLER)) {
			type.setCooler(Boolean.valueOf(text));
		} else if (currentTag.equals(ComputerTagEnum.ENERGY)) {
			type.setEnergy(Double.valueOf(text));
		} else if (currentTag.equals(ComputerTagEnum.GROUP)) {
			type.setGroup(Group.fromValue(text));
		} else if (currentTag.equals(ComputerTagEnum.PORT)) {
			if (type.getClass() == Internal.class) {
				((Internal) type).setPort(IntPort.valueOf(text.toUpperCase()));
			} else if (type.getClass() == External.class) {
				((External) type).setPort(ExtPort.valueOf(text.toUpperCase()));
			}
		}		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equalsIgnoreCase("device")) {
			computer.getDevice().add(device);
		} else if (localName.equalsIgnoreCase("externalType")) {
			JAXBElement<External> element = new JAXBElement<External>(new QName(uri, localName), External.class, (External) type);
			List<JAXBElement<? extends AbstractType>> typeList = device.getAbstractType();
			typeList.add(element);
		} else if (localName.equalsIgnoreCase("internalType")) {
			JAXBElement<Internal> element = new JAXBElement<Internal>(new QName(uri, localName), Internal.class, (Internal) type);
			List<JAXBElement<? extends AbstractType>> typeList = device.getAbstractType();
			typeList.add(element);
		}		
	}
	
	@Override
	public void endDocument() throws SAXException {
		Messanger.printOperationCompleteMessage();
	}
		
}

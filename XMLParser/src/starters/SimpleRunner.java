package starters;

import checkers.SimpleSAXChecker;
import entities.Computer;
import helpers.Messanger;
import helpers.ReadWriteHelper;
import readers.ComputerReader;
import readers.UnmarshalCompReader;

public class SimpleRunner {

	
	public static void main(String[] args) {

		String xmlFileName = "files/simpleExample.xml";
		String xmlSchemaFileName = "files/simpleXMLSchema.xsd";
		
		boolean isXMLValid = new SimpleSAXChecker(xmlFileName, xmlSchemaFileName).check();
		
		Messanger.printXMLValidationResult(isXMLValid);

		Computer comp;
		ComputerReader unmarshalReader = new UnmarshalCompReader();
		comp = unmarshalReader.generateCompInstance(xmlFileName);
		
		ReadWriteHelper.printMessage(comp.toString());

	}
	
}

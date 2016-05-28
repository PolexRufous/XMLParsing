package starters;

import checkers.SimpleSAXChecker;
import entities.Computer;
import helpers.Messanger;
import helpers.ReadWriteHelper;
import readers.ComputerReader;
import readers.SAXComputerReader;
import readers.UnmarshalCompReader;

public class SimpleRunner {

	
	public static void main(String[] args) {

		String xmlFileName = "files/simpleExample.xml";
		String xmlSchemaFileName = "files/simpleXMLSchema.xsd";
		
		boolean isXMLValid = new SimpleSAXChecker(xmlFileName, xmlSchemaFileName).check();
		
		Messanger.printXMLValidationResult(isXMLValid);

		Computer comp1;
		ComputerReader unmarshalReader = new UnmarshalCompReader();
		comp1 = unmarshalReader.generateCompInstance(xmlFileName);
		
		Computer comp2;
		ComputerReader saxReader = new SAXComputerReader();
		comp2 = saxReader.generateCompInstance(xmlFileName);
		
		String compStr = comp1.toString();
		String comp1Str = comp2.toString();
		
		if (comp1Str.equals(compStr)) {
			ReadWriteHelper.printMessage("Result of all reading is equals!");
		} else {
			ReadWriteHelper.printMessage("Result of all reading is not equals!");
		}
		

	}
	
}

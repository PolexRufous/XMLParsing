package readers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entities.Computer;
import handlers.ProjectExceptionHandler;
import handlers.SimpleConsoleExceptionHandler;

public class UnmarshalCompReader implements ComputerReader{

	private ProjectExceptionHandler exceptionHandler;
	private Computer computer;
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	private FileReader reader;
	
	public UnmarshalCompReader(){
		exceptionHandler = new SimpleConsoleExceptionHandler();
	}
	
	public Computer getCompInstanse(){
		return computer;
	}
	
	public Computer generateCompInstance(String xmlFileName) {
		
		try {
			
			jaxbContext = JAXBContext.newInstance(Computer.class);
			unmarshaller = jaxbContext.createUnmarshaller();
			reader = new FileReader(xmlFileName);
						
			computer = (Computer) unmarshaller.unmarshal(reader);
			
			return computer;
			
		} catch (JAXBException | FileNotFoundException e) {
			exceptionHandler.logException(e);
		} 
		
		return null;
	}
}

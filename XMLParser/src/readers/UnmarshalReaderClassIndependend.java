package readers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import handlers.ProjectExceptionHandler;
import handlers.SimpleConsoleExceptionHandler;

public class UnmarshalReaderClassIndependend<T> {

	private ProjectExceptionHandler exceptionHandler;
	
	private String xmlFileName;
	private Class<T> targetClass;
	private T t;
	
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	private FileReader reader;
	
	public UnmarshalReaderClassIndependend(String xmlFileName, Class<T> targetClass){
		this.xmlFileName = xmlFileName;
		this.targetClass = targetClass;
		exceptionHandler = new SimpleConsoleExceptionHandler();
	}
	
	@SuppressWarnings("unchecked")
	public T generateClassInstance(){
		
		try {
			
			jaxbContext = JAXBContext.newInstance(targetClass);
						
			unmarshaller = jaxbContext.createUnmarshaller();
			reader = new FileReader(xmlFileName);
						
			t = (T) unmarshaller.unmarshal(reader);
			
			return t;
			
		} catch (JAXBException | FileNotFoundException e) {
			exceptionHandler.logException(e);
		} 
		
		return null;
	}
	
	public T getClassInstance(){
		return t;
	}
	
	
	
	
}

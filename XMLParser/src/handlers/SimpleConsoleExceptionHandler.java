package handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleConsoleExceptionHandler implements ProjectExceptionHandler{
	
	private static final Logger consoleLogger = LogManager.getLogger(SimpleConsoleExceptionHandler.class.getName());
	
	public SimpleConsoleExceptionHandler(){
	}

	//********************************
	//Project Exceptions logging 
	//********************************
	
	@Override
	public void logException(Throwable e) {
		consoleLogger.catching(e);
	}

}

package handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ProjectLogger {

	private static final Logger consoleLogger = LogManager.getLogger(ProjectLogger.class.getName());

	public static Logger getConsoleLogger() {
		return consoleLogger;
	}
	
	
	
}

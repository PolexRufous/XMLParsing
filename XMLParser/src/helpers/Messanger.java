package helpers;

public class Messanger {

	private Messanger(){}
	
	public static void printHelloMessage()	{
		ReadWriteHelper.printMessage("Hello! This is test2 programm!");
	}
	
	
	public static void printWrongCommandMessage() {
		ReadWriteHelper.printMessage("Incorrect command. Please choose correct command.");
	}
	
	public static void printXMLValidationResult(boolean result)	{
		if (result) {
			ReadWriteHelper.printMessage("XML file is valid!");
		} else {
			ReadWriteHelper.printMessage("XML file is not valid!");
		}
	}
	
	public static void printNotIntFormatMessage() {
		ReadWriteHelper.printMessage("Incorrect enter. Please enter correct number.");
	}
	
	public static void printExceptionMessage(Exception e) {
		ReadWriteHelper.printMessage(e.getMessage());
		ReadWriteHelper.printMessage(e.getClass().getName());
	}

	public static void printByeMessage() {
		ReadWriteHelper.printMessage("Goodbye! See you later!");		
	}
	
	public static void printMethotIsNotWorkingMessage()	{
		ReadWriteHelper.printMessage("Sorry, this action is not working yet!");		
	}
	
	public static void printOperationCompleteMessage() {
		ReadWriteHelper.printMessage("Operation complete!");		
	}
	
	public static void printWriteTextToConcoleMessage()	{
		ReadWriteHelper.printMessage("Write text to console! End writing by empty line (two times push Enter).");		
	}
	
	public static void printEnterFileNameMessage() {
		ReadWriteHelper.printMessage("Enter absolute part to file which contains text (only .txt supported).");		
	}
	
	public static void printIncorrectFileNameMessage() {
		ReadWriteHelper.printMessage("Incorrect file name or file is not available.");
	}
	
	public static void printSeparatorLine() {
		ReadWriteHelper.printMessage("|----------------------------------------------------------------|");
	}	
}

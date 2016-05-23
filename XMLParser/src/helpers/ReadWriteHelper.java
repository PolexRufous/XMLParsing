package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 
 * @author polex
 *
 */
public class ReadWriteHelper {

	private static PrintStream printStream = System.out;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private ReadWriteHelper(){}
	
	/**
	 * This method prints line to console
	 * @param message - string line to print
	 */
	public static void printMessage(String  message)
	{
		printStream.println(message);
	}
	
	/**
	 * Method changes stream to print messages
	 * @param printStream - new stream for printing
	 */
	public static void setOut(PrintStream printStream)
	{
		ReadWriteHelper.printStream = printStream;
	}
	
	
	/**
	 * Method changes stream to read info
	 * @param inputStream - new stream for reading
	 */
	public static void setIn(InputStream inputStream)
	{
		ReadWriteHelper.reader = new BufferedReader(new InputStreamReader(inputStream));
	}

	/**
	 * Read string line from stream
	 * @return read string <br/>
	 * null if no strings to read 
	 * @throws IOException if there is a problem with reading stream
	 */
	public static String readStringLine() throws IOException
	{
		if (reader.ready())
		{
			return reader.readLine();
		}
		else
		{
			return null;
		}
	}

	
	/**
	 * Method reads all lines in stream
	 * @return all lines in stream like string
	 * @throws IOException if there is a problem with reading
	 */
	public static String readAllLines() throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder("");
		
		String currentLine;
		while ((currentLine = ReadWriteHelper.readStringLine()) != null)
		{
			stringBuilder.append(currentLine);
			stringBuilder.append("\n");
		}
		
		return stringBuilder.toString();
	}

	/**
	 * Classic implementation for reading
	 * Recommended for working with console only
	 * @return read string line
	 * @throws IOException if there is a problem with reading
	 */
	public static String readLine() throws IOException
	{
		return reader.readLine();
	}
	
	/**
	 * Method read entered int value <br/>
	 * If value is not int, value will be asked again
	 * @return read int value
	 * @throws IOException if there is a problem with reading
	 */
	public static int readInt() throws IOException
	{
		int num = 99;
		
		while (true)
		{
			try
			{
				num = Integer.parseInt(reader.readLine());
				break;
			}
			catch (NumberFormatException e)
			{
				Messanger.printNotIntFormatMessage();			
			}
		}
		
		return num;
	}
	
}

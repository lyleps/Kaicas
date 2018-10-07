/**
   A Lexical analyzer
 **/

// import java.io.Reader;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;
import java.io.*;

public class Lexer
{
	/*
	  The input to be read as a stream of chars.
	  This can either be from a file or from the system input stream.
	 */
	private static InputStreamReader in;
	

	/**
	   Sets the input stream to read from
	   @param in the input stream to read from
	 **/
	public static void setInputStream(InputStream in)
	{
		try
		{
			Lexer.in = new InputStreamReader(in);
		}
		catch (NullPointerException e)
		{
			System.err.println
				(
				 "Input stream was null, did not change input"
				 );
							   
		}
	}
	

	/**
	   Gets the next token
	   @return the next token as a string.
	 **/
	public static char getToken()
	{
		try
		{
			return (char) in.read();
		}
		catch (IOException e)
		{
			System.err.println
				(
				 "IOException while reading input"
				 );
			return (char) 0;
		}
		catch (NullPointerException e)
		{
			System.err.println
				(
				 "NullPointerException while trying to access InputStream"
				 );
			return (char) 0;
		}
	}
	
	
	public static void main(String args[])
	{
		Lexer.setInputStream(System.in);
		System.out.println(getToken());

		try
		{
			Lexer.setInputStream(new FileInputStream(new File("test.txt")));	
			System.out.println(getToken());
			Lexer.setInputStream(new FileInputStream(new File("test.txtt")));	
			System.out.println(getToken());
		}
		catch (FileNotFoundException e)
		{
			System.err.println
				(
				 "File not found, make sure you have the right path"
				 );
		}
		Lexer.setInputStream(null);
		System.out.println(getToken());
	}
}

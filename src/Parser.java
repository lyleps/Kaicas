import java.io.*;

public class Parser
{
	/**
	   Starts the Parser
	   @return returns 0 on success -1 otherwise
	 **/
	public static int start()
	{
		Lexer.setInputStream(System.in);	
		return 0;
	}

	/**
	   Starts the Parser
	   @param filepath a sting representing the filepath to the desired input file.
	   @return returns 0 on success -1 otherwise
	 **/
	public static int start(String filepath)
	{
		try
		{
			Lexer.setInputStream(new FileInputStream(new File(filepath)));
			return 0;
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Could Not Find File: " + filepath);
			return -1;
		}
	}
	
}

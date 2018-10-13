import java.io.*;

/**
   A class to parse the input
 **/
public class Parser
{

	private static String token;
	
	/**
	   Evaluates the input
	   @return The evaluated value of the expression given (eval not yet implemented)
	**/
	public static String expression()
	{
		System.out.print("KAIC >> ");
		token = Lexer.getToken();
		return expr();
	}

	/**
	   Sets the input to be a file or System.in
	   @param filepath a sting representing the filepath to the desired input file. If null input is System.in
	**/
	public static void setInput(String filepath)
	{
		if (filepath == null)
		{
			Lexer.setInputStream(System.in);
		}
		else
		{
			try
			{
				Lexer.setInputStream(new FileInputStream(new File(filepath)));
			}
			catch (FileNotFoundException e)
			{
				System.err.println("Could Not Find File: " + filepath);
			}
		}
	}

	/*
	  a private helper function for expression
	  @return the evaluated value of the expression given (eval not yet implemented)
	 */
	private static String expr()
	{
		String returned = "";

		if (token.equals("(")) // if token == "("
		{
			returned += "(";
			token = Lexer.getToken(); // get next token
			returned += expr(); // recurse expression
			token = Lexer.getToken(); // get next token
			while (!token.equals(")")) // while token != ")"b
			{
				returned += " ";
				returned += expr(); // recurse expression
				token = Lexer.getToken(); // get next token
			} // end while when found ")" on current depth
			returned += ")";
		}
		else // token will not be "(" or ")"
		{
			returned += token;
		}
		return returned;
	}
}

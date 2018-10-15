import java.io.*;

/**
   A class to parse the input
 **/
public class Parser
{

	private static String token;
	
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


	/**
	   Evaluates the input
	   @return The evaluated value of the expression given (eval not yet implemented)
	**/
	public static Cell expression()
	{
		token = Lexer.getToken();
		Cell root = expr();
		return root;
	}


	/*
	  a private helper function for expression
	  @return the evaluated value of the expression given (eval not yet implemented)
	 */
	private static Cell expr()
	{
		Cell root = new Cell();;
		if (token.equals("(")) // if token == "("
		{
			token = Lexer.getToken(); // get next token. Will not be ")"
			root.setDown(expr()); // recurse expression
			token = Lexer.getToken(); // get next token. Could be ")"
			Cell cur = root;
			while (!token.equals(")")) // while token != ")"
			{
				// move cur over one cell
				cur.setOver(new Cell());
				cur = cur.getOver();
				
				// recurse expression and set cur.down to returned cell
				cur.setDown(expr());
				token = Lexer.getToken(); // get next token
			} // end while when found ")" on current depth
			return root;
		}
		else // token will not be "(" or ")"
		{
			root.setData(token);
			return root;
		}
	}

	
	/**
	   Prints out the Cell structure
	   @param root The root of the Cell Structure
	 **/
	public static void print(Cell root)
	{
		System.out.print(":: ");
		pnt(root);
		System.out.println("");
	}

	/*
	  A helper method for printing the Cell structure
	 */
	private static void pnt(Cell root)
	{
		// If the Cell is a leaf return its contents
		if (root.getDown() == null && root.getOver() == null)
		{
			System.out.print(root.getData());
		}
		else
		{
			System.out.print("(");
			while (root != null)
			{
				if (root.getDown() != null)
				{
					pnt(root.getDown());
				}
				if (root.getOver() != null)
					System.out.print(" ");
				root = root.getOver();
			}
			System.out.print(")");
		}
	}
}

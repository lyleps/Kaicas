/**
   A Lexical analyzer for Kaic Functional
 **/

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;

public class Lexer
{
	/*
	  The input to be read as a stream of chars.
	  This can either be from a file or from the system input stream.
	 */
	private static InputStreamReader in;
	private static char cur;
	private static boolean started = false;

	/**
	   Sets the input stream to read from
	   @param in the input stream to read from
	 **/
	public static void setInputStream(InputStream in)
	{
		try
		{
			Lexer.in = new InputStreamReader(in, Charset.forName("US-ASCII"));
		}
		catch (NullPointerException e)
		{
			System.err.println
				(
				 "Input stream was null, did not change input"
				 );
							   
		}
	}


	/*
	  a helper function that eats whitespace
	 */
	private static void eatWhitespace()
	{
		try
		{
			do
			{
				cur = (char) in.read();
			}			
			while (cur == ' ' || cur == '\t' || cur == '\n' || cur == '\r');
		}
		catch (IOException e)
		{
			System.err.println
				(
				 "IOException while reading input"
				 );
		}			
	}
	

	/*
	  a helper function that tells if a char is whitespace
	  @param c the query char
	  @return a boolean that returns true if c is whitespace false otherwise
	 */
	private static boolean isWhitespace(char c)
	{
		return c == ' ' || c == '\t' || c == '\n' || c == '\r';
	}

	/*
	  a helper function that tells if a char signifies the start of a number
	  @param c the query char
	  @return a boolean that returns true if c signifies the start of a number false otherwise
	 */
	private static boolean isNumberStart(char c)
	{
		return (c >= '0' && c <= '9') || c == '.';
	}

	/*
	  a helper function that tells if a char is number legal
	  @param c the query char
	  @return a boolean that returns true if c is number legal false otherwise
	 */
	private static boolean isNumberLegal(char c)
	{
		return (c >= '0' && c <= '9') || c == '.' || c == '_';
	}

	/*
	  a helper function that tells if a char signifies the start of a string
	  @param c the query char
	  @return a boolean that returns true if c signifies the start of a string false otherwise
	*/
	private static boolean isStringStart(char c)
	{
		return (c >= 'A' && c <= 'z') || c == '#';
	}

	/*
	  a helper function that tells if a char is string legal
	  @param c the query char
	  @return a boolean that returns true if c is string legal false otherwise
	 */
	private static boolean isStringLegal(char c)
	{
		return (c >= 'A' && c <= 'z') || (c >= '0' && c <= '9') || c == '_';
	}
	
	/*
	  a helper function that tells if a char is a break character
	  @param c the query char
	  @return a boolean that returns true if c is a break character false otherwise
	 */
	private static boolean isBreakChar(char c)
	{
		return c == '(' || c == ')';
	}
	
	/**
	   Gets the next token
	   @return the next token as a string. null if EOF or on error
	 **/
	public static String getToken()
	{
		try
		{
			// if not started eat whitespace
			if(!started)
			{
				eatWhitespace();
			}
			else
			{
				started = false;
			}
			// cur is now a non-whitespace char

			// return null if at the end of file
			if (cur == (char)-1) return null;

			// takes care of special characters except for '.' because of it's use in numbers
			char start = cur;
			switch (start){
			case '!':
			case ',':
			case '+':
			case '*':
			case '-':
			case '^':
			case '/':
				cur = (char) in.read();
				if (isWhitespace(cur))
				{
					char[] token = {start};
					return new String(token);
				}
				else if (isBreakChar(cur))
				{
					char[] token = {start};
					started = true;
					return new String(token);
				}
				else
				{
					return null;
				}
			case ')':
				return ")";
			case '(':
				eatWhitespace();
				if (cur == ')')
				{
					return "()";
				}
				else
				{
					started = true;
					return "(";
				}
			}

			// for number tokens
			// also takes care of stand alone '.'
			if (isNumberStart(cur))
			{
				Queue<String> queue = new LinkedList<String>();

				// if cur is not number legal return null.
				int dot = 0;
				int length = 0;
				do
				{
					length++;
					// numbers cannot have more than one dot
					if (cur == '.') dot++;
					if (dot > 1) return null;

					// if cur is an illegal char return null
					if (!isNumberLegal(cur)) return null;

					// add cur to the queue as a String
					// TODO: find out if there is a better way to do this
					// ie. maybe use a primitive
					char[] curS = {cur};
					queue.offer(new String(curS));
					cur = (char) in.read();
				} // is cur not a break char or whitespace
				while(!(isWhitespace(cur) || isBreakChar(cur)));
				// if cur is not whitespace started should be true
				if (!isWhitespace(cur)) started = true;

				// the return array to be converted to a string
				char[] rtnArr = new char[length];
				
				for(int i = 0; i < length; i++)
				{
					rtnArr[i] = queue.poll().charAt(0);
				}
				return new String(rtnArr);
			}

			// for string tokens
			if (isStringStart(cur))
			{
				Queue<String> queue = new LinkedList<String>();
				int length = 0;

				// '#' should not be a sting on its own
				if (cur == '#')
				{
					length++;
					char[] curS = {cur};
					queue.offer(new String(curS));
					cur = (char) in.read();
					// make sure cur char is legal string char
					if (!isStringLegal(cur)) return null;
				}
				
				do
				{
					length++;

					// if cur is an illegal char return null
					if (!isStringLegal(cur)) return null;
					// add cur to the queue as a String
					// TODO: find out if there is a better way to do this
					// ie. maybe use a primitive
					char[] curS = {cur};
					queue.offer(new String(curS));
					cur = (char) in.read();
				} // is cur not a break char or whitespace
				while(!(isWhitespace(cur) || isBreakChar(cur)));
				// if cur is not whitespace started should be true
				if (!isWhitespace(cur)) started = true;

				// the return array to be converted to a string
				char[] rtnArr = new char[length];
				
				for(int i = 0; i < length; i++)
				{
					rtnArr[i] = queue.poll().charAt(0);
				}
				return new String(rtnArr);				
			}

			
			// filler for other tokens
			char[] token = {cur};
			return new String(token);
		}
		catch (IOException e)
		{
			System.err.println
				(
				 "IOException while reading input"
				 );
			return null;
		}
	}
}

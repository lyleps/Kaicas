public class Runner
{

	/**
	   The root of Kaik Functional program
	   use this class to Start Kaik
	   @param argv the filepaths to follow and run in order given
	 **/
	public static void main(String argv[])
	{
		String returned;
		for(int i = 0; i < argv.length; i++)
		{
			Parser.setInput(argv[i]);
			returned = Parser.expression();
			while(!(returned.equals("%EOF") || returned.equals("%ERR") || returned.equals("quit")))
			{
				System.out.println(":: " + returned);
				returned = Parser.expression();
			}
		}
		Parser.setInput(null);
		returned = Parser.expression();
		while(!(returned.equals("%EOF") || returned.equals("%ERR") || returned.equals("quit")))
		{
			System.out.println(":: " + returned);
			returned = Parser.expression();
		}
	}
}

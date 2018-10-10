public class Runner
{

	/**
	   The root of Kaik Functional program
	   use this class to Start Kaik
	   @param argv the filepaths to follow and run in order given
	 **/
	public static void main(String argv[])
	{
		for(int i = 0; i < argv.length; i++)
		{
			Parser.start(argv[i]);
		}
		Parser.start();
	}
}

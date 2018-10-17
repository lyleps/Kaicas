import java.io.IOException;

/**
   The main class to be run as the root of Kaik Functional
 **/
public class Runner
{

	/**
	   The root of Kaik Functional program
	   use this class to Start Kaik
	   @param argv The filepaths to follow and run in order given
	 **/
	public static void main(String argv[])
	{
		Cell root;
		for(int i = 0; i < argv.length; i++)
		{
			Parser.setInput(argv[i]);
			root = Parser.expression();
			while(root == null || root.getData() == null ||
				  !(root.getData().equals("%EOF") || root.getData().equals("%ERR") ||
					root.getData().equals("quit")))
			{
				Parser.print(root);
				root = Parser.expression();
			}
		}
		Parser.setInput(null);
		System.out.print("KAIC >> ");
		root = Parser.expression();
		while(root == null || root.getData() == null ||
			  !(root.getData().equals("%EOF") || root.getData().equals("%ERR") ||
				root.getData().equals("quit")))
		{
			System.out.println("");
			Parser.print(Eval.evaluate(root));
			System.out.print("KAIC >> ");
			root = Parser.expression();
		}
	}
}

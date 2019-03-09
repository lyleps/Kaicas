/**
   The Eval class,
   containing static methods for evaluating Cell structures
**/
public final class Eval
{
	/*
	  Hides the constructor
	 */
	private Eval()
	{
		// do nothing
	}
	
	/**
	   Evaluates the given cell structure
	   The Cell structure should not be modified
	   @param root The root Cell of the cell structure
	   @return An evaluated Cell structure
	**/
	public static Cell evaluate(Cell root)
	{
		if(root == null)
			return null;
		Cell newRoot = root.clone();
		return eval(newRoot);
	}

	/*
	  A helper method for evaluate that recursively evaluates an Cell structure
	  @param root The root of the Cell structure
	  @return The evaluated Cell structure
	*/
	private static Cell eval(Cell root)
	{
		if (root == null) return null;
		if (root.getDown() == null) return root;
		String func = root.getDown().getData();

		// Definition functions
		if (func.equals("deffun"))
		{
			GAL.add(head(tail(root)).getData(), "F", tail(tail(root)));
			return head(tail(tail(tail(root))));
		}
		
			
		
		// List functions
		if (func == null) return root;
		if (func.equals("head")) return head(eval(head(tail(root))));
		if (func.equals("tail")) return tail(eval(head(tail(root))));
		if (func.equals("concat"))
			return concat(eval(head(tail(root))), eval(head(tail(tail(root)))));
		
		return root;
	}

	/*
	  Get the head of the given Cell structure
	  @param root The root of the Cell structure
	  @return The head of the given Cell structure
	*/
	private static Cell head(Cell root)
	{
		if (root == null) return null;
		return root.getDown();
	}

	/*
	  Get the tail of the given Cell structure
	  @param root The root of the Cell structure
	  @return The tail of the given Cell structure
	*/
	private static Cell tail(Cell root)
	{
		if (root == null) return null;
		return root.getOver();
	}

	/*
	  Concatenate the rootB Cell structure to the end of the rootA Cell structure
	  @param rootA The root of the first Cell structure
	  @param rootB The root of the second Cell structure
	  @return The rootB Cell structure to the end of the root A Cell structure
	*/
	private static Cell concat(Cell rootA, Cell rootB)
	{
		if (rootA == null) return rootB;
		if (head(rootA) == null) return null;
		if (rootB == null) return rootA;
		if (head(rootB) == null) return null;
		Cell tempA = rootA;
		while(tail(tempA) != null) tempA = tail(tempA);
		tempA.setOver(rootB);
		return rootA;
	}
	
}

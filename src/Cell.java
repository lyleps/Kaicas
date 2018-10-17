/**
   A simple class for a Cell
 **/
public class Cell
{
	private String data;
	private Cell down;
	private Cell over;

	/**
	   A method to return a cloned cell including cloned children pointed to by the Cell
	   @return The cloned Cell structure
	 **/
	@Override
	public Cell clone()
	{
		Cell newRoot = new Cell();
		if (data != null)
			newRoot.data = new String(data);
		if (down != null)
			newRoot.down = down.clone();
		if (over != null)
			newRoot.over = over.clone();
		return newRoot;						
	}

	/**
	   Sets the data stored in the Cell
	   @param data A String to be stored in the Cell
	   @see java.lang.String
	 **/
	public void setData(String data)
	{
		if (data != null)
			this.data = new String(data);
	}

	/**
	   Gets the data stored in the Cell
	   @return The String stored in the cell
	 **/
	public String getData()
	{
		if (data == null) return null;
		return new String(data);
	}

	/**
	   Sets the down Cell
	   @param down The Cell to be set below this one
	 **/
	public void setDown(Cell down)
	{
		this.down = down;
	}

	/**
	   Sets the over Cell
	   @param over The Cell to be set to right of this one
	 **/
	public void setOver(Cell over)
	{
		this.over = over;
	}

	/**
	   Gets the down cell
	   @return The Cell below this one
	 **/
	public Cell getDown()
	{
		return down;
	}

	/**
	   Gets the over cell
	   @return The Cell to the right of this one
	 **/
	public Cell getOver()
	{
		return over;
	}
}

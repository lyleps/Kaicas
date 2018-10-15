/**
   A simple class for a Cell
 **/
public class Cell
{
	private String data;
	private Cell down;
	private Cell over;


	public void setData(String data)
	{
		this.data = new String(data);
	}

	/**
	   Gets the data stored in the Cell
	   @return data the String stored in the cell
	 **/
	public String getData()
	{
		return data;
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

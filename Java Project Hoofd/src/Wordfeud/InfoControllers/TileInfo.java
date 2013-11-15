package Wordfeud.InfoControllers;

public class TileInfo
{
	private int		x;
	private int		y;
	private String	boardname;
	private String	TileType;

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public String getBoardname()
	{
		return boardname;
	}

	public void setBoardname(String boardname)
	{
		this.boardname = boardname;
	}

	public String getTileType()
	{
		return TileType;
	}

	public void setTileType(String tileType)
	{
		TileType = tileType;
	}

}

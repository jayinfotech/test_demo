public class Location {
    private int row;
	private int column;
	private ChessPiece piece;

    public Location(int r, int c) {
		row = r;
		column = c;
	}

    int getRow() {
		return row;
	}

    int getCol() {
		return column;
	}

    public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		this.piece = piece;
		if(piece!= null)
		{
			piece.setLocation(this);
		}
	}

	
	public boolean isDiagonalTo(Location to)
	{
		return (this.row + this.column) == (to.row + to.column);
	}
	
	
	public boolean isAntiDiagonalTo(Location to)
	{	
		return (this.row-to.row) == this.column - to.column;
	}

	public boolean isVerticalTo(Location to)
	{
		return this.column == to.column;
	}
	
	public boolean isHorizontalTo(Location to)
	{
		return this.row == to.row;
	}
	

    @Override
	public String toString() {
			
		return "" + column + (row); 
	}

}

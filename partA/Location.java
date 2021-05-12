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

    @Override
	public String toString() {
		return "" + column + (row); 
	}

}

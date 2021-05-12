public abstract class ChessPiece {
    protected Colour color;
	protected Location location;
	protected ChessBoard board;
	protected String symbol;

    public ChessPiece(Colour color, Location location, String symbol, ChessBoard board) {
		super();
		this.color = color;
		this.location = location;
		this.location.setPiece(this);
		this.symbol = symbol;
		this.board = board;
	}
    public abstract void move(Location newLocation) throws IllegalChessMoveException;  // moveToLocation
	protected abstract boolean isValidMove(Location To) throws IllegalChessMoveException;

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Colour getColour()
	{
		return this.color;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public String toStringType() {
		return "Piece ";
	}

}

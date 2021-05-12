public abstract class ChessPiece {
    protected Color color;
	protected Location location;
	protected ChessBoard board;
	protected String symbol;

    public ChessPiece(Color color, Location location, String symbol, ChessBoard board) {
		super();
		this.color = color;
		this.location = location;
		this.location.setPiece(this);
		this.symbol = symbol;
		this.board = board;
	}
    public abstract void move(Location newLocation);  // moveToLocation
	protected abstract boolean isValidMove(Location To);

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return color.equals(Color.BLACK) ? symbol.toLowerCase() : symbol;
	}

	public String toStringType() {
		return "Piece ";
	}
}

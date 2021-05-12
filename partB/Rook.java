
public class Rook extends ChessPiece {

	public Rook(Color color, Location location, ChessBoard board) {
		super(color, location, " -r-", board);
	}

	@Override
	public void move(Location newLocation)  {
		
	}

	
	@Override
	public String toStringType() {
		return "Rook ";
	}

}

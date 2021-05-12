
public class Bishop extends ChessPiece {

	public Bishop(Color color, Location location, ChessBoard board) {
		super(color, location, " -b-", board);
	}

	@Override
	public void move(Location newLocation)  {
		
	}


	@Override
	public String toStringType() {
		return "Bishop ";
	}

}

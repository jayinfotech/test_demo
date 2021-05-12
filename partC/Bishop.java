

public class Bishop extends ChessPiece {

	public Bishop(Color white, Location location, ChessBoard board) {
		super(white, location, " -b-", board);
	}

	@Override
	public void move(Location newLocation)  {
		if (isValidMove(newLocation)) {
			board.movePiece(location, newLocation);
		}
		else
		{
			System.out.println("Invalid move");
		}
	}

	@Override
	public boolean isValidMove(Location locTo)  {
		if (location.isDiagonalTo(locTo) && board.freeDiagonalPath(location, locTo)) {
			return true;
		} else if (location.isAntiDiagonalTo(locTo) && board.freeAntidiagonalPath(location, locTo)) {
			return true;
		} else {
			return false;
		}
	}



	@Override
	public String toStringType() {
		return "Bishop ";
	}

}

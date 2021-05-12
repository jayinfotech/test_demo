
public class Rook extends ChessPiece {

	public Rook(Color white, Location location, ChessBoard board) {
		super(white, location, " -r-", board);
	}

	@Override
	public void move(Location newLocation) throws IllegalChessMoveException {
		if (isValidMove(newLocation)) {
			board.movePiece(location, newLocation);
		}
		else
		{
			throw new IllegalChessMoveException(IllegalChessMoveException.ROOK);
		}
	}

	@Override
	protected boolean isValidMove(Location locTo) throws IllegalChessMoveException {

		if (location.isHorizontalTo(locTo) && board.freeHorizontalPath(location, locTo)) {
			return true;
		} else if (location.isVerticalTo(locTo) && board.freeVerticalPath(location, locTo)) {
			return true;
		} else {
			return false;
		}
	}


	
	@Override
	public String toStringType() {
		return "Rook ";
	}

}

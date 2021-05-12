
public class Queen extends ChessPiece {

	public Queen(Colour color, Location location, ChessBoard board) {
		super(color, location, " -q-", board);
	}

	@Override
	public void move(Location newLocation) throws IllegalChessMoveException {
		if (isValidMove(newLocation)) {
			board.movePiece(location, newLocation);
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.QUEEN);
		}
	}

	// checks of this piece can make this move
	@Override
	public boolean isValidMove(Location locTo) throws IllegalChessMoveException {

		if (location.isDiagonalTo(locTo) && board.freeDiagonalPath(location, locTo)) {
			return true;
		} else if (location.isAntiDiagonalTo(locTo) && board.freeAntidiagonalPath(location, locTo)) {
			return true;
		} else if (location.isHorizontalTo(locTo) && board.freeHorizontalPath(location, locTo)) {
			return true;
		} else if (location.isVerticalTo(locTo) && board.freeVerticalPath(location, locTo)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toStringType() {
		return "Queen ";
	}

}

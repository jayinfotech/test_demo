
public class King extends ChessPiece {

	public King(Colour color, Location location, ChessBoard board) {
		super(color, location, " -k-", board);
	}

	@Override
	public void move(Location newLocation) throws IllegalChessMoveException {
		if (isValidMove(newLocation)) {
			board.movePiece(location, newLocation);
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.KING);
		}

	}

	@Override
	public boolean isValidMove(Location locTo) {

		if (location.isVerticalTo(locTo)
				&& ((locTo.getRow() == 1 + location.getRow()) || (locTo.getRow() == location.getRow() - 1))) {
			return true;
		} else if (location.isHorizontalTo(locTo)
				&& (locTo.getCol() == 1 + location.getCol() || locTo.getCol() == location.getCol() - 1)) {
			return true;
		} else if (location.isAntiDiagonalTo(locTo)
				&& (locTo.getCol() == 1 + location.getCol() || locTo.getCol() == location.getCol() - 1)) {
			return true;
		} else if (location.isDiagonalTo(locTo)
				&& (locTo.getCol() == 1 + location.getCol() || locTo.getCol() == location.getCol() - 1)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toStringType() {
		return "King ";
	}

}

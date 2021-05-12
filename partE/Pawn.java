
public class Pawn extends ChessPiece {

	public Pawn(Colour color, Location location, ChessBoard board) {
		super(color, location, " -p-", board);
	}

	@Override
	public void move(Location newLocation) throws IllegalChessMoveException
	{
		if (isValidMove(newLocation)) {
			board.movePiece(location, newLocation);
		}
		else
		{
			throw new IllegalChessMoveException(IllegalChessMoveException.PAWN);
		}

	}

	@Override
	public boolean isValidMove(Location locTo) throws IllegalChessMoveException {
		if (isMoveForward(locTo)) {
			if (locTo.getPiece() == null && isValidWhenNotCapturing(locTo)) {
				return true;
			} else if (locTo.getPiece() != null && isValidWhenCapturing(locTo)) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.PAWN_ONLY_FORWARD);
		}
	}

	private boolean isMoveForward(Location locTo) throws IllegalChessMoveException {
		if (this.color.equals(color.BLACK) && locTo.getRow() > location.getRow()) {
			return true;
		} else if (this.color.equals(color.WHITE) && locTo.getRow() < location.getRow()) {
			return true;
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.PAWN_ONLY_FORWARD);
		}
	}

	private boolean isTheFirstMove() throws IllegalChessMoveException  {
		if (this.color.equals(color.BLACK) && location.getRow() == 1) {
			return true;
		}
		if (this.color.equals(color.WHITE) && location.getRow() == 6) {
			return true;
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.PAWN_NOT_FIRSTMOVE);
		}
	}

	private boolean isValidWhenCapturing(Location locTo) throws IllegalChessMoveException {

		if (((location.getCol() - locTo.getCol() == 1) || (location.getCol() - locTo.getCol() == -1))
				&& (location.getRow() - locTo.getRow() == 1)) {
			return true;
		} else {
			throw new IllegalChessMoveException(IllegalChessMoveException.PAWN_CAPTURE_ONLY_DIAGONALLY);
		}
	}

	private boolean isValidWhenNotCapturing(Location locTo) throws IllegalChessMoveException {
		if (location.getCol() == locTo.getCol()) {
			if ((location.getRow() - locTo.getRow() == 1) || location.getRow() - locTo.getRow() == -1) {
				return true;
			}

			else if (((location.getRow() - locTo.getRow() == 2) || (location.getRow() - locTo.getRow() == -2))
					&& isTheFirstMove() && board.freeVerticalPath(location, locTo)) {
				return true;
			}
		}

		return false;

	}

	@Override
	public String toStringType() {
		return "Pawn ";
	}

}

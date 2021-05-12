
public class Pawn extends ChessPiece {

	public Pawn(Color color, Location location, ChessBoard board) {
		super(color, location, " -p-", board);
	}

	@Override
	public void move(Location newLocation)
	{
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
		if (isMoveForward(locTo)) {
			if (locTo.getPiece() == null && isValidWhenNotCapturing(locTo)) {
				return true;
			} else if (locTo.getPiece() != null && isValidWhenCapturing(locTo)) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Invalid move. Pawn move only forward");
			return false;
		}
	}

	private boolean isMoveForward(Location locTo)  {
		if (this.color.equals(color.BLACK) && locTo.getRow() > location.getRow()) {
			return true;
		} else if (this.color.equals(color.WHITE) && locTo.getRow() < location.getRow()) {
			return true;
		} else {
			System.out.println("Invalid move. Pawn move only forward");
			return false;
		}
	}

	private boolean isTheFirstMove()  {
		if (this.color.equals(color.BLACK) && location.getRow() == 1) {
			return true;
		}
		if (this.color.equals(color.WHITE) && location.getRow() == 6) {
			return true;
		} else {
			System.out.println("Invalid move. Pawn is not on first move");
			return false;
		}
	}

	private boolean isValidWhenCapturing(Location locTo) {

		if (((location.getCol() - locTo.getCol() == 1) || (location.getCol() - locTo.getCol() == -1))
				&& (location.getRow() - locTo.getRow() == 1)) {
			return true;
		} else {
			System.out.println("Pawn capture only diagonally");
			return false;
		}
	}

	private boolean isValidWhenNotCapturing(Location locTo) {
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

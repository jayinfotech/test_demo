
public class Knight extends ChessPiece {

	public Knight(Color white, Location location, ChessBoard board) {
		super(white, location, " -h-", board);
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
	protected boolean isValidMove(Location locTo) {

		int twoSquaresBack = this.location.getRow() - 2;
		int twoSquaresFront = this.location.getRow() + 2;
		int twoSquaresRight = this.location.getCol() - 2;
		int twoSquaresLeft = this.location.getCol() + 2;
		int oneSquareBack = this.location.getRow() - 1;
		int oneSquareFront = this.location.getRow() + 1;
		int oneSquareRight = this.location.getCol() - 1;
		int oneSquareLeft = this.location.getCol() + 1;

		int targetRow = locTo.getRow();
		int targetCol = locTo.getCol();

		if (targetRow == twoSquaresBack && (targetCol == oneSquareLeft || targetCol == oneSquareRight)) {
			return true;
		} else if (targetRow == twoSquaresFront && (targetCol == oneSquareLeft || targetCol == oneSquareRight)) {
			return true;
		} else if (targetCol == twoSquaresLeft && (targetRow == oneSquareBack || targetRow == oneSquareFront)) {
			return true;
		} else if (targetCol == twoSquaresRight && (targetRow == oneSquareBack || targetRow == oneSquareFront)) {
			return true;
		} else {
			return false;
		}
	}


	
	@Override
	public String toStringType() {
		return "Knight ";
	}

}

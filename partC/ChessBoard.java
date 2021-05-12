public class ChessBoard {
    public Location[][] locations;

    public ChessBoard() {
		locations = new Location[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				locations[i][j] = new Location(i, j);
			}
		}
    }

    public void printTheBoard() {

		for (int i = 0; i < 8; i++) {
			System.out.print("=" + (7 - i)+"=");
			for (int j = 0; j < 8; j++) {

				if (locations[i][j].getPiece() != null) {
					System.out.print(locations[i][j].getPiece().toString());
				} else {
					System.out.print(" ---");
				}
			}
			System.out.println();
		}
		System.out.println("=== =0= =1= =2= =3= =4= =5= =6= =7=");
	}

	public void movePiece(Location from, Location to) {
		if (getPieceAt(to) == null) {
			movePieceWithoutCapturing(from, to);
		} 
	}

	public void movePieceWithoutCapturing(Location from, Location to) {
		to.setPiece(getPieceAt(from));
		from.setPiece(null);
	}

	public ChessPiece getPieceAt(Location loc) {
		return locations[loc.getRow()][loc.getCol()].getPiece();
	}

	public boolean freeDiagonalPath(Location from, Location to) {

		if (from.getCol() < to.getCol()) {

			int row = from.getRow() - 1;
			int col = from.getCol() + 1;

			while (col < to.getCol()) {

				if (locations[row][col].getPiece() == null) {
					row--;
					col++;
					continue;
				} else {
					System.out.println("Invalid move");
				}
				
			} return true;
		} else {
			int row = from.getRow() + 1;
			int col = from.getCol() - 1;

			while (col > to.getCol()) {

				if (locations[row][col].getPiece() == null) {
					row++;
					col--;
					continue;
				} else {
					System.out.println("Invalid move");
				}
			}return true;

		}
	}

	public boolean freeAntidiagonalPath(Location from, Location to)  {
		if (from.getCol() < to.getCol()) {

			int row = from.getRow() + 1;
			int col = from.getCol() + 1;

			while (col < to.getCol()) {

				if (locations[row][col].getPiece() == null) {
					row++;
					col++;
					continue;
				} else {
					System.out.println("Invalid move");
				}
				
			} return true;
		} else {
			int row = from.getRow() - 1;
			int col = from.getCol() - 1;

			while (col > to.getCol()) {

				if (locations[row][col].getPiece() == null) {
					row--;
					col--;
					continue;
				} else {
						System.out.println("Invalid move");
				}
			}return true;

		}
	}

	public boolean freeHorizontalPath(Location from, Location to)  {
		// constant row- increasing column
		if (from.getCol() < to.getCol()) {
			for (int i = from.getCol() + 1; i < to.getCol(); i++) {
				if (locations[from.getRow()][i].getPiece() == null) {
					continue;
				} else {
					System.out.println("Invalid move");
					return false;
				}
			}
		}
		// constant row- decreasing column
		else if (from.getCol() > to.getCol())
			for (int i = to.getCol() + 1; i < from.getCol(); i++) {
				if (locations[from.getRow()][i].getPiece() == null) {
					continue;
				} else {
					System.out.println("Invalid move");
					return false;
				}
			}

		return true;

	}


	public boolean freeVerticalPath(Location from, Location to)  {
		if (from.getRow() < to.getRow()) {
			for (int i = from.getRow() + 1; i < to.getRow(); i++) {
				if (locations[i][from.getCol()].getPiece() == null) {
					continue;
				} else {
					
					System.out.println("Invalid move");
					return false;
				}
			}
		} else if (from.getRow() > to.getRow())
			for (int i = to.getRow() + 1; i < from.getRow(); i++) {
				if (locations[i][from.getCol()].getPiece() == null) {
					continue;
				} else {
					System.out.println("Invalid move");
					return false;
				}
			}

		return true;

	}

}

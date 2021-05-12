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

}

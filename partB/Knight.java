
public class Knight extends ChessPiece {

	public Knight(Color color, Location location, ChessBoard board) {
		super(color, location, " -h-", board);
	}

	@Override
	public void move(Location newLocation)  {
		
	}

	
	@Override
	public String toStringType() {
		return "Knight ";
	}

}

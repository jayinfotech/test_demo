
public class Pawn extends ChessPiece {

	public Pawn(Color color, Location location, ChessBoard board) {
		super(color, location, " -p-", board);
	}

	@Override
	public void move(Location newLocation)
	{

	}

	
	@Override
	public String toStringType() {
		return "Pawn ";
	}

}

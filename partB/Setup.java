import java.io.*;
import java.util.*;

public class Setup {

	public static void main(String[] args) throws FileNotFoundException {
		ChessBoard board = new ChessBoard();
		board.printTheBoard();
		
		Scanner scan = new Scanner(new File("input1.txt"));
		String line;
		String[] lineSegment;
		String p;
		int c,r;

		while(scan.hasNextLine())
		{
			line = scan.nextLine();
			lineSegment = line.split(" "); // stores all input in array of Strings
			p=lineSegment[0];
			c=Integer.parseInt(lineSegment[1]);
			r=Integer.parseInt(lineSegment[2]);
			
			if(board.locations[r][c].getPiece()==null)
			{
				if(p.equalsIgnoreCase("Knight"))
				{
					
					new Knight(Color.WHITE,board.locations[7-r][c],board);
					
				}
				else if(p.equalsIgnoreCase("Pawn"))
				{
					new Pawn(Color.WHITE,board.locations[7-r][c],board);
				}
				else if(p.equalsIgnoreCase("Rook"))
				{
					new Rook(Color.WHITE,board.locations[7-r][c],board);
				}
				else if(p.equalsIgnoreCase("Bishop"))
				{
					new Bishop(Color.WHITE,board.locations[7-r][c],board);
				}

			}
			System.out.println("\n" + line);
			board.printTheBoard();
		}
	}
}
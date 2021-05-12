
import java.io.*;
import java.util.*;

public class ChessMoves {

	public static void main(String[] args) throws FileNotFoundException 
	{
		ChessBoard board = new ChessBoard();
		board.printTheBoard();
		
		Scanner scan = new Scanner(new File("input2.txt"));
		String line;
		String[] lineSegment;
		String p;
		int c,r,dr,dc;

		while(scan.hasNextLine())
		{
			line = scan.nextLine();
			lineSegment = line.split(" "); // stores all input in array of Strings
			p=lineSegment[0];
			c=Integer.parseInt(lineSegment[1]);
			r=Integer.parseInt(lineSegment[2]);
	
			if(p.equalsIgnoreCase("move"))
			{
				

				dc=Integer.parseInt(lineSegment[3]);
				dr=Integer.parseInt(lineSegment[4]);
				
				Location from = board.locations[7-r][c];
				Location to = board.locations[7-dr][dc];
				

				ChessPiece pieceToMove = from.getPiece();
				
				String tstr=pieceToMove.toString();
				if(tstr.equals(" -p-"))
				{
					pieceToMove= new Pawn(Color.WHITE,board.locations[7-r][c],board);
				}
				else if(tstr.equals(" -h-"))
				{
					pieceToMove= new Knight(Color.WHITE,board.locations[7-r][c],board);
				}		
				else if(tstr.equals(" -b-"))
				{
					pieceToMove= new Bishop(Color.WHITE,board.locations[7-r][c],board);
				}		
				else if(tstr.equals(" -r-"))
				{
					pieceToMove= new Rook(Color.WHITE,board.locations[7-r][c],board);
				}					
					
				pieceToMove.move(to);
			}
				
			else
			{			
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
			}
			System.out.println("\n" + line);
			board.printTheBoard();
		}
		
	}
}
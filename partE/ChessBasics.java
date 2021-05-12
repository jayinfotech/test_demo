
import java.awt.Color;
import java.io.*;
import java.util.*;

public class ChessBasics {

	public static void main(String[] args) throws FileNotFoundException 
	{
		ChessBoard board = new ChessBoard();
		board.printTheBoard();
		
		Scanner scan = new Scanner(new File("game.txt"));
		String line;
		String[] lineSegment;
		String p;
		int c,r,dr,dc;
		Colour clr=Colour.WHITE;
		int cnt=0;
		while(scan.hasNextLine())
		{
			cnt++;
			if(cnt<=16)
				clr=Colour.WHITE;
			else if(cnt>=16)
				clr=Colour.BLACK;

			line = scan.nextLine();
			lineSegment = line.split(" "); // stores all input in array of Strings
			p=lineSegment[0];
			c=Integer.parseInt(lineSegment[1]);
			r=Integer.parseInt(lineSegment[2]);
			r=7-r; 

			if(p.equalsIgnoreCase("move"))
			{
				dc=Integer.parseInt(lineSegment[3]);
				dr=Integer.parseInt(lineSegment[4]);
				dr=7-dr;	
				Location from = board.locations[r][c];
				Location to = board.locations[dr][dc];

				ChessPiece pieceToMove = from.getPiece();
				
				clr=pieceToMove.getColour();
				
				String tstr=pieceToMove.toString();
				if(tstr.equals(" -p-"))
					pieceToMove= new Pawn(clr,board.locations[r][c],board);
				else if(tstr.equals(" -h-"))
					pieceToMove= new Knight(Colour.WHITE,board.locations[r][c],board);
				else if(tstr.equals(" -b-"))
					pieceToMove= new Bishop(Colour.WHITE,board.locations[r][c],board);
				else if(tstr.equals(" -r-"))
					pieceToMove= new Rook(Colour.WHITE,board.locations[r][c],board);
				else if(tstr.equals(" -k-"))
					pieceToMove= new King(Colour.WHITE,board.locations[r][c],board);
				else if(tstr.equals(" -q-"))
					pieceToMove= new Queen(Colour.WHITE,board.locations[r][c],board);

				try
				{
					pieceToMove.move(to);
				}
				catch(Exception e)
				{
					System.out.println("Invalid Move"+e);
				}
			}
			else
			{			
				if(board.locations[r][c].getPiece()==null)
				{
					if(p.equalsIgnoreCase("Knight"))
						new Knight(clr,board.locations[r][c],board);
					else if(p.equalsIgnoreCase("Pawn"))
						new Pawn(clr,board.locations[r][c],board);
					else if(p.equalsIgnoreCase("Rook"))
						new Rook(clr,board.locations[r][c],board);
					else if(p.equalsIgnoreCase("Bishop"))
						new Bishop(clr,board.locations[r][c],board);
					else if(p.equalsIgnoreCase("King"))
						new King(clr,board.locations[r][c],board);
					else if(p.equalsIgnoreCase("Queen"))
						new Queen(clr,board.locations[r][c],board);					
				}
			}
			System.out.println("\n" + line +" "+ clr);
			board.printTheBoard();
		}
	}
}
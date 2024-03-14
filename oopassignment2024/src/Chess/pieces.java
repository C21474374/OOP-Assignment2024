package Chess;

import javax.swing.ImageIcon;


interface PieceControl
{
	void movePiece(Tile current_tile, Tile new_tile);
	
}
class Piece {
	
	 
	ImageIcon queen_black = new ImageIcon("Chesspieces/queen_black.png");
	ImageIcon king_black = new ImageIcon("Chesspieces/king_black.png");
	ImageIcon bishop_black = new ImageIcon("Chesspieces/bishop_black.png");
	ImageIcon knight_black = new ImageIcon("Chesspieces/knight_black.png");
	ImageIcon rook_black = new ImageIcon("Chesspieces/rook_black.png");
	ImageIcon pawn_black = new ImageIcon("Chesspieces/pawn_black.png");
	ImageIcon queen_white = new ImageIcon("Chesspieces/queen_white.png");
	ImageIcon king_white = new ImageIcon("Chesspieces/king_white.png");
	ImageIcon bishop_white = new ImageIcon("Chesspieces/bishop_white.png");
	ImageIcon knight_white = new ImageIcon("Chesspieces/knight_white.png");
	ImageIcon rook_white = new ImageIcon("Chesspieces/rook_white.png");
	ImageIcon pawn_white = new ImageIcon("Chesspieces/pawn_white.png");
	
	
	private boolean is_white;
	int available_move[];
	boolean alive = true;
	
	Piece(boolean is_white){
		this.is_white = is_white;
	}

	public boolean isIs_white() {
		return is_white;
	}
	public boolean notIs_white() {
		return !is_white;
	}
	public void setIs_white(boolean is_white) {
		this.is_white = is_white;
	}
	
	
	
}

class Queen extends Piece implements PieceControl{
	
	public Queen(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(queen_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(queen_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}
class King extends Piece implements PieceControl{
	
	public King(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(king_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(king_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}

class Bishop extends Piece implements PieceControl{
	
	public Bishop(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(bishop_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(bishop_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}

class Knight extends Piece implements PieceControl{
	
	public Knight(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(knight_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(knight_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}

class Rook extends Piece implements PieceControl{
	
	public Rook(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(rook_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(rook_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}

class Pawn extends Piece implements PieceControl{
	
	public Pawn(boolean is_white,Tile tile) {
		super(is_white);
		if (super.isIs_white()) {
			tile.placePiece(pawn_white);
		}
		else if(!super.isIs_white()) {
			tile.placePiece(pawn_black);
		}
		
	}
	public void movePiece(Tile current_tile, Tile new_tile) {
		
	}
	
}









public class pieces {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

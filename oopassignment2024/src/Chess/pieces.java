package Chess;

import javax.swing.ImageIcon;
import javax.swing.JButton;


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
	
	static boolean has_moved = false;
	private boolean is_white;
	int available_move[];
	boolean alive = true;
	Tile current_tile;
	private String piece_type;
	
	public Piece(boolean is_white,Tile current_tile,String piece_type){
		this.is_white = is_white;
		this.piece_type = piece_type;
		this.current_tile = current_tile;
		JButton new_button = current_tile.getButton();
		if(piece_type == "Knight") {
			if (is_white) {
				current_tile.placePiece(knight_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(knight_black,piece_type);
			}
		}
		else if (piece_type == "Queen") {
			if (is_white) {
				current_tile.placePiece(queen_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(queen_black,piece_type);
			}
		}
		else if (piece_type == "King") {
			if (is_white) {
				current_tile.placePiece(king_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(king_black,piece_type);
			}
		}
		else if (piece_type == "Bishop") {
			if (is_white) {
				current_tile.placePiece(bishop_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(bishop_black,piece_type);
			}
		}
		else if (piece_type == "Rook") {
			if (is_white) {
				current_tile.placePiece(rook_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(rook_black,piece_type);
			}
		}
		else if (piece_type == "Pawn") {
			if (is_white) {
				current_tile.placePiece(pawn_white,piece_type);
			}
			else if(!is_white) {
				current_tile.placePiece(pawn_black,piece_type);
			}
		}
	}

	public String getPiece_type() {
		return piece_type;
	}

	public void setPiece_type(String piece_type) {
		this.piece_type = piece_type;
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
	
	public void movePiece(Tile new_tile) {
		JButton current_button = current_tile.getButton();
		JButton new_button = new_tile.getButton();
		
			System.out.println("hello world!");
			if(piece_type == "Knight") {
				if (is_white) {
					new_tile.placePiece(knight_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(knight_black,piece_type);
				}
			}
			else if (piece_type == "Queen") {
				if (is_white) {
					new_tile.placePiece(queen_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(queen_black,piece_type);
				}
			}
			else if (piece_type == "King") {
				if (is_white) {
					new_tile.placePiece(king_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(king_black,piece_type);
				}
			}
			else if (piece_type == "Bishop") {
				if (is_white) {
					new_tile.placePiece(bishop_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(bishop_black,piece_type);
				}
			}
			else if (piece_type == "Rook") {
				if (is_white) {
					new_tile.placePiece(rook_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(rook_black,piece_type);
				}
			}
			else if (piece_type == "Pawn") {
				if (is_white) {
					System.out.println("pawn moved");
					new_tile.placePiece(pawn_white,piece_type);
				}
				else if(!is_white) {
					new_tile.placePiece(pawn_black,piece_type);
				}
			}
			
			current_button.setIcon(null);
			current_tile.piece_type = null;
			
	}
	
	
}


			
	










public class pieces {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

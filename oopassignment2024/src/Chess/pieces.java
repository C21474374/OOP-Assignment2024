/***************************************************
* Piece:Controls the function of chess pieces
* Author:C21474374
* OOP Assignment 2024
*********************************/

package Chess;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Set Interface
interface PieceControl
{
	void movePiece(Tile current_tile, Tile new_tile);

}
class Piece {

	// -- Initializing Variables --
	// Initializing Image locations and image icons
	static ImageIcon queen_black = new ImageIcon("Chesspieces/queen_black.png");
	static ImageIcon king_black = new ImageIcon("Chesspieces/king_black.png");
	static ImageIcon bishop_black = new ImageIcon("Chesspieces/bishop_black.png");
	static ImageIcon knight_black = new ImageIcon("Chesspieces/knight_black.png");
	static ImageIcon rook_black = new ImageIcon("Chesspieces/rook_black.png");
	static ImageIcon pawn_black = new ImageIcon("Chesspieces/pawn_black.png");
	static ImageIcon queen_white = new ImageIcon("Chesspieces/queen_white.png");
	static ImageIcon king_white = new ImageIcon("Chesspieces/king_white.png");
	static ImageIcon bishop_white = new ImageIcon("Chesspieces/bishop_white.png");
	static ImageIcon knight_white = new ImageIcon("Chesspieces/knight_white.png");
	static ImageIcon rook_white = new ImageIcon("Chesspieces/rook_white.png");
	static ImageIcon pawn_white = new ImageIcon("Chesspieces/pawn_white.png");
	
	// Other variables
	static boolean has_moved = false;
	private boolean pawn_moved = false;
	private boolean is_white;
	int available_move[];
	boolean alive = true;
	Tile current_tile;// current tile piece is on
	private String piece_type;
	
	// -- Constructor -- 
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
	
	// -- Getters and Setters --
	public boolean isPawn_moved() {
		return pawn_moved;
	}

	public void setPawn_moved(boolean pawn_moved) {
		this.pawn_moved = pawn_moved;
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
	
	// -- Methods --
	// - Move Piece -
	// this method moves a piece to a new tile and checks if the piece on the other tile can be taken
	public void movePiece(Tile new_tile) {
		String message;
		JButton current_button = current_tile.getButton();
		JButton new_button = new_tile.getButton();
			current_tile.deselectTile();
			current_tile.has_piece = false;
			if(new_tile.has_piece) {
				Control.game.takePiece(new_tile.piece_type, new_tile.current_piece.is_white);
			}
			new_tile.deselectTile();

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
					pawn_moved = true;
					new_tile.placePiece(pawn_white,piece_type);
				}
				else if(!is_white) {
					pawn_moved = true;
					new_tile.placePiece(pawn_black,piece_type);
				}
			}
//			if (maingame.is_whites_turn) {
//				System.out.println("It is now Blacks turn");
//			}
//			else if (!maingame.is_whites_turn) {
//				System.out.println("It is now Whites turn");
//			}
			maingame.is_whites_turn = !maingame.is_whites_turn;
			maingame.DisplayTurn();
			try {
				if (new_tile.has_piece)
					
				{
					
					if((new_tile.current_piece.is_white) && (new_tile.current_piece.piece_type == "King")) {
						message = Control.game.black_name+" wins!";
						Control.game.fileProcessor.updateScore("scores.txt", Control.game.black_name, 1);
						JFrame frame = new JFrame();
						frame.setTitle("Win screen");
						frame.setResizable(false);
						frame.setSize(250,250);
						
						// Alert box that displays message variable
						JOptionPane.showMessageDialog(frame, message);
						Control.game.clearscreen();
						Control.game.mainmenu();
					}
					else if ((!new_tile.current_piece.is_white) && (new_tile.current_piece.piece_type == "King")) {
						message = Control.game.white_name+" wins!";
						Control.game.fileProcessor.updateScore("scores.txt", Control.game.white_name, 1);
						JFrame frame = new JFrame();
						frame.setTitle("Win screen");
						frame.setResizable(false);
						frame.setSize(250,250);
						
						// Alert box that displays message variable
						JOptionPane.showMessageDialog(frame, message);
						Control.game.clearscreen();
						Control.game.mainmenu();
					}
					
					
				}
			}
			catch(Exception e) {
				
			}
			current_tile.current_piece = null;
			new_tile.current_piece = this;
			current_tile = new_tile;
			
			new_tile.has_piece = true;
			current_button.setIcon(null);
			current_tile.piece_type = null;
			new_tile.piece_type = this.piece_type;

	}// end move piece
	
	// With the following select methods the highlight tile is a tile in which the user can select to move
	// to and a kill tile is a tile in which as user can take another piece
	
	// - Select Pawn -
	// Selects pawn and highlights tiles it can move to.

	public void selectPawn(int left,int top) {
		if ((is_white) && (maingame.is_whites_turn)) {
			try {
				if(!maingame.position[left-1][top].has_piece) {
					maingame.position[left-1][top].moveableTile();
					if((!maingame.position[left-2][top].has_piece) && (!this.isPawn_moved())) {
						maingame.position[left-2][top].moveableTile();
					}
				}
			}
				catch(Exception e) {

				}

			try {
				if (!maingame.position[left-1][top-1].current_piece.is_white) {
					maingame.position[left-1][top-1].killTile();
				}

			}
			catch(Exception e) {

			}
			try {
				if (!maingame.position[left-1][top+1].current_piece.is_white) {
					maingame.position[left-1][top+1].killTile();
				}

			}
			catch(Exception e) {

			}
		}
		else if((!is_white) && (!maingame.is_whites_turn)) {
			try {
				if(!maingame.position[left+1][top].has_piece) {
					maingame.position[left+1][top].moveableTile();
					if((!maingame.position[left+2][top].has_piece) && (!this.isPawn_moved())) {
						maingame.position[left+2][top].moveableTile();
					}
				}
			}
				catch(Exception e) {

				}


			try {
				if(maingame.position[left+1][top-1].current_piece.is_white) {
					maingame.position[left+1][top-1].killTile();
				}

			}
			catch(Exception e) {

			}
			try {
				if (maingame.position[left+1][top+1].current_piece.is_white) {
					maingame.position[left+1][top+1].killTile();
				}

			}
			catch(Exception e) {

			}


		}

	}// end select pawn
	
	// - Select Knight -
	public void selectKnight(int left,int top) {
		int knight_left[] = {1,-1,-2,-2,-1,1,2,2};
		int knight_top[] = {-2,-2,-1,1,2,2,1,-1};
		if ((is_white) && (maingame.is_whites_turn)) {

				for(int i = 0;i<8;i++) {
					try {
						if(!maingame.position[left+knight_left[i]][top+knight_top[i]].has_piece) {
							maingame.position[left+knight_left[i]][top+knight_top[i]].moveableTile();

						}
						else if((maingame.position[left+knight_left[i]][top+knight_top[i]].has_piece) && (!maingame.position[left+knight_left[i]][top+knight_top[i]].current_piece.is_white) ){
							maingame.position[left+knight_left[i]][top+knight_top[i]].killTile();
						}
					}
					catch(Exception e) {

					}

				}

		}
		else if((!is_white) && (!maingame.is_whites_turn)) {

				for(int i = 0;i<8;i++) {
				try {
					if(!maingame.position[left+knight_left[i]][top+knight_top[i]].has_piece) {
						maingame.position[left+knight_left[i]][top+knight_top[i]].moveableTile();

					}
					else if((maingame.position[left+knight_left[i]][top+knight_top[i]].has_piece) && (maingame.position[left+knight_left[i]][top+knight_top[i]].current_piece.is_white) ){
						maingame.position[left+knight_left[i]][top+knight_top[i]].killTile();
					}
				}
				catch(Exception e) {

				}

				}

		}

	}//end select knight
	
	//  - Select Rook -
	public void selectRook(int left,int top) {
		if ((is_white) && (maingame.is_whites_turn)) {

			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left+i][top].has_piece) {
						maingame.position[left+i][top].moveableTile();

					}
					else if((maingame.position[left+i][top].has_piece) && (!maingame.position[left+i][top].current_piece.is_white) ){
						maingame.position[left+i][top].killTile();
						i = 8;
					}
					else if ((maingame.position[left+i][top].has_piece) && (maingame.position[left+i][top].current_piece.is_white)) {
						i = 8;
					}
				}
				catch(Exception e) {

				}
			}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left-i][top].has_piece) {
							maingame.position[left-i][top].moveableTile();

						}
						else if((maingame.position[left-i][top].has_piece) && (!maingame.position[left-i][top].current_piece.is_white) ){
							maingame.position[left-i][top].killTile();
							i = 8;
						}
						else if ((maingame.position[left-i][top].has_piece) && (maingame.position[left-i][top].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left][top+i].has_piece) {
							maingame.position[left][top+i].moveableTile();

						}
						else if((maingame.position[left][top+i].has_piece) && (!maingame.position[left][top+i].current_piece.is_white) ){
							maingame.position[left][top+i].killTile();
							i = 8;
						}
						else if ((maingame.position[left][top+i].has_piece) && (maingame.position[left][top+i].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left][top-i].has_piece) {
							maingame.position[left][top-i].moveableTile();

						}
						else if((maingame.position[left][top-i].has_piece) && (!maingame.position[left][top-i].current_piece.is_white) ){
							maingame.position[left][top-i].killTile();
							i = 8;
						}
						else if ((maingame.position[left][top-i].has_piece) && (maingame.position[left][top-i].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}

		}
		else if((!is_white) && (!maingame.is_whites_turn)) {

			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left+i][top].has_piece) {
						maingame.position[left+i][top].moveableTile();

					}
					else {
						if((maingame.position[left+i][top].has_piece) && (maingame.position[left+i][top].current_piece.is_white) ){

							maingame.position[left+i][top].killTile();
							i = 8;
						}
						if ((maingame.position[left+i][top].has_piece) && (!maingame.position[left+i][top].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left-i][top].has_piece) {
						maingame.position[left-i][top].moveableTile();

					}
					else {
						if((maingame.position[left-i][top].has_piece) && (maingame.position[left-i][top].current_piece.is_white) ){

							maingame.position[left-i][top].killTile();
							i = 8;
						}
						if ((maingame.position[left-i][top].has_piece) && (!maingame.position[left-i][top].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left][top+i].has_piece) {
						maingame.position[left][top+i].moveableTile();

					}
					else {
						if((maingame.position[left][top+i].has_piece) && (maingame.position[left][top+i].current_piece.is_white) ){

							maingame.position[left][top+i].killTile();
							i = 8;
						}
						if ((maingame.position[left][top+i].has_piece) && (!maingame.position[left][top+i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left][top-i].has_piece) {
						maingame.position[left][top-i].moveableTile();

					}
					else {
						if((maingame.position[left][top-i].has_piece) && (maingame.position[left][top-i].current_piece.is_white) ){

							maingame.position[left][top-i].killTile();
							i = 8;
						}
						if ((maingame.position[left][top-i].has_piece) && (!maingame.position[left][top-i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
		}
	}//end select Rook

	// - Select Bishop -
	public void selectBishop(int left,int top) {
		if ((is_white) && (maingame.is_whites_turn)) {

				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left+i][top+i].has_piece) {
							maingame.position[left+i][top+i].moveableTile();
							if((maingame.position[left+i][top+i].has_piece) && (!maingame.position[left+i][top+i].current_piece.is_white) ){
								maingame.position[left+i][top+i].killTile();
								i = 8;
							}
							if ((maingame.position[left+i][top+i].has_piece) && (maingame.position[left+i][top+i].current_piece.is_white)) {
								i = 8;
							}
						}

					}
					catch(Exception e) {

					}

				}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left-i][top-i].has_piece) {
							maingame.position[left-i][top-i].moveableTile();

						}
						else if((maingame.position[left-i][top-i].has_piece) && (!maingame.position[left-i][top-i].current_piece.is_white) ){
							maingame.position[left-i][top-i].killTile();
							i = 8;
						}
						else if ((maingame.position[left-i][top-i].has_piece) && (maingame.position[left-i][top-i].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left-i][top+i].has_piece) {
							maingame.position[left-i][top+i].moveableTile();

						}
						else if((maingame.position[left-i][top+i].has_piece) && (!maingame.position[left-i][top+i].current_piece.is_white) ){
							maingame.position[left-i][top+i].killTile();
							i = 8;
						}
						else if ((maingame.position[left-i][top+i].has_piece) && (maingame.position[left-i][top+i].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}
				for(int i = 1;i<8;i++) {
					try {
						if(!maingame.position[left+i][top-i].has_piece) {
							maingame.position[left+i][top-i].moveableTile();

						}
						else if((maingame.position[left+i][top-i].has_piece) && (!maingame.position[left+i][top-i].current_piece.is_white) ){
							maingame.position[left+i][top-i].killTile();
							i = 8;
						}
						else if ((maingame.position[left+i][top-i].has_piece) && (maingame.position[left+i][top-i].current_piece.is_white)) {
							i = 8;
						}
					}
					catch(Exception e) {

					}
				}

		}
		else if((!is_white) && (!maingame.is_whites_turn)) {

			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left+i][top+i].has_piece) {
						maingame.position[left+i][top+i].moveableTile();

					}
					else {
						if((maingame.position[left+i][top+i].has_piece) && (maingame.position[left+i][top+i].current_piece.is_white) ){

							maingame.position[left+i][top+i].killTile();
							i = 8;
						}
						if ((maingame.position[left+i][top+i].has_piece) && (!maingame.position[left+i][top+i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left-i][top-i].has_piece) {
						maingame.position[left-i][top-i].moveableTile();

					}
					else {
						if((maingame.position[left-i][top-i].has_piece) && (maingame.position[left-i][top-i].current_piece.is_white) ){

							maingame.position[left-i][top-i].killTile();
							i = 8;
						}
						if ((maingame.position[left-i][top-i].has_piece) && (!maingame.position[left-i][top-i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left-i][top+i].has_piece) {
						maingame.position[left-i][top+i].moveableTile();

					}
					else {
						if((maingame.position[left-i][top+i].has_piece) && (maingame.position[left-i][top+i].current_piece.is_white) ){

							maingame.position[left-i][top+i].killTile();
							i = 8;
						}
						if ((maingame.position[left-i][top+i].has_piece) && (!maingame.position[left-i][top+i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
			for(int i = 1;i<8;i++) {
				try {
					if(!maingame.position[left+i][top-i].has_piece) {
						maingame.position[left+i][top-i].moveableTile();

					}
					else {
						if((maingame.position[left+i][top-i].has_piece) && (maingame.position[left+i][top-i].current_piece.is_white) ){

							maingame.position[left+i][top-i].killTile();
							i = 8;
						}
						if ((maingame.position[left+i][top-i].has_piece) && (!maingame.position[left+i][top-i].current_piece.is_white)) {
							i = 8;
						}
					}

				}
				catch(Exception e) {

				}

			}
		}
	}//end select Bishop
	
	// - Select Queen -
	// The queens movement logic is done by combining the rooks and bishops movement
	// logic as the queen has the same moves as both of them combined
	public void selectQueen(int left,int top) {
		selectBishop(left,top);
		selectRook(left,top);
	}

	// - Select King -
	public void selectKing(int left,int top) {
		int king_left[] = {1,0,-1,-1,-1,0,1,1};
		int king_top[] = {-1,-1,-1,0,1,1,1,0};
		if ((is_white) && (maingame.is_whites_turn)) {

				for(int i = 0;i<8;i++) {
					try {
						if(!maingame.position[left+king_left[i]][top+king_top[i]].has_piece) {
							maingame.position[left+king_left[i]][top+king_top[i]].moveableTile();

						}
						else if((maingame.position[left+king_left[i]][top+king_top[i]].has_piece) && (!maingame.position[left+king_left[i]][top+king_top[i]].current_piece.is_white) ){
							maingame.position[left+king_left[i]][top+king_top[i]].killTile();
						}
					}
					catch(Exception e) {

					}

				}

		}
		else if((!is_white) && (!maingame.is_whites_turn)) {

				for(int i = 0;i<8;i++) {
				try {
					if(!maingame.position[left+king_left[i]][top+king_top[i]].has_piece) {
						maingame.position[left+king_left[i]][top+king_top[i]].moveableTile();

					}
					else if((maingame.position[left+king_left[i]][top+king_top[i]].has_piece) && (maingame.position[left+king_left[i]][top+king_top[i]].current_piece.is_white) ){
						maingame.position[left+king_left[i]][top+king_top[i]].killTile();
					}
				}
				catch(Exception e) {

				}

				}
		}

	}// End select king

//	public static void checkPath() {
//		for (Tile moveable_tile : Buttontile.moveable_tiles) {
//			if(moveable_tile.has_piece) {
//				moveable_tile.deselectTile();
//			}
//		System.out.println("path checked");
//	}
//
//	}
}

















public class pieces {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

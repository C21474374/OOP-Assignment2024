package Chess;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


class maingame {
	
	
	
	
	int top[] = new int[8];
	int left[] = new int[8];
	Tile[][] position = new Tile[8][8];
	boolean is_wheat = true;
	
	ImageIcon queen_white = new ImageIcon("ChessPieces/queen_white.png");
	
	
	public void start2player(){
		
		JFrame gui = new JFrame();
		gui.setTitle("Chess");
		gui.setResizable(false);
		gui.setSize(500,500);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container board = gui.getContentPane();
		board.setLayout(new GridLayout(8,8));
		gui.setVisible(true);
		
		for(int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				
				top[j] = j;
				left[i] = i;
				//PLACING TILES
				if (is_wheat)
				{
					position[i][j] = new Tile(is_wheat,board,top[j],left[i]);
					System.out.println("wheat tile");
					is_wheat = false;
					
				}
				else if (!is_wheat)
				{
					int top = j;
					int left = i;
					position[i][j] = new Tile(is_wheat,board,top,left);
					
					is_wheat = true;
				}
				
				
				// PLACING PIECES
				
				//BLACK PIECES
				if ((i == 0 && j == 0) || (i == 0 && j == 7))
				{
					Rook rook_black = new Rook(false,position[i][j]);
				}
				else if ((i == 0 && j == 1) || (i == 0 && j == 6))
				{
					Knight knight_black = new Knight(false,position[i][j]);
				}
				else if ((i == 0 && j == 2) || (i == 0 && j == 5))
				{
					Bishop bishop_black = new Bishop(false,position[i][j]);
				}
				else if (i == 0 && j == 3)
				{
					Queen Queen_black = new Queen(false,position[i][j]);
				}
				else if (i == 0 && j == 4)
				{
					King king_black = new King(false,position[i][j]);
				}
				else if (i == 1) {
					Pawn pawn_black = new Pawn(false,position[i][j]);
				}
				
				
				//WHITE PIECES
				if ((i == 7 && j == 0) || (i == 7 && j == 7))
				{
					Rook rook_white = new Rook(true,position[i][j]);
				}
				else if ((i == 7 && j == 1) || (i == 7 && j == 6))
				{
					Knight knight_white = new Knight(true,position[i][j]);
				}
				else if ((i == 7 && j == 2) || (i == 7 && j == 5))
				{
					Bishop bishop_white = new Bishop(true,position[i][j]);
				}
				else if (i == 7 && j == 3)
				{
					Queen Queen_white = new Queen(true,position[i][j]);
				}
				else if (i == 7 && j == 4)
				{
					King king_white = new King(true,position[i][j]);
				}
				else if (i == 6) {
					Pawn pawn_white = new Pawn(true,position[i][j]);
				}
			}
			is_wheat = !is_wheat;
			
		}
		gui.setVisible(true);
	}
}


public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

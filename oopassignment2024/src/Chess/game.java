package Chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class maingame {




	int top[] = new int[8];
	int left[] = new int[8];
	static Tile[][] position = new Tile[8][8];
	boolean is_wheat = true;
	static boolean is_whites_turn;
	JPanel labelPanel;
	static JLabel whos_turn_bottom;
	static JLabel whos_turn_top;
	static Color bg= new Color(60,179,113);

	ImageIcon queen_white = new ImageIcon("ChessPieces/queen_white.png");


	public void start2player(){
		is_whites_turn = true;
		JFrame gui = new JFrame();
		JPanel text = new JPanel();
		gui.setTitle("Chess");
		gui.setResizable(false);
		gui.setSize(600,650);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int size = 30;
		Container contentPane = gui.getContentPane();
	        contentPane.setLayout(new BorderLayout());
	
	    
	    JPanel board = new JPanel(new GridLayout(8, 8));
	    board.setBackground(bg);
	    contentPane.add(board, BorderLayout.CENTER);
	    
	    
	    JPanel leftgreen = new JPanel(new BorderLayout());
	    contentPane.add(leftgreen, BorderLayout.WEST);
	    leftgreen.setBorder(BorderFactory.createEmptyBorder(size, size, size, size));
	
	    leftgreen.setBackground(bg);
	    
	    JPanel rightgreen = new JPanel(new BorderLayout());
	    contentPane.add(rightgreen, BorderLayout.EAST);
	    rightgreen.setBorder(BorderFactory.createEmptyBorder(size, size, size, size));
	    rightgreen.setBackground(bg);
	    
	    JPanel topgreen = new JPanel(new BorderLayout());
	    contentPane.add(topgreen, BorderLayout.NORTH);
	    topgreen.setBorder(BorderFactory.createEmptyBorder(size, size, size, size));
	    topgreen.setBackground(bg);
	    whos_turn_top = new JLabel("It is Black's turn", JLabel.CENTER);
	    
        whos_turn_top.setForeground(bg);
        topgreen.add(whos_turn_top, BorderLayout.CENTER);
	    
        labelPanel = new JPanel(new BorderLayout());
        contentPane.add(labelPanel, BorderLayout.SOUTH);
        
        whos_turn_bottom = new JLabel("It is White's turn", JLabel.CENTER);
//        JLabel white_score = new JLabel("Score:2", JLabel.CENTER);
//        white_score.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
//        white_score.setForeground(Color.WHITE);
        labelPanel.setBackground(bg);
        
        whos_turn_bottom.setBorder(BorderFactory.createEmptyBorder(size, size,size, size));
        whos_turn_bottom.setForeground(Color.WHITE);
        labelPanel.add(whos_turn_bottom, BorderLayout.CENTER);
//        labelPanel.add(white_score, BorderLayout.EAST);
        
        this.DisplayScore();
	    
       
	        
	        
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
					Piece rook_black = new Piece(false,position[i][j],"Rook");
					position[i][j].addPiece(rook_black);
				}
				else if ((i == 0 && j == 1) || (i == 0 && j == 6))
				{
					Piece knight_black = new Piece(false,position[i][j],"Knight");
					position[i][j].addPiece(knight_black);
				}
				else if ((i == 0 && j == 2) || (i == 0 && j == 5))
				{
					Piece bishop_black = new Piece(false,position[i][j],"Bishop");
					position[i][j].addPiece(bishop_black);
				}
				else if (i == 0 && j == 3)
				{
					Piece queen_black = new Piece(false,position[i][j],"Queen");
					position[i][j].addPiece(queen_black);
				}
				else if (i == 0 && j == 4)
				{
					Piece king_black = new Piece(false,position[i][j],"King");
					position[i][j].addPiece(king_black);
				}
				else if (i == 1 && j == 0) {
					Piece pawn_black1 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black1);
				}
				else if (i == 1 && j == 1) {
					Piece pawn_black2 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black2);
				}
				else if (i == 1 && j == 2) {
					Piece pawn_black3 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black3);
				}
				else if (i == 1 && j == 3) {
					Piece pawn_black4 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black4);
				}
				else if (i == 1 && j == 4) {
					Piece pawn_black5 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black5);
				}
				else if (i == 1 && j == 5) {
					Piece pawn_black6 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black6);
				}
				else if (i == 1 && j == 6) {
					Piece pawn_black7 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black7);
				}
				else if (i == 1 && j == 7) {
					Piece pawn_black8 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black8);
				}


				//WHITE PIECES
				if ((i == 7 && j == 0) || (i == 7 && j == 7))
				{
					Piece rook_white = new Piece(true,position[i][j],"Rook");
					position[i][j].addPiece(rook_white);
				}
				else if ((i == 7 && j == 1) || (i == 7 && j == 6))
				{
					Piece knight_white = new Piece(true,position[i][j],"Knight");
					position[i][j].addPiece(knight_white);
				}
				else if ((i == 7 && j == 2) || (i == 7 && j == 5))
				{
					Piece bishop_white = new Piece(true,position[i][j],"Bishop");
					position[i][j].addPiece(bishop_white);
				}
				else if (i == 7 && j == 3)
				{
					Piece queen_white = new Piece(true,position[i][j],"Queen");
					position[i][j].addPiece(queen_white);
				}
				else if (i == 7 && j == 4)
				{
					Piece king_white = new Piece(true,position[i][j],"King");
					position[i][j].addPiece(king_white);
				}
				else if (i == 6 && j == 0) {
					Piece pawn_white1 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white1);
				}
				else if (i == 6 && j == 1) {
					Piece pawn_white2 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white2);
				}
				else if (i == 6 && j == 2) {
					Piece pawn_white3 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white3);
				}
				else if (i == 6 && j == 3) {
					Piece pawn_white4 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white4);
				}
				else if (i == 6 && j == 4) {
					Piece pawn_white5 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white5);
				}
				else if (i == 6 && j == 5) {
					Piece pawn_white6 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white6);
				}
				else if (i == 6 && j == 6) {
					Piece pawn_white7 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white7);
				}
				else if (i == 6 && j == 7) {
					Piece pawn_white8 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white8);
				}
			}
			is_wheat = !is_wheat;

		}//end double for

		for (int n = 0;n<33;n++) {

		}
		gui.setVisible(true);
	}
	public static void DisplayScore() {
		
		if (is_whites_turn) {
			whos_turn_top.setForeground(bg);
	        whos_turn_bottom.setForeground(Color.WHITE);
	    } else {
	    	whos_turn_top.setForeground(Color.WHITE);
	        whos_turn_bottom.setForeground(bg);
	    }
	}
}


public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

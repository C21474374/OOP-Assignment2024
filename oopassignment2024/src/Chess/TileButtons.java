/***************************************************
* Button:Controls the function of when the button is clicked
* Author:C21474374
* Date:29/2/2024
*********************************/

package Chess;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



class Buttontile implements ActionListener{
	private Tile current_tile;
	private Piece selected_piece;
	//static Tile selected_tile;
	public static JButton last_button = null;
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	Color  brown   = new Color(139,69,19); 
	private static boolean last_color;
	private boolean is_wheat;
	
	static boolean is_yellow = false;
	// Button event method
	public Buttontile(Tile tile,boolean is_wheat,Piece selected_piece) {
		current_tile = tile;
		this.selected_piece = selected_piece;
		
		this.is_wheat = is_wheat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
			//selected_tile = current_tile;
			if (!current_tile.is_selected) {
				current_tile.selectTile();
			}
			
			else if (current_tile.is_moveable) {
				current_tile.selected_piece.movePiece(current_tile);
			}
			
			
	
	
	

}

}


public class TileButtons {

	public static void main(String[] args) {
		

	}

}

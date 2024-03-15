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
	static boolean is_moveable;
	public static Tile moveable_tiles[];
	public static Tile killable_tiles[];
	public static Tile selected_tile;
	static boolean is_yellow = false;
	// Button event method
	public Buttontile(Tile tile,boolean is_wheat) {
		current_tile = tile;
		
		
		this.is_wheat = is_wheat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tile is selected:"+current_tile.isIs_selected());
		System.out.println("Tile is moveable:"+current_tile.is_moveable);
			//selected_tile = current_tile;
			if ((!current_tile.isIs_selected()) && (current_tile.has_piece)) {
				current_tile.selectTile();
				Tile.has_moved = false;
				
				
			}
			if ((!current_tile.isIs_selected()) && (!current_tile.has_piece)) {
				clearTiles();
			}
			
			if (current_tile.is_moveable == true) {
				System.out.println("Piece moved");
				Tile.selected_piece.movePiece(current_tile);
				clearTiles();
				current_tile.deselectTile();
				Tile.has_moved = true;
			}
			if (current_tile.is_killable == true) {
				System.out.println("Piece taken1");
				
				
				Tile.selected_piece.movePiece(current_tile);
				clearTiles();
				
				current_tile.deselectTile();
				Tile.has_moved = true;
			}

			
			
			
			
	
	
	

}
	
	
	public static void clearTiles() {
		if (selected_tile == null) {
			
		}
		else {
			selected_tile.deselectTile();
		}
	
		if(moveable_tiles == null) {
			
		}
		else {
			for (int i = 0;i<moveable_tiles.length;i++) {
				moveable_tiles[i].deselectTile();
			}
		}
		if(killable_tiles == null) {
			
		}
		else {
			for (int j = 0;j<killable_tiles.length;j++) {
				killable_tiles[j].deselectTile();
			}
		}
	}

}


public class TileButtons {

	public static void main(String[] args) {
		

	}

}

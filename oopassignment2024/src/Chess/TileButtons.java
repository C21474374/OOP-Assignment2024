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
	Color light_tile = new Color(245,222,179);
	Color highlighted_tile = new Color(255,255,0);
	Color  dark_tile   = new Color(119,78,36);
	private static boolean last_color;
	private boolean is_light_tile;
	static boolean is_moveable;
	public static Tile moveable_tiles[];
	public static Tile killable_tiles[];
	public static Tile selected_tile;
	static boolean is_yellow = false;
	// Button event method
	public Buttontile(Tile tile,boolean is_wheat) {
		current_tile = tile;


		this.is_light_tile = is_wheat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tile is selected:"+current_tile.isIs_selected());
		System.out.println("Tile is moveable:"+current_tile.is_moveable);
			//selected_tile = current_tile;
			if ((!current_tile.isIs_selected()) && (current_tile.has_piece)) {
				if((current_tile.current_piece.isIs_white()) && (maingame.is_whites_turn)) {
					current_tile.selectTile();
					Tile.has_moved = false;
				}
				else if((!current_tile.current_piece.isIs_white()) && (!maingame.is_whites_turn)) {
					current_tile.selectTile();
					Tile.has_moved = false;
				}



			}
			if ((!current_tile.isIs_selected()) && (!current_tile.has_piece)) {
				clearTiles();
			}

			if (current_tile.is_moveable) {
				System.out.println("Piece moved");
				Tile.selected_piece.movePiece(current_tile);
				clearTiles();
				current_tile.deselectTile();
				Tile.has_moved = true;
			}
			if (current_tile.is_killable) {
				System.out.println("Piece taken1");
				System.out.println("tile type:"+current_tile.piece_type);
				
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
			for (Tile moveable_tile : moveable_tiles) {
				moveable_tile.deselectTile();
			}
		}
		if(killable_tiles == null) {

		}
		else {
			for (Tile killable_tile : killable_tiles) {
				killable_tile.deselectTile();
			}
		}
	}

}


public class TileButtons {

	public static void main(String[] args) {


	}

}

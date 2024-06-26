/***************************************************
* Tile:Controls the function of the tiles on the chess board
* Author:C21474374
* OOP Assignment 2024
*********************************/

package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalButtonUI;

class Tile {
	
	// Initialize Variables
	private Color tile_color;
	public static JButton last_button;
	public static boolean last_color;
	public static boolean is_yellow = false;
	int top;
	int left;
	String piece_type;
	JButton tile_button;
	boolean tile_selected = false;
	boolean has_piece = false;
	boolean is_light_tile;
	Piece current_piece;
	public static Piece selected_piece;
	boolean is_moveable = false;
	private boolean is_selected = false;
	boolean is_killable = false;
	static Color  dark_tile   = new Color(119,78,36);
	static Color light_tile = new Color(245,222,179);
	static Color highlighted_tile = new Color(255,255,0);
	static Color kill_tile = new Color(255,0,0);
	String piecetypes[] = {"Queen","King","Pawn","Rook","Bishop","Knight"};
	static int number;
	public static boolean has_moved;





	// -- CONSTRUCTOR --
	public Tile(boolean is_wheat,JPanel pane,int top,int left) {
		tile_button = new JButton();
		this.top = top;
		this.left = left;
		this.is_light_tile = is_wheat;

		Buttontile evt = new Buttontile(this,is_wheat);
		if (is_wheat) {
			tile_button.setBackground(light_tile);
		}
		else if (!is_wheat) {
			tile_button.setBackground(dark_tile);
		}

		//REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		tile_button.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });



		tile_button.addActionListener(evt);
		pane.add(tile_button);


	}

	// -- GETTERS AND SETTERS --
	public void addPiece(Piece piece) {
		current_piece = piece;
		has_piece = true;
	}
	public boolean isIs_selected() {
		return is_selected;
	}

	public void setIs_selected(boolean is_selected) {
		this.is_selected = is_selected;
	}

	public Color getTile_color() {
		return tile_color;
	}


	public boolean isHas_piece() {
		return has_piece;
	}

	public void setHas_piece(boolean has_piece) {
		this.has_piece = has_piece;
	}

	public void setTile_color(Color tile_color) {
		this.tile_color = tile_color;
	}

	public JButton getButton() {
		return tile_button;
	}

	public void setPiece () {

	}



	public boolean isTile_selected() {
		return tile_selected;
	}

	public void setTile_selected(boolean tile_selected) {
		this.tile_selected = tile_selected;
	}

	// -- METHODS --
	// - Select Tile -
	// Selects a tile by changing it to the highlighted color and then checks what
	// piece is on the tile and selects that piece using the pieces class
	public void selectTile() {
		Buttontile.clearTiles();
		is_selected = false;
		

		selected_piece = current_piece;

		if (has_piece) {
//			System.out.println(current_piece.isIs_white());
			Buttontile.selected_tile = this;
			is_selected = true;
			is_moveable = false;
			if (is_yellow && !last_color)
			{

				last_button.setBackground(dark_tile);
			}
			else if (is_yellow && last_color)
			{

				last_button.setBackground(light_tile);
			}
			if (maingame.highlight_mode) {
				tile_button.setBackground(highlighted_tile);
			}
			

			last_color = is_light_tile;

			last_button = tile_button;
			is_yellow = true;
			if (current_piece.getPiece_type() == "Pawn") {
				current_piece.selectPawn(left, top);
				}
			else if (current_piece.getPiece_type() == "Knight") {
				System.out.println("Knight selected");
				current_piece.selectKnight(left, top);
			}
			else if (current_piece.getPiece_type() == "King") {
				System.out.println("Queen selected");
				current_piece.selectKing(left, top);
			}
			else if (current_piece.getPiece_type() == "Bishop") {
				System.out.println("Queen selected");
				current_piece.selectBishop(left, top);
			}
			else if (current_piece.getPiece_type() == "Rook") {
				System.out.println("Queen selected");
				current_piece.selectRook(left, top);
			}
			else if (current_piece.getPiece_type() == "Queen") {
				System.out.println("Queen selected");
				current_piece.selectQueen(left, top);
			}
		}
		else if (!has_piece) {
			this.clearTiles();
		}
	}


	// - De-select Tile -
	// Simply de-selects a tile back to its original state
	public void deselectTile() {
		if (is_light_tile) {
			tile_button.setBackground(light_tile);
		}
		else if (!is_light_tile) {
			tile_button.setBackground(dark_tile);
		}
		is_selected = false;
		is_moveable = false;
		is_killable = false;

	}
	public void killTile() {
		is_moveable = false;
		is_selected = true;
		is_killable = true;
		if ((this.has_piece) && (maingame.highlight_mode)) {
			tile_button.setBackground(kill_tile);
		}
		if (Buttontile.killable_tiles == null) {
			Buttontile.killable_tiles = new Tile[1];
			Buttontile.killable_tiles[0] = this;
        } else {
           
            Tile[] newkillable_tiles = new Tile[Buttontile.killable_tiles.length + 1];
          
            System.arraycopy(Buttontile.killable_tiles, 0, newkillable_tiles, 0, Buttontile.killable_tiles.length);
          
            newkillable_tiles[newkillable_tiles.length - 1] = this;
           
            Buttontile.killable_tiles = newkillable_tiles;
        }
	}
	public void moveableTile () {
		is_moveable = true;
		is_selected = true;

		if (Buttontile.moveable_tiles == null) {
			Buttontile.moveable_tiles = new Tile[1];
			Buttontile.moveable_tiles[0] = this;
        } else {
           
            Tile[] newMoveableTiles = new Tile[Buttontile.moveable_tiles.length + 1];
         
            System.arraycopy(Buttontile.moveable_tiles, 0, newMoveableTiles, 0, Buttontile.moveable_tiles.length);
      
            newMoveableTiles[newMoveableTiles.length - 1] = this;
            
            Buttontile.moveable_tiles = newMoveableTiles;
        }
		//System.out.println("Position "+left+","+top+" is moveable");
		if ((!has_piece) & (maingame.highlight_mode)) {
			tile_button.setBackground(highlighted_tile);
		}
		else if (has_piece) {
			this.killTile();
		}
	}

	 private void clearTiles() {

		 Buttontile.moveable_tiles = null;
		 Buttontile.killable_tiles = null;
	    }
	 
	// - Place Piece -
	// Places an image icon (piece) on the tile
	public void placePiece(ImageIcon piece,String piece_Type) {
		this.piece_type = piece_Type;
		Image image = piece.getImage();
        Image scaledImage = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
        tile_button.setIcon(new ImageIcon(scaledImage));
//        System.out.println(piece_type+" has been placed in:("+left+","+top+")");
        has_piece = true;
	}


}// end Tile class

public class tiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

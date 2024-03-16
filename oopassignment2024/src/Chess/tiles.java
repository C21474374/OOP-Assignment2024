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
	boolean is_wheat;
	Piece current_piece;
	public static Piece selected_piece;
	boolean is_moveable = false;
	private boolean is_selected = false;
	boolean is_killable = false;
	Color  brown   = new Color(139,69,19);
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	Color red = new Color(255,0,0);
	String piecetypes[] = {"Queen","King","Pawn","Rook","Bishop","Knight"};
	static int number;
	public static boolean has_moved;





	// CONSTRUCTOR
	public Tile(boolean is_wheat,JPanel pane,int top,int left) {
		//tile_position = position;
		tile_button = new JButton();
		this.top = top;
		this.left = left;
		this.is_wheat = is_wheat;

		Buttontile evt = new Buttontile(this,is_wheat);
		if (is_wheat) {
			tile_button.setBackground(wheat);
		}
		else if (!is_wheat) {
			tile_button.setBackground(brown);
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

	// GETTERS AND SETTERS

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

	public void selectTile() {
		Buttontile.clearTiles();
		is_selected = false;
		Color wheat = new Color(245,222,179);
		Color yellow = new Color(255,255,0);
		Color  brown   = new Color(139,69,19);

		selected_piece = current_piece;

		if (has_piece) {
			System.out.println(current_piece.isIs_white());
			Buttontile.selected_tile = this;
			is_selected = true;
			is_moveable = false;
			if (is_yellow && !last_color)
			{

				last_button.setBackground(brown);
			}
			else if (is_yellow && last_color)
			{

				last_button.setBackground(wheat);
			}
			tile_button.setBackground(yellow);

			last_color = is_wheat;

			last_button = tile_button;
			is_yellow = true;
			if (current_piece.getPiece_type() == "Pawn") {
				current_piece.selectPawn(left, top);
				//current_piece.movePiece(maingame.position[left-1][top]);
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



	public void deselectTile() {
		if (is_wheat) {
			tile_button.setBackground(wheat);
		}
		else if (!is_wheat) {
			tile_button.setBackground(brown);
		}
		is_selected = false;
		is_moveable = false;
		is_killable = false;

	}
	public void killTile() {
		is_moveable = false;
		is_selected = true;
		is_killable = true;
		if (this.has_piece) {
			tile_button.setBackground(red);
		}
		if (Buttontile.killable_tiles == null) {
			Buttontile.killable_tiles = new Tile[1];
			Buttontile.killable_tiles[0] = this;
        } else {
            // Create a new array with increased size to accommodate the new tile
            Tile[] newkillable_tiles = new Tile[Buttontile.killable_tiles.length + 1];
            // Copy existing tiles to the new array
            System.arraycopy(Buttontile.killable_tiles, 0, newkillable_tiles, 0, Buttontile.killable_tiles.length);
            // Add the new tile to the end of the new array
            newkillable_tiles[newkillable_tiles.length - 1] = this;
            // Update the moveable_tiles reference to point to the new array
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
            // Create a new array with increased size to accommodate the new tile
            Tile[] newMoveableTiles = new Tile[Buttontile.moveable_tiles.length + 1];
            // Copy existing tiles to the new array
            System.arraycopy(Buttontile.moveable_tiles, 0, newMoveableTiles, 0, Buttontile.moveable_tiles.length);
            // Add the new tile to the end of the new array
            newMoveableTiles[newMoveableTiles.length - 1] = this;
            // Update the moveable_tiles reference to point to the new array
            Buttontile.moveable_tiles = newMoveableTiles;
        }
		System.out.println("Position "+left+","+top+" is moveable");
		if (!has_piece) {
			tile_button.setBackground(yellow);
		}
		else if (has_piece) {
			System.out.println("red");
			this.killTile();
		}
	}

	 private void clearTiles() {

		 Buttontile.moveable_tiles = null;
		 Buttontile.killable_tiles = null;
	    }
	public void placePiece(ImageIcon piece,String piece_Type) {
		piece_type = piece_Type;
		Image image = piece.getImage();
        Image scaledImage = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
        tile_button.setIcon(new ImageIcon(scaledImage));
        System.out.println(piece_type+" has been placed in:("+left+","+top+")");
        has_piece = true;
	}


}
//2d array grid example
//      0 1 2 3 4 5 6 7
//     0
//     1
//     2
//     3
//     4
//     5
//     6
//     7



public class tiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

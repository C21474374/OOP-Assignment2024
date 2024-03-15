package Chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	boolean is_moveable;
	boolean is_selected = false;
	Color  brown   = new Color(139,69,19); 
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	String piecetypes[] = {"Queen","King","Pawn","Rook","Bishop","Knight"};
	
	
	
	
	
	// CONSTRUCTOR
	public Tile(boolean is_wheat,Container pane,int top,int left) {
		//tile_position = position;
		tile_button = new JButton();
		this.top = top;
		this.left = left;
		this.is_wheat = is_wheat;
		
		Buttontile evt = new Buttontile(this,is_wheat,selected_piece);
		if (is_wheat) {
			tile_button.setBackground(wheat);
		}
		else if (!is_wheat) {
			tile_button.setBackground(brown);
		}
		
		//REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		tile_button.setUI (new MetalButtonUI () {
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
		Color wheat = new Color(245,222,179);
		Color yellow = new Color(255,255,0);
		Color  brown   = new Color(139,69,19); 
		is_selected = true;
		selected_piece = current_piece;
		if (has_piece) {
			if (is_yellow == true && last_color == false)
			{
				
				last_button.setBackground(brown);
			}
			else if (is_yellow == true && last_color == true)
			{
				
				last_button.setBackground(wheat);
			}
			tile_button.setBackground(yellow);
			
			last_color = is_wheat;
			
			last_button = tile_button;
			is_yellow = true;
			if (current_piece.getPiece_type() == "Pawn") {
				maingame.position[left-1][top].moveableTile();
			//current_piece.movePiece(maingame.position[left-1][top]);
				}
		}
		
		
	}
	
	public void moveableTile () {
		is_moveable = true;
		if (!has_piece) {
			tile_button.setBackground(yellow);
		}
		else if (has_piece) {
			System.out.println("red");
			tile_button.setBackground(yellow);
		}
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

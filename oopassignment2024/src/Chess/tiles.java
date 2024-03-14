package Chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.metal.MetalButtonUI;

class Tile {
	private Color tile_color;
	int top;
	int left;
	JButton tile_button;
	boolean tile_selected = false;
	private boolean has_piece = false;
	boolean is_wheat;
	Piece current_piece;
	Color  brown   = new Color(139,69,19); 
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	
	// CONSTRUCTOR
	public Tile(boolean is_wheat,Container pane,int top,int left) {
		//tile_position = position;
		tile_button = new JButton();
		this.top = top;
		this.left = left;
		
		
		Buttontile evt = new Buttontile(tile_button,is_wheat);
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

	



	public boolean isTile_selected() {
		return tile_selected;
	}

	public void setTile_selected(boolean tile_selected) {
		this.tile_selected = tile_selected;
	}
	
	public void placePiece(ImageIcon piece) {
		
		Image image = piece.getImage();
        Image scaledImage = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
        tile_button.setIcon(new ImageIcon(scaledImage));
        System.out.println("Queen has been placed in:("+left+","+top+")");
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

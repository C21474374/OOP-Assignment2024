package Chess;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;

class Tile {
	private Color tile_color;
	private int tile_position[][];
	boolean tile_selected = false;
	boolean is_wheat;
	Color  brown   = new Color(139,69,19); 
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	
	// CONSTRUCTOR
	public Tile(boolean is_wheat,Container pane) {
		//tile_position = position;
		JButton tile_button = new JButton();
		
		Buttontile evt = new Buttontile(tile_button,is_wheat);
		if (is_wheat) {
			tile_button.setBackground(wheat);
		}
		else if (!is_wheat) {
			tile_button.setBackground(brown);
		}
		tile_button.addActionListener(evt);
		pane.add(tile_button);
		
		
	}

	// GETTERS AND SETTERS
	public Color getTile_color() {
		return tile_color;
	}

	
	public void setTile_color(Color tile_color) {
		this.tile_color = tile_color;
	}

	public int[][] getTile_position() {
		return tile_position;
	}

	public void setTile_position(int[][] tile_position) {
		this.tile_position = tile_position;
	}

	public boolean isTile_selected() {
		return tile_selected;
	}

	public void setTile_selected(boolean tile_selected) {
		this.tile_selected = tile_selected;
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

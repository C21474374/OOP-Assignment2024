/***************************************************
* Theme:Stores the functions for the types of themes and setting them
* This class also uses OOP concepts such as interfaces,classes,subclasses,methods,attributes and is designed in an OOP away
* Author:C21474374
* OOP Assignment 2024
*********************************/



package Chess;

import java.awt.Color;

import javax.swing.ImageIcon;

// Set Interface
interface ThemeSetter
{
	void setTheme();
	void resetTheme();
}

class Theme  {
	

	// Initialize Variables
	static ImageIcon default_board = new ImageIcon("Themes/default_board.png");
	static ImageIcon pink_board = new ImageIcon("Themes/pink_board.png");
	static ImageIcon blue_board = new ImageIcon("Themes/blue_board.png");
	static ImageIcon grey_board = new ImageIcon("Themes/grey_board.png");
	static ImageIcon purple_board = new ImageIcon("Themes/purple_board.png");
	static ImageIcon magma_board = new ImageIcon("Themes/magma_board.png");
	static int board_index = 0;
	static ImageIcon[] theme_images = {default_board,pink_board,blue_board,grey_board,purple_board,magma_board};
	static String[] board_names = {"Default","Pink","Blue","Grey","Purple","Magma"};
	
	Color default_dark =  new Color(119,78,36);
	Color default_light = new Color(245,222,179);
	Color default_bg = new Color(94,61,28);
	Color default_border = new Color(0,0,0);
	Color default_text = new Color(255,255,255);
	Color default_highlight = new Color(255,255,0);
	Color default_kill = new Color(255,0,0);
	
	Color current_dark_color;
	Color current_light_color;
	Color current_bg_color;
	Color current_border_color;
	Color current_text_color;
	Color current_highlight_color;
	Color current_kill_color;
	
	 public Theme(Color darkColor, Color lightColor, Color bgColor, Color borderColor, Color textColor, Color highlightColor, Color killColor) {
	   
		 
		 	current_dark_color = darkColor;
	        current_light_color = lightColor;
	        current_bg_color = bgColor;
	        current_border_color = borderColor;
	        current_text_color = textColor;
	        current_highlight_color = highlightColor;
	        current_kill_color = killColor;
	    }
	
	
	
}

// -- SUBCLASS'S OF THEME --
// - Pink Theme -
class pinkTheme extends Theme implements ThemeSetter {
	
	public pinkTheme() {
		super(new Color(255,200,251),//dark_color (Pink Lavender)
			  new Color(255, 238, 242),//light_color (Lavender Blush)
			  new Color(255, 194, 220),//bg_color (Orchid Pink)
			  new Color(85, 67, 72),//border_color (Rose Ebony)
			  new Color(0,0,0),//text_color (Black)
			  new Color(255, 194, 227),//highlight_color (Lavender pink)
			  new Color(255, 146, 194));//kill color (Amaranth pink)
		//System.out.println("Job done");
	}
	public void setTheme() {
		Tile.dark_tile = super.current_dark_color;
		Tile.light_tile = super.current_light_color;
		Tile.highlighted_tile = super.current_highlight_color;
		Tile.kill_tile = super.current_kill_color;
		maingame.bg = super.current_bg_color;
		maingame.bd = super.current_border_color;
		maingame.textcl = super.current_text_color;
		
		
	}
	public void resetTheme() {
		Tile.dark_tile = super.default_dark;
		Tile.light_tile = super.default_light;
		Tile.highlighted_tile = super.default_highlight;
		Tile.kill_tile = super.default_kill;
		maingame.bg = super.default_bg;
		maingame.bd = super.default_border;
		maingame.textcl = super.default_text;
	}
	
}

// - Grey Theme -
class greyTheme extends Theme implements ThemeSetter {
	
	public greyTheme() {
		super(new Color(112, 112, 112),//dark_color (Dim Gray)
			  new Color(242, 242, 242),//light_color (White smoke)
			  new Color(165, 165, 165),//bg_color (Silver 1)
			  new Color(0,0,0),//border_color (Black)
			  new Color(0,0,0),//text_color (Black)
			  new Color(204, 204, 204),//highlight_color (Silver 2)
			  new Color(89, 89, 89));//kill color (Dave's grey)
		//System.out.println("Job done");
	}
	public void setTheme() {
		Tile.dark_tile = super.current_dark_color;
		Tile.light_tile = super.current_light_color;
		Tile.highlighted_tile = super.current_highlight_color;
		Tile.kill_tile = super.current_kill_color;
		maingame.bg = super.current_bg_color;
		maingame.bd = super.current_border_color;
		maingame.textcl = super.current_text_color;
		
		
	}
	public void resetTheme() {
		Tile.dark_tile = super.default_dark;
		Tile.light_tile = super.default_light;
		Tile.highlighted_tile = super.default_highlight;
		Tile.kill_tile = super.default_kill;
		maingame.bg = super.default_bg;
		maingame.bd = super.default_border;
		maingame.textcl = super.default_text;
	}
	
}

// - Blue Theme -
class blueTheme extends Theme implements ThemeSetter {
	
	public blueTheme() {
		super(new Color(70, 87, 117),//dark_color (null)
			  new Color(255,255,255),//light_color (White)
			  new Color(169, 180, 199),//bg_color (Gun metal)
			  new Color(79, 93, 117),//border_color (null)
			  new Color(255,255,255),//text_color (White)
			  new Color(155, 167, 191),//highlight_color (null)
			  new Color(66, 77, 97));//kill color (null)
		//System.out.println("Job done");
	}
	public void setTheme() {
		Tile.dark_tile = super.current_dark_color;
		Tile.light_tile = super.current_light_color;
		Tile.highlighted_tile = super.current_highlight_color;
		Tile.kill_tile = super.current_kill_color;
		maingame.bg = super.current_bg_color;
		maingame.bd = super.current_border_color;
		maingame.textcl = super.current_text_color;
		
		
	}
	public void resetTheme() {
		Tile.dark_tile = super.default_dark;
		Tile.light_tile = super.default_light;
		Tile.highlighted_tile = super.default_highlight;
		Tile.kill_tile = super.default_kill;
		maingame.bg = super.default_bg;
		maingame.bd = super.default_border;
		maingame.textcl = super.default_text;
	}
	
}

// - Purple Theme -
class purpleTheme extends Theme implements ThemeSetter {
	
	public purpleTheme() {
		super(new Color(165, 148, 249),//dark_color (Tropical Indigo)
			  new Color(245, 239, 255),//light_color (Magnolia)
			  new Color(229, 217, 242),//bg_color (Pale Purple)
			  new Color(125, 101, 246),//border_color (medium slate blue)
			  new Color(0,0,0),//text_color (White)
			  new Color(205, 193, 255),//highlight_color (Periwinkle)
			  new Color(137, 135, 253));//kill color (Tropical indigo)
		//System.out.println("Job done");
	}
	public void setTheme() {
		Tile.dark_tile = super.current_dark_color;
		Tile.light_tile = super.current_light_color;
		Tile.highlighted_tile = super.current_highlight_color;
		Tile.kill_tile = super.current_kill_color;
		maingame.bg = super.current_bg_color;
		maingame.bd = super.current_border_color;
		maingame.textcl = super.current_text_color;
		
		
	}
	public void resetTheme() {
		Tile.dark_tile = super.default_dark;
		Tile.light_tile = super.default_light;
		Tile.highlighted_tile = super.default_highlight;
		Tile.kill_tile = super.default_kill;
		maingame.bg = super.default_bg;
		maingame.bd = super.default_border;
		maingame.textcl = super.default_text;
	}
	
}

// - Magma Theme -
class magmaTheme extends Theme implements ThemeSetter {
	
	public magmaTheme() {
		super(new Color(105, 20, 14),//dark_color (blood red)
			  new Color(238, 205, 170),//light_color (vanilla)
			  new Color(90, 17, 12),//bg_color (black bean)
			  new Color(60, 21, 24),//border_color (Mahogany)
			  new Color(255,255,255),//text_color (White)
			  new Color(213, 137, 54),//highlight_color (Bronze)
			  new Color(164, 66, 0));//kill color (Brown)
		//System.out.println("Job done");
	}
	public void setTheme() {
		Tile.dark_tile = super.current_dark_color;
		Tile.light_tile = super.current_light_color;
		Tile.highlighted_tile = super.current_highlight_color;
		Tile.kill_tile = super.current_kill_color;
		maingame.bg = super.current_bg_color;
		maingame.bd = super.current_border_color;
		maingame.textcl = super.current_text_color;
		
		
	}
	public void resetTheme() {
		Tile.dark_tile = super.default_dark;
		Tile.light_tile = super.default_light;
		Tile.highlighted_tile = super.default_highlight;
		Tile.kill_tile = super.default_kill;
		maingame.bg = super.default_bg;
		maingame.bd = super.default_border;
		maingame.textcl = super.default_text;
	}
	
}




public class Themes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

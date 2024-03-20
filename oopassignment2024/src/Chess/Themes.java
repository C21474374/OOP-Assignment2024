package Chess;

import java.awt.Color;

interface ThemeSetter
{
	void setTheme();
	void resetTheme();
}
class Theme  {
	
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

class pinkTheme extends Theme implements ThemeSetter {
	
	public pinkTheme() {
		super(new Color(255,200,251),//dark_color (Pink Lavender)
			  new Color(255, 238, 242),//light_color (Lavender Blush)
			  new Color(255, 194, 220),//bg_color (Orchid Pink)
			  new Color(85, 67, 72),//border_color (Rose Ebony)
			  new Color(0,0,0),//text_color (Black)
			  new Color(255, 194, 227),//highlight_color (Lavender pink)
			  new Color(255, 146, 194));//kill color (Amaranth pink)
		System.out.println("Job done");
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

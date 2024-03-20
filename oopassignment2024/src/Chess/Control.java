package Chess;

public class Control {
	static maingame game = new maingame();
	static ThemeSetter theme_setter = new magmaTheme();
	public static void main(String[] args) {
		theme_setter.setTheme();
		game.mainmenu();
		
	}

}

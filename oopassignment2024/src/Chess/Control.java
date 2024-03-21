package Chess;

public class Control {
	static maingame game = new maingame();
	static ThemeSetter theme_setter = new greyTheme();
	public static void main(String[] args) {
		theme_setter.resetTheme();
		game.mainmenu();
		
	}

}

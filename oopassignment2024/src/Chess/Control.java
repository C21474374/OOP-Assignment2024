/***************************************************
* Control:Other classes use this class to control the game
* Author:C21474374
* OOP Assignment 2024
*********************************/

package Chess;

public class Control {
	// Instantiates game object and theme setter for controlling in different classes
	static maingame game = new maingame();
	static ThemeSetter theme_setter = new greyTheme();
	public static void main(String[] args) {
		theme_setter.resetTheme();
		game.mainmenu();
		
	}

}

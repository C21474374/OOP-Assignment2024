/***************************************************
* Button:Controls the function of when the button is clicked
* Author:C21474374
* Date:29/2/2024
*********************************/

package Chess;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



class Menuevt implements ActionListener{
	private JButton current_btn;
	private String menu_type;
	
	// Button event method
	public Menuevt(JButton button,String menu_type) {
		this.current_btn = button;
		this.menu_type = menu_type;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (menu_type == "two_player") {
			Control.game.clearscreen();
			Control.game.start2player();
		}
		else if(menu_type == "main_menu"){
			Control.game.clearscreen();
			Control.game.mainmenu();
		}
		
	
	

}//end actionPerformed



}
public class MenuButtons {

	public static void main(String[] args) {
		

	}

}

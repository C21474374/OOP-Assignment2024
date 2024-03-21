/***************************************************
* Button:Controls the function of when the button is clicked
* Author:C21474374
* Date:29/2/2024
*********************************/

package Chess;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



class Themeevt implements ActionListener{
	private JLabel board_image;
	private String button_type;
	
	// Button event method
	public Themeevt(String button_type) {
		this.button_type = button_type;
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (button_type == "left_arrow") {
			Theme.board_index--;
			if(Theme.board_index == -1) {
				Theme.board_index = 5;
			}
			Control.game.clearscreen();
			Control.game.changeTheme();
//			Image image = Theme.theme_images[Theme.board_index].getImage();
//		    Image scaledImage = image.getScaledInstance(300,300, Image.SCALE_SMOOTH);
//		    maingame.board_image.setIcon(new ImageIcon(scaledImage));
		}
		else if(button_type == "select") {
			
			if (Theme.board_index == 0) {
				Control.theme_setter.resetTheme();
			}
			else if (Theme.board_index == 1) {
				Control.theme_setter = new pinkTheme();
				Control.theme_setter.setTheme();
			}
			else if (Theme.board_index == 2) {
				Control.theme_setter = new blueTheme();
				Control.theme_setter.setTheme();
			}
			else if (Theme.board_index == 3) {
				Control.theme_setter = new greyTheme();
				Control.theme_setter.setTheme();
			}
			else if (Theme.board_index == 4) {
				Control.theme_setter = new purpleTheme();
				Control.theme_setter.setTheme();
			}
			else if (Theme.board_index == 5) {
				Control.theme_setter = new magmaTheme();
				Control.theme_setter.setTheme();
			}
			Control.game.clearscreen();
			Control.game.changeTheme();
			
		  
		}
		else if(button_type == "right_arrow") {
			Theme.board_index++;
			if(Theme.board_index == 6) {
				Theme.board_index = 0;
				
			}
			
			Control.game.clearscreen();
			Control.game.changeTheme();
//			Image image = Theme.theme_images[Theme.board_index].getImage();
//		    Image scaledImage = image.getScaledInstance(300,300, Image.SCALE_SMOOTH);
//		    maingame.board_image.setIcon(new ImageIcon(scaledImage));
		}
	
	

}//end actionPerformed



}
public class ThemeButtons {

	public static void main(String[] args) {
		

	}

}

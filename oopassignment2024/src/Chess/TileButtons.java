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



class Buttonevt implements ActionListener{
	private JButton current_btn;
	public static JButton last_button = null;
	Color wheat = new Color(245,222,179);
	Color yellow = new Color(255,255,0);
	Color  brown   = new Color(139,69,19); 
	private static boolean last_color;
	private boolean is_wheat;
	static boolean is_yellow = false;
	// Button event method
	public Buttonevt(JButton button,boolean is_wheat) {
		this.current_btn = button;
		this.is_wheat = is_wheat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// initialize JFrame
		if (is_yellow == true & last_color == false)
		{
			last_button.setIcon(null);
			last_button.setBackground(brown);
		}
		else if (is_yellow == true & last_color == true)
		{
			last_button.setIcon(null);
			last_button.setBackground(wheat);
		}
		current_btn.setBackground(yellow);
		
		last_color = is_wheat;
		
		last_button = current_btn;
		is_yellow = true;
		
		
		
		// Alert box that displays message variable
		
		
	}
	
	

}




public class TileButtons {

	public static void main(String[] args) {
		

	}

}

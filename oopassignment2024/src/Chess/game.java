package Chess;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

class maingame {
	
	Tile[][] position = new Tile[8][8];
	boolean is_wheat = true;
	
	
	public void start2player(){
		
		JFrame gui = new JFrame();
		gui.setTitle("Chess");
		gui.setResizable(false);
		gui.setSize(500,500);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container board = gui.getContentPane();
		board.setLayout(new GridLayout(8,8));
		gui.setVisible(true);
		
		for(int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				if (is_wheat)
				{
					 
					position[i][j] = new Tile(is_wheat,board);
					System.out.println("wheat tile");
					is_wheat = false;
					
				}
				else if (!is_wheat)
				{
					position[i][j] = new Tile(is_wheat,board);
					System.out.println("brown tile");
					is_wheat = true;
				}
				
			}
			is_wheat = !is_wheat;
			
		}
		gui.setVisible(true);
	}
}


public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

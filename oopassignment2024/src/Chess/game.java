package Chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.metal.MetalButtonUI;

class maingame {

	// Static game settings and state
	static boolean is_whites_turn;
	static boolean highlight_mode = true;
	static String highlight_option = "On";
	static String white_name;
	static String black_name;

	// Static UI components
	static Tile[][] position = new Tile[8][8];
	static JLabel whos_turn_bottom;
	static JLabel whos_turn_top;
	static JLabel board_image;
	static JLabel board_name;

	// Static UI colors
	static Color bg = new Color(94, 61, 28);
	static Color textcl = new Color(255, 255, 255);
	static Color bd = new Color(0, 0, 0);

	// File processing
	static file fileProcessor = new file();

	// Game board and positioning
	int[] top = new int[8];
	int[] left = new int[8];
	boolean is_wheat = true;

	// UI components for game interaction
	JFrame gui = new JFrame();
	Container contentPane;
	JPanel board;
	JPanel left_screen;
	JPanel labelPanel;

	// Game piece tracking
	JLabel[] white_pieces;
	int current_white = 0;
	JLabel[] black_pieces;
	int current_black = 0;
	public void mainmenu() {
	
		
		gui.setTitle("Main Menu");
		gui.setResizable(false);
		gui.setSize(500,500);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=By%20default%2C%20a%20JFrame%20can,()%20method%20of%20Window%20class.
		gui.setLocationRelativeTo(null); // this method displays the JFrame to center position of a screen
		contentPane = gui.getContentPane();
		contentPane.setLayout(new BorderLayout()); 
		contentPane.setBackground(bg);
        
		//https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
		JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        menuPanel.setBackground(bg);
        
        JLabel chess_title = new JLabel("Java Chess");
        chess_title.setForeground(textcl);
        Font titleFont = new Font("Arial", Font.PLAIN, 60);
        chess_title.setFont(titleFont);
        menuPanel.add(chess_title, gbc);
        gbc.gridy++;
       
        
        
        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        JButton two_player = new JButton("Start 2 Player Mode");
        Menuevt twoplay = new Menuevt(two_player,"pick_name");
        two_player.addActionListener(twoplay);
        //two_player.setMaximumSize(new Dimension(100, 50));
        two_player.setForeground(textcl);
        two_player.setFont(buttonFont);
        two_player.setBackground(Tile.dark_tile);
        two_player.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		two_player.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
		menuPanel.add(two_player, gbc);
        gbc.gridy++;
        
        JButton change_theme = new JButton("Change Theme");
        Menuevt theme = new Menuevt(change_theme,"themes");
        change_theme.addActionListener(theme);
        //two_player.setMaximumSize(new Dimension(100, 50));
        change_theme.setForeground(textcl);
        change_theme.setFont(buttonFont);
        change_theme.setBackground(Tile.dark_tile);
        change_theme.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
        change_theme.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
		menuPanel.add(change_theme, gbc);
        gbc.gridy++;
		
		
		JButton options = new JButton("Options");
        Menuevt optionevt = new Menuevt(options,"options");
        options.addActionListener(optionevt);
      //  options.setMaximumSize(new Dimension(100, 50));
        options.setForeground(textcl);
        options.setFont(buttonFont);
        
        options.setBackground(Tile.dark_tile);
        options.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
        options.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
       
        
        menuPanel.add(options, gbc);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        
        contentPane.add(menuPanel, BorderLayout.CENTER);
        
        gui.setVisible(true);
	}//end main menu
	public void clearscreen() {
//		https://stackoverflow.com/questions/16869812/how-to-remove-all-children-components-of-a-container
		contentPane.removeAll();
	    contentPane.revalidate();
	    contentPane.repaint();
	
	}
	public void picknames() {
			
		
			
			gui.setTitle("Enter Names");
			gui.setResizable(false);
			gui.setSize(500,500);
			//https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=By%20default%2C%20a%20JFrame%20can,()%20method%20of%20Window%20class.
			gui.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
			gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			contentPane = gui.getContentPane();
			contentPane.setLayout(new BorderLayout()); 
			contentPane.setBackground(bg);
	        
			//https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
			JPanel menuPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.insets = new Insets(10, 10, 10, 10); 
	        menuPanel.setBackground(bg);
	  
	        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
	     // Labels and text fields for name input
	        JLabel nameLabel1 = new JLabel("Enter White Player:");
	        nameLabel1.setForeground(textcl);
	        nameLabel1.setFont(buttonFont);
	        menuPanel.add(nameLabel1, gbc);
	        
	        gbc.gridy++;
	        JTextField nameField1 = new JTextField(15);
	        nameField1.setFont(buttonFont);
	        menuPanel.add(nameField1, gbc);
	        
	        gbc.gridy++;
	        JLabel nameLabel2 = new JLabel("Enter Black Player:");
	        nameLabel2.setForeground(textcl);
	        nameLabel2.setFont(buttonFont);
	        menuPanel.add(nameLabel2, gbc);
	        
	        gbc.gridy++;
	        JTextField nameField2 = new JTextField(15);
	        nameField2.setFont(buttonFont);
	        menuPanel.add(nameField2, gbc);
	        
	        gbc.gridy++;
	     // Save button
	        gbc.gridy++;
	        JButton saveButton = new JButton("Save Names");
	        saveButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                white_name = nameField1.getText();
	                black_name = nameField2.getText();
	                
	                System.out.println("Name 1: " + white_name + ", Name 2: " + black_name);
	                if((!white_name.isBlank()) & (!black_name.isBlank())) {
	                	if(!Control.game.fileProcessor.nameExists("scores.txt", white_name)) {
	                		fileProcessor.writefile("scores.txt", white_name + ", 0"); 
	                	}
	                	else if(!Control.game.fileProcessor.nameExists("scores.txt", black_name)) {
	                		fileProcessor.writefile("scores.txt", black_name + ", 0");
	                	}
	                	
	                    JOptionPane.showMessageDialog(gui, "Names saved successfully.");
	                	Control.game.clearscreen();
	  	                Control.game.start2player();
	                }
	                else {
	                	JOptionPane.showMessageDialog(gui, "Names cannot be blank.", "Input Error", JOptionPane.ERROR_MESSAGE);
	                }
	              
	            }
	        });
	        saveButton.setForeground(textcl);
	        saveButton.setFont(new Font("Arial", Font.PLAIN, 20));
	        saveButton.setBackground(Tile.dark_tile);
	        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        saveButton.setUI(new MetalButtonUI() {
	            @Override
	            protected void paintButtonPressed(Graphics g, AbstractButton b) {}
	        });
	        menuPanel.add(saveButton, gbc);
	        gbc.gridy++;
			  
		        JButton menu = new JButton("Back");
		        Menuevt menuevt = new Menuevt(menu,"main_menu");
		        menu.addActionListener(menuevt);
		        //two_player.setMaximumSize(new Dimension(100, 50));
		        menu.setForeground(textcl);
		        menu.setFont(buttonFont);
		        menu.setBackground(Tile.dark_tile);
		        menu.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
		        //-i-get-on-a-jbutton-when-it-s-h-8112
		        menu.setUI (new MetalButtonUI () {
		            @Override
					protected void paintButtonPressed (Graphics g, AbstractButton b) { }
		        });
				menuPanel.add(menu, gbc);
				contentPane.add(menuPanel, BorderLayout.CENTER);
		        
		        gui.setVisible(true);
	        
	
		
	}
	public void start2player(){
	
		current_black = 0;
		current_white = 0;
		is_whites_turn = true;
		
		
		gui.setTitle("2 Player Game");
		gui.setResizable(false);
		gui.setSize(850,650);
		//https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=By%20default%2C%20a%20JFrame%20can,()%20method%20of%20Window%20class.
		gui.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int size = 30;
		contentPane = gui.getContentPane();
	        contentPane.setLayout(new BorderLayout());
	
	    
	    board = new JPanel(new GridLayout(8, 8));
	    board.setBackground(bd);
	    board.setBorder(BorderFactory.createLineBorder(bd ,5));
	    contentPane.add(board, BorderLayout.CENTER);
	    
	    
	    left_screen = new JPanel(new BorderLayout());
	    contentPane.add(left_screen, BorderLayout.WEST);
	    left_screen.setBorder(BorderFactory.createEmptyBorder(size, size, size, size));
	    left_screen.setBackground(bg);
	    
	    
	    
	    
	    
	    JPanel rightgreen = new JPanel();
        rightgreen.setLayout(new BoxLayout(rightgreen, BoxLayout.Y_AXIS));
	    contentPane.add(rightgreen, BorderLayout.EAST);
	    rightgreen.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 60));
	    rightgreen.setBackground(bg);
	    
	   
	    
	    white_pieces = new JLabel[16];
	    ImageIcon piece = new ImageIcon("Chesspieces/queen_black.png");
	    Image image = piece.getImage();
        Image scaledImage = image.getScaledInstance(30,30, Image.SCALE_SMOOTH);
       
        JLabel black_text = new JLabel("White Pieces Taken");
      
	    black_text.setForeground(textcl);
	    black_text.setBorder(BorderFactory.createEmptyBorder(0,0,10,60));
	    rightgreen.add(black_text);
        
	    JPanel black_panel = new JPanel();
	
	    
	    
	    black_panel.setBorder(BorderFactory.createLineBorder(bd,5));
	    black_panel.setLayout(new GridLayout(4, 4));
	   // Dimension panelSize = new Dimension(150, 200);
	    black_panel.setBackground(Tile.dark_tile);
	  //  black_panel.setPreferredSize(panelSize);
	    for (int i = 0;i<16;i++) {
	    	white_pieces[i] = new JLabel("");
	    	//white_pieces[i].setIcon(new ImageIcon(scaledImage));
	    	white_pieces[i].setBackground(Tile.dark_tile);
	    	white_pieces[i].setPreferredSize(new Dimension(30, 30));
	    	black_panel.add(white_pieces[i]);
	    }
	    white_pieces[5].setIcon(null);
	    rightgreen.add(black_panel);
	    
	    
	    
	    //Empty panel
	    
	    JPanel empty = new JPanel();
	    empty.setBorder(BorderFactory.createEmptyBorder(60, 0, 40, 0) );
	    empty.setBackground(bg);
	    rightgreen.add(empty);
	    
	    JLabel white_text = new JLabel("Black Pieces Taken");
	    
	    white_text.setForeground(textcl);
	    white_text.setBorder(BorderFactory.createEmptyBorder(0,0,10,60));
	    rightgreen.add(white_text);
	    black_pieces = new JLabel[16];
	    
	    
	    //TitledBorder black_pieces_border = BorderFactory.createTitledBorder("Black Pieces Taken");
	    //black_pieces_border.setTitleColor(Color.WHITE);
	    JPanel white_panel = new JPanel();
	    
	    white_panel.setBorder(BorderFactory.createLineBorder(bd, 5));
	    white_panel.setLayout(new GridLayout(4, 4));
	   // Dimension panelSize = new Dimension(150, 200);
	    white_panel.setBackground(Tile.light_tile);
	  //  black_panel.setPreferredSize(panelSize);
	    for (int i = 0;i<16;i++) {
	    	black_pieces[i] = new JLabel("");
	    	//black_pieces[i].setIcon(new ImageIcon(scaledImage));
	    	black_pieces[i].setBackground(Tile.light_tile);
	    	black_pieces[i].setPreferredSize(new Dimension(30, 30));
	    	white_panel.add(black_pieces[i]);
	    }
	    black_pieces[5].setIcon(null);
	    rightgreen.add(white_panel);
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    JPanel topgreen = new JPanel(new BorderLayout());
	    contentPane.add(topgreen, BorderLayout.NORTH);
	    topgreen.setBorder(BorderFactory.createEmptyBorder(size, size, size, 385));
	    topgreen.setBackground(bg);
	    whos_turn_top = new JLabel("It is "+black_name+"'s turn", JLabel.CENTER);
	   
	    
	    JButton menu = new JButton();
	    ImageIcon menu_icon = new ImageIcon("list.png");
	    Image mimage = menu_icon.getImage();
        Image scaledImagemenu = mimage.getScaledInstance(30,30, Image.SCALE_SMOOTH);
        menu.setBorder(BorderFactory.createLineBorder(bd,5));
	    menu.setIcon(new ImageIcon(scaledImagemenu));
	    menu.setBackground(bg);
	    Menuevt menue = new Menuevt(menu,"main_menu");
	    menu.addActionListener(menue);
	  //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		menu.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
	    topgreen.add(menu, BorderLayout.WEST);
	    
	    
	    
	    
        whos_turn_top.setForeground(bg);
        topgreen.add(whos_turn_top, BorderLayout.CENTER);
	    
  
        
        
        
        
        
        labelPanel = new JPanel(new BorderLayout());
        contentPane.add(labelPanel, BorderLayout.SOUTH);
        
        whos_turn_bottom = new JLabel("It is "+white_name+"'s turn", JLabel.CENTER);
        

        labelPanel.setBackground(bg);
        
        whos_turn_bottom.setBorder(BorderFactory.createEmptyBorder(size, size,size, 320));
        whos_turn_bottom.setForeground(textcl);
        labelPanel.add(whos_turn_bottom, BorderLayout.CENTER);
//        labelPanel.add(white_score, BorderLayout.EAST);
        
        DisplayTurn();
	    
       
	        
	        
		gui.setVisible(true);
		
		
		

		for(int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {

				top[j] = j;
				left[i] = i;
				//PLACING TILES
				if (is_wheat)
				{
					position[i][j] = new Tile(is_wheat,board,top[j],left[i]);
					System.out.println("wheat tile");
					is_wheat = false;

				}
				else if (!is_wheat)
				{
					int top = j;
					int left = i;
					position[i][j] = new Tile(is_wheat,board,top,left);

					is_wheat = true;
				}


				// PLACING PIECES

				//BLACK PIECES
				if ((i == 0 && j == 0) || (i == 0 && j == 7))
				{
					Piece rook_black = new Piece(false,position[i][j],"Rook");
					position[i][j].addPiece(rook_black);
				}
				else if ((i == 0 && j == 1) || (i == 0 && j == 6))
				{
					Piece knight_black = new Piece(false,position[i][j],"Knight");
					position[i][j].addPiece(knight_black);
				}
				else if ((i == 0 && j == 2) || (i == 0 && j == 5))
				{
					Piece bishop_black = new Piece(false,position[i][j],"Bishop");
					position[i][j].addPiece(bishop_black);
				}
				else if (i == 0 && j == 3)
				{
					Piece queen_black = new Piece(false,position[i][j],"Queen");
					position[i][j].addPiece(queen_black);
				}
				else if (i == 0 && j == 4)
				{
					Piece king_black = new Piece(false,position[i][j],"King");
					position[i][j].addPiece(king_black);
				}
				else if (i == 1 && j == 0) {
					Piece pawn_black1 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black1);
				}
				else if (i == 1 && j == 1) {
					Piece pawn_black2 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black2);
				}
				else if (i == 1 && j == 2) {
					Piece pawn_black3 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black3);
				}
				else if (i == 1 && j == 3) {
					Piece pawn_black4 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black4);
				}
				else if (i == 1 && j == 4) {
					Piece pawn_black5 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black5);
				}
				else if (i == 1 && j == 5) {
					Piece pawn_black6 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black6);
				}
				else if (i == 1 && j == 6) {
					Piece pawn_black7 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black7);
				}
				else if (i == 1 && j == 7) {
					Piece pawn_black8 = new Piece(false,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_black8);
				}


				//WHITE PIECES
				if ((i == 7 && j == 0) || (i == 7 && j == 7))
				{
					Piece rook_white = new Piece(true,position[i][j],"Rook");
					position[i][j].addPiece(rook_white);
				}
				else if ((i == 7 && j == 1) || (i == 7 && j == 6))
				{
					Piece knight_white = new Piece(true,position[i][j],"Knight");
					position[i][j].addPiece(knight_white);
				}
				else if ((i == 7 && j == 2) || (i == 7 && j == 5))
				{
					Piece bishop_white = new Piece(true,position[i][j],"Bishop");
					position[i][j].addPiece(bishop_white);
				}
				else if (i == 7 && j == 3)
				{
					Piece queen_white = new Piece(true,position[i][j],"Queen");
					position[i][j].addPiece(queen_white);
				}
				else if (i == 7 && j == 4)
				{
					Piece king_white = new Piece(true,position[i][j],"King");
					position[i][j].addPiece(king_white);
				}
				else if (i == 6 && j == 0) {
					Piece pawn_white1 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white1);
				}
				else if (i == 6 && j == 1) {
					Piece pawn_white2 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white2);
				}
				else if (i == 6 && j == 2) {
					Piece pawn_white3 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white3);
				}
				else if (i == 6 && j == 3) {
					Piece pawn_white4 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white4);
				}
				else if (i == 6 && j == 4) {
					Piece pawn_white5 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white5);
				}
				else if (i == 6 && j == 5) {
					Piece pawn_white6 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white6);
				}
				else if (i == 6 && j == 6) {
					Piece pawn_white7 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white7);
				}
				else if (i == 6 && j == 7) {
					Piece pawn_white8 = new Piece(true,position[i][j],"Pawn");
					position[i][j].addPiece(pawn_white8);
				}
			}
			is_wheat = !is_wheat;

		}//end double for

		for (int n = 0;n<33;n++) {

		}
		gui.setVisible(true);
	}
	
	
	public void options() {
		gui.setTitle("Options");
		gui.setResizable(false);
		gui.setSize(500,500);
		//https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=By%20default%2C%20a%20JFrame%20can,()%20method%20of%20Window%20class.
		gui.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		contentPane = gui.getContentPane();
		contentPane.setLayout(new BorderLayout()); 
		contentPane.setBackground(bg);
        
		//https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
		JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        menuPanel.setBackground(bg);
        
        
        JLabel options_title = new JLabel("Options");
        options_title.setForeground(textcl);
        Font optionsFont = new Font("Arial", Font.PLAIN, 40);
        options_title.setFont(optionsFont);
        menuPanel.add(options_title, gbc);
        gbc.gridy++;
       
       
        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        JButton highlights = new JButton("Highlight mode:"+highlight_option);
        Menuevt highlightevt = new Menuevt(highlights,"highlight");
        highlights.addActionListener(highlightevt);
        //two_player.setMaximumSize(new Dimension(100, 50));
        highlights.setForeground(textcl);
        highlights.setFont(buttonFont);
        highlights.setBackground(Tile.dark_tile);
        highlights.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
        highlights.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
		menuPanel.add(highlights, gbc);
		gbc.gridy++;
		  
	        JButton menu = new JButton("Back");
	        Menuevt menuevt = new Menuevt(menu,"main_menu");
	        menu.addActionListener(menuevt);
	        //two_player.setMaximumSize(new Dimension(100, 50));
	        menu.setForeground(textcl);
	        menu.setFont(buttonFont);
	        menu.setBackground(Tile.dark_tile);
	        menu.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	      //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
	        //-i-get-on-a-jbutton-when-it-s-h-8112
	        menu.setUI (new MetalButtonUI () {
	            @Override
				protected void paintButtonPressed (Graphics g, AbstractButton b) { }
	        });
			menuPanel.add(menu, gbc);
			contentPane.add(menuPanel, BorderLayout.CENTER);
	        
	        gui.setVisible(true);
        
	}//end options
	
	public void changeTheme() {
		gui.setTitle("Themes");
		gui.setResizable(false);
		gui.setSize(700,500);
		//https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=By%20default%2C%20a%20JFrame%20can,()%20method%20of%20Window%20class.
		gui.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		contentPane = gui.getContentPane();
		contentPane.setLayout(new BorderLayout()); 
		contentPane.setBackground(bg);
		
		JPanel top = new JPanel(new BorderLayout());
		top.setBackground(bg);
		JButton menu = new JButton();
	    ImageIcon menu_icon = new ImageIcon("list.png");
	    Image mimage = menu_icon.getImage();
        Image scaledImagemenu = mimage.getScaledInstance(30,30, Image.SCALE_SMOOTH);
        menu.setBorder(BorderFactory.createLineBorder(bd,5));
	    menu.setIcon(new ImageIcon(scaledImagemenu));
	    menu.setBackground(bg);
	    Menuevt menue = new Menuevt(menu,"main_menu");
	    menu.addActionListener(menue);
	  //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		menu.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
		top.add(menu,BorderLayout.WEST);
		
		board_name = new JLabel(Theme.board_names[Theme.board_index]);
		
		Font board_name_Font = new Font("Arial", Font.PLAIN, 20);
		board_name.setFont(board_name_Font);
		board_name.setForeground(textcl);
		board_name.setBorder(BorderFactory.createEmptyBorder(30,280,0,0));
		top.add(board_name, BorderLayout.CENTER);
		
		contentPane.add(top,BorderLayout.NORTH);
		
		
		board_image = new JLabel();
		Image image = Theme.theme_images[Theme.board_index].getImage();
	    Image scaledImage = image.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    board_image.setIcon(new ImageIcon(scaledImage));
	    board_image.setBorder(BorderFactory.createEmptyBorder(0,194,0,0));
	    contentPane.add(board_image,BorderLayout.CENTER);
	    
		JPanel bottom = new JPanel(new FlowLayout());
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		bottom.setBackground(bg);
		
		ImageIcon l_arrow = new ImageIcon("left_arrow.png"); 
		JButton left_arrow = new JButton();
		Themeevt leftevt = new Themeevt("left_arrow");
		left_arrow.addActionListener(leftevt);
		left_arrow.setBackground(Tile.light_tile);
		Image leftarrow = l_arrow.getImage();
	    Image scaledleftarrow = leftarrow.getScaledInstance(30,30, Image.SCALE_SMOOTH);
	    left_arrow.setIcon(new ImageIcon(scaledleftarrow));
	  //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		left_arrow.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
	    
	    
		JButton select = new JButton("Select This Theme");
		Themeevt selectevt = new Themeevt("select");
		select.addActionListener(selectevt);
		select.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
		select.setBackground(Tile.dark_tile);
		select.setForeground(textcl);
		 //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		select.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
		
		JButton right_arrow = new JButton();
		Themeevt rightevt = new Themeevt("right_arrow");
		right_arrow.addActionListener(rightevt);
		right_arrow.setBackground(Tile.light_tile);
		ImageIcon r_arrow = new ImageIcon("right_arrow.png"); 
		Image rightarrow = r_arrow.getImage();
	    Image scaledrightarrow = rightarrow.getScaledInstance(30,30, Image.SCALE_SMOOTH);
	    right_arrow.setIcon(new ImageIcon(scaledrightarrow));
	  //REMOVES HIGHLIGHT https://forums.oracle.com/ords/apexds/post/how-to-disable-the-highlight
        //-i-get-on-a-jbutton-when-it-s-h-8112
		right_arrow.setUI (new MetalButtonUI () {
            @Override
			protected void paintButtonPressed (Graphics g, AbstractButton b) { }
        });
	    
	    
	    
		bottom.add(left_arrow);
		bottom.add(select);
		bottom.add(right_arrow);
		contentPane.add(bottom,BorderLayout.SOUTH);
		
		gui.setVisible(true);
	}
	public static void DisplayTurn() {
		
		if (is_whites_turn) {
			whos_turn_top.setForeground(bg);
	        whos_turn_bottom.setForeground(textcl);
	    } else {
	    	whos_turn_top.setForeground(textcl);
	        whos_turn_bottom.setForeground(bg);
	    }
	}// end display turn
	public void takePiece(String piece_type,boolean is_white) {
			ImageIcon selected_icon = null;
			System.out.println(piece_type);
			System.out.println("is white:"+is_white);
			if (is_white) {
				if (piece_type == "Pawn") {
					selected_icon = Piece.pawn_white;
				}
				else if(piece_type == "Bishop") {
					selected_icon = Piece.bishop_white;
				}
				else if(piece_type == "Rook") {
					selected_icon = Piece.rook_white;
				}
				else if(piece_type == "Knight") {
					selected_icon = Piece.knight_white;
				}
				else if(piece_type == "Queen") {
					selected_icon = Piece.queen_white;
				}
				else if(piece_type == "King") {
					selected_icon = Piece.king_white;
				}
				try {
					ImageIcon piece = selected_icon;
					 Image image = piece.getImage();
				     Image scaledImage = image.getScaledInstance(30,30, Image.SCALE_SMOOTH);
				     white_pieces[current_white].setIcon(new ImageIcon(scaledImage));
				     current_white++;
				}
				catch(Exception e) {
					
				}
				
			}// end if white
			
			else if(!is_white) {
				if (piece_type == "Pawn") {
					selected_icon = Piece.pawn_black;
				}
				else if(piece_type == "Bishop") {
					selected_icon = Piece.bishop_black;
				}
				else if(piece_type == "Rook") {
					selected_icon = Piece.rook_black;
				}
				else if(piece_type == "Knight") {
					selected_icon = Piece.knight_black;
				}
				else if(piece_type == "Queen") {
					selected_icon = Piece.queen_black;
				}
				else if(piece_type == "King") {
					selected_icon = Piece.king_black;
				}
				try {
					ImageIcon piece = selected_icon;
					 Image image = piece.getImage();
				     Image scaledImage = image.getScaledInstance(30,30, Image.SCALE_SMOOTH);
				     black_pieces[current_black].setIcon(new ImageIcon(scaledImage));
				     current_black++;
				}
				catch(Exception e) {
					
				}
				
			     
			}//end if black
			
		     
	}//end takePiece
}


public class game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

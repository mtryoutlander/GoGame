/*
 * made by Jason Miller and Tera Benoit
 * This class manages the UI elements of the game and its gameboard. It displays the various
 * interactable buttons (Pass, placing pieces on the gameboard, and returning to the title screen).
 */
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class GameUI extends JFrame {
	//variables displayed by GUI that are fetched from the business code.
	//String ColorScore = Integer.toString(game.getScore(color));
	String blkScore = Integer.toString(0);
	String whtScore = Integer.toString(0);
    //String ColorName = game.getPlayer(color);
    String blkPlayerName = "Player 01";
    String whtPlayerName = "Player 02";
    //Gamegrid for piece locations and colors.
    int[][] gameGrid = new int[9][9];
	
	/* Coded by Jason Miller:
	 * Default constructor for a new GameUI. It calls showGameUI to display the game and gameboard visuals
	 * and creates a Game object and a Gameboard object to handle the business logic of the game.
	 * 
	 *
	 * We may need to add a second constructor in the final implementation of the game that takes
	 * the two player objects created by the two players logging in and uses those to display
	 * the correct player usernames when the visuals are created. */
    public GameUI()  {
    	Game myGame = new Game();
        GameBoard myGameBoard = new GameBoard();
        this.showGameUI();
    }

    /* Coded by Tera Benoit (gamegrid and button listeners by Jason Miller):
     * This is the initializing class for all of the pieces that will go into the GUI frames for the go board ui.
     *	Displays the game, buttons, and gameboard. It may need to delete the previous instance of
     * the TitleUI. */
    public void showGameUI() {	
	        //Components displayed via the GUI.
	        JButton exitbtn = new JButton("Exit >>");
	        JButton passbtn = new JButton("Pass Turn");
   			passbtn.setAlignmentX(Component.CENTER_ALIGNMENT);	//Aligns the button horizontally.
	
	        JLabel timer = new JLabel("Timer goes Here.");
	
	        JLabel BlkPlayerLabel = new JLabel("Black Player: ");
	        JLabel WhtPlayerLabel = new JLabel("White Player: ");
	        JLabel BlkPlayerNameLabel = new JLabel(blkPlayerName);
	        JLabel WhtPlayerNameLabel = new JLabel(whtPlayerName);
	
	       	JLabel scoreLabelblk = new JLabel("Score: ");
	       	JLabel scoreLabelwht = new JLabel("Score: ");
	       	JLabel scoreAmtWht = new JLabel(whtScore);
	       	JLabel scoreAmtBlk = new JLabel(blkScore);
	       	
	       	//Action listener for the pass button (calls pass() in game).
	       	passbtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {
                    myGame.pass();
                }
            });
	       	
	       	//Action listener for the exit button (calls quit() in game).
	       	exitbtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {
                    myGame.quit();
                }
            });
	
	       	/* Coded by Jason Miller (Tera Benoit came up with the buttonGrid solution):
	       	 * This creates the grid that will form the gameboard in the UI and handles the
	       	 * function/action listener of each location on the gameboard (each location being a button). */
	       	JPanel goGrid = new JPanel();
	       		goGrid.setAlignmentX(Component.CENTER_ALIGNMENT);
	       		goGrid.setLayout(new GridLayout(9,9,0,0));
	       		goGrid.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4)); //Adds border around gameboard.
	       	/* This loop fills the GridLayout with JButtons (each one representing a 
	       	 * location on the board where a piece can be placed). */
	       	JButton[][] buttonGrid = new JButton[9][9];
	       	for (int x = 0; x < 9; x++) {
	       		for (int y = 0; y < 9; y++) {
	       			//Creates the button used for a location on the gameboard.
	       			Icon icon = new ImageIcon("icon.png");
	       			JButton gridButton = new JButton(icon);
	       			
	       			//Alters the button's appearance (will be changed later to form proper intersections).
	       			gridButton.setIconTextGap(0);
	       			gridButton.setContentAreaFilled(false);					//Makes the button same as the background
	       			gridButton.setBorderPainted(false);						//Removes border from the button.
	       			gridButton.setBorder(null);
	       			//gridButton.setPreferredSize(new Dimension(40, 40));		//Changes size of each button.
	       			
	       			//Loads the buttonGrid with the gridButtons so that we can use it to find the button's location later.
	       			buttonGrid[x][y] = gridButton;
	       				       			
	       			//Action listener for each button in the grid.
	       			gridButton.addActionListener(new ActionListener()
	                {
	                    public void actionPerformed(ActionEvent e) {
	                        JButton button = (JButton)e.getSource();
	                        for (int x = 0; x < 9; x++) {
	            	       		for (int y = 0; y < 9; y++) {
	            	       			//If the button matches the one in 
	            	       			if (buttonGrid[x][y] == button) {
	            	       				myGameBoard.move(x, y);
	            	       			}	            	       				
	            	       		}
	                        }	
	                    }
	                });
	                goGrid.add(gridButton);
	       		}
	       	}
	       	
	      //middle frame, contains the game grid and the pass turn button
	        JPanel middleFrame = new JPanel();
	        	middleFrame.setLayout(new BoxLayout(middleFrame, BoxLayout.X_AXIS));
	        	middleFrame.add(Box.createHorizontalGlue());
	        	middleFrame.add(goGrid);						//Adds the goGrid (the gameboard).
	        	middleFrame.add(Box.createHorizontalGlue());
	
	        //top frame, contains an exit button and the turn timer.
	       	JPanel topFrame = new JPanel();
	         	topFrame.setLayout(new BorderLayout());
	        	topFrame.add(exitbtn, BorderLayout.EAST);
	          	topFrame.add(timer, BorderLayout.WEST);	    
	          	
	         //score grids for displaying user score.
	    	 JPanel blkScoreGrid = new JPanel();
	    	     blkScoreGrid.setLayout(new GridLayout(2,2));
	    	     blkScoreGrid.add(BlkPlayerLabel);
	    	     blkScoreGrid.add(BlkPlayerNameLabel);
	    	     blkScoreGrid.add(scoreLabelblk);
	    	     blkScoreGrid.add(scoreAmtBlk);
	    	
	    	 JPanel whtScoreGrid = new JPanel();
	    	     whtScoreGrid.setLayout(new GridLayout(2,2));
	    	     whtScoreGrid.add(WhtPlayerLabel);
	    	     whtScoreGrid.add(WhtPlayerNameLabel);
	    	     whtScoreGrid.add(scoreLabelwht);
	    	     whtScoreGrid.add(scoreAmtWht);

	        //bottom frame, contains the two player's scores and the pass button.
        	JPanel bottomFrame = new JPanel();
        		bottomFrame.setLayout(new BoxLayout(bottomFrame, BoxLayout.X_AXIS));
        		bottomFrame.add(Box.createHorizontalGlue());
        		bottomFrame.add(blkScoreGrid);
        		bottomFrame.add(Box.createHorizontalGlue());
        		bottomFrame.add(passbtn);
        		bottomFrame.add(Box.createHorizontalGlue());
        		bottomFrame.add(whtScoreGrid);
        		bottomFrame.add(Box.createHorizontalGlue());

            //creates the main container that will hold all the other elements, and then adds those elements to itself in their proper position.
        	JPanel mainFrame = new JPanel();
            	mainFrame.setLayout(new BorderLayout());
            	mainFrame.add(topFrame, BorderLayout.NORTH);
            	mainFrame.add(middleFrame, BorderLayout.CENTER);
            	mainFrame.add(bottomFrame, BorderLayout.SOUTH);

            	add(mainFrame);      	
    }    
    
    /*Returns to the titleUI when the back button is pressed.
     * Will be filled out when a back button is necessary (after the first stage of implementation). */
    public void titleUI() {
    	//Hides GameUI and shows the TitleUI again. Clears the board and any temporary data.
    }    

    /* Coded by Jason Miller:
     * This method takes the gameGrid passed by GameBoard at the end of the capture() method
     * and uses it to update the gameboard in the UI.
     * After it is passed the grid, it loops through gameGrid and displays
     * the corresponding white, black, or absent gamepieces to the player.
     * In the 2-dimensional array, 0 = no piece; 1 = black piece; 2 = white piece. */
    public void updateUI(int[][] grid) {
    	int piece = 0;
    	/*The outer loop progresses horizontally along the x-axis (from 0 to 8).
    	 * The inner loop progresses vertically along the y-aix (from 0 to 8).
    	 * This means that the loop goes from top to bottom in the first column, then does the
    	 * same through the second column, then third, and so on.
    	 * The grid in the Ui is updated at every point in gameGrid so that they match.*/
    	for (int x = 0; x < 9; x++) {
    		for (int y = 0; y < 9; y++) {
    			/* If the passed grid piece at this location differs from the gameGrid's
    			 * at this location, set the gameGrid location to match the passed on. */
    			if (grid[x][y] != gameGrid[x][y]) {
    				gameGrid[x][y] = grid[x][y];
    			}
    			//Here UI is updated to display the piece (or lack thereof) at the x, y point indicated.
    			
    		}
    	}

    //*!*!*! remember to add get method for player's scores and run it here to update the score display !*!*!*!
    }
}
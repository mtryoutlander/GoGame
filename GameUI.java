/*
 * made by Jason Miller and Tera Benoit
 * This class manages the UI elements of the game and its gameboard. It displays the various
 * interactable buttons (Pass, placing pieces on the gameboard, and returning to the title screen).
 */
import java.awt.*;
import javax.swing.*;
public class GameUI extends JFrame {

	/*Default constructor for a new GameUI. It calls showGameUI to display the game and gameboard visuals
	 * and creates a Game object and Gameboard object to handle the business logic of the game.
	 *
	 * We may need to add a second constructor in the final implementation of the game that takes
	 * the two player objects created by the two players logging in and uses those to display
	 * the correct player usernames when the visuals are created. */
    public GameUI()  {
    	public Game myGame = new Game;
        public GameBoard myGameBoard = new GameBoard;
        this.showGameUI();
    }

    /* Coded by Tera Benoit:
     * This is the initializing class for all of the pieces that will go into the GUI frames for the go board ui.
     *	Displays the game, buttons, and gameboard. It may need to delete the previous instance of
     * the TitleUI. */
    	public showGameUI(){
        	// variables displayed by GUI that are fetched from the business code.
        		//String ColorScore = Integer.toString(game.getScore(color));
        	String blkScore = Integer.toString(1);
        	String whtScore = Integer.toString(2);

        		//String ColorName = game.getPlayer(color);
        	String blkPlayerName = "Jason Miller";
        	String whtPlayerName = "Tera Benoit";

        	//Components displayed via the gui.

        	JButton exitbtn = new JButton("Exit >>");
        	JButton passbtn = new JButton("Pass Turn");

        	JLabel timer = new JLabel("Timer goes Here.");

        	JLabel BlkPlayerLabel = new JLabel("Black Player: ");
        	JLabel WhtPlayerLabel = new JLabel("White Player: ");
        	JLabel BlkPlayerNameLabel = new JLabel(blkPlayerName);
        	JLabel WhtPlayerNameLabel = new JLabel(whtPlayerName);

        	JLabel scoreLabelblk = new JLabel("Score: ");
        	JLabel scoreLabelwht = new JLabel("Score: ");
        	JLabel scoreAmtWht = new JLabel(whtScore);
        	JLabel scoreAmtBlk = new JLabel(blkScore);

        	//goGrid jpanel, set as a 9 by 9 grid. Needs to be populated.
        	JPanel goGrid = new JPanel();
        		goGrid.setLayout(new GridLayout(9,9));

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

          //top frame, contains an exit button and the turn timer.
        	JPanel topFrame = new JPanel();
          		topFrame.setLayout(new BorderLayout());
          		topFrame.add(exitbtn, BorderLayout.EAST);
          		topFrame.add(timer, BorderLayout.WEST);

          //middle frame, contains the game grid and the pass turn button
          	JPanel middleFrame = new JPanel();
          		middleFrame.setLayout(new BorderLayout());
          		middleFrame.add(goGrid, BorderLayout.NORTH); //this adds the goGrid
          		middleFrame.add(passbtn, BorderLayout.SOUTH);

          //bottom frame, contains the two player's scores.
        	JPanel bottomFrame = new JPanel();
            	bottomFrame.setLayout(new BorderLayout());
            	bottomFrame.add(blkScoreGrid, BorderLayout.WEST);
            	bottomFrame.add(whtScoreGrid, BorderLayout.EAST);


          //create's the main container that will hold all the other elements, and then adds those elements to itself in their proper position.
        	JPanel mainFrame = new JPanel();
            	mainFrame.setLayout(new BorderLayout());
            	mainFrame.add(topFrame, BorderLayout.NORTH);
            	mainFrame.add(middleFrame, BorderLayout.CENTER);
            	mainFrame.add(bottomFrame, BorderLayout.SOUTH);


            add(mainFrame);
    	}

    }

    /*Displays the game, buttons, and gameboard. It may need to delete the previous instance of
     * the TitleUI. */


    /*Creates a new TitleUI and then displays it when the user clicks the
     * button to return to the title screen. */
    public void titleUI() {
    	public TitleUI myTitleUI = new TitleUI;
    }

    /*This method takes the gameGrid passed by GameBoard at the end of the capture() method
     * and uses it to update the gameboard in the UI.
     * After it is passed the grid, it loops through gameGrid and displays
     * the corresponding white, black, or absent gamepieces to the player. */
    public void updateUI(int[][] gameGrid) {
    	int piece = 0;
    	/*The outer loop progresses horizontally along the x-axis (from 0 to 8).
    	 * The inner loop progresses vertically along the y-aix (from 0 to 8).
    	 * This means that the loop goes from top to bottom in the first column, then does the
    	 * same through the second column, then third, and so on.
    	 * The grid in the Ui is updated at every point in gameGrid so that they match.*/
    	for (int x = 0; x < 8; x++) {
    		for (int y = 0; y < 8; y++) {
    			piece = gameGrid[x][y];
    			//Here the program will update the UI to display the piece (or lack thereof) at the x, y point indicated.
    		}
    	}

    	//*!*!*! remember to add get method for player's scores and run it here to update the score display !*!*!*!
    }




}

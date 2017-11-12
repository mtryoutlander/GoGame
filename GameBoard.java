public class GameBoard {

    boolean playerTurn;
    int[][] gameGrid = new int[9][9];
    int[][] gameGridPast = new int[9][9];
    int piece;
    int tempScore;

    GameBoard() {
        playerTurn = false;

        for (int i = 0; i < gameGrid.length; i++) {
            for (int k = 0; k < gameGrid.length; k++) {
                gameGrid[i][k] = 0;
                gameGridPast[i][k] = 0;
            }
        }
        piece = 1;
        tempScore = 0;
    }

    public String move(int xPostion, int yPostion) {
        if (playerTurn)
            piece = 2;
        else
            piece = 1;
        if (gameGrid[xPostion][yPostion] != 0)
            return "Stone already their";
        gameGrid[xPostion][yPostion] = piece;

        if (!capture()) {
            for (int i = 0; i < gameGrid.length; i++) {
                for (int k = 0; k < gameGrid.length; k++) {
                    gameGrid[i][k] = gameGridPast[i][k];
                }
            }
            return "Sucide move";

        }

        boolean koRule = true;
        for (int i = 0; i < gameGrid.length; i++) {
            for (int k = 0; k < gameGrid.length; k++) {
                if (gameGrid[i][k] != gameGridPast[i][k]) {
                    koRule = false;
                    break;
                }
            }
            if (!koRule)
                break;
        }

        if (koRule) {
            for (int i = 0; i < gameGrid.length; i++) {
                for (int k = 0; k < gameGrid.length; k++) {
                    gameGrid[i][k] = gameGridPast[i][k];
                }
            }
            return "Ko Rule broke";
        }
        for (int i = 0; i < gameGrid.length; i++) {
            for (int k = 0; k < gameGrid.length; k++) {
                gameGridPast[i][k] = gameGrid[i][k];
            }
        }

        //updateScore(playerTurn,tempScore);
        //updateUI();
        playerTurn = !playerTurn;
        return "";
    }

    private boolean capture() {
        return true;
    }

}

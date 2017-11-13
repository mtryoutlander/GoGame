/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgogo;

/**
 *
 * @author akash
 */
public class Game {
    
    private int newAttr,passCount,blackPieces,whitePieces;
    public GameUI gameUI=new GameUI();
    public Game(){
        newAttr=0;
        passCount=0;
        blackPieces=0;
        whitePieces=0;
    }
    public void score(){
    }
    public void victory(){
    }
    public void endTurn(){
    }
    public void pass(int passCount){
        switch (passCount){
            case 0:
                passCount++;
                endTurn();
                break;
            case 1:
                passCount++;
                endGame();
                break;
            default:
                gameUI.passCount=0;
        }
    
        
        
    }
    public void play(){
    }
    public void quit(){
    }
    public void endGame(){
    }
    public void resetTimer(){
    }
    
}

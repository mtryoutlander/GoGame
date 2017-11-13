/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
In this file, Sanjay declare the function and me(akash) defines the function, we did kind of pair programming//
*/
package teamgogo;

/**
 *
 * @author akash
 */
public class Game //Main class
{
    boolean gameEnd=false;
    private int newAttr,passCount,blackPieces,whitePieces;
GameBoard gmBoard;    

    public Game() //constructor 
    {
        newAttr=0;
        passCount=0;
        blackPieces=0;
        whitePieces=0;
        gmBoard=new GameBoard();
//GameBoard gmBoard=new GameBoard();
    }
    public void score(){
    }
    public void victory(){
    }
    public void endTurn(){
    
    }
    public void pass()//This method helps to update the class variable pass
    {
        if (this.passCount==0){
               
        passCount++;
        this.endTurn();
        }else{
        
        endGame();        
                }
    }    
public void play(){
    }
    public void quit(){
    
    }
    public void endGame()//the GameUI is updated when the endgame happens
    { 
        this.gameEnd=true;
    }
    
    public void resetTimer(){
    
    }
    


}
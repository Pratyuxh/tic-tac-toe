
import java.util.Arrays;
public class Game {

    private char turn; // who's turn is it, 'x' or 'o' ? x always starts
    private boolean twoPlayer; // true if this is a 2 player game, false if AI playing
    private char [][] grid; // a 2D array of chars representing the game grid
    private int freeSpots; // counts the number of empty spots remaining on the board (starts from 9  and counts down)
    private static GameUI gui;

    
    public Game() {
        newGame(false);
    }

   
    public void newGame(boolean twoPlayer){
        
        this.twoPlayer = twoPlayer;

        
        grid = new char[3][3];
       
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                grid[i][j] = '-';
            }
        }
        
        freeSpots = 9;
       
        turn = 'x';
    }

    public char gridAt(int i, int j){
        if(i>=3||j>=3||i<0||j<0)
            return '!';
        return grid[i][j];
    }

    
    public boolean playAt(int i, int j){
        
        if(i>=3||j>=3||i<0||j<0)
            return false;
       
        if(grid[i][j] != '-'){
            return false; 
        }
        
        grid[i][j] = turn;
       
        freeSpots--;
        return true;
    }

    public String toString(){
        return Arrays.deepToString(this.grid);
    }

  
    public boolean doChecks() {
        String winnerMessage = checkGameWinner(grid);
        if (!winnerMessage.equals("None")) {
            gui.gameOver(winnerMessage);
            newGame(false);
            return true;
        }
        return false;
    }

    public void nextTurn()
    {if(!twoPlayer){
            if(freeSpots == 0){
                return ; 
            }
            int ai_i, ai_j;
            do {
                
                ai_i = (int) (Math.random() * 3);
                ai_j = (int) (Math.random() * 3);
            }while(grid[ai_i][ai_j] != '-'); 
            grid[ai_i][ai_j] = 'o';
           
            freeSpots--;
        }
        else{
           
            if(turn == 'x'){
                turn = 'o';
            }
            else{
                turn = 'x';
            }
        }
        return;
    }


   
    public String checkGameWinner(char [][]grid){
        String result = "None";
        
        return result;
    }

   
    public static void main(String args[]){
        Game game = new Game();
        gui = new GameUI(game);
    }

}

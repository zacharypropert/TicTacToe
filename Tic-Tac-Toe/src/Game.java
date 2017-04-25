import java.util.*;
import javax.swing.*;
/**
 * The heart of a basic tic-tac-toe game.
 * Almost all of the game mechanics are in this class.
 * 
 * v0.01 Just started the project to code a tic-tac-toe game.
 * v0.4 Game is currently working and notifies when someone has won.
 * v0.5 Game mechanics finished, made it so a player can not choose a spot that is already taken.
 * v1 A lot of functionality has been changed
 * 		- changed the way the game board is displayed
 * 		- simplified the method where it checks if there is a winner with loops
 * 		- Added a play again feature
 * 		- the player now chooses their desire location by clicking on the spot
 * 
 * 
 * @Zachary Propert
 * @1
 */
public class Game
{
    private GUI gui;
    private Computer comp;
    public LinkedHashMap<Integer, String> board;
    private int turn;

    /**
     * Constructor for objects of class Game
     */
    public Game(int t, Controller c, int playStyle)
    {
        board = new LinkedHashMap<Integer, String> ();
        turn = t;
        gui = new GUI(c, this);
        gui.setTurn(turn);
        buildBoard();
        /* 	Not yet implemented, plan to be used when AI is added
        if(playStyle == 0){
        	comp = new Computer(c.getDifficulty(), this, gui);
        }
        */
    }
    

    /**
     *  Creates the hashmap with a total of 9 entries each representing a spot on the tic tac toe board.
     */
    public void buildBoard()
    {
    	for(int i=1;i<10;i++){
    		board.put(i, Integer.toString(i));
    	}
    }
    
    /**
     * Returns whose turn it is, with 0 representing X and 1 representing O
     * @return
     */
    public int getTurn()
    {
        return turn;
    }

    /**
     * 
     * @param key, the key for the hashmap
     * @param xo the string determining if the value for the key will be either X or O.
     * 
     */
    public void play(int key, String xo){
    		board.put(key, xo);
    		if (turn == 0){
    			turn = 1;
    			gui.setTurn(turn);
    		}else{
    			turn = 0;
    			gui.setTurn(turn);
    		}
    		if(checkDraw()){
    			gui.showDraw();
    		}
    		checkWin();
    }
    
    /**
     * Checks whether a board location already has an X or O on it, if it does a pop-up 
     * will display "Invalid location, please select another spot." and will not update the game board.
     * Allowing a spot to only be used once each game.
     * @param pos the JTextField from GUI that is being checked
     * @return
     */
	public boolean emptySpot(JTextField pos){
    	if(pos.getText().matches("X") || pos.getText().matches("O")){
    		JOptionPane.showMessageDialog(null, "\nInvalid location, please select another spot.\n");
    		return false;
    	}else{
    		return true;
    	} 
    	
    }
	
	/**
	 * Checks if anyone has won yet and returns true or false depending if there is a winner or not,
	 * @return
	 */
    public boolean checkWin()
    {
    	boolean won = false;
    	
    	for(int x=1;x<10;x=x+3){ 	//Checks if there is a winner across
    		if(board.get(x).equals(board.get(x+1)) && board.get(x+1).equals(board.get(x+2)))
            {
                won = true;
				gui.showWinner(board.get(x));
            }
    	}
    	
    	for(int y=1;y<4;y++){     	// Checks if there is a winner up and down
    		if(board.get(y).equals(board.get(y+3)) && board.get(y+3).equals(board.get(y+6)))
            {
                won = true;
				gui.showWinner(board.get(y));
            }
    	}

    	//Checks if there is a winner diagonally
    	 if(board.get(1).equals(board.get(5)) && board.get(5).equals(board.get(9)))
         {
             won = true;
             gui.showWinner(board.get(1));
         }
         if(board.get(3).equals(board.get(5)) && board.get(5).equals(board.get(7)))
         {
             won = true;
             gui.showWinner(board.get(3));
         }
        return won;
    }
    
    public boolean checkDraw(){
    	boolean draw = false;
    	int count = 0;
    	for(int x =1; x<10; x++){
    		if(board.get(x).matches("X") || board.get(x).matches("O")){
    			count++;
    		}
    	}
    	if(count == 9){
    		draw = true;
    	}
    	return draw;
    }
}

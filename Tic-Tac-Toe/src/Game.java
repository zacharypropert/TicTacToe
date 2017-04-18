import java.util.*;
import javax.swing.*;
/**
 * The heart of a basic tic-tac-toe game.
 * Almost all of the game mechanics are in this class.
 * 
 * v0.01 Just started the project to code a tic-tac-toe game.
 * v0.4 Game is currently working and notifies when someone has won.
 * v0.5 Game mechanics finished, made it so a player can not choose a spot that is already taken.
 * 
 * 
 * 
 * @Zachary Propert
 * @0.5
 */
public class Game
{
    private GUI gui;
    private HashMap<Integer, String> board;
    //     Random rgen = new Random();
    private int turn;

    /**
     * Constructor for objects of class Game
     */
    public Game(int t)
    {
        board = new HashMap<Integer, String> ();
        turn = t;
        gui = new GUI();
        JOptionPane.showMessageDialog(null, "Choose a position between 1-9 and choose to enter either x or o \n");
        gui.setTurn(turn);
        buildBoard();

        //         for(int x=1; x<10; x++)
        //         {
        //             gui.drawBoard(x , board.get(x));
        //         }
        printBoard();
    }

    /**
     * 
     */
    public void buildBoard()
    {
        // put your code here
        board.put(1," 1 ");
        board.put(2," 2 ");
        board.put(3," 3 ");
        board.put(4," 4 ");
        board.put(5," 5 ");
        board.put(6," 6 ");
        board.put(7," 7 ");
        board.put(8," 8 ");
        board.put(9," 9 ");
    }

    public void printBoard()
    {
        //turn();
        //         gui.appendText(board.get(1) + "|" + board.get(2) + "|" + board.get(3));
        //         gui.appendText("---+---+---");
        //         gui.appendText(board.get(4) + "|" + board.get(5) + "|" + board.get(6));
        //         gui.appendText("---+---+---");
        //         gui.appendText(board.get(7) + "|" + board.get(8) + "|" + board.get(9) + "\n");
        for(int x=1; x<10; x++)
        {
            gui.drawBoard(x , board.get(x));
        }
    }

    public void play(int pos, String xo)
    {   
        if(turn == 0) //if its x's turn
        {
            if(xo.matches("x") || xo.matches("X")){
                if(xo.matches("x"))
                    xo = xo.toUpperCase();

                if(board.get(pos).matches(" X ") || board.get(pos).matches(" O "))
                {
                    JOptionPane.showMessageDialog(null, "\nSpot is already taken. Try again!\n");
                    turn=0;
                    printBoard();
                }else{
                    board.put(pos," " + xo + " ");
                    turn = 1;
                    printBoard();
                }

            }else{
                JOptionPane.showMessageDialog(null, " \n Not a Valid character you can only enter X's \n Try again: \n");
                turn=0;
                printBoard();
            }
        }
        else if(turn == 1) //if its o's turn
        {
            if(xo.matches("o") || xo.matches("O")){
                if(xo.matches("o"))
                    xo = xo.toUpperCase();

                if(board.get(pos).matches(" O ") || board.get(pos).matches(" X "))
                {
                    JOptionPane.showMessageDialog(null, "\nSpot is already taken. Try again! \n");
                    turn=1;
                    printBoard();
                }else{
                    board.put(pos," " + xo + " ");
                    turn = 0;
                    printBoard();
                }

            }else{
                JOptionPane.showMessageDialog(null, "\n Not a Valid character you can only enter O's \n Try again: \n");
                turn = 1;
                printBoard();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "ERROR!!!!");
        }
        gui.setTurn(turn);
        win(xo);
        
    }

    public int getTurn()
    {
        return turn;
    }

    public void setTurn(int turn)
    {
        turn = this.turn;
    }

    /** 
     * Tests if there was a win
     */
    public boolean win(String x)
    {
        boolean won = false;

        if(board.get(1).matches(" " + x + " ") && board.get(2).matches(" " + x + " ") && board.get(3).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won across the top!");

        }
        if(board.get(4).matches(" " + x + " ") && board.get(5).matches(" " + x + " ") && board.get(6).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won across the middle!");

        }
        if(board.get(7).matches(" " + x + " ") && board.get(8).matches(" " + x + " ") && board.get(9).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won across the bottom!");

        }
        if(board.get(1).matches(" " + x + " ") && board.get(4).matches(" " + x + " ") && board.get(7).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won vertically on the left!");

        }
        if(board.get(2).matches(" " + x + " ") && board.get(5).matches(" " + x + " ") && board.get(8).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won vertically in the middle!");

        }
        if(board.get(3).matches(" " + x + " ") && board.get(6).matches(" " + x + " ") && board.get(9).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won vertically on the right!");

        }
        if(board.get(1).matches(" " + x + " ") && board.get(5).matches(" " + x + " ") && board.get(9).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won diagonally!");

        }
        if(board.get(3).matches(" " + x + " ") && board.get(5).matches(" " + x + " ") && board.get(7).matches(" " + x + " "))
        {
            won = true;
            JOptionPane.showMessageDialog(null, x.toUpperCase() + " won diagonally!");

        }
        return won;
    }

}

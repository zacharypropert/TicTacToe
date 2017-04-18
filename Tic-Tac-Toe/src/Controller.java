import java.util.*;
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{
    // instance variables - replace the example below with your own
    private GUI gui;
    private static Game game;
    private static int turn;
    static Random rgen = new Random();

    /**
     * Constructor for objects of class Controller
     */
    public static void main(String[] args)
    {
        turn = rgen.nextInt(2);
        game = new Game(turn);
        game.printBoard();
    }

    public void playGame(int p, String n)
    {
        game.play(p,n);
    }

//     public void play()
//     {
//         String temp="!";
//         if(game.getTurn() == 0){
//             temp = "X";
//         }else{
//             temp = "O";
//         }
//         game.play(gui.getSpot(),temp); 
//     }

}

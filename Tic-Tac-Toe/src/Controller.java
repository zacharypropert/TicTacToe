import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Controller
{
    private GUI gui;
    private Game game;
    private int turn;
    Random rgen = new Random();
	private static JFrame frame;
	private Container contentPane;
	
	private static JFrame diffFrame;
	private Container diffcontentPane;
	private int playStyle;
	private int difficulty;
    
    public static void main(String[] args){
    	Controller c = new Controller();
    }

    /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {

        turn = rgen.nextInt(2);
        game = new Game(turn, this, 1);
        //buildPlayStyle(this); //not yet used will be used when the AI is implemented
    }
    
    /**
     * Builds the gui for the selection menu of either vs Player or vs Computer
     * @param c
     */
    public void buildPlayStyle(Controller c){
    	Font arial = new Font("Arial", Font.BOLD, 15);
    	frame = new JFrame("Tic Tac Toe");
    	frame.setSize(250, 150);
		frame.setResizable(false);
		contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(3,1));
		
		JLabel choose = new JLabel("How are you planning to play?");
		choose.setHorizontalAlignment(SwingConstants.CENTER);
		choose.setFont(arial);
		contentPane.add(choose);
		
		JButton vsComp = new JButton("vs Computer");
		vsComp.setFont(arial);
		vsComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playStyle = 0;
				chooseDifficulty(c);
				frame.setVisible(false);
			}
		});
		contentPane.add(vsComp);
		
		JButton vsPlayer = new JButton("vs Player");
		vsPlayer.setFont(arial);
		vsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playStyle = 1;
				game = new Game(turn, c, playStyle);
				frame.setVisible(false);
			}
		});
		contentPane.add(vsPlayer);
		
		screenCenter(frame, frame.getSize());
		frame.setVisible(true);
    }
    
    /**
     * Builds the gui for the computer difficulty selection menu
     * @param c
     */
    public void chooseDifficulty(Controller c){
    	Font arial = new Font("Arial", Font.BOLD, 15);
    	diffFrame = new JFrame("Computer Difficulty");
    	diffFrame.setSize(200, 150);
		diffFrame.setResizable(false);
		diffcontentPane = diffFrame.getContentPane();
		diffcontentPane.setLayout(new GridLayout(3,1));
		
		JLabel chooseDifficulty = new JLabel("Computer Difficulty");
		chooseDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		chooseDifficulty.setFont(arial);
		diffcontentPane.add(chooseDifficulty);
		
		JButton easy = new JButton("Easy");
		easy.setFont(arial);
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 0;
				game = new Game(turn, c, playStyle);
				diffFrame.setVisible(false);
			}
		});
		diffcontentPane.add(easy);
		
		JButton hard = new JButton("Hard");
		hard.setFont(arial);
		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 1;
				game = new Game(turn, c, playStyle);
				diffFrame.setVisible(false);
			}
		});
		diffcontentPane.add(hard);
		
		screenCenter(diffFrame, diffFrame.getSize());
		diffFrame.setVisible(true);
    }
    
    public int getDifficulty(){
    	return difficulty;
    }
    
	public static void screenCenter(JFrame frame, Dimension window){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth()-window.getWidth())/2);
		int y = (int) ((d.getHeight()-window.getHeight())/2);
		frame.setLocation(x,y);
	}
}

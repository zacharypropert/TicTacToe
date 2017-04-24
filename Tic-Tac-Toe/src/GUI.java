import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Write a description of class GUI here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI {
	// instance variables - replace the example below with your own
	private static JFrame frame;
	private Container contentPane;
	private JLabel whoseTurn;
	private JButton play;

	private JTextField pos1;
	private JTextField pos2;
	private JTextField pos3;
	private JTextField pos4;
	private JTextField pos5;
	private JTextField pos6;
	private JTextField pos7;
	private JTextField pos8;
	private JTextField pos9;
	

	private Game game;
	private Controller control;
	private String turn;
	private ArrayList<JTextField> posList; //currently not being used

	/**
	 * Constructor for objects of class GUI
	 */
	public GUI(Controller c, Game g) {
		Build();
		control = c;
		game = g;
		//posList = new ArrayList<JTextField>();
	}

	/**
	 * Builds the GUI
	 */
	public void Build() {
		Font arial = new Font("Arial", Font.BOLD, 30);
		Font boardFont = new Font("Arial", Font.BOLD, 175);

		frame = new JFrame("Tic Tac Toe");
		frame.setSize(300, 300);
		frame.setResizable(false);

		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel Center = new JPanel();
		Center.setLayout(new GridLayout(3,3));

		pos1 = new JTextField("    ", 1);
		pos1.setFont(boardFont);
		pos1.setHorizontalAlignment(SwingConstants.CENTER);
		pos1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.black));
		pos1.setEditable(false);
		pos1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!game.checkWin() && game.emptySpot(pos1)){
                	pos1.setText(turn);
                	game.play(1, turn);
                }
             }
        });
		Center.add(pos1);
		pos2 = new JTextField("   ");
		pos2.setFont(boardFont);
		pos2.setHorizontalAlignment(SwingConstants.CENTER);
		pos2.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.black));
		pos2.setEditable(false);
		pos2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	if(!game.checkWin() && game.emptySpot(pos2)){
            		pos2.setText(turn);
                	game.play(2, turn);
            	}
            }
        });
		Center.add(pos2);
		pos3 = new JTextField("   ");
		pos3.setFont(boardFont);
		pos3.setHorizontalAlignment(SwingConstants.CENTER);
		pos3.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.black));
		pos3.setEditable(false);
		pos3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos3)){
            		 pos3.setText(turn);
            		 game.play(3, turn);
            	 }
            }
        });
		Center.add(pos3);
		pos4 = new JTextField("   ");
		pos4.setFont(boardFont);
		pos4.setHorizontalAlignment(SwingConstants.CENTER);
		pos4.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));
		pos4.setEditable(false);
		pos4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos4)){
            		 pos4.setText(turn);
            		 game.play(4, turn);
            	 }
            }
        });
		Center.add(pos4);
		pos5 = new JTextField("   ");
		pos5.setFont(boardFont);
		pos5.setHorizontalAlignment(SwingConstants.CENTER);
		pos5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		pos5.setEditable(false);
		pos5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos5)){
            		 pos5.setText(turn);
            		 game.play(5, turn);
            	 }
            }
        });
		Center.add(pos5);	
		pos6 = new JTextField("   ");
		pos6.setFont(boardFont);
		pos6.setHorizontalAlignment(SwingConstants.CENTER);
		pos6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.black));
		pos6.setEditable(false);
		pos6.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos6)){
            		 pos6.setText(turn);
            		 game.play(6, turn);
            	 }
            }
        });
		Center.add(pos6);
		pos7 = new JTextField("   ");
		pos7.setFont(boardFont);
		pos7.setHorizontalAlignment(SwingConstants.CENTER);
		pos7.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));
		pos7.setEditable(false);
		pos7.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos7)){
            		 pos7.setText(turn);
            		 game.play(7, turn);
            	 }
            }
        });
		Center.add(pos7);
		pos8 = new JTextField("   ");
		pos8.setFont(boardFont);
		pos8.setHorizontalAlignment(SwingConstants.CENTER);
		pos8.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		pos8.setEditable(false);
		pos8.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos8)){
            		 pos8.setText(turn);
            		 game.play(8, turn);
            	 }
            }
        });
		Center.add(pos8);
		pos9 = new JTextField("   ");
		pos9.setFont(boardFont);
		pos9.setHorizontalAlignment(SwingConstants.CENTER);
		pos9.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.black));
		pos9.setEditable(false);
		pos9.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	 if(!game.checkWin() && game.emptySpot(pos9)){
            		 pos9.setText(turn);
            		 game.play(9, turn);
            	 }
            }
        });
		Center.add(pos9);
		/*
		 * Not yet implemented, plans are to use this so the computer can change the tiles
		posList.add(pos1);
		posList.add(pos2);
		posList.add(pos3);
		posList.add(pos4);
		posList.add(pos5);
		posList.add(pos6);
		posList.add(pos7);
		posList.add(pos8);
		posList.add(pos9);
		*/
		contentPane.add(Center, BorderLayout.CENTER);
		JPanel north = new JPanel();
		north.setFont(arial);
		whoseTurn = new JLabel("");
		whoseTurn.setFont(arial);
		north.add(whoseTurn);
		contentPane.add(north, BorderLayout.NORTH);
		
		screenCenter(frame.getSize());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Resets the board, used in the showWinner method by the play again JButton.
	 */
	public void clearBoard(){
		pos1.setText("   ");
		pos2.setText("   ");
		pos3.setText("   ");
		pos4.setText("   ");
		pos5.setText("   ");
		pos6.setText("   ");
		pos7.setText("   ");
		pos8.setText("   ");
		pos9.setText("   ");
	}
	
	/**
	 * Updates the top of the frame with who's turn it is
	 * 
	 */
	public void setTurn(int s) {
		if (s == 0) {
			whoseTurn.setText("It's X's turn! \n");
			turn = "X";
			whoseTurn.setForeground(Color.blue);
		} else {
			whoseTurn.setText("It's O's turn! \n");
			turn = "O";
			whoseTurn.setForeground(Color.red);
		}
	}
	
	/**
	 * Displays the winner on the top of the frame, and adds a play again button along the bottom to allow
	 * continuous play.
	 * 
	 * @param s represents who the winner is, either X or O
	 */
	public void showWinner(String s){
		Font winner = new Font("Arial", Font.BOLD, 40);
		Font button = new Font("Arial", Font.BOLD, 30);
		whoseTurn.setFont(winner);
		whoseTurn.setForeground(Color.red);
		whoseTurn.setText(s + " HAS WON!!");
		
		play = new JButton("Play Again?");
		play.setFont(button);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearBoard();
				game.buildBoard();
				setTurn(game.getTurn());
				game.checkWin();
				play.setVisible(false);
			}
		});
		contentPane.add(play, BorderLayout.SOUTH);
	}
	
	/**
	 * Returns the ArrayList of the pos JTextFields
	 * currently not implemented
	 */
	public ArrayList<JTextField> getList(){
		return posList;
	}
	
	/**
	 * Aligns the graphics to the center of the screen.
	 * 
	 */
	public static void screenCenter(Dimension window){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth()-window.getWidth())/3);
		int y = (int) ((d.getHeight()-window.getHeight())/3);
		frame.setLocation(x,y);
	}

	

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private Container contentPane;
    private JTextArea text;
    private JLabel whoseTurn;
    private JComboBox<Integer> position;

    private Game game;
    private Controller control;
    private GridCanvas gc;
    private Graphics g;

    private String turn;
    private int spot;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        Build();
    }

    public void Build()
    {
        Font arial = new Font("Arial", Font.BOLD, 20);

        frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 300);
        frame.setResizable(false);

        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setFont(arial);
        whoseTurn = new JLabel("");
        whoseTurn.setFont(arial);
        north.add(whoseTurn);

        contentPane.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setFont(arial);

        /* Grid/Board */
        JPanel grid = new JPanel();
        grid.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        gc = new GridCanvas(400, 400, 3, 3); // (width, height, floors, elevators)
        gc.setBackground(Color.WHITE);
        grid.add(gc);
        grid.setSize(new Dimension(400, 400));
        contentPane.add(grid, BorderLayout.CENTER);

        /* Play button and commands at bottom */
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        JButton play = new JButton("Play");
        play.setFont(arial);

        Integer[] positions = {1,2,3,4,5,6,7,8,9};
        position = new JComboBox<Integer>(positions);
        position.setFont(arial);
        //spot = Integer.parseInt((String)position.getSelectedItem());
        position.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        int i = (Integer)e.getItemSelectable().getSelectedObjects()[0];
                        spot = i;
                        System.out.println(spot);
                    }
                }
            });

//         play.addActionListener(new ActionListener() { 
//                 public void actionPerformed(ActionEvent e) {
//                     control.playGame(spot,turn);
//                 } 
//             });
            
            play.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Spot: "+spot+" turn: " +turn);
                    playButton();
                } 
            });

        controls.add(position);
        controls.add(play);
        contentPane.add(controls, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds text to the text area
     */
    public void appendText(String t)
    {
        text.append(t+"\n");
    }

    public int getSpot()
    {
        return spot;
    }
    
      public void playButton()
    {
        control.playGame(spot,turn);
    }

    public void setTurn(int s)
    {
        if(s == 0){
            whoseTurn.setText("It's X's turn! \n");
            turn = "X";
            whoseTurn.setForeground(Color.blue);
        }else{
            whoseTurn.setText("It's O's turn! \n");
            turn = "O";
            whoseTurn.setForeground(Color.red);
        }
    }

    /**
     * 
     */
    public void drawBoard(int pos, String s)
    {
        g = gc.getGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 130));
        if(pos == 1){
            g.setColor(Color.white);
            g.fillRect(3, 3, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, -20, 115);
        }
        if(pos == 2){
            g.setColor(Color.white);
            g.fillRect(136, 3, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 120, 115);
        }
        if(pos == 3){
            g.setColor(Color.white);
            g.fillRect(269, 3, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 250, 115);
        }

        if(pos == 4){
            g.setColor(Color.white);
            g.fillRect(3, 136, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, -20, 250);
        }
        if(pos == 5){
            g.setColor(Color.white);
            g.fillRect(136, 136, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 120, 250);
        }
        if(pos == 6){
            g.setColor(Color.white);
            g.fillRect(269, 136, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 250, 250);
        }

        if(pos == 7){
            g.setColor(Color.white);
            g.fillRect(3, 269, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, -20, 385);
        }
        if(pos == 8){
            g.setColor(Color.white);
            g.fillRect(136, 269, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 120, 385);
        }
        if(pos == 9){
            g.setColor(Color.white);
            g.fillRect(269, 269, 127, 127);
            g.setColor(Color.black);
            g.drawString(s, 250, 385);
        }

    }

    /**
     * Class used to draw the grid
     */
    class GridCanvas extends Canvas
    {
        int width, height;
        int rows, columns;
        int rowHt, rowWid;

        /**
         * GridCanvas constructor
         */
        GridCanvas(int w, int h, int r, int c)
        {
            width = w;
            height = h;
            rows = r;
            columns = c;
            setSize(width, height);
        }

        /**
         * Draws the lines of the grid based on the number rows (floors) and the columns (elevators)
         */
        public void paint(Graphics g)
        {
            int i;
            width = getSize().width;
            height = getSize().height;

            rowHt = height / rows;
            for (i=0; i<=rows; i++)
                g.drawRect(0, i*rowHt, width, i*rowHt);
            rowWid = width / columns; 
            for(i=0; i < columns; i++)
                g.drawRect(i*rowWid, 0, i*rowWid, height);
        }

        /**
         * Returns the rowHt to  be used in drawCar so the elevator is drawn correctly.
         */
        public int getScalingFactor()
        {
            return rowHt;
        }
    }
}

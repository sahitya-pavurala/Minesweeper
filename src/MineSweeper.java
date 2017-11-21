import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahityapavurala on 11/19/17.
 * Implementation of MineSweeper Game
 */
public class MineSweeper{
    private static final int NUM_MINES = 20;
    private static final int SIZE = 10;
    public static JFrame frame;
    public static JPanel gamePanel;

    public static void main(String[] args) {
        frame = new JFrame("Mine Sweeper | # of mines: " + NUM_MINES);

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    getFreshGameFrame();

                }
            });

    }


    public static void getFreshGameFrame(){

        gamePanel = new GameGUI(SIZE, SIZE, NUM_MINES);
        gamePanel.setVisible(true);
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(0,1,0,0));
        JButton reset = new JButton("reset");

        //Reset the game panel after clicking reset button
        reset.addActionListener(new ResetButtonHandler(frame, gamePanel, SIZE, NUM_MINES));

        JButton exit = new JButton("exit");
        ////Functionality for the exit button
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        buttonPanel.add(reset);
        buttonPanel.add(exit);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.pack();

    }
}










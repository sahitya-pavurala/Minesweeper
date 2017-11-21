import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahityapavurala on 11/19/17.
 * ActionListener class for the reset button
 */
class ResetButtonHandler implements ActionListener {

    JFrame frame;
    JPanel panel;
    int SIZE;
    int NUM_MINES;

    public ResetButtonHandler(JFrame frame, JPanel panel, int SIZE, int NUM_MINES){

        this.frame = frame;
        this.panel = panel;
        this.SIZE = SIZE;
        this.NUM_MINES = NUM_MINES;
    }

    public void actionPerformed(ActionEvent event) {
        panel.setVisible(false);
        panel = new GameGUI(SIZE, SIZE, NUM_MINES);
        panel.setVisible(true);
        frame.add(panel);
    }
}

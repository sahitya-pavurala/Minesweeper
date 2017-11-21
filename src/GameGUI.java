import javax.swing.*;
import java.awt.*;

/**
 * Created by sahityapavurala on 11/19/17.
 * JPanel class for the game panel
 */
public class GameGUI extends JPanel{

    private MineGrid grid;

    public GameGUI(int numRows, int numCols, int numMines) {
        grid = new MineGrid(numRows, numCols, numMines);

        setLayout(new GridLayout(numRows, numCols));
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                JButton button = new JButton();
                add(button);
                button.addActionListener(new GridButtonHandler(i,j, grid));
            }
        }
    }
}



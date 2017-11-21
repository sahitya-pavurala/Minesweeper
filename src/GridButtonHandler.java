import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahityapavurala on 11/19/17.
 * ActionListener class to update grid information
 */
class GridButtonHandler implements ActionListener {
    private int row, col;
    private MineGrid grid;

    public GridButtonHandler(int row, int col, MineGrid grid) {
        this.row = row;
        this.col = col;
        this.grid = grid;
    }

    public void actionPerformed(ActionEvent event) {
        if(grid.containsMineAt(row, col)) {
            JOptionPane.showMessageDialog(null, "Game Lost!!");
        } else {
            JButton button = (JButton)event.getSource();
            button.setText(String.valueOf(grid.getInfoAt(row, col)));
        }
    }
}
import java.util.Random;

/**
 * Created by sahityapavurala on 11/19/17.
 * Class to control the grid information
 */
class MineGrid {
    public static final int MINE = -1;
    protected int[][] mineInformation;

    public MineGrid(int numRows, int numCols, int numMines) {
        mineInformation = new int[numRows][numCols];

        initializeCells();
        //placeMines(numMines);
        placeMinesUniformly(numRows, numCols, numMines);
        setMineInformation();
    }

    /**
     * Initialize the grid
     */
    protected void initializeCells() {
        for(int i = 0; i < mineInformation.length; i++) {
            for(int j = 0; j < mineInformation[0].length; j++) {
                mineInformation[i][j] = 0;
            }
        }
    }


    /**
     * Method to place mine randomly
     * @param numMines
     */
    private void placeMines(int numMines) {
        Random random = new Random();
        for(int i = 0; i < numMines; i++) {
            int r = random.nextInt(mineInformation.length);
            int c = random.nextInt(mineInformation[0].length);
            mineInformation[r][c] = MINE;
        }
    }

    /**
     * This method places the mines uniformly in the grid
     * @param rows
     * @param cols
     * @param numMines
     */
    private void placeMinesUniformly(int rows, int cols, int numMines){
        float probability = (float)numMines/ (rows * cols);
        System.out.println(probability);
        Random random = new Random();
        int count = 0;
        while(numMines > 0){
            probability = (float)numMines / (rows * cols - count);
            int i = random.nextInt(rows-1);
            int j = random.nextInt(cols-1);
            float check = (float) Math.random();//return a value between 0 and 1
            //System.out.println(check);
            if(check < probability && mineInformation[i][j] != MINE){
                mineInformation[i][j] = MINE;
                numMines--;
                count++;
            }
        }
        System.out.println("num mines :: " + numMines);
        System.out.println("count :: "+ count);
    }

    /**
     * Setter method to update mine information
     */
    private void setMineInformation() {
        for(int i = 0; i < mineInformation.length; i++) {
            for(int j = 0; j < mineInformation[0].length; j++) {
                if(mineInformation[i][j] == MINE) {
                    // previous row
                    incrementMineCountAt(i-1, j-1);
                    incrementMineCountAt(i-1, j);
                    incrementMineCountAt(i-1, j+1);

                    // left and right cells
                    incrementMineCountAt(i, j-1);
                    incrementMineCountAt(i, j+1);

                    // next row
                    incrementMineCountAt(i+1, j-1);
                    incrementMineCountAt(i+1, j);
                    incrementMineCountAt(i+1, j+1);
                }
            }
        }
    }

    /**
     * Method to increment the minecount
     * @param i
     * @param j
     */
    private void incrementMineCountAt(int i, int j) {
        if(isInsideGrid(i, j) && mineInformation[i][j] != MINE) {
            mineInformation[i][j]++;
        }
    }

    /**
     * edge case method to check if the cell is inside the grid
     * @param i
     * @param j
     * @return
     */
    private boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < mineInformation.length) &&
                (j >= 0 && j < mineInformation[0].length);
    }

    public int getInfoAt(int i, int j) {
        return mineInformation[i][j];
    }

    public boolean containsMineAt(int i, int j) {
        return getInfoAt(i, j) == MINE;
    }
}

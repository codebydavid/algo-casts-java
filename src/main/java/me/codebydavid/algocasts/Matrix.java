package me.codebydavid.algocasts;

// --- Directions
// Write a function that accepts an integer N
// and returns a NxN spiral matrix.
// --- Examples
//   matrix(2)
//     [[1, 2],
//     [4, 3]]
//   matrix(3)
//     [[1, 2, 3],
//     [8, 9, 4],
//     [7, 6, 5]]
//  matrix(4)
//     [[1,   2,  3, 4],
//     [12, 13, 14, 5],
//     [11, 16, 15, 6],
//     [10,  9,  8, 7]]
public class Matrix {

    /**
     * Solution
     * 
     * Track the "free" section of the matrix then fill out the numbers
     * in clockwise order (right, down, left then up).
     */
    public static int[][] matrix1(int n) {
        // initialize the matrix
        int[][] result = new int[n][n];

        int counter = 1; // number to be placed into each cell
        int startRow = 0; // starting row index of the free matrix
        int endRow = n - 1; // end row index of the free matrix
        int startCol = 0; // starting column index of the free matrix
        int endCol = n - 1; // ending column index of the free matrix

        // keep filling out the numbers
        while (startRow <= endRow && startCol <= endCol) {
            // 1. fill out the starting row (from start col to end col)
            for (int i = startCol; i <= endCol; i++) {
                result[startRow][i] = counter;
                counter++;
            }
            startRow++; // move startRow (of "free" matrix) after fill

            // 2. fill down the end column (from start row to end row)
            for (int i = startRow; i <= endRow; i++) {
                result[i][endCol] = counter;
                counter++;
            }
            endCol--; // move endCol (of "free" matrix) after fill

            // 3. fill out the end row (from end column to start column)
            for (int i = endCol; i >= startCol; i--) {
                result[endRow][i] = counter;
                counter++;
            }
            endRow--; // move endRow (of "free" matrix) after fill

            // 4. fill up the starting column (from end row to start row)
            for (int i = endRow; i >= startRow; i--) {
                result[i][startCol] = counter;
                counter++;
            }
            startCol++; // move startCol (of "free" matrix) after fill
        }

        return result;
    }

    /**
     * Alternative Solution
     * 
     * Determine the direction to fill the next number after filling a number
     */ 
    public static int[][] matrix2(int n) {
        // initialize the matrix
        int[][] result = new int[n][n];

        // directions modeled as the incremental change in index number.
        // the order of the elements defines the order for checking the directions.
        // right: {0, 1}
        // down: {1, 0}
        // left: {0, -1}
        // up: {-1, 0}
        final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // currently headed direction; start with "right"
        int heading = 0;

        // current poisition (start at first row, first column)
        int row = 0;
        int col = 0;

        // loop through the numbers to add to the matrix
        for (int i = 1; i <= n * n; i++) {
            // set the number at the current cell
            result[row][col] = i;

            // check the directions to determine the next cell
            // base on the current heading
            for (int j = 0; j < 4; j++) {
                int newRow = row + directions[heading][0];
                int newCol = col + directions[heading][1];

                // make sure the new row & col indexes are in bound
                // new cell is found if the cell value is 0
                if (newRow >= 0 && newRow < n && 
                    newCol >= 0 && newCol < n && 
                    result[newRow][newCol] == 0)
                {
                    // set row & col index for the next cell
                    row = newRow;
                    col = newCol;

                    // break, no need to check other directions
                    break;
                }

                // Check the next heading if "free" cell is not found
                // heading index must be between 0 and 3
                heading = (heading + 1) % 4;
            }
        }

        return result;
    }

}
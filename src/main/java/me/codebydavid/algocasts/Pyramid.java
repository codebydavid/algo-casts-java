package me.codebydavid.algocasts;

// --- Directions
// Write a function that accepts a positive number N.
// The function should console log a pyramid shape
// with N levels using the # character.  Make sure the
// pyramid has spaces on both the left *and* right hand sides
// --- Examples
//   pyramid(1)
//       '#'
//   pyramid(2)
//       ' # '
//       '###'
//   pyramid(3)
//       '  #  '
//       ' ### '
//       '#####'
public class Pyramid {

    /**
     * Solution 1: iterative solution
     */
    public static void pyramid1(int n) {
        for (int row = 0; row < n; row ++) {
            String level = "";
            int width = 2 * n - 1;
            int midpoint = (int)Math.floor(width / 2);

            for (int column = 0; column < width; column++) {
                if (column >= midpoint - row && column <= midpoint + row) {
                    level += '#';
                } else {
                    level += ' ';
                }
            }

            System.out.println(level);
        }
    }

    /**
     * Solution 2: recursive solution
     */
    public static void pyramid2(int n, int row, String level) {
        // stop if max row is reached
        if (row == n) return;

        // print level to output if level width is reached
        int width = 2 * n - 1;
        if (level.length() == width) {
            System.out.println(level);
            pyramid2(n, row + 1, "");
            return;
        }

        // add char to level
        int midpoint = (int)Math.floor(width / 2);
        char add;
        if (level.length() >= midpoint - row && level.length() <= midpoint + row) {
            add = '#';
        } else {
            add = ' ';
        }
        pyramid2(n, row, level + add);
    }

    // Java doesn't support default parameter values.
    // Overload the method to make "row" & "level" optional
    public static void pyramid2(int n) {
        pyramid2(n, 0, "");
    }
}
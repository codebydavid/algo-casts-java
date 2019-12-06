package me.codebydavid.algocasts;

// --- Directions
// Write a function that accepts a positive number N.
// The function should console log a step shape
// with N levels using the # character.  Make sure the
// step has spaces on the right hand side!
// --- Examples
//   steps(2)
//       '# '
//       '##'
//   steps(3)
//       '#  '
//       '## '
//       '###'
//   steps(4)
//       '#   '
//       '##  '
//       '### '
//       '####'
public class Steps {

    // Solution 1: iterative approach
    public static void steps1(Integer n) {
        for (int row = 0; row < n; row++) {
            String stair = "";
            for (int col = 0; col < n; col++) {
                stair += col <= row ? "#" : " ";
            }
            System.out.println(stair);
        }
    }

    // Solution 2: recursive approach
    // NOTE:
    //   Java does not support default parameter values.
    //   Using variable arguments as a workaround.
    public static void steps2(Integer n, Object... args) {
        Integer row = args.length >= 1 ? (Integer)args[0] : 0;
        String stair = args.length >= 2 ? (String)args[1] : ""; 

        // stop if the row has reached "n"
        if (n == row) return;

        // print "stair" if length reaches "n"
        if (n == stair.length()) {
            System.out.println(stair);
            // move on to next row and reset stair
            steps2(n, row + 1, "");
            return;
        }

        // determine the char to append
        String c = stair.length() <= row ? "#" : " ";
        // append then continue on the current row
        steps2(n, row, stair + c);
    }

    // Solution 3: alternative iterative solution
    public static void steps3(Integer n) {
        // initialize "stair" char array with spaces
        char[] stair = new char[n];
        for (int i = 0; i < n; i++) {
            stair[i] = ' ';
        }

        // for each row, change the column to '#'
        for (int row = 0; row < n; row++) {
            stair[row] = '#';
            System.out.println(new String(stair));
        }

        return;
    }
}

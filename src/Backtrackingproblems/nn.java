package Backtrackingproblems;

public class nn {
    public void solveSudoku(char[][] board) {
        find(board);  // Solve in-place
    }

    static boolean find(char[][] board) {
        int n = board.length;

        // find an empty cell
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {   // empty cells are usually '.'
                    // try numbers 1-9
                    for (int num = 1; num <= 9; num++) {
                        if (correctval(board, r, c, num)) {
                            board[r][c] = (char)(num + '0'); // place number

                            if (find(board)) { // recursive call
                                return true;  // solved
                            } else {
                                board[r][c] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // no valid number → backtrack
                }
            }
        }
        return true; // no empty cell left → solved
    }

    static boolean correctval(char[][] board, int r, int c, int num) {
        char ch = (char)(num + '0');
        int n = board.length;

        // check row
        for (int i = 0; i < n; i++) {
            if (board[r][i] == ch) return false;
        }

        // check column
        for (int i = 0; i < n; i++) {
            if (board[i][c] == ch) return false;
        }

        // check 3x3 box
        int sqrt = (int)Math.sqrt(n);
        int rowStart = r - r % sqrt;
        int colStart = c - c % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == ch) return false;
            }
        }

        return true; // ✅ valid placement
    }

}

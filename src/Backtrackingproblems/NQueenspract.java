package Backtrackingproblems;

public class NQueenspract {
    public static void main(String[] args) {

        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(findpath(board,0));
    }
    static int findpath(boolean[][] board, int row){
        int count = 0;

        if (row == board.length){
           show(board);
            System.out.println();
            return 1;
        }


        for (int col =0; col<board.length; col++){


            if (issafe(board , row, col)){
                board[row][col] = true;
                count += findpath(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }
    static boolean issafe(boolean[][] cboard,int r, int c){

        for (int i=0; i < r; i++){
            if (cboard[i][c]){
                return false;
            }
        }

        int Rightmin = Math.min(r,cboard.length-c-1);
        for (int i= 1; i<=Rightmin; i++){
            if (cboard[r-i][c+i]){
                return false;
            }
        }

        int Leftmin = Math.min(r,c);
            for (int i = 1; i <= Leftmin; i++){
                if (cboard[r-i][c-i]){
                    return false;
                }
            }

           return true;

    }


    //🔹 Visual Example (5×5 board, r=3, c=1)
    //
    //Board index:
    //
    //0 1 2 3 4
    //---------
    //. . . . .
    //. . . . .
    //. . . . .
    //. Q . . .
    //. . . . .
    //
    //
    //For right diagonal (↗️):
    //
    //r = 3 → can move 3 steps up
    //
    //cboard.length - c - 1 = 5 - 1 - 1 = 3 → can move 3 steps right
    //
    //Rightmin = min(3, 3) = 3 → diagonal length = 3
    //
    //For left diagonal (↖️):
    //
    //r = 3 → can move 3 steps up
    //
    //c = 1 → can move only 1 step left
    //
    //Leftmin = min(3, 1) = 1 → diagonal length = 1


    static void show(boolean[][] ans){
        for(boolean[] a : ans){
            for (boolean b : a){
                if (b){
                    System.out.print("Q ");

                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}

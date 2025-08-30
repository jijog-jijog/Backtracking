package allPath;

import java.util.Arrays;

public class pathPrintpractice {
    public static void main(String[] args) {

        boolean[][] val = {{true,true,true},
                           {true,true,true},
                           {true,true,true}, };

        int[][] add = new int[val.length][val[0].length];

        find("",0,0,val,add,1);
    }
    static void find(String p, int r, int c,boolean[][] bool, int[][] nums, int start){

        if ( (r == bool.length-1) && (c == bool[0].length-1)){
            nums[r][c] = start;
            for (int[] a : nums){
                System.out.println(Arrays.toString(a));
            }
//            System.out.println(start);
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!bool[r][c]){
            return;
        }

        bool[r][c] = false;
        nums[r][c] = start;
        if (r < bool.length-1){
            find(p+'D',r+1,c,bool,nums,start+1);
        }
        if (c < bool[0].length-1){
            find(p+'R',r,c+1,bool,nums,start+1);
        }
        if (r>0){
            find(p+'U',r-1,c,bool,nums,start+1);
        }
        if (c>0){
            find(p+'L',r,c-1,bool,nums,start+1);
        }

        bool[r][c] = true;
        nums[r][c] = 0;
    }
}

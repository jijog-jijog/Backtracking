package allPath;

public class paths {
    public static void main(String[] args) {
        path(3,3,"");
    }
    static void path(int r,int c,String p){
        if (r==1 && c==1){
            System.out.println(p);
            return;
        }
        if (r > 1){
            path(r-1,c,p+"D");
        }
        if (c > 1){
            path(r,c-1,p+"R");
        }

    }
}

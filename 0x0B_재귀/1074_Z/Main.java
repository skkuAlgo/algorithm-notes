import java.io.*;

public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] ss = s.split(" ");
        int N = Integer.parseInt(ss[0]);
        int r = Integer.parseInt(ss[1]);
        int c = Integer.parseInt(ss[2]);

        // 2^N이 행 길이임
        int len = 1;
        for(int i=0; i<N; i++){
            len *= 2;
        }

        arr = new int[len][len];
        Z(0,0,len,r,c,0);

        // Z(0,0,len);

        // for(int i=0; i<len; i++){
        //     for(int j=0; j<len; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        
    }

    public static int check = 0;

    // public static void Z(int x, int y, int r){
    //     if(r == 2){
    //         arr[x][y] = check*4 + 0;
    //         arr[x][y+1] = check*4 + 1;
    //         arr[x+1][y] = check*4 + 2;
    //         arr[x+1][y+1] = check*4 + 3;
    //         check++;
    //     }
    //     else{
    //         Z(x, y, r/2);
    //         Z(x, y+r/2, r/2);
    //         Z(x+r/2, y, r/2);
    //         Z(x+r/2, y+r/2, r/2);
    //     }
    // }

    public static void Z(int row, int col, int len, int x, int y, int answ){
        if(len == 2){
            if(x == row && y == col){
                System.out.print(answ);
            }
            else if(x == row && y == col+1){
                System.out.print(answ+1);
            }
            else if(x == row+1 && y == col){
                System.out.print(answ+2);
            }
            else if(x == row+1 && y == col+1){
                System.out.print(answ+3);
            }
        }
        else{
            int multi = len*len/4;
        
            if(x < row+(len/2) && y < (col+(len/2))){
                Z(row, col, len/2, x, y, answ);
            }
            else if(x < row+(len/2) && y >= (col+(len/2))){
                Z(row, col+(len/2), len/2, x, y, answ + multi);
            }
            else if(x >= row+(len/2) && y < (col+(len/2))){
                Z(row+(len/2), col, len/2, x, y, answ + (multi*2));
            }
            else if(x >= row+(len/2) && y >= (col+(len/2))){
                Z(row+(len/2), col+(len/2), len/2, x, y, answ + (multi*3));
            }
        }

    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr = new int[10];
    public static int[] isUsed = new int[10];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        // Scanner sc = new Scanner(System.in);
        // N = sc.nextInt();
        // M = sc.nextInt();
        // sc.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        func(0);
        System.out.print(sb);
    }

    public static void func(int count){
        if(count == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[count] = i;
            func(count+1);
        }
    }
}


/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
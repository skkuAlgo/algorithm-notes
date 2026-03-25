import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr = new int[10];
    public static int[] isUsed = new int[10];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        func(0);
    }

    public static void func(int count){
        if(count == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(isUsed[i] == 0){
                arr[count] = i;
                isUsed[i] = 1;
                func(count+1);
                isUsed = new int[10];
            }
            for(int j=1; j<=i; j++){
                isUsed[j] = 1;
            }
        }
    }
}


/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
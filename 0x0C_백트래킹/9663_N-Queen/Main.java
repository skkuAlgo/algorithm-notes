import java.util.*;

public class Main {
    public static int N;
    public static int answ = 0;
    public static int[] isused1 = new int[40];
    public static int[] isused2 = new int[40];
    public static int[] isused3 = new int[40];

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        func(0);
        System.out.print(answ);
    }

    public static void func(int cur){
        if(cur == N){
            answ++;
            return;
        }

        for(int i=0; i<N; i++){
            if(isused1[i] == 1 || isused2[i+cur] == 1 || isused3[cur-i+N-1] == 1 )
                continue;

            isused1[i] = 1;
            isused2[i+cur] = 1; 
            isused3[cur-i+N-1] = 1;
            func(cur+1);
            isused1[i] = 0;
            isused2[i+cur] = 0;
            isused3[cur-i+N-1] = 0;
        }

    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
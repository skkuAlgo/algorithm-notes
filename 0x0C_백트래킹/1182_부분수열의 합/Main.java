import java.io.*;

public class Main {
    public static int[] arr;
    public static int N;
    public static int S;
    public static int answ;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        N = Integer.parseInt(s1.split(" ")[0]);
        S = Integer.parseInt(s1.split(" ")[1]);
        arr = new int[N];
        answ = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s2.split(" ")[i]);
        }

        for(int i=0; i<N; i++){
            func(i,0);
        }
        System.out.print(answ);

    }

    public static void func(int now, int sum){
        if(now >= N) return;
        sum += arr[now];
        if(sum == S){
            answ++;
        } 

        for(int i=now+1; i<N; i++){
            func(i, sum);
        }
    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
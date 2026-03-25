import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int C = Integer.parseInt(arr[2]);
        

        System.out.print(mod(A,B,C));

    }

    public static long mod(int a, int b, int c){
        if(b == 1) return a%c;

        long half = mod(a, b/2, c);
        if(b%2 == 0){
            return half*half%c;
        }else{
            return (half*half%c) * (a%c) %c;
        }
    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
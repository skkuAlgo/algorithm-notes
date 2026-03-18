import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int res = 1;
        sc.close();

        while(B>=1){
            res *= A;
            res %= C;
            B--;
        }

        System.out.print(res);

    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
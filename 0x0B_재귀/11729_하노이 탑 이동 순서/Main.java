import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();


        int num = (1<<n)-1;
        sb.append(num+"\n");

        func(1,3,n);
        System.out.print(sb);
    }

    public static void func(int a, int b, int n){
        if(n == 1){
            sb.append(a + " " + b+"\n");
            // System.out.println(a + " " + b);
            return;
        }
        func(a, 6-a-b, n-1);
        sb.append(a + " " + b+"\n");
        func(6-a-b, b, n-1);
    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
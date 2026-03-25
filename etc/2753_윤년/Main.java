import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        if(N%4 == 0){
            if(N%100 != 0){
                System.out.println(1);
                return;
            } 
            if(N%400 == 0){
                System.out.println(1);
                return;
            } 
            else{
                System.out.println(0);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}

/*
javac -encoding UTF-8 Main.java
java Main < input.txt
*/
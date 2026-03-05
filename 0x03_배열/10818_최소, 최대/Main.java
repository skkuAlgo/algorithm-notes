// https://www.acmicpc.net/problem/10818

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = 1000000;
        int max = -1000000;
        
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num < min) min = num;
            if(num > max) max = num;
        }
        sc.close();

        System.out.print(min + " " + max);
    }
}
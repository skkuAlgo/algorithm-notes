// https://www.acmicpc.net/problem/3052

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int[] result = new int[42];
        int count = 0;
        for(int i=0; i<10; i++){    
            int n = sc.nextInt();
            result[n%42]++;
        }
        for(int i=0; i<42; i++){
            if(result[i]>0) count++;
        }
        sc.close();
        System.out.print(count);
    }
}

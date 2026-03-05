// https://www.acmicpc.net/problem/10808

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        sc.close();
        int[] result = new int['z'-'a'+1];
        for(int i=0; i<word.length(); i++){
            for(int j='a'; j<='z'; j++){
                if(word.charAt(i) == j) result[j-'a']++;
            }
        }

        for(int i=0; i<'z'-'a'+1; i++){
            System.out.print(result[i] + " ");
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    // ( : 0 넣음
    // )을 만나면 가장 최근의 (이 0인지 아닌지에 따라 행동이 달라짐
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       int[] list = new int[str.length()];
       int end = 0;
    //    LinkedList<Integer> list = new LinkedList<>();
       int answer = 0;

       for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                list[end] = 0;
                end++;
            }
            else{
                // 레이저인 경우
                int size = end;
                int check = list[end-1];
                if( check == 0){
                    list[end-1] = 0;
                    end--;
                    for(int j=0; j<size; j++){
                        list[j]++;
                    }
                }
                // 막대인 경우
                else{
                    answer += (check + 1);
                    list[end-1] = 0;
                    end--;
                }
            }
       }
       System.out.println(answer);
    }

    public static void show(LinkedList<Integer> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

}
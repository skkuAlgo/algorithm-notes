import java.io.*;
import java.util.*;

public class Main {
    // ( : 0 넣음
    // )을 만나면 가장 최근의 (이 0인지 아닌지에 따라 행동이 달라짐
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str = br.readLine();
       LinkedList<Integer> list = new LinkedList<>();
       int answer = 0;

       for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                list.addLast(0);
            }
            else{
                // 레이저인 경우
                int check = list.get(list.size()-1);
                if( check == 0){
                    list.removeLast();
                    for(int j=0; j<list.size(); j++){
                        list.set(j, list.get(j)+1);
                    }
                }
                // 막대인 경우
                else{
                    answer += (check + 1);
                    list.removeLast();
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
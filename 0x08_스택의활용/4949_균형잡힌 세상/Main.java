import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();
        
        // 할 때마다 초반에 list 초기화
        while(!s.equals(".")){
            int len = s.length();
            int check=0;
            for(int i=0; i<len; i++){
                if(s.charAt(i) == '[' || s.charAt(i) == '('){
                    list.addLast(s.charAt(i));
                }
                else if(s.charAt(i) == ']'){
                    if(list.size() == 0){
                        check++;
                        break;
                    } 
                    else{
                        char c = list.get(list.size()-1);
                        if(c == '[') list.removeLast();
                        else {
                            check++;
                            break;
                        }
                    }

                }
                else if(s.charAt(i) == ')'){
                    if(list.size() == 0){
                        check++;
                        break;
                    } 
                    else{
                        char c = list.get(list.size()-1);
                        if(c == '(') list.removeLast();
                        else{
                            check++;
                            break;
                        } 
                    }
                }
            }
            if(check == 0 && list.size()==0) sb.append("yes\n");
            else sb.append("no\n");
            
            list.clear();
            s = br.readLine();
        }

        System.out.print(sb);
    }

    public static void show(LinkedList<Character> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

   
}
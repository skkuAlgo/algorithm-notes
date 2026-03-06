import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> cursor = list.listIterator();
        for(int j=0; j<str.length(); j++){
            cursor.add(str.charAt(j));
        }
        

        for(int i=0; i<n; i++){
            String input = br.readLine();
            char s = input.charAt(0);
            
            // 커서 왼쪽으로 (커서가 문장의 맨 앞이면 무시)
            if(s == 'L'){
                if(cursor.hasPrevious())
                    cursor.previous();
            }
            // 커서 오른쪽으로 (커서가 문장의 맨 뒤면 무시)
            else if(s == 'D'){
                if(cursor.hasNext())
                    cursor.next();
            }
            // 커서 왼쪽의 문자 삭제 (커서가 문장의 맨 앞이면 무시)
            // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타남
            else if(s == 'B'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                    cursor.remove();
                }
            }
            // P: $라는 문자를 커서 왼쪽에 추가
            else{
                char c = input.charAt(2);
                cursor.add(c);
            }

        }

        cursor = list.listIterator();
        StringBuilder sb = new StringBuilder();
        while(cursor.hasNext()){
            sb.append(cursor.next());
        }

        System.out.println(sb.toString());
        
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        LinkedList<Character> list = new LinkedList<>();
        int n = sc.nextInt();
        int len = str.length();
        int cursor = len;

        for(int j=0; j<str.length(); j++){
            list.addLast(str.charAt(j));
        }
        

        for(int i=0; i<n; i++){
            String s = sc.next();
            
            // 커서 왼쪽으로 (커서가 문장의 맨 앞이면 무시)
            if(s.equals("L")){
                if(cursor != 0) cursor--;
            }
            // 커서 오른쪽으로 (커서가 문장의 맨 뒤면 무시)
            else if(s.equals("D")){
                if(cursor != len) cursor++;
            }
            // 커서 왼쪽의 문자 삭제 (커서가 문장의 맨 앞이면 무시)
            // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타남
            else if(s.equals("B")){
                if(cursor != 0){
                    list.remove(cursor-1);
                    cursor--;
                    len--;
                }
            }
            // P: $라는 문자를 커서 왼쪽에 추가
            else{
                char c = sc.next().charAt(0);
                list.add(cursor,c);
                cursor++;
                len++;
            }

        }

        for(int k=0; k<len; k++){
            System.out.print(list.get(k));
        }
        
        sc.close();
    }
}
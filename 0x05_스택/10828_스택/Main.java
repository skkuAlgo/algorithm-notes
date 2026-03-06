import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for(int i=0; i<n; i++){
            String s = sc.next();
            if(s.equals("push")){
                int push = sc.nextInt();
                arr[count] = push;
                count++;
            }
            else if(s.equals("top")){
                if(count==0) System.out.println("-1");
                else{
                    System.out.println(arr[count-1]);
                }
            }
            else if(s.equals("pop")){
                if(count==0) System.out.println("-1");
                else{
                    System.out.println(arr[count-1]);
                    count--;    
                }
            }
            else if(s.equals("size")){
                System.out.println(count);
            }
            else if(s.equals("empty")){
                if(count==0) System.out.println("1");
                else System.out.println("0");
            }
        }
        sc.close();
    }
}
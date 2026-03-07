import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n+1];
        LinkedList<Integer> arr = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            String[] parts = s.split(" ");

            if(parts[0].equals("push")){
                Integer num = Integer.parseInt(parts[1]);
                arr.addLast(num);
            }
            else if(parts[0].equals("pop")){
                if(arr.size() == 0) sb.append("-1\n");
                else{
                    sb.append(arr.get(0));
                    sb.append("\n");
                    arr.removeFirst();
                }
            }
            else if(parts[0].equals("size")){
                sb.append(arr.size());
                sb.append("\n");
            }
            else if(parts[0].equals("empty")){
                if(arr.size() == 0) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(parts[0].equals("front")){
                if(arr.size() == 0) sb.append("-1\n");
                else{
                    sb.append(arr.get(0));
                    sb.append("\n");
                }
            }
            else if(parts[0].equals("back")){
                if(arr.size() == 0) sb.append("-1\n");
                else{
                    sb.append(arr.get(arr.size()-1));
                    sb.append("\n");
                }
            }
            // System.out.print(parts[0] + " : ");
            // check(arr);
        }
        
        System.out.print(sb);
    }
    
    public static void check(LinkedList<Integer> arr){
        System.out.print("[ ");
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n+1];
        LinkedList<Integer> arr = new LinkedList<>();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            String[] parts = s.split(" ");

            if(parts[0].equals("push")){
                Integer num = Integer.parseInt(parts[1]);
                arr.addLast(num);
            }
            else if(parts[0].equals("pop")){
                if(arr.size() == 0) System.out.println(-1);
                else{
                    System.out.println(arr.get(0));
                    arr.removeFirst();
                }
            }
            else if(parts[0].equals("size")){
                System.out.println(arr.size());
            }
            else if(parts[0].equals("empty")){
                if(arr.size() == 0) System.out.println(1);
                else System.out.println(0);
            }
            else if(parts[0].equals("front")){
                if(arr.size() == 0) System.out.println(-1);
                else{
                    System.out.println(arr.get(0));
                }
            }
            else if(parts[0].equals("back")){
                if(arr.size() == 0) System.out.println(-1);
                else{
                    System.out.println(arr.get(arr.size()-1));
                }
            }
            // System.out.print(parts[0] + " : ");
            // check(arr);
        }
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
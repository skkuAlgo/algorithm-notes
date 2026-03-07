import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int head = 0;
        int tail = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            String[] parts = s.split(" ");

            if(parts[0].equals("push")){
                int num = Integer.parseInt(parts[1]);
                arr[tail] = num;
                tail++;
                // check(arr,tail,head);
            }
            else if(parts[0].equals("pop")){
                if(head == tail) System.out.println(-1);
                else{
                    System.out.println(arr[head]);
                    head++;
                }
            }
            else if(parts[0].equals("size")){
                System.out.println(tail-head);
            }
            else if(parts[0].equals("empty")){
                if(head == tail) System.out.println(1);
                else System.out.println(0);
            }
            else if(parts[0].equals("front")){
                if(head == tail) System.out.println(-1);
                else{
                    System.out.println(arr[head]);
                }
            }
            else if(parts[0].equals("back")){
                if(head == tail) System.out.println(-1);
                else{
                    System.out.println(arr[tail-1]);
                }
            }
        }
    }

    public static void check(int[] arr, int tail, int head){
        System.out.print("[ ");
        for(int i=0; i<tail; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
        System.out.println();
        System.out.println("head: " + head + " tail: "+ tail);
    }
}
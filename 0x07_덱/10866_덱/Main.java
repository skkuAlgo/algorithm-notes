import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n*2+1];
        int head = n+1;
        int tail = n+1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String s = bf.readLine();
            String[] input = s.split(" ");
            System.out.println(s);

            if(input[0].equals("push_front")){
                int num = Integer.parseInt(input[1]);
                if(head==tail){
                    arr[head] = num;
                    head--; tail++;
                }
                else{
                    arr[head] = num;
                    head--; 
                }                
            }
            else if(input[0].equals("push_back")){
                int num = Integer.parseInt(input[1]);
                if(head==tail){
                    arr[head] = num;
                    head--; tail++;
                }
                else{
                    arr[tail] = num;
                    tail++;
                } 
            }
            else if(input[0].equals("pop_front")){
                if(head==tail) sb.append("-1\n");
                else{
                    sb.append(arr[head+1]+"\n");
                    head++;
                }
            }
            else if(input[0].equals("pop_back")){
                if(head==tail) sb.append("-1\n");
                else{
                    sb.append(arr[tail-1]+"\n");
                    tail--;
                }
            }
            else if(input[0].equals("size")){
                sb.append(tail-head+"\n");
            }
            else if(input[0].equals("empty")){
                if(head==tail) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(input[0].equals("front")){
                if(head==tail) sb.append("-1\n");
                else{
                    sb.append(arr[head+1]+"\n");
                }
            }
            else if(input[0].equals("back")){
                if(head==tail) sb.append("-1\n");
                else{
                    sb.append(arr[tail-1]+"\n");
                }
            }
            check(arr, head, tail);
        }
        System.out.print(sb);
    }

    public static void check(int[] arr, int head, int tail){
        System.out.print("[ ");
        for(int i=0; i<tail-head; i++){
            System.out.print(arr[head+i+1] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
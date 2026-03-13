import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[100000];
        Queue<Integer> q = new LinkedList<>(); 
        q.offer(N);
        arr[N] = 1;
        int answer = 0;

        while(arr[K] == 0){
            int num = q.poll();
            int c = arr[num];
            if(num-1 == N || num+1 == N || num*2 == N){
                answer = c+1;
                break;
            }
            
            if(num-1 >= 0){
                arr[num-1] = c+1;
                q.offer(num-1);
            } 
            if(num+1 <= 100000){
               arr[num+1] = c+1; 
               q.offer(num+1);
            } 
            if(num*2 <= 100000){
               arr[num*2] = c+1; 
               q.offer(num*2);
            } 
        }

        System.out.print(answer+1);
         
    }
}
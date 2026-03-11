import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int M = Integer.parseInt(s.split(" ")[0]);
        int N = Integer.parseInt(s.split(" ")[1]);
        int[][] arr = new int[N][M];
        int countZero = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            s = br.readLine();
            String[] aM = s.split(" ");
            for(int j=0; j<M; j++){
                int a = Integer.parseInt(aM[j]);
                arr[i][j] = a;
                if(a == 0) countZero++;
                else if(a == 1) queue.offer(new int[]{i,j});
            }
        }

        if(countZero == 0){
            System.out.print(0);
            return;
        }

        // 상 하 좌 우
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int result = 0;

        while(!queue.isEmpty()){
            int[] n = queue.poll();
            int x = n[0];
            int y = n[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(arr[nx][ny] == -1 || arr[nx][ny] > 0) continue;
                else{
                    queue.offer(new int[]{nx, ny});
                    arr[nx][ny] = arr[x][y] + 1;
                    countZero--;

                    if(arr[nx][ny] > result) result = arr[nx][ny];
                }
            }
        }
        
        if(countZero != 0) result = 0;

        System.out.println(result-1);
    }
}

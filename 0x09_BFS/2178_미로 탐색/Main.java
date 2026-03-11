import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int row = Integer.parseInt(s.split(" ")[0]);
        int col = Integer.parseInt(s.split(" ")[1]);

        int[][] arr= new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<row; i++){
            s = br.readLine();
            for(int j=0; j<s.length(); j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        q.offer(new int[]{0, 0});

        // 구현 시작

        // 상하좌우
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx<0 || nx>=row || ny<0 || ny>=col) continue;
                if(arr[nx][ny] == 0) continue;
                if(arr[nx][ny] == 1){
                    arr[nx][ny] = arr[now[0]][now[1]]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.println(arr[row-1][col-1]);
    }

}


   

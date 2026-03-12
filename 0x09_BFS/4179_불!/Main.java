import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int row = Integer.parseInt(s.split(" ")[0]);
        int col = Integer.parseInt(s.split(" ")[1]);
        char[][] arr = new char[row][col];
        int[][] jihoon = new int[row][col];
        int[][] fire = new int[row][col];
        Queue<int[]> fQ = new LinkedList<>();
        Queue<int[]> jQ = new LinkedList<>();
        LinkedList<int[]> list = new LinkedList<>();

        for(int i=0; i<row; i++){
            s = br.readLine();
            for(int j=0; j<col; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'J'){
                    jQ.offer(new int[]{i,j});
                    jihoon[i][j] = 1;
                } 
                else if(arr[i][j] == 'F'){
                    fQ.offer(new int[]{i,j});
                    fire[i][j] = 1;
                } 
                else if(arr[i][j] == '#'){
                    jihoon[i][j] = -1;
                    fire[i][j] = -1;
                }

                if(i==0 && arr[i][j] != '#'){
                    list.add(new int[]{i,j});
                }
                if(j==0 && arr[i][j] != '#'){
                    list.add(new int[]{i,j});
                }
                if(j==col-1 && arr[i][j] != '#'){
                    list.add(new int[]{i,j});
                }
                if(i==row-1 && arr[i][j] != '#'){
                    list.add(new int[]{i,j});
                }
            }
        }


        // 상 하 좌 우
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        while(!jQ.isEmpty()){
            int[] now = jQ.poll();
            for(int i=0; i<4; i++){
                int newR = now[0] + dr[i];
                int newC = now[1] + dc[i];

                if(newR < 0 || newR >= row || newC < 0 || newC >= col) continue;
                if(jihoon[newR][newC] >= 1 || jihoon[newR][newC] == -1) continue;

                jihoon[newR][newC] = jihoon[now[0]][now[1]]+1;
                jQ.offer(new int[]{newR, newC});
            }

        }

        while(!fQ.isEmpty()){
            int[] now = fQ.poll();
            for(int i=0; i<4; i++){
                int newR = now[0] + dr[i];
                int newC = now[1] + dc[i];

                if(newR < 0 || newR >= row || newC < 0 || newC >= col) continue;
                if(fire[newR][newC] >= 1 || fire[newR][newC] == -1) continue;

                fire[newR][newC] = fire[now[0]][now[1]]+1;
                fQ.offer(new int[]{newR, newC});
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(fire[i][j] == -1) continue;
                if(fire[i][j] != 0 && fire[i][j] <= jihoon[i][j]) arr[i][j] = 'F';
                else arr[i][j] = 'J';
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int[] edge : list){
            int r = edge[0];
            int c = edge[1];

            if(jihoon[r][c] == 0) continue;

            if(fire[r][c] == 0 || jihoon[r][c] < fire[r][c]){
                answer = Math.min(answer, jihoon[r][c]);
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(answer);
        }

    }
}

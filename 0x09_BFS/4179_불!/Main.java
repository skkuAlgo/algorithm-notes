import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int row = Integer.parseInt(s.split(" ")[0]);
        int col = Integer.parseInt(s.split(" ")[1]);
        char[][] arr = new char[row][col];
        boolean[][] visited_j = new boolean[row][col];
        boolean[][] visited_f = new boolean[row][col];
        Queue<int[]> fQ = new LinkedList<>();
        Queue<int[]> jQ = new LinkedList<>();

        for(int i=0; i<row; i++){
            s = br.readLine();
            for(int j=0; j<col; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'J'){
                    jQ.offer(new int[]{i,j});
                } 
                else if(arr[i][j] == 'F'){
                    fQ.offer(new int[]{i,j});
                } 
            }
        }

        // 상 하 좌 우
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        boolean finish = true;
        int checkJ=0; int checkF=0;
        int nextJ=1; int nextF=1;
        int answer = 0;

        while(finish){
            // for(int i=0; i<row; i++){
            //     for(int j=0; j<col; j++){
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            answer++;
            checkJ = 0;
            for(int j=0; j<nextJ; j++){
                int[] jNow = jQ.poll();
                if(arr[jNow[0]][jNow[1]] == 'F') continue;
                for(int i=0; i<4; i++){
                    int jNew_r = jNow[0] + dr[i];
                    int jNew_c = jNow[1] + dc[i];
                    if(visited_j[jNow[0]][jNow[1]] == true) continue;
                    if(jNew_r<0 || jNew_r>=row || jNew_c<0 || jNew_c>=col) continue;
                    if(arr[jNew_r][jNew_c] == 'F' || arr[jNew_r][jNew_c] == '#') continue;

                    jQ.offer(new int[]{jNew_r,jNew_c});
                    checkJ++;
                    arr[jNow[0]][jNow[1]] = '.';
                    arr[jNew_r][jNew_c] = 'J';
                }
                visited_j[jNow[0]][jNow[1]] = true;
            }
            nextJ = checkJ;
            checkF = 0;
            for(int j=0; j<nextF; j++){
                int[] fNow = fQ.poll();
                for(int i=0; i<4; i++){
                    int fNew_r = fNow[0] + dr[i];
                    int fNew_c = fNow[1] + dc[i];
                    if(visited_f[fNow[0]][fNow[1]] == true) continue;
                    if(fNew_r<0 || fNew_r>=row || fNew_c<0 || fNew_c>=col) continue;
                    if(arr[fNew_r][fNew_c] == 'F' || arr[fNew_r][fNew_c] == '#') continue;

                    fQ.offer(new int[]{fNew_r,fNew_c});
                    checkF++;
                    arr[fNew_r][fNew_c] = 'F';
                }
                visited_f[fNow[0]][fNow[1]] = true;
            }
            nextF = checkF;
            if(jQ.isEmpty()) finish = false;

            // for(int i=0; i<row; i++){
            //     for(int j=0; j<col; j++){
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            // System.out.println("*****");

        }

        System.out.print(answer);

    }
}

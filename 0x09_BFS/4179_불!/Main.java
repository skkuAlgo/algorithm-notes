import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int row = Integer.parseInt(s.split(" ")[0]);
        int col = Integer.parseInt(s.split(" ")[1]);
        char[][] arr = new char[row][col];
        Queue<int[]> fQ = new LinkedList<>();
        Queue<int[]> jQ = new LinkedList<>();

        for(int i=0; i<row; i++){
            s = br.readLine();
            for(int j=0; j<col; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'J') jQ.offer(new int[]{i,j});
                else if(arr[i][j] == 'F') fQ.offer(new int[]{i,j});
            }
        }

        /*
        1. 불 큐, 지훈 큐 따로
        지훈... 을 큐로 둘 이유가 있나?
        불 큐 -> 불이 이동할 곳 미리 F로 표시
            지훈 -> 벽이거나, F -> 무시, .이면 감
            이 때 문제) .이 여러 개면 어디로 가게 할 거임?
            이거때매 지훈도 큐로 두긴 해야 할 듯
            지훈 위치도 큐로 두되, 불한테 잡아먹히면? 끝
        그럼 불이랑 지훈 큐 이동.. 위치?를 동시에 두고, 겹치면(불이 가는 경로면) 지훈 큐에서 빼는건?
        1. 지훈 큐 추가
        2. 불 큐 확인 (이 때 추가할 큐가 지훈 큐에 있으면 -> 지훈 큐 삭제 후 불 큐에 추가)
            - 지훈이 탈출 -> 탈출시간 - return
            - 지훈 큐가 0 : Impossible (지훈이 탈출한 경우는 제외 - 탈출시간 출력)
        */

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
                for(int i=0; i<4; i++){
                    int jNew_r = jNow[0] + dr[i];
                    int jNew_c = jNow[1] + dc[i];
                    if(jNew_r<0 || jNew_r>=row || jNew_c<0 || jNew_c>=col) continue;
                    if(arr[jNew_r][jNew_c] == 'F' || arr[jNew_r][jNew_c] == '#') continue;

                    jQ.offer(new int[]{jNew_r,jNew_c});
                    checkJ++;
                    arr[jNow[0]][jNow[1]] = '.';
                    arr[jNew_r][jNew_c] = 'J';
                }
            }
            nextJ = checkJ;
            checkF = 0;
            for(int j=0; j<nextF; j++){
                int[] fNow = fQ.poll();
                for(int i=0; i<4; i++){
                    int fNew_r = fNow[0] + dr[i];
                    int fNew_c = fNow[1] + dc[i];
                    if(fNew_r<0 || fNew_r>=row || fNew_c<0 || fNew_c>=col) continue;
                    if(arr[fNew_r][fNew_c] == 'F' || arr[fNew_r][fNew_c] == '#') continue;

                    fQ.offer(new int[]{fNew_r,fNew_c});
                    checkF++;
                    // 여기서 지훈 위치 확인해서 queue에서 빼야 함
                    jQ.remove(new int[]{fNew_r,fNew_c});
                    arr[fNew_r][fNew_c] = 'F';
                }
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

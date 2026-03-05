import java.util.*;

public class Main {
    public static int result = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        

        // 0:빈 공간  8:queen  -1:놓을 수 없는 공간
        int[][] arr = new int[N][N];
        int[][] arr2 = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 맨 처음 queen위치 선정 (지나간 모든 빈칸?은 사용 불가로 만들어야 함)
                arr = new int[N][N];
                for (int r = 0; r < N; r++) {
                    arr[r] = arr2[r].clone();
                }
                cantGo(i,j,arr,N,0);
                
                
                arr2[i][j] = -1;
            }
        }
        System.out.println(result);

    }


    public static void cantGo(int x, int y, int[][] arr, int N, int count){
        arr[x][y] = 8;
        // 퀸의 수가 N개 이상이면 무시 (0더해줌)
        count++;
        if(count>N) return;

        // 갈 수 없는 위치 표시
        // 8방향: 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 해당 방향으로 끝까지 진행
            while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = -1;
                }

                nx += dx[d];
                ny += dy[d];
            }
        }

        
        // System.out.println("count: "+count);
        // 종료 확인
        if(count == N){
            // System.out.println("count: "+count);
            result ++;
            // print(arr,N);
            return;
        } 
        else{
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 0) cantGo(i,j,arr,N,count);
                }
            }

            return;
        }

        
    }

    public static void print(int[][] arr, int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
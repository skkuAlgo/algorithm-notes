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
        // 상
        if(x!=0){
            for(int i=1; i<=x; i++){
                if(arr[x-i][y] == 0){
                    arr[x-i][y] = -1;
                }
            }
        }
        
        // // 하
        if(x!=N-1){
            for(int i=1; i<=N-x-1; i++){
                if(arr[x+i][y] == 0){
                    arr[x+i][y] = -1;
                }
            }
        }
        
        // // 좌
        if(y!=0){
            for(int i=1; i<=y; i++){
                if(arr[x][y-i] == 0){
                    arr[x][y-i] = -1;
                }
            }
        }
        
        // // 우
        if(y!=N-1){
            for(int i=1; i<=N-y-1; i++){
                if(arr[x][y+i] == 0){
                    arr[x][y+i] = -1;
                }
            }
        }
        
        // System.out.println("count: "+count);
        // 종료 확인
        if(count == N){
            // System.out.println("count: "+count);
            result ++;
            print(arr,N);
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
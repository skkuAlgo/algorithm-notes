import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int row = Integer.valueOf(s.split(" ")[0]);
        int col = Integer.valueOf(s.split(" ")[1]);

        int[][] arr = new int[row][col];
        int[][] checkArr = new int[row][col];

        for(int i=0; i<row; i++){
            s = br.readLine();
            String[] str = s.split(" ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }

        int[][] stack = new int[row*col][2];
        // 상 하 좌 우
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};

        int paint_cnt = 0;
        int max = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int count = 0;
                checkArr[i][j] = 1;

                if(arr[i][j] == 1){
                    stack[count][0] = i;
                    stack[count][1] = j;
                    count++;
                    paint_cnt++;

                    int size = 1;
                    while(count != 0){
                        int r = stack[count-1][0];
                        int c = stack[count-1][1];
                        arr[r][c] = 0;
                        count--;

                        for(int k=0; k<4; k++){
                            if(r+dx[k] >= 0 && r+dx[k] <= row-1 && c+dy[k] >= 0 && c+dy[k] <= col-1){
                                if(arr[r+dx[k]][c+dy[k]] == 1 && checkArr[r+dx[k]][c+dy[k]] != 1){
                                    stack[count][0] = r+dx[k];
                                    stack[count][1] = c+dy[k];
                                    checkArr[r+dx[k]][c+dy[k]] = 1;
                                    count++;
                                    size++;
                                }
                            }
                        }
                    }
                    if(size > max) max = size;
                }
            }
        }

        System.out.println(paint_cnt);
        System.out.println(max);
    }

}


   

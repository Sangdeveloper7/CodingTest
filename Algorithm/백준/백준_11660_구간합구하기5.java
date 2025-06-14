package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11660_구간합구하기5 {
    // 시간초과 되는 문제 시간 복잡도 고려
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] total_arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                total_arr[i][j] = arr[i][j] + total_arr[i-1][j] + total_arr[i][j-1] - total_arr[i-1][j-1];
            }
        }

        int[] result = new int[M];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total = total_arr[x2][y2] + total_arr[x1-1][y1-1] - total_arr[x1 -1][y2] - total_arr[x2][y1 -1];

            result[i] = total;
        }

        for(int i = 0; i < M; i++){
            System.out.println(result[i]);
        }
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1932_정수삼각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0 ; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <= i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = n-1 ; i >= 0; i--){
            for(int j = 0 ; j <= i; j++){
                if(i == n-1){
                    dp[i][j] = map[i][j];
                }else{
                    dp[i][j] = map[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }

        int max = 0;

        for(int[] arr : dp){
            for(int i : arr){
                if(max < i)
                    max = i;
            }
        }

        System.out.print(max);
    }
}

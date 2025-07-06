package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_LCS_9251 {
    private static int[][] dp;
    private static char[] chr1;
    private static char[] chr2;



    private static void solution(int i, int j){
        if(chr1[i] == chr2[j]){
            if(i == 0 || j == 0){
                dp[i][j] = 1;
            }else{
                dp[i][j] = dp[i-1][j-1] + 1;
            }
        }else{
            if(i == 0 && j == 0){
                dp[i][j] = 0;
            }else if(i == 0){
                dp[i][j] = dp[i][j-1];
            }else if(j == 0)
                dp[i][j] = dp[i-1][j];
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        * ACAYKP
          CAPCAK  : 4
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        chr1 = str1.toCharArray();
        chr2 = str2.toCharArray();


        int N = str1.length();
        int M = str2.length();


        dp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                solution(i,j);
            }
        }

        int max = 0;
        for(int[] i : dp){
            for(int j : i){
                if(j > max)
                    max = j;
            }
        }

        System.out.print(max);
    }
}

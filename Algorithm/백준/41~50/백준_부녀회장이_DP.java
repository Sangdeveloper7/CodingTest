import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_부녀회장이_DP {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[15][15];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[0][i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < 15; i++) {
            dp[i][0] = 1;
            dp[0][i] = i;
        }

        for(int i = 1; i <15; i++){
            for(int j = 2; j < 15; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
    }

}

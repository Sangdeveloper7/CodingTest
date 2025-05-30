import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_설탕배달_DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int max = 1700;
        int[] dp = new int[5001];
        Arrays.fill(dp, 5001);
        dp[0] = 0;

        for(int i = 0; i <= N; i++) {
            if(i + 3 <= N)
                dp[i + 3] = Math.min(dp[i+3], dp[i] + 1);
            if(i + 5 <= N)
                dp[i + 5] = Math.min(dp[i+5], dp[i] + 1);
        }
        if(dp[N] == 5001){
            System.out.println("-1");
        }else{
            System.out.println(dp[N]);
        }
    }
}

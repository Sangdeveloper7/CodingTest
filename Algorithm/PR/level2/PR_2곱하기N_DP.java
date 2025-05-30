package PR.level2;

public class PR_2곱하기N_DP {

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1_000_000_007;
        }
       return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}

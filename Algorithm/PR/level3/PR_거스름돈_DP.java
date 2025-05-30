package PR.level3;

public class PR_거스름돈_DP {

    public static int solution(int n, int[] money) {
        int[][] dp = new int[money.length+1][n+1];

        for(int i = 0; i <= money.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= money.length; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if(money[i-1] <= j) {
                    dp[i][j] += dp[i][j-money[i-1]];
                    dp[i][j] %= 1000_000_007;
                }
            }
        }
        return dp[money.length][n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 5};
        System.out.println(solution(n, arr));
    }
}

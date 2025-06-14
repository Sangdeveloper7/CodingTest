package PR.level2;

public class PR_땅따먹기_DP {

    private static int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int [][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0){
                    dp[i][j] = land[i][j];
                }else{
                    int max = 0;
                    for(int k = 0; k < m; k++){
                        if(k != j){
                            max = Math.max(max, dp[i-1][k]);
                        }
                    }
                    dp[i][j] = max + land[i][j];;
                }
            }
        }

        for(int i = 0; i < dp[n-1].length; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int result = solution(arr);

        System.out.print(result);
    }
}

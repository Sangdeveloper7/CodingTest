package PR.level4;

public class PR_도둑질 {

    public static int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[1] = money[1];

        for(int i = 2; i < n -1; i++){
            dp1[i] = Math.max(dp1[i-1] , dp1[i-2] + money[i]);
        }

        for(int i = 2; i < n; i++){
            dp2[i] = Math.max(dp2[i-1] , dp2[i-2] + money[i]);
        }

        return Math.max(dp1[n-2], dp2[n-1]);
    }

    public static void main(String[] args){
        int[] money = {1, 2, 3, 1};
        int result = solution(money);
        System.out.print(result);
    }
}

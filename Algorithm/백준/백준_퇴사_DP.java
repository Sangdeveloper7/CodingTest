import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_퇴사_DP {
    private static class Sang{
        int time;
        int money;
        Sang(int time, int money){
            this.time = time;
            this.money = money;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int Number = Integer.parseInt(st.nextToken());
        int T_time = Number;
        Sang[] sang = new Sang[Number];
        for(int i = 0; i<Number; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            sang[i] = new Sang(time, money);
        }
        int []dp = new int[T_time + 2];
        for(int i = 1; i<=Number; i++){
            int next = sang[i-1].time + i; // 한번 전의 최댓값이 현재 최댓값이 될 수 도 있으므로
            if(next <= Number + 1){
                dp[next] = Math.max(dp[next],dp[i] + sang[i-1].money);
            }
            dp[i + 1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[Number+1]);
    }
}

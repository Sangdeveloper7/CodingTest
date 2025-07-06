import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_개똥벌레_누적합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 장애물 수
        int H = Integer.parseInt(st.nextToken()); // 동굴 높이

        int[] prefix = new int[H+1];

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                // 석순: 아래에서 위로 자람
                prefix[0]++;
                prefix[k]--;
            } else {
                // 종유석: 위에서 아래로 자람
                prefix[H - k]++;
                prefix[H]--;
            }
        }

        // 누적합을 통해 각 높이마다 장애물 수 구하기
        for (int i = 1; i <= H; i++) {
            prefix[i] += prefix[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < H; i++) {
            if (prefix[i] < min) {
                min = prefix[i];
                count = 1;
            } else if (prefix[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_N과M2_BackTracking {

    private static int N, M;
    private static boolean[] check;
    private static StringBuilder sb = new StringBuilder();

    private static void backtracking(int number, int cnt, String s) {
        if(cnt == M) {
            sb.append(s.trim() + "\n");
            return;
        }

        for(int i = number + 1; i<=N; i++) {
            if(!check[i]) {
                check[i] = true;
                backtracking(i,cnt + 1, s + " " + i);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        backtracking(0,0, "");
        System.out.println(sb);

    }
}

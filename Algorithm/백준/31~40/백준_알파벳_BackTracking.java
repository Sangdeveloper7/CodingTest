import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_알파벳_BackTracking {

    private static int R, C;
    private static boolean[] used;
    private static final int[] rx = {0, 0, -1, 1};
    private static final int[] ry = {1, -1, 0, 0};
    private static char[][] map;
    private static int answer = 0;


    private static class Node{
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void backtrack(Node now, int cnt) {
        answer = Math.max(answer, cnt);

        for(int i = 0; i < 4; i++){
            int next_r = now.r + rx[i];
            int next_c = now.c + ry[i];

            if(next_r < 0 || next_c < 0 || next_r >= R || next_c >= C){
                continue;
            }
            if(used[map[next_r][next_c] - 'A']){ // 어떤 알파벳을 사용했어?
                continue;
            }
            used[map[next_r][next_c] - 'A'] = true;
            backtrack(new Node(next_r, next_c), cnt + 1);
            used[map[next_r][next_c] - 'A'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        used = new boolean['Z' - 'A' + 1];
        used[map[0][0] - 'A'] = true;
        backtrack(new Node(0, 0), 1);

        System.out.println(answer);

    }
}

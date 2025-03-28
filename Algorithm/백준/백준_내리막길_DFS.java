import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_내리막길_DFS {

    private static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] rx = {0, 0, -1, 1};
    private static final int[] ry = {1, -1, 0, 0};
    private static int[][] map;
    private static int[][] cnt;
    private static int N, M;


    private static int dfs(Node now){
        if(cnt[now.r][now.c] >= 0){
            return cnt[now.r][now.c];
        }

        cnt[now.r][now.c] = 0;

        for(int i = 0; i <4; i++){
            int nr = now.r + rx[i];
            int nc = now.c + ry[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M) // 맵 밖에 나가는 경우
                continue;
            if(map[now.r][now.c] > map[nr][nc]){
                cnt[now.r][now.c] += dfs(new Node(nr, nc));
            }
        }
        return cnt[now.r][now.c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[N][M];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                cnt[i][j] = -1;
            }
        }

        cnt[N-1][M-1] = 1; // 최초 initalizing 값을 해놔야  한다.
        dfs(new Node(0, 0));


        System.out.println(cnt[0][0]);
    }
}

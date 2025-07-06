package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_미로탐색 {

    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<Integer> answer;
    static int[] rx = {-1, 1, 0, 0};
    static int[] ry = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0, N, M);
        System.out.print(map[N-1][M-1]);
    }

    public static void bfs(int x, int y, int N, int M){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i = 0; i < 4; i++){
                int nx = nowx + rx[i];
                int ny = nowy + ry[i];

                if(nx >= 0 && ny >= 0 && nx <= N-1 && ny <= M-1){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        map[nx][ny] = map[nowx][nowy] + 1;
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

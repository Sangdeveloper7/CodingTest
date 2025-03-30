import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_연구소_BFS {
    private static int[][] map;
    private static int N, M;
    private static ArrayDeque<Node> virus = new ArrayDeque<>(); // 바이러스가 있는 칸

    private static final int rx[] = {0, 0, -1, 1};
    private static final int ry[] = {-1, 1, 0, 0,};


    private static class Node{
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.addLast(new Node(i, j));
                }
            }
        }
        int answer = 0;

        ArrayDeque<Node> block = new ArrayDeque<>();
        for(int i = 0; i < N*M -2; i++){
            if(map[i / M][i % M] != 0)
                continue;
            block.addLast(new Node(i / M, i % M));
            for(int j = i + 1; j < N*M-1; j++){
                if(map[j / M][j % M] != 0)
                    continue;
                block.addLast(new Node(j / M, j % M));
                for(int k = j + 1; k < N*M; k++){
                    if(map[k / M][k % M] != 0)
                        continue;
                    block.addLast(new Node(k / M, k % M));
                    answer = Math.max(answer, bfs(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }
        System.out.println(answer);

    }

    private static int bfs(ArrayDeque<Node> block){
        int[][] map2 = new int[N][M];


        // map2 = map;  이렇게 하면 안에 있는 데이터가 바뀐다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        } // 이렇게 안하면 swallow copy 가 발생한다 -> 기존 데이터에 영향을 준다.

        for (Node node : block) {
            map2[node.r][node.c] = 1; // 새로 복사한 map2에다가 벽 3개(추가한 벽) 을 세운다.
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        for(Node node : virus){
            queue.addLast(node);
        } // 바이러스가 있는 곳 deepcopy

        while(!queue.isEmpty()){
            Node now = queue.pollFirst();

            for(int i = 0; i < 4; i++){
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) { // 밖으로 나가는 경우
                    continue;
                }
                if(map[nr][nc] == 1){
                    continue;
                }
                if(map2[nr][nc] == 0){
                    map2[nr][nc] = 2;
                    queue.addLast(new Node(nr, nc));
                } // 비어 있는 곳 -> 바이러스가 퍼질 것이다.
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map2[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

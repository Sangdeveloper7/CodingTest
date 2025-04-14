import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_연구소_BFS {


    private static final int rx[] = {0, 0, -1, 1};
    private static final int ry[] = {-1, 1, 0, 0,};

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /* BFS 알고리즘
     < 초기 설정 >
     1. 현재 위치를 넣을 Queue를 만든다
     2. 내가 방문한 노드를 확인할 배열 boolean 배열을 만든다
     3. 내가 방문한 노드와 내가 출발한 위치와의 거리 ? 를 위한 배열을 만든다

     ---------------------------------------------------------
     < 진행 >
     1. 내가 처음 있는 위치를 Deque에 addLast 한다
     2. 내가 있는 위치를 boolean True 해준다
     3. 내가 이동한 위치 (동서남북 , 상하좌우 등 )의 노드가 이동 가능한지 check 후 이동한다
     4. 이동한 좌표를 Queue 에 넣고 위의 과정을 반복한다.
     5. 마지막 도착점의 좌표가 Queue에 들어가면 종료한다.
    *
    */
//    public static int solution(int[][] maps) {
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.deepToString(map));
    }
}


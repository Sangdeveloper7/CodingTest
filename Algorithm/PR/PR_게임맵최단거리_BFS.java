import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PR_게임맵최단거리_BFS {

    private static final int rx[] = {0, 0, -1, 1};
    private static final int ry[] = {-1, 1, 0, 0,};

    private static class Node{
        int x;
        int y;
        Node(int x, int y){
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
    public static int solution(int[][] maps) {
        int answer = 0;
        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length]; // 방문 했는지 체크한 배열
        int[][] distance = new int[maps.length][maps[0].length]; // 원점과 거리 체크 배열
        int N = maps.length;
        int M = maps[0].length;


        queue.addLast(new Node(0, 0)); // 처음 노드의 위치 큐에 삽입
        visited[0][0] = true; // 처음 위치 노드 방문했다고 표시
        distance[0][0] = 1; // 처음 위치를 1로 표시
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();

            for(int i = 0; i<4; i++){
                int x = now.x + rx[i];
                int y = now.y + ry[i];

                /* 예외처리
                * 1. 범위를 벗어나는 경우
                * 2. 이미 방문한 노드를 방문할 경우
                * ------ 예외가 아닌 경우 ------- (범위 벗어난 경우도 아니고 이미 방문한 노드도 아닌 경우)
                * 1. Queue에 삽입
                * 2. 방문했다고 visted 배열 반영
                * 3. 거리 배열 distance 배열에 distance[이동할][위치] = dist[현재][위치] + 1;
                * */

                if(x < 0 || y <0 || x > maps.length-1 || y > maps[0].length-1)
                    continue;
                else if(visited[x][y])
                    continue;
                else if (!visited[x][y] && maps[x][y] == 1){
                    visited[x][y] = true;
                    queue.addLast(new Node(x, y));
                    distance[x][y] = distance[now.x][now.y] + 1;
                }
            }

        }
        if (distance[N-1][M-1] == 0) {
            answer = -1;
        }else{
            answer = distance[N-1][M-1];
        }

//        for(int i = 0; i< distance.length; i++){
//            System.out.println(i + " " + Arrays.toString(distance[i]));
//        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] arr2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        int answer = solution(arr);
        System.out.println(answer);
    }
}

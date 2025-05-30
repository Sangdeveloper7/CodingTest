package PR.level2;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PR_게임맵최당 {

    /*
    * 1. 현재 위치가 들어갈 queue, 처음 위치와 지금 현재 위치까지의 정보가 들어간 배열 int[][] dist, 방문 확인 배열 boolean[][] visited, INF 정의
    * 2. Node class 생성 x, y 좌표를 넣을
    * 3. dist(0,0) = 1 , visited[0][0] = true로 초기화 queue.add(new Node(0,0))
    * 4. while(!pq.isEmpty())일때 까지 -> pq 상하좌우 노드 별로 비었는지 아니면 범위를 벗어나는지 확인 후 -> 비었으면 처음 위치에서 그 위치까지의 거리를 dist 배열에 넣음
    * 5. 계속해서 반복 -> 만약 dist[maps.size()-1][maps[0].size] = INF 일 경우 -1 return
    * 6. 아닌 경우 answer= dist[maps.size()-1][maps[0].size];
    * */

    private static final int INF = Integer.MAX_VALUE;
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static ArrayDeque<Node> queue; // 현재 위치를 담을 큐
    private static int[][] dist; //  처음 위치와 얼마만큼의 떨어져 있는지를 기록하기 위한 배열
    private static boolean[][] visited; // 방문 확인 배열
    private static int[] rx = {0,0,1,-1};
    private static int[] ry = {1,-1,0,0};

    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        queue = new ArrayDeque<>();
        dist = new int[N][M];
        visited = new boolean[N][M];

        queue.addLast(new Node(0, 0));

        dist[0][0] = 1;
        visited[0][0] = true;


        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i<4; i++){
                int x_1 = now.x + rx[i];
                int y_1 = now.y + ry[i];

                if(x_1 < 0 || y_1 < 0 || x_1 > maps.length-1 || y_1 > maps[0].length-1)
                    continue;
                if(!visited[x_1][y_1] && maps[x_1][y_1] == 1){
                    visited[x_1][y_1] = true;
                    queue.addLast(new Node(x_1, y_1));
                    dist[x_1][y_1] = dist[now.x][now.y] + 1;
                }
            }
        }
        int answer = 0;
        if(dist[N-1][M-1] == 0)
            answer = -1;
        else
            answer = dist[N-1][M-1];

        return answer;
    }

    public static void main(String[] args) {
        int[][] maps1 = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        int[][] maps2 = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };

        System.out.println("결과 1: " + solution(maps1)); // 기대값: 11
        System.out.println("결과 2: " + solution(maps2)); // 기대값: -1
    }
}

package PR.level2;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PR_배달_DFS {

    static final int INF = Integer.MAX_VALUE;

    private static class Node{
        int dest;
        int cost;
        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static ArrayDeque<Node>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Node> answer2 = new ArrayDeque<>();

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        visited = new boolean[N+1];
        adjList = new ArrayDeque[N+1];

        for(int i = 0; i < N+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr : road){
            adjList[arr[0]].add(new Node(arr[1], arr[2]));
            adjList[arr[1]].add(new Node(arr[0], arr[2]));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.dest] < now.cost)
                continue;

            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost ){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for(int i2 = 1; i2 < N+1; i2++){
            if(dist[i2] <= K){
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int N1 = 5;
        int[][] road1 = {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        int K1 = 3;

        int N2 = 6;
        int[][] road2 = {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        int K2 = 4;

        System.out.println("테스트 1 결과 (기대값: 4): " + solution(N1, road1, K1));
        System.out.println("테스트 2 결과 (기대값: 4): " + solution(N2, road2, K2));
    }
}

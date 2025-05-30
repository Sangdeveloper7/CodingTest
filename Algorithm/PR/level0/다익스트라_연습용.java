package PR.level0;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라_연습용 {
    static final int INF = Integer.MAX_VALUE;



    private static class Node{
        int dest;
        int cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }


    private static int[] solution(int[][] graph, int start, int n){
        ArrayDeque<Node>[] adjList = new ArrayDeque[n+1];

        int[] dist = new int[n+1];

        for(int i = 0 ; i< n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr : graph){
            adjList[arr[0]].add(new Node(arr[1], arr[2]));
        }

        Arrays.fill(dist, INF);

        dist[start] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest] < now.cost ) continue;

            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }

            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        int start = 0;
        int n = 3;
        int[][] arr2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
        int n2 = 4;
        int[] result = solution(arr, start, n);

        for(int i : result){
            System.out.println(i + " ");
        }
    }
}

package PR.level0;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라_알고리즘 {

    /*
    * 1. 클래스를 만든다 dest, cost로 만든다
    * 2. INF를 정의한다.
    * 3. 그래프를 담을 ArrayDeque<Node>[] adjList 배열을 만든다 그리고 그래프를 초기화 하고 담는다.
    * 4. 노드별로 최소거리를 담을 int[] dist를 만든다.
    * 5. Arrays.fill(dist, INF)를 통해 모든 거리를 무한으로 초기화한다
    * 6. 시작 노드 (dist[start] = 0;) 으로 초기화 하고
    * 7. 우선순위 큐를 만든다 PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost)); cost가 작은 순으로 쌓이는 priority queue 만듬
    * 8. while(!pq.isEmpty())를 통해 Node now = pq.poll();를 통해 현재 pq에 들어있는 노드를 꺼낸다
    * 9. dist[now.des]와 비교한다 now.cost 만약 dist이 now.cost 보다 작다면 계속한다. 크면 멈춘다
    * 10. 현재 노드와 거쳐서 가는 노드 + 거쳐가는 값 dist[next] > next.cost + now.cost 크면 경로를 변경한다.
    * */
    private static class Node{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    static final int INF = Integer.MAX_VALUE;

    public static int[] solution(int[][] graph, int start, int n){
        ArrayDeque<Node>[] adjList = new ArrayDeque[n+1];

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr : graph){
            adjList[arr[0]].add(new Node(arr[1], arr[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.dest] < now.cost) continue;

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

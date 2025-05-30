import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.IntFunction;

public class 백준_최단경로_다익스트라 {

    private static class Node {
        int end;
        int cost;
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    private static ArrayList<Node>[] adjList;
    private static int[] dist;
    private static boolean[] visited;
    private static final int INF = 20000 * 10 + 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V+1];
        dist = new int[V+1];
        visited = new boolean[V+1];

        for(int i = 0; i<=V; i++) {
            adjList[i] = new ArrayList<>();

        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=V; i++){
            if(dist[i] == 200001)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void dijkstra(int start){
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF); // 여기 까지가 전체 값을 모두 무한으로 바꾼 과정

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        dist[start] = 0;
        pq.add(new Node(start, 0)); // pq에다가 시작점에서 현재 점 (시작점) 까지의 최단 거리는 0인걸 넣어줌


        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.end])
                continue;

            visited[now.end] = true;

            for(Node next : adjList[now.end]){
                if(dist[next.end] > now.cost + next.cost){
                    dist[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }

}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_1753 {

    public static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.weight = weight;
            this.end = end;
        }
    }

    static int V;
    static int E;
    static int startEdge;
    static ArrayDeque<Node>[] adjList;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        startEdge = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        visited = new boolean[V+1];
        adjList = new ArrayDeque[V+1];

        for(int i = 0 ; i < V+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node k = new Node(end,weight);
            adjList[start].add(k);
        }

        dijstra(startEdge);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dijstra(int start){
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.end])
                continue;

            visited[now.end] = true;

            for(Node next : adjList[now.end]){
                if(dist[next.end] > now.weight + next.weight){
                    dist[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}

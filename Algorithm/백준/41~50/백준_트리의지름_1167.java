package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_트리의지름_1167 {

    public static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayDeque<Node>[] adjList;
    static boolean[] visited;
    static int answer = 0;
    static int far_idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine()); // 정점의 갯수 받음
        adjList = new ArrayDeque[V+1]; // adjList 초기화

        for(int i = 0; i < V+1; i++){ // adjList[i] 배열 초기화
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < V; i++){ // 값 입력 받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1)
                    break;
                else {
                    int weight = Integer.parseInt(st.nextToken());
                    adjList[start].add(new Node(end, weight));
                }
            }
        }

            visited = new boolean[V+1]; // 매번 확인해야 되므로 매번 초기화
            dfs(1, 0);
            visited = new boolean[V+1]; // 매번 확인해야 되므로 매번 초기화
            dfs(far_idx,0);

            // 가장 멀리갔을때 Idx 기억해 그 idx에서 dfs 탐색
        System.out.print(answer);
    }

    public static void dfs(int start, int dist){
        visited[start] = true;

        if(answer < dist){
            far_idx = start;
        }
        answer = Math.max(answer, dist);


        for(Node next : adjList[start]){
            int end = next.end;
            int weight = next.weight;
            if(!visited[end]){
                int next_dist = dist + weight;
                dfs(end, next_dist);
            }
        }

    }
}

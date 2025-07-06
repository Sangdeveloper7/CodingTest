package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_DFS와BFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited_bfs;
    static boolean[] visited_dfs;
    static ArrayDeque<Integer> answer_bfs;
    static ArrayDeque<Integer> answer_dfs;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        visited_bfs = new boolean[N+1];
        visited_dfs = new boolean[N+1];
        answer_bfs = new ArrayDeque<>();
        answer_dfs = new ArrayDeque<>();

        for(int i = 0; i < N+1; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        for(int i = 0; i < N+1; i++){
            Collections.sort(adjList[i]);
        }

        dfs(V);
        bfs(V);

        for(int i : answer_dfs){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i : answer_bfs){
            System.out.print(i + " ");
        }

    }

    public static void dfs(int now){
        visited_dfs[now] = true;
        answer_dfs.add(now);

        for(int next : adjList[now]){
            if(!visited_dfs[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited_bfs[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer_bfs.add(now);

            for(int next : adjList[now]){
                if(!visited_bfs[next]){
                    queue.addLast(next);
                    visited_bfs[next] = true;
                }
            }
        }
    }


}

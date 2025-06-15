package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_연결요소개수 {
    static ArrayDeque<Integer>[] adjList;
    static boolean[] visited;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        count = 0;

        adjList = new ArrayDeque[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < N + 1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i <M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }


        for(int i = 1; i < N +1; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.print(count);
    }

    public static void dfs(int now){
        visited[now] = true;

        for(int next : adjList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_ABCDE {
    static ArrayDeque<Integer>[] adjList;
    static boolean[] visited;
    static int N;
    static boolean flag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayDeque[N];
        for(int i = 0; i < N; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            dfs(i, 1);
            if(flag)
                break;
        }

        if(flag)
            System.out.print("1");
        else
            System.out.print("0");

    }

    public static void dfs(int now, int dept){
        if(dept == 5){
            flag = true;
            return;
        }

        visited[now] = true;
        for(int next : adjList[now]){
            if(!visited[next]){
               dfs(next, dept+1);
               if(flag)
                   return;
            }
        }
        visited[now] = false;
    }
}

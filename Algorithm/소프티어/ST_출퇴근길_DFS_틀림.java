package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ST_출퇴근길_DFS_틀림 {


    private static ArrayDeque<Integer>[] adjList;
    private static ArrayDeque<Integer>[] reverseAdjList;
    private static int n;
    private static int S, T;
    private static boolean[] visited1;
    private static boolean[] visited2;
    private static boolean[] visited3;
    private static boolean[] visited4;


    private static void dfs(int now,  int target, boolean[] visited,  ArrayDeque<Integer>[] visitednow){
        visited[now] = true;

        if(now == target)
            return;

        for(int next : visitednow[now]){
            if(!visited[next]){
                dfs(next, target, visited, visitednow);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayDeque[n+1];
        reverseAdjList = new ArrayDeque[n+1];
        visited2 = new boolean[n+1];
        visited1 = new boolean[n+1];
        visited3 = new boolean[n+1];
        visited4 = new boolean[n+1];

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
            reverseAdjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            reverseAdjList[v].add(u);
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dfs(S, T, visited1, adjList);              // S → X
        dfs(T, S, visited2, reverseAdjList);          // X → T  (== T → X on reversed)
        dfs(T, S, visited3, adjList);                 // T → X
        dfs(S, T, visited4, reverseAdjList);     // X -> S

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i != S && i != T ){

                boolean onGoPath = visited1[i] && visited2[i];    // 출근길 상에 있음
                boolean onReturnPath = visited3[i] && visited4[i]; // 퇴근길 상에 있음
                if (onGoPath && onReturnPath) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}



/*
5 9
1 2
1 4
2 1
2 3
3 4
3 5
4 1
4 3
5 1
1 3
answer = 1

8 14
1 2
1 5
1 7
2 3
3 1
4 1
4 2
5 4
5 8
6 2
6 3
7 1
7 6
8 7
6 5

answer = 4
* */
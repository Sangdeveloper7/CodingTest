package PR.level0;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PR_저자_깊이우선탐색순회_DFS {

    private static ArrayDeque<Integer>[] adjList; // 인접 리스트 저장 배열
    private static boolean[] visited; // 방문 체크용 배열
    private static ArrayList<Integer> answer;

    private static int[] solution(int n, int[][] graph, int start){
        adjList = new ArrayDeque[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr : graph){
            adjList[arr[0]].add(arr[1]);
        }
        answer = new ArrayList<>();

        dfs(start);

        return answer.stream().mapToInt(i->i).toArray();
    }

    private static void dfs(int now){
        visited[now] = true;
        answer.add(now);

        for(int next : adjList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4},{4,5}};
        int start = 1;
        int n = 5;
        int[] result = solution(n, arr, start);

        for(int i : result)
            System.out.print(i + " ");
    }
}

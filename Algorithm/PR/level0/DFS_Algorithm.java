package PR.level0;

import java.util.ArrayDeque;

public class DFS_Algorithm {

    /*
    1.
    * */
    private static ArrayDeque<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Integer> answer;

    private static int[] solution(int n, int[][] graph, int start) {
        adjList = new ArrayDeque[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i < n + 1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr : graph){
            adjList[arr[0]].add(arr[1]);
        }
        answer = new ArrayDeque<>();

        dfs(start);
        int[] returnvalue = new int[answer.size()];
        int j = 0;
        for(int i : answer){
            returnvalue[j++] = i;
        }

        return returnvalue;
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
        int[][] arr2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        int start2 = 1;  // 출력: 1 2 4 5 3 (DFS 순서에 따라 다를 수 있음)
        int[][] arr3 = {{1, 2}, {2, 3}, {4, 5}};
        int start3 = 1;  // 출력: 1 2 3 (4,5는 연결 안됨)
        int[][] arr4 = {{1, 2}, {2, 3}, {3, 4}, {4, 2}, {3, 5}};
        int start4 = 1;  // 출력: 1 2 3 4 5 (visited 없으면 무한루프 위험)
        int n = 5;
        int[] result = solution(n, arr3, start2);

        for(int i : result)
            System.out.print(i + " ");
    }
}

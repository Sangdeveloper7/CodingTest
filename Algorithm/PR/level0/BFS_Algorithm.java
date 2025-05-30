package PR.level0;

import java.util.ArrayDeque;

public class BFS_Algorithm {

    private static ArrayDeque<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Integer> answer;


    private static int[] solution(int[][] arr, int start, int n){
        adjList = new ArrayDeque[n+1];
        visited = new boolean[n+1];
        answer = new ArrayDeque<>();

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr2 : arr){
            adjList[arr2[0]].add(arr2[1]);
        }

        bfs(start);
        int[] answer2 = new int[answer.size()];
        int j = 0;
        for(int k : answer){
            answer2[j++] = k;
        }
        return answer2;

    }

    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);

            for(int next : adjList[now]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

    }


    private static void bfsTest(int[][] graph, int start, int n) {
        int[] result = solution(graph, start, n);
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("예제 1: 선형 그래프");
        bfsTest(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 1, 5);
        System.out.println("\n예제 2: 트리 구조");
        bfsTest(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}}, 1, 5);
        System.out.println("\n예제 3: 비연결 그래프");
        bfsTest(new int[][]{{1, 2}, {2, 3}, {4, 5}}, 1, 5);
        System.out.println("\n예제 4: 사이클 존재");
        bfsTest(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 2}, {3, 5}}, 1, 5);
    }
}

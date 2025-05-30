package PR.level2;

import java.util.ArrayDeque;

public class PR_전력망을둘로나누기_DFS {

        /*
        1. DFS 탐색이 필요 어떤 전선이 어디와 연결 되어 있는지 확인
        2. 자식 노드의 수를 계산해서 전체노드 - 자식노드 가 가장 적은 것 찾기
        */
        private static ArrayDeque<Integer>[] adjList;
        private static boolean[] visited;
        private static int N, answer;

        private static int min = Integer.MAX_VALUE;

        public int solution(int n, int[][] wires) {
            N = n;
            answer = n - 1;

            adjList = new ArrayDeque[n+1];

            for(int i = 0; i < n+1; i++){
                adjList[i] = new ArrayDeque<>();
            }

            visited = new boolean[n+1];

            for(int[] arr : wires){
                adjList[arr[0]].add(arr[1]);
                adjList[arr[1]].add(arr[0]);
            }

            dfs(1);

            return answer;
        }

        private static int dfs(int now){
            visited[now] = true;
            int sum = 0;

            for(int next : adjList[now]){
                if(!visited[next]){
                    int cnt = dfs(next);
                    answer = Math.min(answer, Math.abs(N - cnt * 2));
                    sum += cnt;
                }
            }
            return sum +1;
        }
}

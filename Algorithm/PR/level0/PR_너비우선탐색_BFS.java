package PR.level0;

import java.util.ArrayDeque;

public class PR_너비우선탐색_BFS {

    /*
    * 1. ArrayDeque<Integer>[] adjList 를 만든다 -> 여기다 엣지들의 연결을 만든다 ex) {{1번과 연결된 노드 , 1, 2, 3, 4}, {2번 노드와 연결된 노드, 1, 3}, {}} 이런거 만듬
    * 2. boolean[] visited, ArrayDeque<Integer> answer 만듦 -> 방문 체크 , 답 넣는 배열(이거는 탐색한 노드 넣음)
    * 3. adjList = new ArrayDeque[n+1]; 초기화 한다 -> for(int i = 0; i < n+1 까지 초기화 한다) adjList[i] = new ArrayDeque<>();
    * 4. int[][] arr  즉, 맵 정보가 들어있는 정보를 adjList[]에 넣는다 1 -> 2 가 연결 되있다는걸 넣는다
    * 5. bfs(int start) = > queue 를 만든다
    *   1. 처음엔 큐에 넣고, 방문처리
    *   2. 큐에 무슨 노드가 있을때는 while -> 큐에서 하나를 poll, 앤서 배열에 넣는다 , adjList에 대해서 노드와 연결된 next들을 모두 탐색한다 -> 방문했는지 확인 후 큐에 넣는다 방문했다고 체크
    * */

    private static ArrayDeque<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Integer> answer;


    private static int[] solution(int[][] arr, int n, int start){
        adjList = new ArrayDeque[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int[] arr2 : arr){
            adjList[arr2[0]].add(arr2[1]);
        }
        answer = new ArrayDeque<>();
        bfs(start);

        return answer.stream().mapToInt(i->i).toArray();
    }

    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
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

    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4},{4,5}};
        int start = 1;
        int n = 5;
        int[] result = solution(arr, n, start);

        for(int i : result)
            System.out.print(i + " ");
    }
}

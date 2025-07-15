package PR.level0;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.IntFunction;


public class                                                                                                   PR_저자_다익스트라_알고리즘 {
    static final int INF = Integer.MAX_VALUE;

    /*
    * 1. 노드의 정보(노드 번호와 거리)를 저장할 클래스를 하나 만든다.
    * 2. 그래프를 담을 arrayList<Integer>[]를 하나 만든다
    * 3. 그래프의 인접 노드 정보를 담는다.
    * 4. int[] dist 즉, 거리 정보를 담을 배열을 하나 만든다.
    * 5. Arrays.fill을 통해 dist 배열의 모든 값을 최댓값으로 바꾼다.
    * 6. 시작 노드의 값을 0으로 초기화 한다.
    * 7. 우선순위 큐를 생성하고(생성할 때 o1, o2 비교를 통해 작은 값으로 pq 내림차순 정렬하는 priority queue) 시작 노드를 삽입한다
    * 8. 현재 거리가 가장 짧은 노드를 poll()를 통해서 가져온다 .
    * 9. pq가 비어있지 않으면 현재 노드의 거리 값과 큐에서 가져온 거리 값과 비교 후 -> 큐에서 가져온 거리의 값보다 크면 무시
    * 10. 현재 노드와 인접한 노드들의 거리 값을 계산하여 업데이트 -> 기존에 발견했던 거리보다 더 짧은 거리를 발견하면 거리 값을 갱신하고 큐에 넣음
    * 11. 최단 거리를 담고 있는 배열을 반환한다.
    * */

    private static class Node{
        int dest;
        int cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static int[] solution(int[][] graph, int start, int n){
        ArrayDeque<Node>[] adjList = new ArrayDeque[n+1];
        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int [] arr : graph){
            adjList[arr[0]].add(new Node(arr[1], arr[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // pq는 원래는 작은 값부터 나온다 하지만 반대로 큰 수 부터 나오게 하고 싶으면 o2.cost - o1.cost로 코드를 짜면 된다.
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest] < now.cost) continue;

            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        int start = 0;
        int n = 3;
        int[][] arr2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
        int n2 = 4;
        int[] result = solution(arr, start, n);

        for(int i : result){
            System.out.println(i + " ");
        }
    }
}

package PR.level3;

import java.util.Arrays;

public class PR_다시_섬연결하기_Hash_Greedy {

    /*
    * 1. 섬을 UnionFind 집합으로 표시한다 ArrayDeuque<Integer>[] Sum; -> 1번 섬하고 무엇이 연결되있는지 1 -> {2, 3, 4} 이런식
    * 2. union, find 함수 만들기
    * 3. HashSet -> 현재 방문한 노드 집합
    * 4. Math.min으로
    * */

    private static int[] parent;

    private static int find(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x1 = find(a);
        int x2 = find(b);
        parent[x2] = x1;
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,(o1, o2) -> Integer.compare(o1[2] , o2[2]));

        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int edges = 0;

        for(int[] edge : costs){
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if(edges == n-1)
                break;
            if(find(a) != find(b)){
                union(a, b);
                answer += cost;
                edges++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };

        int result = solution(n, costs);
        System.out.println("최소 비용: " + result);  // 출력: 최소 비용: 4
    }
}

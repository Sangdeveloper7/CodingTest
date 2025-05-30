package PR.level0;

import java.util.ArrayDeque;
import java.util.Arrays;

public class UnionFind {

    private static int[] parent;

    private static boolean[] solution(int k, int[][] arr) {

        parent = new int[k];

        for(int i = 0; i < k; i++){
            parent[i] = i;
        }
        ArrayDeque<Boolean> result = new ArrayDeque<>();

        for(int[] a : arr){
            int x = a[0];
            int y = a[1];
            int z = a[2];
            if(x == 0){
                union(y,z);
            }else{
                if(find(y) == find(z)){
                    result.addLast(true);
                }else{
                    result.addLast(false);
                }
            }

        }

        boolean[] answer = new boolean[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.poll();
        }

        return answer;
    }

    private static int find(int x){
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
        System.out.println(Arrays.toString(solution(4, arr)));
    }
}

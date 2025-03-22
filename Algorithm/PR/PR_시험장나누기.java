import java.util.HashSet;

public class PR_시험장나누기 {

    private static int mid, use;


    public static int solution(int k, int[] num, int[][] links) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]); // 가장 큰값 구하기 -> why? min, max 에서 min값 구하려고
            set.add(i); // 부모 노드 찾기 위해 전체 vertex의 value 안에 넣음
        }

        for(int[] a : links) {
            for(int i : a){
                set.remove(i); // 자식 노드 제거 why? -> loot 노드 구하려고
            }
        }

        int root = set.iterator().next();

        int left = max;
        int right = 10000 * 10000;

        while(left < right) {
            mid = (left + right) / 2;
            use = k-1;
            dfs(root, num, links);
            if(use < 0){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    private static int dfs(int now, int[] num, int[][] links) {
        if(now == -1){
            return 0;
        }
        int l = dfs(links[now][0], num, links);
        int r = dfs(links[now][1], num, links);
        int max = Math.max(l, r);
        int min = Math.min(l, r);
        int sum = num[now] + min + max;
        if(sum > mid){
            sum -= max;
            use--;
        }
        if(sum > mid){
            sum -=min;
            use--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] num = {12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1};
        int[][] links = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10}, {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1}};
        System.out.println(solution(k, num, links));
    }
}

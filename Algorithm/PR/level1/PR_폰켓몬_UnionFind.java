package PR.level1;

import java.util.HashSet;

public class PR_폰켓몬_UnionFind {

    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hset = new HashSet<>();
        int length = nums.length / 2;

        for (int i : nums) {
            hset.add(i);
        }

        answer = Math.min(length, hset.size());
        return answer;
    }

    public static void main(String[] args) {

    }
}

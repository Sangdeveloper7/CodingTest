package PR.level1;

import java.util.*;

public class PR_실패율 {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N + 2]; // stages 값이 N+1까지 가능하므로

        // O(M): 유저가 머무르고 있는 스테이지 수 count
        for (int stage : stages) {
            stageCount[stage]++;
        }

        int totalPlayers = stages.length;
        float[] failureRate = new float[N];

        // O(N): 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureRate[i - 1] = 0;
            } else {
                failureRate[i - 1] = (float) stageCount[i] / totalPlayers;
                totalPlayers -= stageCount[i];
            }
        }

        // O(N log N): 인덱스 기반 정렬
        List<Integer> stageList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stageList.add(i);
        }

        stageList.sort((a, b) -> {
            if (failureRate[b] == failureRate[a]) {
                return a - b;
            } else {
                return Float.compare(failureRate[b], failureRate[a]);
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(result));  // [3, 4, 2, 1, 5]
    }
}
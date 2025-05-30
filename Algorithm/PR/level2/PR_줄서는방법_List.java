package PR.level2;

import java.util.ArrayList;

public class PR_줄서는방법_List {

    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];
            ArrayList<Integer> people = new ArrayList<>();

            // 1부터 n까지 사람 추가
            for (int i = 1; i <= n; i++) {
                people.add(i);
            }

            // 1-based index → 0-based index로 변환
            k--;

            // 미리 팩토리얼 계산해놓기
            long[] factorial = new long[n];
            factorial[0] = 1;
            for (int i = 1; i < n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }

            // k가 n!보다 큰 경우 예외 처리
            if (k >= factorial[n - 1] * n) {
                throw new IllegalArgumentException("k는 n! 이하의 값이어야 합니다.");
            }

            // 순열 구성
            for (int i = 0; i < n; i++) {
                int size = people.size();
                int idx = (int)(k / factorial[n - 1 - i]);
                answer[i] = people.get(idx);
                people.remove(idx);
                k %= factorial[n - 1 - i];
            }

            return answer;
        }
    }
}

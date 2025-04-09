package PR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PR_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        // 가변 길이 ArrayList 정의
        ArrayList<Integer> list = new ArrayList<>();

        // 이중 for문을 통한 서로 더한 모든 경우의 수 (자신제외) ArrayList에 넣기
        for(int i = 0; i < numbers.length; i++) {
           for(int j = i+1; j < numbers.length; j++) {
               list.add(numbers[i] + numbers[j]);
           }
        }

        // ArrayList 중복 제거
        HashSet<Integer> set = new HashSet<>(list);

        // 2. 다시 리스트로 바꿔서 정렬
        ArrayList<Integer> result = new ArrayList<>(set);
        result.sort(null);  // 내림차순 정렬
        int t = 0;
        int[] answer = new int[result.size()];
        for(int k : result) {
            answer[t++] = k;
        }


        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 1, 3, 4, 1};
        int[] answer = new PR_두개뽑아서더하기().solution(numbers);
        System.out.println(Arrays.toString(answer));
    }
}

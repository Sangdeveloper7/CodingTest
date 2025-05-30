package PR.level2;

import java.util.ArrayDeque;

public class PR_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = new int[progresses.length];
            int[] elsedays = new int[progresses.length];

            for(int i = 0; i < progresses.length; i++) {
                int p = 100 - progresses[i];
                elsedays[i] = (int)(p / speeds[i]) + 1;
                if(p % speeds[i] == 0) {
                    elsedays[i]--;
                }
            } /*
         1. 남은 마감기한을 Elsedays[] 배열에 넣습니다.
       */
            ArrayDeque<Integer> answer_arr = new ArrayDeque<>();
            int now_max = 0; // 현재까지 가장 큰 값
            int now_count = 0; // 현재까지 몇개의 작업이 동시에 진행이 가능한지

            for(int i : elsedays) {
                if(now_max == 0){
                    now_max = i;
                    now_count++;
                }else{
                    if(i > now_max){
                        answer_arr.addLast(now_count);
                        now_max = i;
                        now_count = 1;
                    }else{
                        now_count++;
                    }
                }
            }
            answer_arr.addLast(now_count);
            int k = answer_arr.size();
            answer = new int[k];

            for(int i = 0; i < k; i++) {
                answer[i] = answer_arr.removeFirst();
            }
            return answer;
        }
    }
}

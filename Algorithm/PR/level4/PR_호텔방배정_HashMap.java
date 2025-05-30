package PR.level4;

import java.util.HashMap;

public class PR_호텔방배정_HashMap {
    class Solution {
        private static HashMap<Long, Long> parent;

        public long[] solution(long k, long[] room_number) {
            long[] answer = {};
            parent = new HashMap<>();
            answer = new long[room_number.length];

            for (int i = 0; i < room_number.length; i++) {
                answer[i] = find(room_number[i]);
            }

            return answer;
        }

        private static long find(long a){
            if(parent.get(a) == null){
                parent.put(a, a+1);
                return a;
            }
            parent.put(a, find(parent.get(a)));
            return parent.get(a);
        }
    }
}

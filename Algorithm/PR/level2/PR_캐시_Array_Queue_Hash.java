package PR.level2;

import java.util.ArrayDeque;

public class PR_캐시_Array_Queue_Hash {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            ArrayDeque<String> queue = new ArrayDeque<>();
            if (cacheSize == 0) {
                return cities.length * 5;
            }
            for(String city : cities){
                if(queue.isEmpty()){
                    queue.addLast(city);
                    answer += 5;
                }else{

                    if(containsCity(queue, city)){
                        answer += 1;
                        removeCity(queue, city);
                        queue.addLast(city);
                    }else{
                        if(queue.size() == cacheSize){
                            queue.removeFirst();
                        }
                        answer += 5;
                        queue.addLast(city);
                    }
                }
            }
            return answer;
        }

        private static boolean containsCity(ArrayDeque<String> queue, String cityName) {
            for (String c : queue) {
                if (c.equalsIgnoreCase(cityName)) {
                    return true;
                }
            }
            return false;
        }

        private static void removeCity(ArrayDeque<String> queue, String cityName) {
            for (String c : queue) {
                if (c.equalsIgnoreCase(cityName)) {
                    queue.remove(c);  // 정확한 값을 remove 해야 하니까
                    break;
                }
            }
        }
    }
}

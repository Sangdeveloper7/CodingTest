package PR.level2;

import java.util.*;

public class PR_메뉴리뉴얼 {

    public class Solution {
        public String[] solution(String[] orders, int[] course) {
            Map<Integer, Map<String, Integer>> courseMap = new HashMap<>();

            for (int len : course) {
                courseMap.put(len, new HashMap<>());
            }

            for (String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                generateCombinations(orderArr, 0, new StringBuilder(), courseMap);
            }

            List<String> answer = new ArrayList<>();

            for (int len : course) {
                Map<String, Integer> freqMap = courseMap.get(len);

                int max = freqMap.values().stream()
                        .filter(v -> v > 1)
                        .max(Integer::compareTo)
                        .orElse(0);

                for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                    if (entry.getValue() == max && max > 1) {
                        answer.add(entry.getKey());
                    }
                }
            }

            Collections.sort(answer);
            return answer.toArray(new String[0]);
        }

        private void generateCombinations(char[] order, int idx, StringBuilder sb,
                                          Map<Integer, Map<String, Integer>> courseMap) {
            if (courseMap.containsKey(sb.length())) {
                String key = sb.toString();
                Map<String, Integer> freq = courseMap.get(sb.length());
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }

            for (int i = idx; i < order.length; i++) {
                sb.append(order[i]);
                generateCombinations(order, i + 1, sb, courseMap);
                sb.deleteCharAt(sb.length() - 1); // 백트래킹
            }
        }
    }
}

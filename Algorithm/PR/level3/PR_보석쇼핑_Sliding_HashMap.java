package PR.level3;

import java.util.HashMap;

public class PR_보석쇼핑_Sliding_HashMap {

    public static int[] solution(String[] gems) {
        int[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String gem : gems) {
            hashMap.put(gem, 0);
        }
        int max = hashMap.size();;
        int min = gems.length;

        int left = 0;
        int right = 0;

        int start = 1;
        int end = gems.length ;
        hashMap = new HashMap<>();

        while(right < gems.length) {
            if(hashMap.containsKey(gems[right])) {
                hashMap.put(gems[right], hashMap.get(gems[right]) + 1);
            }else{
                hashMap.put(gems[right], 1);
            }
            right += 1;

            while(hashMap.size() == max) {
                if(right - left < min) {
                    min = right - left;
                    start = left + 1;
                    end = right;
                }
                int cnt = hashMap.get(gems[left]) -1;
                if(cnt == 0) {
                    hashMap.remove(gems[left]);
                }else{
                    hashMap.put(gems[left], cnt);
                }
                left += 1;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        String[] arr = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] arr2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] arr3 = {"XYZ", "XYZ", "XYZ"};

        int[] arr4 = solution(arr);
        for(int i : arr4) {
            System.out.println(i);
        }

    }
}

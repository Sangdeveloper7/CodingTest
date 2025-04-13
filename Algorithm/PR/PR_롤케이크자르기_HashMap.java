import java.util.HashMap;
import java.util.HashSet;

public class PR_롤케이크자르기_HashMap {

    public static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i = 0; i<topping.length; i++) {
            set.add(topping[i]);
            map.put(i, set.size());
        }
        for(int j = topping.length - 1; j >= 0; j--) {
            set2.add(topping[j]);
            map2.put(j, set2.size());
        }

        for(int i = 0; i < map.size()-1; i++) {
            int map1_value = map.get(i);
            int map2_value = map2.get(i+1);
            if(map1_value == map2_value) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = solution(topping);
        System.out.println(result);
    }
}

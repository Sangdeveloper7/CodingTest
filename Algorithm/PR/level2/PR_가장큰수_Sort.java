package PR.level2;

import java.util.ArrayList;
import java.util.Collections;

public class PR_가장큰수_Sort {


    public static String solution(int[] numbers) {
        ArrayList<String> al = new ArrayList<>();

        for(int num : numbers){
            al.add(String.valueOf(num));
        }

        al.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();

        for(String k : al){
            sb.append(k);
        }

        return sb.charAt(0) == '0' ? "0" :sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}

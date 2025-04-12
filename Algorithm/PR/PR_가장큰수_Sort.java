import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class PR_가장큰수_Sort {
    public static String solution(int[] numbers) {
       String answer = "";
       ArrayList<String> list = new ArrayList<>();

       for (int number : numbers) {
           list.add(String.valueOf(number));
       }

        Collections.sort(list, (o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        } );

        StringBuilder sb = new StringBuilder();

        for(String s : list) {
            sb.append(s);
        }
        if(sb.charAt(0) == '0') {
            return "0";
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}

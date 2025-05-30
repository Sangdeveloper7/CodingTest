package PR.level1;

import java.util.Arrays;
import java.util.HashMap;

public class PR_문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
        return strings;
    }

    public static void main(String[] args){
        String[] k = {"sun", "bed", "car"};
        solution(k, 1);
        for(String s : k){
            System.out.print(s + " ");

        }
        String[] k2 = {"abce", "abcd", "cdx"};

    }
}

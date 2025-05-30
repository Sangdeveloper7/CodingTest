package PR.level1;

import java.util.Arrays;
import java.util.Collections;

public class PR_정수내림차순으로배치 {
    public static long solution(long n) {
        long answer = 0;
        String k = String.valueOf(n);
        char[] arr = k.toCharArray();
        Arrays.sort(arr);

        String re = "";
        for(int i = arr.length-1; i >= 0; i--){
            re += arr[i];
        }

        return Long.parseLong(re);
    }
    public static void main(String[] args){
        long n = 118372;
        long k = solution(n);
        System.out.print(k);
    }
}

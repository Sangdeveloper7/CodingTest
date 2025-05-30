package PR.level1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PR_자연수뒤집기 {
    public static int[] solution(long n) {
        int[] answer = {};
        String n_str = String.valueOf(n);
        String[] n_char = new String[n_str.length()];

        n_char = n_str.split("");
        answer = new int[n_char.length];

        int j = 0;
        for(int i = n_char.length - 1; i >= 0; i--) {
            answer[j++] = Integer.parseInt(n_char[i]);
        }


        return answer;
    }

    public static void main(String[] args){
        int n = 12345;
        int[] result = solution(n);
        for(int i : result){
            System.out.println(i);
        }
    }
}

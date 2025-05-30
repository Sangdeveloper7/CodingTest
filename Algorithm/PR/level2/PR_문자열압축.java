package PR.level2;

import java.util.ArrayDeque;

public class PR_문자열압축 {

    private static ArrayDeque<String> splitN(String s, int length){
        ArrayDeque<String> token = new ArrayDeque<>();

        for(int i = 0 ; i < s.length(); i+=length){
            int end = i + length;
            if(end > s.length()) end = s.length();
            token.add(s.substring(i, end));
        }
        return token;
    }

    private static int compress(String s, int length){
        StringBuilder sb = new StringBuilder();
        String now = ""; // last
        int count = 0;

        for(String token : splitN(s, length)){
            if(token.equals(now))
                count++;
            else{
                if(count > 1) sb.append(count);
                sb.append(now);
                now = token;
                count = 1;
            }
        }

        if(count > 1){
            sb.append(count);
        }
        sb.append(now);
        return sb.length();
    }

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i <= s.length()/2; i++){
            int compressed = compress(s, i);
            if(compressed < min)
                min = compressed;
        }
        return min;
    }

    public static void main(String[] args){
        String s = "abcabcabcabcdededededede";
        int result = solution(s);
        System.out.print(result);
    }
}

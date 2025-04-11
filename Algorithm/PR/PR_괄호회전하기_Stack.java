import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class PR_괄호회전하기_Stack {

    public static boolean check_Panlindrome(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(Character k : s.toCharArray() ) {
            if(!stack.isEmpty() && map.get(stack.peek()) == k) {
                stack.pop();
            }else{
                stack.push(k);
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public static int solution(String s) {
        int answer = 0;
        int s_num = s.length();
        String s2 = s + s;
        for(int c = 0; c < s2.length()/2; c++) {
            String instance = "";
            for(int i = c; i < c + s_num; i++) {
                instance += s2.charAt(i);
            }
            if(check_Panlindrome(instance)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String string = "[)(]";
        System.out.println(solution(string));
    }
}

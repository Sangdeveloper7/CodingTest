package PR;

import java.util.ArrayDeque;

public class PR_올바른괄호의갯수_Stack {
    static boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for(char k : s.toCharArray()) {
            if(k == '('){
                stack.addLast(k);
            }else if(k == ')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
            count++;
        }
            if(count == s.length() && answer != false && stack.isEmpty()){
                answer = true;
            }else{
                answer = false;
            }

        return answer;
    }


    public static void main(String[] args) {
        String s1 = "(()(";
        boolean alpha = solution(s1);
        System.out.println(alpha);
    }
}

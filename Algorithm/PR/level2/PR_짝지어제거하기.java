package PR.level2;

import java.util.ArrayDeque;

public class PR_짝지어제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;
            String copy_s = s;
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (Character c : copy_s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek().equals(c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

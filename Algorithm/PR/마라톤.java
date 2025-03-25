import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 마라톤 {
    public static int solution(int[] ingredient) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i : ingredient) {
            stack.push(i);
            if(stack.size() >= 4){
                int a = stack.pop();
                int b = stack.pop();
                int c = stack.pop();
                int d = stack.pop();
                if (d == 1 && c == 2 && b == 3 && a == 1) {
                    answer++; // 햄버거 완성
                }else{
                    stack.push(d);
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] i = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(i));
    }
}


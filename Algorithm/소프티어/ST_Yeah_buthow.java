package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class ST_Yeah_buthow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayDeque<String> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(queue.peek().equals("1")){
                    queue.addLast("+");
                    queue.addLast("1");
                }else if(queue.peek().equals(")")){
                    queue.addLast("+");
                    queue.addLast("1");
                }
                else
                    queue.addLast("1");

                queue.addLast(")");
            }else if(c == '(') {
                if(queue.isEmpty()) {
                    queue.addLast("(");
                }
                else{
                    queue.addLast("(");

                    queue.addLast("1");
                }
            }
        }
        String answer = "";
        while(!queue.isEmpty()){
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}

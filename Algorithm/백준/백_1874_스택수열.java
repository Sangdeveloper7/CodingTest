package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 백_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<String> result = new ArrayList<>();

        int current = 1;
        boolean possible = true;

        for(int i = 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());

            while(current <= target){
                stack.push(current++);
                result.add(("+"));
            }

            if(stack.peek() == target){
                stack.pop();
                result.add("-");
            }else{
                possible = false;
                break;
            }
        }

        if (possible) {
            for (String op : result) {
                System.out.println(op);
            }
        } else {
            System.out.println("NO");
        }
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 백준_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i =1; i <= N; i++){
            queue.addLast(i);
        }
        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print(queue.poll());
    }
}

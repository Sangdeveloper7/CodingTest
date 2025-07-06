package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();

            int add = one + two;
            count += add;
            pq.add(add);
        }
        System.out.print(count);
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 백준_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq_negative = new PriorityQueue<>();
        PriorityQueue<Integer> pq_positive = new PriorityQueue<>(Collections .reverseOrder());
        int count_zero = 0;
        int count_one = 0;


        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0)
                count_zero++;
            else if(now == 1)
                count_one++;
            else if(now > 0)
                pq_positive.add(now);
            else
                pq_negative.add(now);
        }

        int count = 0;

        while(pq_negative.size() > 1){
            int one = pq_negative.poll();
            int two = pq_negative.poll();
            count += one * two;
        }
        if(pq_negative.size() == 1 && count_zero > 0){
            count_zero--;
        }else if(pq_negative.size() == 1){
            count += pq_negative.poll();
        }

        while(pq_positive.size() > 1){
            int one = pq_positive.poll();
            int two = pq_positive.poll();
            count += one * two;
        }
        if(pq_positive.size() == 1){
            count += pq_positive.poll();
        }

        count += count_one;


        System.out.print(count);
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int A = Math.abs(a);
            int B = Math.abs(b);

            if(A == B){
                return Integer.compare(a,b);
            }
            return Integer.compare(A, B);
        });
        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                if(pq.isEmpty())
                    System.out.println("0");
                else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(now);
            }
        }

    }
}

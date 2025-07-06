package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_거의소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long M = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        int count = 0;

        int[] arr = new int[10_000_001];

        for(int i = 2; i < 10_000_001; i++){
            arr[i] = i;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 2; i < 10_000_001; i++){
            if(arr[i] != 0){
                queue.addLast(i);
                for(int j = 2*i; j < 10_000_001; j += i){
                    arr[j] = 0;
                }
            }
        }

        for(int i =2; i < 10_000_001; i++){
            if(arr[i] != 0){
                long prime = (long) i * i;

                while(prime <= N){
                    if(prime >= M){
                        count++;
                    }
                    if(prime > N / i) break;
                    prime *= i;
                }
            }
        }

        System.out.print(count);
    }
}

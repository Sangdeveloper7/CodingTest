package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_K번째수_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;

        while(start <= end){
            long middle = (start+end) / 2;
            long cnt = 0;

            for(int i = 1; i <= N; i++){
                cnt += Math.min(N, middle / i);
            }

            if(cnt < K){
                start = middle + 1;
            }else{
                end = middle -1;
            }
        }

        System.out.print(start);
    }
}

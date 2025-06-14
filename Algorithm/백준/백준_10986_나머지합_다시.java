package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10986_나머지합_다시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long count = 0;

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] total = new long[(int) N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            if(i == 0)
                total[0] = Long.parseLong(st.nextToken());
            else
                total[i] = total[i-1] + Long.parseLong(st.nextToken());
        }

        long[] mod = new long[(int) M];

        mod[0] = 1;

        for(int i = 0; i < N; i++){
            int remainder = (int) (total[i] % M);
            if(remainder == 0)
                count++;
            mod[remainder]++;
        }

        for(int i = 0; i < M; i++){
            if(mod[i] >= 2){
                long e = mod[i];
                count += (e*(e-1)) / 2;
            }
        }

        System.out.print(count);
    }
}

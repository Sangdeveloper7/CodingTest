package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class 백준_제곱ㄴㄴ수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);
        BitSet check = new BitSet(size);

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = (min + pow - 1) / pow * pow; // 최소 시작 값

            for (long j = start; j <= max; j += pow) {
                check.set((int) (j - min));
            }
        }

        int count = size - check.cardinality();
        System.out.println(count);
    }
}
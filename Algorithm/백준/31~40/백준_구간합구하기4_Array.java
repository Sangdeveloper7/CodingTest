import java.io.*;
import java.util.*;

public class 백준_구간합구하기4_Array {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N+1];
        input[0] = 0;

        st = new StringTokenizer(br.readLine());
        input[1] = Integer.parseInt(st.nextToken());;
        for (int i = 2; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken()) + input[i - 1];
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(input[end] - input[start - 1]);
        }


    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for(int i = 0; i <N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        long[][] arr2 = new long[M+K][3];
        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
            arr2[i][2] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(long[] arr3 : arr2){
            if(arr3[0] == 1){
                arr[(int) arr3[1]-1] = arr3[2];
            }else{
                long inst = 0;
                for(int i = (int) arr3[1]-1; i<= (int) arr3[2]-1; i++){
                    inst += arr[i];
                }
                sb.append(inst).append("\n");
            }
        }

        System.out.print(sb);
    }
}

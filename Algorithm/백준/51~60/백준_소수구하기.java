package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i = 2; i < N+1; i++){
            arr[i] = i;
        }

        for(int i = 2; i < N+1; i++){
            if(arr[i] != 0){
                for(int j = i * 2; j <=N; j+=i){
                    arr[j] = 0;
                }
            }
        }

        for(int i = 2; i < N+1; i++){
            int k = arr[i];
            if(k != 0){
                System.out.println(k);
            }
        }
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 동전의 개수

        for(int i = N-1; i >= 0; i--){
            if(arr[i] == K){
                count += 1;
                break;
            }
            if(arr[i] < K){
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        System.out.print(count);
    }
}

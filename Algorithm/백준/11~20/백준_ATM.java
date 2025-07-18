package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] arr2 = new int[N];
        arr2[0] = arr[0];
        for(int i = 1; i < N; i++){
           arr2[i] = arr[i] + arr2[i-1];
        }
        int answer = 0;
        for(int k : arr2){
            answer += k;
        }

        System.out.print(answer);
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_가장긴증가하는부분수열4 {
    public static class node{
        int number;
        int[] arr;

        public node(int number, int[] arr){
            this.number = number;
            this.arr = arr;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        node[] dp = new node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            int k =  Integer.parseInt(st.nextToken());
            arr[i] = k;
            dp[i] = new node(1, new int[]{k});
        }

        for(int i = 1; i<N; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i].number < dp[j].number + 1){
                        dp[i].number = dp[j].number + 1;
                        int[] inst = new int[dp[j].arr.length + 1];
                        for(int e = 0; e <dp[j].arr.length; e++){
                            inst[e] = dp[j].arr[e];
                        }
                        inst[dp[j].arr.length] = arr[i];
                        dp[i].arr = inst;
                    }
                }
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i].number > max) {
                max = dp[i].number;
                idx = i;
            }
        }

        int[] result = dp[idx].arr;
        System.out.println(max);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}

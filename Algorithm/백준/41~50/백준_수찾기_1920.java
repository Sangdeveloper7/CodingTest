package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_수찾기_1920 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
           int k = Integer.parseInt(st.nextToken());
           arr2[i] = binary_search(k);
        }

        for(int i : arr2){
            System.out.println(i);
        }
    }

    public static int binary_search(int k){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == k)
                return 1;
            if(arr[mid] < k)
                start = mid+1;
            else
                end = mid -1;

        }

        return 0;
    }
}

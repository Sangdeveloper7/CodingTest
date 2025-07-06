package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_기타레슨 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = 0;
        arr = new int[N];
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
            min = Math.max(min, arr[i]);
        }

        int answer = binaray_search(min, max, arr, M);
        System.out.print(answer);
    }

    public static int binaray_search(int min, int max, int[] arr, int M){
        int answer = 0;

        while(min <= max){
            int middle = (max + min) / 2;
            if(check(middle)){
                answer = middle;
                max = middle -1;
            }else{
                min = middle + 1;
            }
        }
        return answer;
    }

    public static boolean check(int size){
        int count = 1;
        int sum = 0;

        for(int i = 0; i < N; i++){
            if(sum + arr[i] > size){
                count++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }

        return count <= M;
    }
}

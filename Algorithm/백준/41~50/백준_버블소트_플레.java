package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_버블소트_플레 {
    static long count = 0;
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);
        System.out.print(count);
    }

    static void mergeSort(int left, int right){
        if(left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid +1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right){
        int i = left;
        int j = mid +1;
        int k = left;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }
    }
}

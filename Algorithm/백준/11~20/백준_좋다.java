package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;


        for(int i = 0; i < N; i++){
            long find = arr[i];
            int left = 0;
            int right = N-1;
            while(left < right){
                long now = arr[left] + arr[right];
                if(now == find){
                    if(right != i && left != i){
                        count++;
                        break;
                    }else if(left == i) // 1 1 1 1 2 3 3 3 이런식이 될 수도 있음
                        left++;
                    else
                        right--;
                }
                else if(find > now){
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.out.print(count);
    }
}

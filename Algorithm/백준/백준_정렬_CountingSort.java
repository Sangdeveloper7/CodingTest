import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준_정렬_CountingSort {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 10000; i++) {
            for(int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}

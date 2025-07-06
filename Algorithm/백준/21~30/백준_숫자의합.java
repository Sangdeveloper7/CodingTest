import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_숫자의합 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int total = 0;

       String[] arr = new String[N];
       arr = br.readLine().split("");
       for(int i = 0; i<N; i++) {
           total += Integer.parseInt(arr[i]);
       }
       System.out.println(total);
    }
}

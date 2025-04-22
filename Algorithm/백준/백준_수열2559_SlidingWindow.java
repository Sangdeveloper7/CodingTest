import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_수열2559_SlidingWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i =0; i< K; i++){
            sum += nums[i];
        }
        int answer = sum;

        int left = 0;
        int right = K;

        while(right < N){
            sum += nums[right++];
            sum -= nums[left++];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);


    }
}

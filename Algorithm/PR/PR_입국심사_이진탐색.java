import java.security.PrivateKey;

public class PR_입국심사_이진탐색 {

    private static final int MAX = 1_000_000_000;
    private static int N;
    private static int[] time;


    public static long solution(int n, int[] times) {
        N = n;
        time = times;
        long min = 1;
        long max = (long) MAX * MAX;
        while(min < max) {
            long mid = (max + min) / 2;
            if(isPossible(mid)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    private static boolean isPossible(long answer) {
        long n = N;

        for(int i : time) {
            n -= answer/i;
        }

        return n <= 0;
    }
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long e = solution(n,times);
        System.out.println(e);
    }
}

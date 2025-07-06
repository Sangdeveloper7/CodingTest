import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_구간합구하기_SegmentTree {

    private static int s_idx;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        s_idx = 1;
        while (s_idx < N) {
            s_idx *=2;
        }

        tree = new long[s_idx * 2];
        s_idx--;

        for(int i = 1; i <= N; i++) {
            long num = Long.parseLong(br.readLine());
            update(i, num);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1){
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            }else{
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(b, c) + "\n");
            }
        }
        System.out.println(sb);
    }

    private static long query(int left, int right){
        left += s_idx;
        right += s_idx;

        long sum = 0;

        while(left <= right){
            if(left % 2 == 1)
                sum += tree[left];
            if(right % 2 == 0) // 오른쪽은 짝수일 경우 왼쪽 위로 올라가야 하기 때문에 0으로 표시
                sum += tree[right];
            left = (left + 1) / 2;
            right = (right - 1) / 2;
        }
        return sum;
    }

    private static void update(int idx, long num) {
        idx += s_idx; // 현재 인덱스의 값 몇번째 값일 경우 Idx는 인덱스의 값 (현재 숫자)을 나타냄
        tree[idx] = num;
        idx /= 2;

        while(idx >= 1){
            tree[idx] = tree[2*idx] + tree[2*idx + 1];
            idx /= 2;
        }
    }
}

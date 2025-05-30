package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ST_자동차테스트 {

    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;

    private static int lowerBound(int find, int[] allset) {
        int left = 0;
        int right = allset.length - 1;
        while(left < right){
            int mid = (right + left) / 2;

            if(allset[mid] < find){
                left = mid + 1;
            }else
                right = mid;

        }
        return left;
    } // 결과 left 값은 => Mi < left 값이고 mi 다음 수임

    private static int upperBound(int find, int[] allset){
        int left = 0;
        int right = allset.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(allset[mid] <= find)
                left = mid + 1;
            else
                right = mid;

        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] all = new int[n];
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(k > max) max = k;
            if(k < min) min = k;
            all[i] = k;
            set.add(k);
        }

        Arrays.sort(all);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(!set.contains(a)){
                sb.append("0\n");
                continue;
            }

            int low = lowerBound(a, all);
            int middle = upperBound(a, all) - lowerBound(a, all);
            int hign = n - upperBound(a, all);

            int result = low * middle * hign;
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}

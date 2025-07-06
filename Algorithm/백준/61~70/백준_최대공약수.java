package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());
        long result = gcd(n1, n2);

        StringBuilder sb = new StringBuilder();
        while(result > 0){
            sb.append(1);
            result--;
        }

        System.out.println(sb);

    }

    public static long gcd(long a1, long a2){
        if(a2 == 0)
            return a1;
        else
            return gcd(a2, a1 % a2);
    }
}

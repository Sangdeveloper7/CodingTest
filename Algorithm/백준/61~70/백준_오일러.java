package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_오일러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long result = n;
        long temp = n;

        for (long i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                result = result - result / i;
                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }

        if (temp > 1) {
            result = result - result / temp;
        }

        System.out.println(result);
    }
}
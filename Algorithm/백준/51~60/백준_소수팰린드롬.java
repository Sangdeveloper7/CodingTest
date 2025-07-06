package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_소수팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = N; i <= 2_000_000; i++){
            if(checksosu(i)){
                if(checkPalindrome(i)){
                    answer = i;
                    break;
                }
            }
        }
        System.out.print(answer);
    }

    public static boolean checksosu(int number){
        if(number <= 1)
            return false;
        for(int i = 2; i * i <= number; i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean checkPalindrome(int number){
        String s = String.valueOf(number);
        char[] arr = s.toCharArray();
        int arrlength = arr.length;
        for(int i = 0; i < arrlength /2; i++){
            if(arr[i] != arr[arrlength-i-1])
                return false;
        }
        return true;
    }
}

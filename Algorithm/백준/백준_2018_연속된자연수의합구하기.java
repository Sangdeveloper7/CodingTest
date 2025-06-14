package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2018_연속된자연수의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int count = 0;

        while(start <= N){
            int sum = ((end * (end+1)) - (start * (start+1))) / 2;
            sum += start;
            if(sum == N){
                count++;
                start++;
            }else if(sum > N){
                start++;
            }else{
                end++;
            }
        }

        System.out.print(count);
    }
}

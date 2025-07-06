package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 백준_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine().trim();
        String[] arr = N.split("-");
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(i == 0)
                count += Integer.parseInt(arr[i]);
            else{
                int sum = 0;
                String[] temp = arr[i].split("\\+");
                for(String s: temp){
                    sum += Integer.parseInt(s);
                }
                count -= sum;
            }
        }

        System.out.print(count);
    }

}

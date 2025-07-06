package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 백준_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N =br.readLine();

        char[] arr = N.toCharArray();
        Integer[] arr2 = new Integer[arr.length];
        int i = 0;

        for(char k : arr){
            arr2[i++] = Integer.parseInt(String.valueOf(k));
        }

        Arrays.sort(arr2, Collections.reverseOrder());

        for(int k : arr2){
            System.out.print(k);
        }
    }
}

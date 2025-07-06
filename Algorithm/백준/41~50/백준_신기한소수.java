package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_신기한소수 {

    static int[] rx = {2, 3, 5, 7};
    static int[] ry = {1, 3, 5, 7, 9};

    public static boolean checkPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();

        dfs(0, N);
    }

    public static void dfs(int num, int n){
        if(n == 0){
            System.out.println(num);
            return;
        }
        for(int i = 1; i < 10; i++){
            int tmp = 10*num + i;
            if(checkPrime(tmp)){
                dfs(tmp, n-1);
            }
        }
    }
}

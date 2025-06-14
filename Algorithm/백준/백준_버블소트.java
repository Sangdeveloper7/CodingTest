package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 백준_버블소트 {

    public static class Node{
        int idx;
        int val;
        public Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];

        for(int i = 0; i < N; i++){
            arr[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a.val, b.val));

        int max = 0;

        for(int i = 0; i < N; i++){
            max = Math.max(max, arr[i].idx - i);
        }

        System.out.print(max + 1);
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_2252 {

    static ArrayDeque<Integer>[] adjList;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayDeque[N+1];
        arr = new int[N+1];

        for(int i = 0; i < N+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            arr[end]++;
        }

        ArrayDeque<>
    }
}

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class 백준_1325 {
    static ArrayDeque<Integer>[] adjList;
    static int[] count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
        int M = Integer.parseInt(st.nextToken()); // 주어진 갯수

        adjList = new ArrayDeque[N+1]; //

        for(int i = 0; i < N+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        count = new int[N+1];


        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[end].add(start);
        }

        for(int i = 1; i < N+1; i++){
            BFS(i, N);
        }

        int max = -1;

        for(int i : count){
            max = Math.max(max, i);
        }

        ArrayList<Integer> que = new ArrayList<>();

        for(int i = 1; i < N + 1; i++){
            if(count[i] == max)
                que.add(i);
        }

        Collections.sort(que);

        for(int i : que){
            System.out.print(i + " ");
        }


    }

    public static void BFS(int start, int N){
        boolean[] visited = new boolean[N+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : adjList[now]){
                if(!visited[next]){
                    visited[next] = true;
                    count[start]++;
                    queue.add(next);
                }
            }
        }
    }
}

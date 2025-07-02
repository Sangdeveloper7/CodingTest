package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_18352 {

    static ArrayDeque<Integer>[] adjList;
    static int[] distance;
    static ArrayList<Integer> answer;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 갯수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        adjList = new ArrayDeque[N+1];

        for(int i=0; i < N+1; i++){
            adjList[i] = new ArrayDeque<>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
        }

        answer = new ArrayList<>();
        distance = new int[N+1];
        Arrays.fill(distance, -1);

        DFS(X);

        for(int i = 0; i < N+1; i++){
            int count = distance[i];
            if(count == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty())
            System.out.println(-1);
        else{
            Collections.sort(answer);
            for(int i : answer){
                System.out.println(i);
            }
        }
    }

    public static void DFS(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        distance[start] = 0;


        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : adjList[now]){
                if(distance[next] == -1){
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}

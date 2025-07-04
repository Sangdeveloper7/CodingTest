package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_1707 {
    static ArrayDeque<Integer>[] adjList;
    static int[] color;
    static boolean isezintamsec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());


        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            adjList = new ArrayDeque[vertex+1];
            color = new int[vertex+1];

            for(int j = 0; j < vertex +1; j++){
                adjList[j] = new ArrayDeque<>();
            }


            for(int k = 0; k < edge; k++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList[start].add(end);
                adjList[end].add(start);
            }

            isezintamsec = true;

            for(int l = 1; l < vertex+1; l++){
                if(color[l] == 0)
                    BFS(l);
            }

            System.out.println(isezintamsec ? "YES" : "NO");
        }
    }

    static void BFS(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        color[start] = 1;

        while(!queue.isEmpty() && isezintamsec){
            int now = queue.poll();
            for(int next : adjList[now]) {
                if (color[next] == 0) {
                    color[next] = -color[now];
                    queue.add(next);
                }else if(color[next] == color[now]){
                    isezintamsec = false;
                    return;
                }
            }
        }
    }
}

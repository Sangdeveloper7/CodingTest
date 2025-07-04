package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_1976 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M =  Integer.parseInt(br.readLine());

        parents = new int[N+1];

        for(int i = 1; i < N+1; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int connect = Integer.parseInt(st.nextToken());
                if(connect == 1)
                    union(i,j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        int parent = find(firstCity);
        boolean possible = true;

        for(int i = 1; i < M; i++){
            int nextCIty = Integer.parseInt(st.nextToken());
            if(find(nextCIty) != parent){
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static int find(int x){
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return
                parents[x];
    }

    static void union(int x, int y){ㅇ
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY)
            parents[rootY] = rootX;
    }
}

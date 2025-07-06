import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_네트워크연결_MST_kruskal {

    private static Edge[] arr;
    private static final int INF = 987654321;
    private static int[] parent;
    private static int N, M;

    private static class Edge{
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        arr = new Edge[M];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i =0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[i] = new Edge(a, b, cost);
        }

        System.out.println(kruskal());
    }

    private static int kruskal() {
        Arrays.sort(arr, ((o1, o2) -> o1.cost - o2.cost));
        int result = 0;

        for(Edge edge : arr){
            if(find(edge.start) != find(edge.end)){
                result += edge.cost;
                union(edge.start, edge.end);
            }
        }
        return result;
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        parent[x] = y;
    }

    private static int find(int a) {
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}

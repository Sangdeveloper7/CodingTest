import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class 백준_플로이드워셜 {

    private static int[][] dist;
    private static int n, m;
    private static final int INF= 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = INF;
            }
        }

        for(int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }

        floyd();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] == INF)
                    dist[i][j] = 0;
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    private static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

}

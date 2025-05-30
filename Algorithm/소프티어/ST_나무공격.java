package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ST_나무공격 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] info = new int[2][2];
        st = new StringTokenizer(br.readLine());
        info[0][0] = Integer.parseInt(st.nextToken());
        info[0][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        info[1][0] = Integer.parseInt(st.nextToken());
        info[1][1] = Integer.parseInt(st.nextToken());

        for(int i = info[0][0]-1; i < info[0][1]; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    break;
                }
            }
        }

        for(int i = info[1][0]-1; i < info[1][1]; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    break;
                }
            }
        }

        int count = 0;
        for(int[] arr : map){
            for(int num : arr){
                if(num == 1)
                    count++;
            }
        }
        System.out.println(count);

    }


    /*
6 8
0 0 1 0 0 0 1 0
0 0 0 1 0 0 0 0
0 0 1 0 0 1 1 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0
1 5
2 6

8 8
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 5
4 8
    * */
}

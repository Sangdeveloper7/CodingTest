package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.SQLOutput;
import java.util.*;

public class ST_성적평가 {

    private static class Node{
        int idx;
        int score;
        Node(int idx, int score){
            this.idx = idx;
            this.score = score;
        }
    }

    static Node[][] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        list = new Node[3][N];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                Node k = new Node(j, value);
                list[i][j] = k;
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < N; j++){
                System.out.print(list[i][j].score + " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++){
            Node[] inst = new Node[N];
            int[] rank = new int[N];

            for(int j = 0; j < N; j++){
                inst[j] = list[i][j];
            }

            Arrays.sort(inst, (o1, o2) -> o2.score - o1.score);
            int rankidx = 1;
            for(int j = 0; j < N; j++){
                rank[inst[j].idx] = rankidx++;
            }
            for(int i1 = 0; i1 < N; i1++){
                sb.append(rank[i1] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
/*
3
40 80 70
50 10 20
100 70 30

3
1000 1000 700
300 100 400
200 400 400
*
* */

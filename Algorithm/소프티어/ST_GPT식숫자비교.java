package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ST_GPT식숫자비교 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] number = new int[N][3];


        for (int i = 0; i < N; i++) {
            String[] k = br.readLine().split("\\.");
            number[i][0] = Integer.parseInt(k[0]);
            number[i][2] = 0;
            if(k.length > 1) {
                number[i][1] = Integer.parseInt(k[1]);
                number[i][2] = 1;
            }
        }

        Arrays.sort(number, (o1, o2) -> o1[2] - o2[2]);
        Arrays.sort(number, (o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(number, (o1, o2) -> o1[0] - o2[0]);


        System.out.println("정답");

        for(int i = 0; i < N; i++) {
           if(number[i][2] == 0)
               System.out.println(number[i][0]);
           else
               System.out.println(number[i][0] + "." + number[i][1]);
        }


    }
}

/*
*
5
1.2
1.11
2.9
4.2
3
*
8
1
1.0
2.0
2.10
2.1
2.100
1.11
1.3
* */

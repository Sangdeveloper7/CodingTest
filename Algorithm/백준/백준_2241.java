package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2241 {

    static int A,B,C;
    static boolean[][] visited = new boolean[201][201];
    static HashSet<Integer> answer = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bfs();


        ArrayList<Integer> ans = new ArrayList<>();

        for(int result : answer) {
            ans.add(result);
        }

        Collections.sort(ans);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    static void bfs(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,C});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int a = now[0];
            int b = now[1];
            int c = now[2];

            if(a == 0)
                answer.add(c);

            pour(queue, a, b, c, 0, 1);
            pour(queue, a, b, c, 0, 2);
            pour(queue, a, b, c, 1, 0);
            pour(queue, a, b, c, 1, 2);
            pour(queue, a, b, c, 2, 1);
            pour(queue, a, b, c, 2, 0);
        }
    }

    static void pour (ArrayDeque<int[]> queue, int a, int b, int c, int from, int to){// 물을 옮기는 함수
        int[] water = {a, b, c};
        int[] limit = {A, B, C};

        if(water[from] == 0)
            return;

        int move = Math.min(water[from], limit[to] - water[to]);
        water[from] -= move;
        water[to] += move;

        if(!visited[water[0]][water[1]]){
            visited[water[0]][water[1]] = true;
            queue.add(new int[]{water[0], water[1], water[2]});
        }
    }
}
/*
* import java.util.*;

public class P2251_물통 {

    static int A, B, C;
    static boolean[][] visited = new boolean[201][201];
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        bfs();

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, C});  // 초기 상태 (A, B, C)
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (a == 0) result.add(c);  // A가 비었을 때 C의 물 저장

            // 6가지 경우의 수 - 물을 옮기기
            pour(queue, a, b, c, 0, 1); // A → B
            pour(queue, a, b, c, 0, 2); // A → C
            pour(queue, a, b, c, 1, 0); // B → A
            pour(queue, a, b, c, 1, 2); // B → C
            pour(queue, a, b, c, 2, 0); // C → A
            pour(queue, a, b, c, 2, 1); // C → B
        }
    }

    static void pour(Queue<int[]> queue, int a, int b, int c, int from, int to) {
        int[] water = {a, b, c};
        int[] limit = {A, B, C};

        if (water[from] == 0) return;  // 옮길 물이 없으면 패스

        int move = Math.min(water[from], limit[to] - water[to]);
        water[from] -= move;
        water[to] += move;

        if (!visited[water[0]][water[1]]) {
            visited[water[0]][water[1]] = true;
            queue.add(new int[]{water[0], water[1], water[2]});
        }
    }
}*/
package PR.level2;

import java.security.PublicKey;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PR_미로탈출_BFS {

    private static class Node{
        int x;
        int y;
        char c;
        public Node(int x, int y, char c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    private static int[] rx = {0,0,1,-1};
    private static int[] ry = {1,-1,0,0};

    private static char[][] map;



    public static int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        Node lever = null;
        Node end = null;
        Node start = null;


        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'L'){
                    lever = new Node(i, j, 'L');
                }else if(map[i][j] == 'E'){
                    end = new Node(i, j, 'E');
                }else if(map[i][j] == 'S'){
                    start = new Node(i, j, 'S');
                }
            }
        } // 이차원 배열로 만들기 위함

        ArrayDeque<Node> queue = new ArrayDeque<>(); // 현재 어디에 있는지 알기 위함
        int[][] dist1 = new int[map.length][map[0].length];
        int[][] dist2 = new int[map.length][map[0].length];
        boolean[][] visited1 = new boolean[map.length][map[0].length];
        boolean[][] visited2 = new boolean[map.length][map[0].length];

        queue.add(start);
        dist1[start.x][start.y] = 0;
        visited1[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i<4; i++){
                int x_1 = now.x + rx[i];
                int y_1 = now.y + ry[i];

                if(x_1 < 0 || y_1 < 0 || x_1 > map.length-1 || y_1 > map[0].length-1)
                    continue;
                if(!visited1[x_1][y_1] && map[x_1][y_1] != 'X'){
                    visited1[x_1][y_1] = true;
                    queue.add(new Node(x_1, y_1, 'O'));
                    dist1[x_1][y_1] = dist1[now.x][now.y] + 1;
                }
            }
        }
        answer += dist1[lever.x][lever.y];

        if(dist1[lever.x][lever.y] == 0){
            return -1;
        }
        queue = new ArrayDeque<>();
        queue.add(lever);
        dist2[lever.x][lever.y] = 0;
        visited2[lever.x][lever.y] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i<4; i++){
                int x_1 = now.x + rx[i];
                int y_1 = now.y + ry[i];

                if(x_1 < 0 || y_1 < 0 || x_1 > map.length-1 || y_1 > map[0].length-1)
                    continue;
                if(!visited2[x_1][y_1] && map[x_1][y_1] != 'X'){
                    visited2[x_1][y_1] = true;
                    queue.add(new Node(x_1, y_1, 'O'));
                    dist2[x_1][y_1] = dist2[now.x][now.y] + 1;
                }
            }
        }
        answer += dist2[end.x][end.y];
        if(dist2[end.x][end.y] == 0){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
            String[] mapStr1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
            String[] mapStr2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
            solution(mapStr1);
            solution(mapStr2);

            System.out.println("테스트 1 결과: " + solution(mapStr1)); // 기대값: 16
            System.out.println("테스트 2 결과: " + solution(mapStr2)); // 기대값: -1
    }
}

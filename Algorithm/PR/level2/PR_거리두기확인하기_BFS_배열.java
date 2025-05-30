package PR.level2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PR_거리두기확인하기_BFS_배열 {

    /*
    * 1. 뚫려 있는 방향으로 검사하기 즉, 뚫려 있으면 자기와 연관된 부분에 사람이 있는지 검사하자 => 킵 포인트
    * */
    private static final int[] rx = {1, -1, 0, 0};
    private static final int[] ry = {0, 0, -1, 1};

    private static boolean checkall(char[][] maps, int row, int col){
        for(int i = 0; i < 4; i++){
            int new_x = row + rx[i];
            int new_y = col + ry[i];

            if(new_x < 0 || new_y < 0 || new_x > maps.length - 1 || new_y > maps[0].length - 1) continue;
            switch(maps[new_x][new_y]){
                case 'P' : return false;
                case 'O' : if(!checkall2(maps, new_x, new_y)) return false;
                break;
            }
        }
        return true;
    }

    private static boolean checkall2(char[][] maps, int row, int col){
        int count = 1;
        for(int i = 0; i < 4; i++){
            int new_x = row + rx[i];
            int new_y = col + ry[i];

            if(new_x < 0 || new_y < 0 || new_x > maps.length - 1 || new_y > maps[0].length - 1) continue;
            switch(maps[new_x][new_y]){
                case 'P' : count--;
            }
        }
        if(count != 0) return false;

        return true;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++){
            String[] place = places[i];
            char[][] map = new char[5][5];
            answer[i] = 1;

            for(int j = 0; j < 5; j++){
                map[j] = place[j].toCharArray();
            }

            for(int k = 0; k < 5; k++){
                for(int j = 0; j < 5; j++){
                    if( map[k][j] == 'P' && !checkall(map, k, j)){
                        answer[i] = 0;
                        break;
                    }
                }
                if(answer[i] == 0) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution(places); // 당신이 만든 함수 호출

        System.out.println(Arrays.toString(result)); // [1, 0, 1, 1, 1]
    }
}

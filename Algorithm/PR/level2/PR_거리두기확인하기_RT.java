package PR.level2;

public class PR_거리두기확인하기_RT {

    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, -1, 1};

    public static boolean check_cross(int x, int y, char[][] map){
        if(map[x][y]== 'P'){
            for (int i = 0; i < 4; i++) {
                int n_x = rx[i] + x;
                int n_y = ry[i] + y;

                if (n_x < 0 || n_x >= 5 || n_y < 0 || n_y >= 5)
                    continue;
                else {
                    if (map[n_x][n_y] == 'P')
                        return false;
                    else if (map[n_x][n_y] == 'O') {
                        if (!check_three_side(n_x, n_y, map))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean check_three_side(int x, int y,  char[][] map){
        int check = 0;
        for(int i = 0; i < 4; i++){
            int n_x = rx[i] + x;
            int n_y = ry[i] + y;

            if(n_x < 0 || n_x >= 5 || n_y < 0 || n_y >= 5)
                continue;
            else{
                if(map[n_x][n_y] == 'P')
                    check++;
            }
        }
        if(check > 1)
            return false;
        return true;
    }

    public static int[] solution(String[][] places) {
        int N = 5;
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++){
            String[] pl = places[i];
            char[][] ch = new char[5][5];

            for(int j = 0; j < 5; j++){
                ch[j] = pl[j].toCharArray();
            }
            answer[i] = 1;

            for(int k = 0; k < 5; k++){
                for(int l = 0; l < 5; l++){
                    if(ch[k][l] == 'P' && !check_cross(k,l, ch))
                        answer[i] = 0;
                }
                if(answer[i] == 0)
                    break;
            }
        }
        return answer;
    }

    public static void main(String args[]){
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] answer2 = solution(places);
        for(int i : answer2){
            System.out.print(i + " ");
        }
    }
}

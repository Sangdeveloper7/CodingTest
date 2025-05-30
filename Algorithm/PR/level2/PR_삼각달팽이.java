package PR.level2;

public class PR_삼각달팽이 {

    private static int[] ry = {0, 1, -1};
    private static int[] rx = {1, 0, -1};


    public static int[] solution(int n) {
        int N = n;
        int answer_s = (N * (N + 1)) / 2;
        int[] answer = new int[answer_s];

        int i = 1;

        int map[][] = new int[n][n];
        int dirx = 0;
        int diry = 0;
        int direction = 0;

        while(i <= answer_s){
            map[dirx][diry] = i;
            i++;

            int n_dirx = dirx + rx[direction % 3];
            int n_diry = diry + ry[direction % 3];

            if(n_dirx < 0 || n_dirx >= n || n_diry < 0 || n_diry >= n || map[n_dirx][n_diry] != 0){// 맵이 이미 방문 했던 부분에서는 다시 숫자를 채우면 안됌.
                direction++;
                dirx = dirx + rx[direction % 3];
                diry = diry + ry[direction % 3];
            }else{
                dirx = n_dirx;
                diry = n_diry;
            }
        }

        int l = 0;

        for(int j = 0; j < n; j++){
            for(int k = 0; k <= j ; k++){
                if(map[j][k] != 0)
                    answer[l++] = map[j][k];
            }
        }

        return answer;
    }

    public static void main(String args[]){
        int[] test1 = solution(4);
        for(int r : test1){
            System.out.print(r + " ");
        }
    }
}

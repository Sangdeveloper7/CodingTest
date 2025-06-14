package PR.level2;

public class PR_가장큰정사각형_DP {

    private static int[] rx = {-1, -1, 0};
    private static int[] ry = {-1, 0, -1};
    private static int N;
    private static int M;

    private static int[][] map;

    private static int checkSquare(int x, int y, int[][] board){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            int n_x = rx[i] + x;
            int n_y = ry[i] + y;

            if(n_x < 0 || n_y < 0 || n_x >= N || n_y >= M){
                return 0;
            }
            min = Math.min(min, map[n_x][n_y]);
        }
        return min+1;
    }

    public static int solution(int [][]board)
    {
        N = board.length;
        M = board[0].length;
        map = new int[N][M];
        int max = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = board[i][j];
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                int k = checkSquare(i, j, board);
                max = Math.max(max, k);
                map[i][j] = k;
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
}

package PR.level2;

public class PR_가장큰정사각형_DP {

    public static int solution(int [][]board)
    {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;

        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                if(board[i][j] > 0){
                    board[i][j] += Math.min(board[i-1][j-1],Math.min(board[i-1][j], board[i][j-1]));
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                answer = Math.max(board[i][j], answer);
            }
        }
        answer= answer * answer;
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
}

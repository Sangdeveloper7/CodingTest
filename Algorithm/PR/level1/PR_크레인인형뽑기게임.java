package PR.level1;

import java.util.ArrayDeque;

public class PR_크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        for (int i = 0; i < moves.length; i++) {
            int col = moves[i]-1;
            for(int j = 0; j < board.length; j++) {
                if(board[j][col] != 0) {
                    if(!stack1.isEmpty() && stack1.peek() == board[j][col]) {
                        answer += 2;
                        stack1.pop();
                        board[j][col] = 0;
                    }else{
                        stack1.push(board[j][col]);
                    }break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] move = {1,5,3,5,1,2,1,4};
        int answer = solution(board, move);
        System.out.println(answer);
    }
}

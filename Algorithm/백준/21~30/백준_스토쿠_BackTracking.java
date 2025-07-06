package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_스토쿠_BackTracking {
    /*
    * 1. 각 점의 정보를 저장할 클래스 Block을 만든다.
    * 2. 현재 점에 그 숫자를 넣어도 되는지 확인하는 isValid(int row, int column, int num)을 만든다 -> boolean을 리턴하는 함수
    * 3. 현재 점에서 그 줄 row 에 자기가 넣을 숫자가 있는지 확인하는 메소드 checkRow(int row, int num) 만들기
    * 4. 현재 점에서 그 세로줄 column 에 자기가 넣을 숫자가 있는지 확인하는 메소드 checkColumn(int col, int num) 만들기
    * 5. 현재 자기가 있는 3*3그룹 에서 자기가 넣을 숫자가 있는지 확인하는 메소드 is3_3check(int row, int column, int num)
    * 5.5 현재 비어있는 스도쿠 자리가 있는지 확인하는 메소드 FindEmpty()
    * 6. 백 트래킹을 구현할 함수 void makeStoku (여기 문제에서는 항상 스토쿠로 풀린다는 가정 했기 때문에 그냥 void로 만듦 원래는 boolean으로 스토쿠 안만들어지면 False return
    * */
    private static int[][] Board;

    private static class Block{
        int x, y;
        public Block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    private static boolean checkRow(int row, int num){
        for(int i = 0; i < 9; i++){
            if(Board[row][i] == num)
                return false;
        }
        return true;
    }

    private static boolean checkColumn(int col, int num){
        for(int i = 0; i < 9; i++){
            if(Board[i][col] == num)
                return false;
        }
        return true;
    }

    private static boolean is3_3check(int row, int col, int num){
        int new_x = (row / 3) * 3;
        int new_y = (col / 3) * 3; // => 012 -> 0  , 345 -> 3, 678 -> 6

        for(int i = new_x; i < new_x + 3; i++){
            for(int j = new_y; j < new_y + 3; j++){
                if(Board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, int num){
        return (checkRow(row, num) && checkColumn(col, num) && is3_3check(row, col, num));
    }

    private static Block findEmpty(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Board[i][j] == 0)
                    return new Block(i, j);
            }
        }
        return null;
    }

    private static boolean makeStoku(){
        Block empty = findEmpty();
        if(empty == null)
            return true;

        int row = empty.x;
        int col = empty.y;

        for(int num = 1; num <= 9; num++){
            if(isValid(row, col, num)){
                Board[row][col] = num;
                if(makeStoku()) return true;
                Board[row][col] = 0;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board = new int[9][9];

        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                Board[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력값을 받기

        boolean k = makeStoku();

        StringBuilder sb = new StringBuilder();
        for(int[] i : Board){
            for(int j : i){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

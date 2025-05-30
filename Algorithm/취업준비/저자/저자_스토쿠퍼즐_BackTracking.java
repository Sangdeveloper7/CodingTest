package 취업준비.저자;

public class 저자_스토쿠퍼즐_BackTracking {

    private static int[][] Board = {
            {0, 3, 5, 4, 6, 9, 2, 7, 8},
            {7, 8, 2, 1, 0, 5, 6, 0, 9},
            {0, 6, 0, 2, 7, 8, 1, 3, 5},
            {3, 2, 1, 0, 4, 6, 8, 9, 7},
            {8, 0, 4, 9, 1, 3, 5, 0, 6},
            {5, 9, 6, 8, 2, 0, 4, 1, 3},
            {9, 1, 7, 6, 5, 2, 0, 8, 0},
            {6, 0, 3, 7, 0, 1, 9, 5, 2},
            {2, 5, 8, 3, 9, 4, 7, 6, 0}
    };

    private static class Block{
        int x;
        int y;
        public Block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isValid(int num, int row, int column){
        return !(checkrow(row, num) || checkcolumn(column, num) || check3_3(num, row, column));
    }

    private static boolean checkrow(int row, int num){
        for(int i = 0; i <9; i++){
            if(Board[row][i] == num)
                return false;
        }return true;
    }

    private static boolean checkcolumn(int column, int num){
        for(int i = 0; i<9; i++){
            if(Board[i][column] == num)
                return false;
        }return true;
    }

    private static boolean check3_3(int num, int row, int column){
        int new_row = (row / 3) * 3;
        int new_column = (column / 3) * 3;

        for(int i = new_row; i < new_row+3; i++){
            for(int j = new_column; j < new_column+3; j++){
                if(Board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    private static Block findEmpty(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Board[i][j] == 0)
                    return new Block(i,j);
            }
        }
        return null;
    }

    private static boolean makeStoku(){
        Block empty = findEmpty();
        if(empty == null)
            return true;

        int row = empty.x;
        int column = empty.y;

        for(int i = 1; i <= 9; i++){
            if(isValid(i, row, column)){
                Board[row][column] = i;

                if(makeStoku())
                    return true;
                Board[row][column] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args){
//        int[][] map = new int[9][9];
//        int[][] map2 = {
//                {5, 3, 0, 0, 7, 0, 0, 0, 0},
//                {6, 0, 0, 1, 9, 5, 0, 0, 0},
//                {0, 9, 8, 0, 0, 0, 0, 6, 0},
//                {8, 0, 0, 0, 6, 0, 0, 0, 3},
//                {4, 0, 0, 8, 0, 3, 0, 0, 1},
//                {7, 0, 0, 0, 2, 0, 0, 0, 6},
//                {0, 6, 0, 0, 0, 0, 2, 8, 0},
//                {0, 0, 0, 4, 1, 9, 0, 0, 5},
//                {0, 0, 0, 0, 8, 0, 0, 7, 9}
//        };
//        int[][] map3 = {
//                {0, 2, 0, 6, 0, 8, 0, 0, 0},
//                {5, 8, 0, 0, 0, 9, 7, 0, 0},
//                {0, 0, 0, 0, 4, 0, 0, 0, 0},
//                {3, 7, 0, 0, 0, 0, 5, 0, 0},
//                {6, 0, 0, 0, 0, 0, 0, 0, 4},
//                {0, 0, 8, 0, 0, 0, 0, 1, 3},
//                {0, 0, 0, 0, 2, 0, 0, 0, 0},
//                {0, 0, 9, 8, 0, 0, 0, 3, 6},
//                {0, 0, 0, 3, 0, 6, 0, 9, 0}
//        };

        boolean now = makeStoku();
        for(int[] i : Board){
            for(int j : i){
                System.out.print(j+ " ");
            }
            System.out.println("");
        }
    }
}

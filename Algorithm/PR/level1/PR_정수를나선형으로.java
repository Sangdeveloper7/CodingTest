package PR.level1;

public class PR_정수를나선형으로 {
    private static int[] rx = {0, 1, 0, -1};
    private static int[] ry = {1, 0,-1, 0};

    public static int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int r = 0;
        int c = 0;
        int dir = 0;
        int number = 1;

        while(number <= n * n){
            arr[r][c] = number++;
            int nr =  r + rx[dir % 4];
            int nc =  c + ry[dir % 4];

            if(nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0){
                dir += 1;
            }
            r = r + rx[dir % 4];
            c = c + ry[dir % 4];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr2 = solution(4);
        int n = 4;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}

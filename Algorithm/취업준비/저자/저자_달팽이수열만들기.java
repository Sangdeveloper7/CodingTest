package 취업준비.저자;

public class 저자_달팽이수열만들기 {

    private static int[][] map;
    private static int[] rx = {1,0,-1,0};
    private static int[] ry = {0,1,0,-1};



    private static int[][] makedalpangei(int[][] arr, int n){
        int N = n;
        map = new int[N][N];

        int dir_idx = 0;
        int x_dir = 0;
        int y_dir = 0;
        int count = 1;

        while(count <= n * n){
                map[x_dir][y_dir] = count;

                int next_x = ry[dir_idx % 4] + x_dir;
                int next_y = rx[dir_idx % 4] + y_dir;

                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N || map[next_x][next_y] != 0){
                    dir_idx++;
                    next_x = ry[dir_idx % 4] + x_dir;
                    next_y = rx[dir_idx % 4] + y_dir;
                }
                x_dir = next_x;
                y_dir = next_y;

                count++;
        }
        return map;
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] arr2 = makedalpangei(arr, 4);
        for(int[] arr3 : arr2){
            for(int k : arr3){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}

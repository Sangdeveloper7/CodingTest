package PR.level2;

public class PR_행렬의곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // 완전 탐색으로 진행
        int arr1_m = arr1.length;
        int[][] answer = new int[arr1.length][arr2[0].length];


        for(int i = 0; i < arr1_m; i++ ) {
            for(int j = 0; j < arr2[0].length; j++ ) {
                for(int k = 0; k<arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] a = { {1, 4}, {3, 2}, {4, 1}};
        int[][] b = { {3, 3}, {3, 3}};
        int[][] show = solution(a, b);
        for(int i = 0; i < show.length; i++) {
            for(int j = 0; j < show[i].length; j++) {
                System.out.print(show[i][j] + " ");
            }
        }
    }
}

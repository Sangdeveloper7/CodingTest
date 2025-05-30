package 취업준비.저자;

public class 저자_배열회전하기 {


    private static int[][] rotate(int[][] arr){
        int n = arr.length;

        int[][] arr2 = new int[arr.length][arr[0].length];

//        for(int k = 0 ; k < t; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr2[j][n-1-i] = arr[i][j];
                }
            }
//        }

        return arr2;
    }

    private static int[][] solution(int[][] arr, int time){
        for(int i = 0; i<time; i++){
            arr = rotate(arr);
        }

        return arr;
    }

    public static void main(String[] args){
        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] arr3 = solution(arr,2);

        for(int[] a : arr3){
            for(int e : a){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

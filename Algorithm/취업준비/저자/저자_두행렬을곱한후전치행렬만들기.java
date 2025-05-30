package 취업준비.저자;

public class 저자_두행렬을곱한후전치행렬만들기 {
    public static void main(String[] args){
        int[][] marx1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] marx2 = {{9,8,7}, {6,5,4},{3,2,1}};

        int[][] mult = new int[marx1.length][marx2[0].length];


        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    mult[k][i] += marx1[k][j] * marx2[j][i];
                }
            }
        }

        int[][] mult2 = new int[mult.length][mult[0].length];

        for(int i = 0; i < mult2.length; i++){
            for(int j = 0; j < mult2[0].length; j++){
                mult2[i][j] = mult[j][i];
            }
        }

        for(int[] arr : mult2){
            for(int k : arr){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}

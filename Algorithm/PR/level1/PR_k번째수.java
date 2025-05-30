package PR.level1;

import java.util.Arrays;

public class PR_k번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answercount = 0;

        for(int[] arr : commands){
            int[] arrcom = new int[arr[1] - arr[0] + 1];
            int count = 0;
            for(int i = arr[0]-1; i < arr[1]; i++){
                arrcom[count++] = array[i];
            }
            Arrays.sort(arrcom);
            answer[answercount++] = arrcom[arr[2]-1];
        }

        return answer;
    }

    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] k = solution(array, commands);
        for(int e : k){
            System.out.print(e + " ");
        }
    }
}

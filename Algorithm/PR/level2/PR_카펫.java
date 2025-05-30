package PR.level2;

public class PR_카펫 {

    private static boolean checkresult(int brown, int b, int y){
        return(b+y+b+y -4 == brown);
    }

    public static int[] solution(int brown, int yellow) {
        // 1. brown yello가 가능한 모든 경우의 수를 돌려봄  그때 brown 갯수가 맞으면 리턴

        int[] answer = {};


        int total = brown + yellow;
        for(int i = 1; i <= brown; i++){
            for(int j = 1; j<= brown; j++){
                if(total == i * j){
                    if(checkresult(brown, i, j)){
                            if(i >= j)
                                return new int[]{i,j};
                            else
                                return new int[]{j,i};
                       }
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args){
        int[] result = solution(10,2);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}

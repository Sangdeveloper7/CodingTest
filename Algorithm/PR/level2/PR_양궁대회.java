package PR.level2;

public class PR_양궁대회 {
    private static int max;
    private static int[] answer;
    private static int[] apeach;


    private static int getScore(int[] ryan){
        int score = 0;
        for(int i = 0; i <= 10; i++){
            if(apeach[i] == 0 && ryan[i] == 0) continue;
            if(apeach[i] < ryan[i]){
                score += 10 - i;
            }else
                score += i - 10;
        }
        return score;
    }

    private static void calculate(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        }else if(max > 0 && max == score){
            for(int i = 10; i >= 0; i--){
                if(answer[i] != ryan[i]){
                    if(answer[i] < ryan[i])
                        answer = ryan.clone();
                    break;
                }
            }
        }
    }

    private static void backtrack(int n, int idx, int[] ryan){
        if(n == 0){
            calculate(ryan);
            return;
        }
        for(int i = idx; i <= 10; i ++){
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n-cnt, i+1, ryan);
            ryan[i] = 0;
        }
    }

    public static int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);
        if(max == 0)
            return new int[]{-1};
        else
            return answer;
    }

    public static void main(String[] args){
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        int[] result = solution(9, info);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}

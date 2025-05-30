package PR.level2;

public class PR_피로도_BackTracking {

    private static int answer;
    private static boolean[] visited;
    private static int[][] Dungeons;

    private static void backtrack(int k, int count){
        for(int i = 0; i < Dungeons.length; i++){
            if(!visited[i] && k >= Dungeons[i][0]){
                visited[i] = true;
                backtrack(k- Dungeons[i][1], count + 1);
                answer = Math.max(answer, count + 1);
                visited[i] = false; // 새로운 i = 1 일 경우에 다시 돌아야 하기 때문
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        Dungeons = dungeons;

        backtrack(k, 0);

        return answer;
    }


    public static void main(String[] args){
        int[][] arr = {{80,20},{50,40},{30,10}};
        int k = 80;

        System.out.print(solution(k, arr));
    }
}

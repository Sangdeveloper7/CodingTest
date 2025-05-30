package PR.level3;

public class 네트워크 {

    private static int[][] computer;
    private static boolean[] visited;
    private static int answer;

    public static int solution(int n, int[][] computers) {
        answer = 0;
        computer = computers;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int now){
        if(visited[now])
            return;
        visited[now] = true;
        for(int i = 0; i < computer.length; i++){
            if(computer[now][i] == 1){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int n2 = 3;
        int[][] computers2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        System.out.println("예제 1 결과: " + solution(n1, computers1)); // 기대값: 2
        System.out.println("예제 2 결과: " + solution(n2, computers2)); // 기대값: 1
    }
}

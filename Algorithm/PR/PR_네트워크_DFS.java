public class PR_네트워크_DFS {

    private static int[][] computer;
    private static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        computer = computers;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int now){
        if(visited[now]){
            return;
        }else{
           visited[now] = true;

           for(int i = 0; i<computer.length; i++){
               if(computer[now][i] == 1)
                   dfs(i);

           }
        }
    }

    public static void main(String[] args) {

    }
}

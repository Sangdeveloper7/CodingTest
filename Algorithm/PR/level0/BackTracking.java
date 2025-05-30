public class BackTracking {

    private static final char[] alpha = {'A', 'B', 'C', 'D'};

    private static final int LENGTH = 4;

    private static boolean[] visited = new boolean[4];

    public static void main(String[] args) {
        backTracking("");
    }

    private static void backTracking(String s) {
        if(s.length() == LENGTH) {
            System.out.println(s);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(s + alpha[i]);
                visited[i] = false; // 한번씩만 사용 할 경우 모든 경우의 수 출력
            }
        }
    }
}

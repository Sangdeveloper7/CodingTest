package PR.level2;

public class PR_캐릭터의좌표 {

    private static int xmapsize;
    private static int ymapsize;
    private static int[] now;

    private static boolean checkloc(int x, int y){
        if(x < 0 || y < 0 || x > (2*xmapsize) || y > (2*ymapsize))
            return false;
        return true;
    }

    public static int[] solution(String[] keyinput, int[] board) {

        xmapsize = (board[0]-1) /2;
        ymapsize = (board[1]-1) /2; // 양쪽

        now = new int[2];
        now[0] = xmapsize;
        now[1] = ymapsize;

        for(String k : keyinput){
            switch(k){
                case "left" :
                    if(checkloc(now[0] -1, now[1]))
                        now[0] -= 1;
                    break;
                case "right" :
                    if(checkloc(now[0] +1, now[1]))
                        now[0] += 1;
                    break;
                case "up" :
                    if(checkloc(now[0], now[1]+ 1))
                        now[1] += 1;
                    break;
                case "down" :
                    if(checkloc(now[0], now[1]- 1))
                        now[1] -= 1;
                    break;
            }
        }

        int[] answer = new int[2];
        answer[0] = now[0] - xmapsize;
        answer[1] = now[1] - ymapsize;

        return answer;
    }

    public static void main(String[] args){
        String[] keyinput = {"left", "right", "up", "right", "right"};
        int[] board = {11, 11};
        int[] result = solution(keyinput, board);

        for(int i : result){
            System.out.print(i + " ");
        }
    }
}

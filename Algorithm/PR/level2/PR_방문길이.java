package PR.level2;

import java.util.HashSet;

public class PR_방문길이 {

    // 좌표 범위 검사: 0 ~ 10
    public static int checkArea(int x, int y) {
        if (x < 0 || y < 0 || x > 10 || y > 10) return 1;
        return 0;
    }

    // 방향에 따라 좌표 이동
    public static int[] move(String move, int x, int y) {
        int x_re = x;
        int y_re = y;
        switch (move) {
            case "U": y_re++; break;
            case "D": y_re--; break;
            case "R": x_re++; break;
            case "L": x_re--; break;
        }
        return new int[]{x_re, y_re};
    }

    // 반대 방향 반환
    public static String move2(String move) {
        switch (move) {
            case "U": return "D";
            case "D": return "U";
            case "R": return "L";
            case "L": return "R";
        }
        return "Error";
    }

    public static int solution(String dirs) {
        int x = 5, y = 5; // 중심점 (0,0)을 5,5로 평행이동한 좌표
        int answer = 0;

        // 경로 저장: 양방향 (출발 → 도착, 도착 → 출발) 둘 다 저장
        HashSet<String> navi = new HashSet<>();

        for (char d : dirs.toCharArray()) {
            String dir = String.valueOf(d);

            int[] next = move(dir, x, y); // 이동 후 좌표
            int nx = next[0];
            int ny = next[1];

            if (checkArea(nx, ny) == 0) { // 이동 가능할 때만 처리
                // 경로 문자열: 작은 좌표 먼저 오도록 해서 양방향을 통일
                String path = x + "," + y + "-" + nx + "," + ny;
                String reverse = nx + "," + ny + "-" + x + "," + y;

                // 경로가 처음이라면 저장
                if (!navi.contains(path) && !navi.contains(reverse)) {
                    answer++;
                    navi.add(path);
                    navi.add(reverse);
                }

                // 실제 좌표 업데이트
                x = nx;
                y = ny;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        System.out.println(solution(dirs1)); // 7

        String dirs2 = "LULLLLLLU";
        System.out.println(solution(dirs2)); // 7
    }
}
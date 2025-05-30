package PR.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR_교점에별만들기_배열 {

        static final int INF = Integer.MAX_VALUE;

        private static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        // 두 직선의 교점을 구하는 메서드
        private static Point findXY(int[] line1, int[] line2) {
            long A = line1[0], B = line1[1], E = line1[2];
            long C = line2[0], D = line2[1], F = line2[2];

            long denominator = A * D - B * C;
            if (denominator == 0) return null; // 평행하거나 일치

            long xNumerator = B * F - E * D;
            long yNumerator = E * C - A * F;

            if (xNumerator % denominator != 0 || yNumerator % denominator != 0) return null; // 정수 아님

            int x = (int)(xNumerator / denominator);
            int y = (int)(yNumerator / denominator);
            return new Point(x, y);
        }

        public String[] solution(int[][] line) {
            List<Point> allPoints = new ArrayList<>();

            // 모든 교점 구하기
            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    Point p = findXY(line[i], line[j]);
                    if (p != null) {
                        allPoints.add(p);
                    }
                }
            }

            // 최소/최대 좌표 찾기
            int x_min = INF, x_max = -INF, y_min = INF, y_max = -INF;
            for (Point p : allPoints) {
                x_min = Math.min(x_min, p.x);
                x_max = Math.max(x_max, p.x);
                y_min = Math.min(y_min, p.y);
                y_max = Math.max(y_max, p.y);
            }

            int width = x_max - x_min + 1;
            int height = y_max - y_min + 1;

            // 별 지도 초기화
            char[][] grid = new char[height][width];
            for (int i = 0; i < height; i++) {
                Arrays.fill(grid[i], '.');
            }

            // 별 찍기 (좌표 보정 + y축 반전)
            for (Point p : allPoints) {
                int x = p.x - x_min;
                int y = y_max - p.y; // 위에서 아래로 찍기 위해 반전
                grid[y][x] = '*';
            }

            // char[][] → String[] 변환
            String[] answer = new String[height];
            for (int i = 0; i < height; i++) {
                answer[i] = new String(grid[i]);
            }

            return answer;
        }
}

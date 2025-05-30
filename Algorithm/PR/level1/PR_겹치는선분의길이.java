package PR.level1;

public class PR_겹치는선분의길이 {

    public static int solution(int[][] lines) {
        int[] lineMap = new int[201];
        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;

            for (int i = start; i < end; i++) {
                lineMap[i]++;
            }
        }
        int overlapLength = 0;
        for (int i = 0; i < lineMap.length; i++) {
            if (lineMap[i] > 1) {
                overlapLength++;
            }
        }

        return overlapLength;
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {0, 1},
                {2, 5},
                {3, 9}
        };

        int[][] test2 = {
                {-1, 1},
                {1, 3},
                {3, 9}
        };

        int[][] test3 = {
                {0, 5},
                {3, 9},
                {1, 10}
        };

        System.out.println(solution(test1));
    }
}

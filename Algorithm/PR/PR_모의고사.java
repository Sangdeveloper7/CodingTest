package PR;

import java.util.*;

public class PR_모의고사 {
    public static int[] solution(int[] answers) {
        int[] Correct = new int[3];
        int[] i = {1, 2, 3, 4, 5};
        int[] j = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] k = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int number = 0, number2 = 0, number3 = 0;
        for (int answer_N : answers) {
            if (number == 5) number = 0;
            if (number2 == 8) number2 = 0;
            if (number3 == 10) number3 = 0;

            if (i[number++] == answer_N) Correct[0]++;
            if (j[number2++] == answer_N) Correct[1]++;
            if (k[number3++] == answer_N) Correct[2]++;
        }

        int max = Arrays.stream(Correct).max().getAsInt();


        // ArrayList 가지고 3번까지 돌리는데 최대값이랑 같으면 정답 배열에 추가함
        ArrayList<Integer> temp = new ArrayList<>();
        for (int m = 0; m < 3; m++) {
            if (Correct[m] == max) {
                temp.add(m + 1);
            }
        }

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers1))); // [1]
        System.out.println(Arrays.toString(solution(answers2))); // [1, 2, 3]
    }
}
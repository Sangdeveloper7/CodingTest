package PR.level2;

import java.util.Arrays;

public class PR_구명보트_Sliding {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
       Arrays.sort(people);

        while(left < right) {
            if(people[left] + people[right] > limit){
                answer++;
                right--;
            }else{
                answer++;
                left++;
                right--;
            }
        }
        if(left == right){
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}

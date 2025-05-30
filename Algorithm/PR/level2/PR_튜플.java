package PR.level2;

import java.util.Arrays;
import java.util.HashSet;

public class PR_튜플 {

    public static int[] solution(String s) {
        s = s.substring(0,s.length()-2).replace("{","");

        String[] arr = s.split("},");

        Arrays.sort(arr, (o1,o2) -> Integer.compare(o1.length(), o2.length()));

        HashSet<String> set = new HashSet<>();

        int[] answer = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++){
            String[] numbers = arr[i].split(",");
            for(String k : numbers){
                if(!set.contains(k)){
                    answer[i] = Integer.parseInt(k);
                    set.add(k);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] t = solution(s);

        for(int e : t){
            System.out.print(e + " ");
        }
    }
}

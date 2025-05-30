package 취업준비.저자;

import java.util.*;

public class 저자_1부터N까지숫자중합_백트래킹 {
    private static ArrayList<ArrayList<Integer>> answer;
    private static int n;


    private static void backTracking(int sum, ArrayList<Integer> now, int start){
        if(sum == 10){
            answer.add(now);
            return;
        }

        for(int i = start; i <= n; i++){
            if(sum + i <= 10){
                ArrayList<Integer> newlist = new ArrayList<>(now);
                newlist.add(i);
                backTracking(sum + i, newlist, i+1);
            }
        }
    }

    public static void main(String[] args){
        n = 7;
        answer = new ArrayList<>();

        backTracking(0,new ArrayList<>(), 1);
        for(ArrayList<Integer> i : answer){
            System.out.println(i);
        }
    }


}

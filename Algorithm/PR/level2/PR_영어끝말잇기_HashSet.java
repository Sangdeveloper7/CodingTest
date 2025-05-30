package PR.level2;

import java.util.HashSet;

public class PR_영어끝말잇기_HashSet {

    /*
    * 1. break 하고 index를 return 할 경우
    *   1. HashSet으로 전에 나온 단어 있는지 확인
    *   2. 전에 단어 뒷알파벳 안 이어 할 경우 false
    * 2. index = 1부터 시작
    * 3. 전에 비교할 단어를 1부터 넣고 시작
    * */

    public static int[] solution(int n, String[] words) {
        int[] answer= new int[2];

        HashSet<String> voca = new HashSet<>();
        voca.add(words[0]); // HashSet에 처음 단어 넣기
        char c = words[0].charAt(words[0].length() - 1); // 처음 단어의 뒷 알파벳
        int index = 1;
        int wrong_index = 0;

        for(int i = 1; i < words.length; i++){
            index++;
            String word = words[i];
            char now_c = word.charAt(0);

            if(voca.contains(word) || c != now_c){
                wrong_index = index;
                break;
            }
            voca.add(word);
            c = word.charAt(word.length() - 1);
        }
        
        if(wrong_index == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            int nugu = wrong_index % n;
            int turn = wrong_index / n;
            if(nugu == 0){
                nugu = n;
            }else{
                turn++;
            }
            answer[0] = nugu;
            answer[1] = turn;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] d = solution(2,arr);
        for(int i : d){
            System.out.println(i);
        }
    }
}

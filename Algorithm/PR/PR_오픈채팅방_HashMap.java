import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class PR_오픈채팅방_HashMap {

    public static String[] solution(String[] record) {

        HashMap<String, String> hmap = new HashMap<>();

        for(String s : record) {
            String[] words = s.split(" ");
            if(words[0].equals("Enter") || words[0].equals("Change")) {
                hmap.put(words[1], words[2]);
            }
        }

        ArrayDeque<String> queue = new ArrayDeque<>();

        for(String s : record) {
            String[] words = s.split(" ");
            if(words[0].equals("Enter")) {
                String name = hmap.get(words[1]);
                String sentence = name + "님이 들어왔습니다.";
                queue.add(sentence);
            }else if(words[0].equals("Leave")) {
                String name = hmap.get(words[1]);
                String sentence = name + "님이 나갔습니다.";
                queue.add(sentence);
            }
        }
        String[] answer = new String[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            answer[i++] = queue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = {};
        result = solution(record);
        System.out.println(result.length);
        for(String s : result) {
            System.out.println(s);
        }
    }
}

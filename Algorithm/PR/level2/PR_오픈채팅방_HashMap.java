package PR.level2;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class PR_오픈채팅방_HashMap {

    public static String[] solution(String[] record) throws IOException {
        String[] answer = {};
        HashMap<String, String> check_user = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int count = 0;
        for(String s : record) {
            queue.addLast(s);
            String[] strings = s.split(" ");
            String order = strings[0];

            if(order.equals("Enter") || order.equals("Leave"))
                count++;
            String user_id =  strings[1];
            if(order.equals("Enter") || order.equals("Change")) {
                String nickname = strings[2];
                check_user.put(user_id, nickname);
            }
        }
        answer = new String[count];
        int i = 0;
        for(String s : queue) {
            String[] strings = s.split(" ");

            String order = strings[0];
            String user_id =  strings[1];

            String nickname = check_user.get(user_id);

            if(order.equals("Enter")){
                answer[i++] = nickname + "님이 들어왔습니다.";
            }else if(order.equals("Leave")){
                answer[i++] = nickname + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = {};
        result = solution(record);
        for(String s : result) {
            System.out.println(s);
        }
    }
}

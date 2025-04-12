import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class PR_표편집 {

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 현재 줄에 몇번째 줄에 가있는지 확인
        HashMap<Integer, Integer> map = new HashMap<>(); // 몇번째 행이, 몇번째로 삭제 됬는지 확인하기 위함
        int N = n; // 현재 삭제 된 행 포함해서 몇개의 행 있는지


        ArrayDeque<Integer> stack_ox = new ArrayDeque<>(); // 삭제된 행 순서대로 저장 HashMap으로 찾음
        stack.push(k); // 처음 시작 줄 현재 줄로 설정
        for(String s : cmd){
            String[] parts = s.split(" ");
            String c = parts[0];
            int Num = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

            switch (c){
                case "U":
                    int num = stack.pop();
                    num += Num;
                    stack.push(num);
                case "D":
                    int num2 = stack.pop();
                    num2 -= Num;
                    stack.push(num2);
                case "C":
                    int num3 = stack.pop();
                    map.put(num3, stack_ox.size());
                    if(num3 == N){
                        num3 = 1;
                    }
                    stack.push(num3);
                case "Z":
                    int num4 = stack_ox.pop();
                    map.remove(num4);
            }
        }

        while(!stack_ox.isEmpty()){

        }
        for(int i = 0; i<n; i++){
            if(map.containsKey(stack.peek())){}
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}

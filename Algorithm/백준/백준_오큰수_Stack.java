import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_오큰수_Stack {
    public static int[] solution(int n, int[] arr){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--){
            // 스택에 나보다 작거나 같은 값은 다 버림
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            // 스택이 비어있으면 오큰수 없음 (-1), 아니면 맨 위가 오큰수
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 값은 다음 사람을 위해 스택에 넣어줌
            stack.push(arr[i]);
        }

        return answer;
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int[] num = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = solution(k, num);

        for(int i = 0; i < answer.length; i++){
            bw.write(answer[i] + " ");
        }

        bw.flush();
    }
}

import java.io.*;
import java.util.ArrayDeque;

public class 저자_10진수2진수로 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (k == 0) {
            stack.push(0);
        }

        while(k>0){
            stack.push(k%2);
            k/=2;
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop()+"");
        }
        bw.flush();    // 출력 버퍼 비우기
        bw.close();
    }
}

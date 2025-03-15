import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

    public class ArraySort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한줄씩 읽는다

        StringTokenizer st =  new StringTokenizer(br.readLine()); // 띄어쓰기 단위로 끊는 토근

        ArrayDeque<Integer> dq = new ArrayDeque<>(); // dequeue 선언

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            dq.add(num);
        }

        int[] list = new int[dq.size()];
        int i = 0;
        for(int num : dq) {
            list[i++] = num;
        }
        int[] clone = sort(list);

        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(list));

    }

    private static int[] sort(int[] list) {
        int[] clone = list.clone(); // clone method 사용 안할 시 -> 원본 배열의 상태 변경됨
        Arrays.sort(clone);
        return clone;
    }
}

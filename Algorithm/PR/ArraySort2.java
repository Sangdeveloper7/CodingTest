import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArraySort2 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 1. 중복 제거 (HashSet 사용)
        HashSet<Integer> set = new HashSet<>(arr);

        // 2. 다시 리스트로 바꿔서 정렬
        ArrayList<Integer> result = new ArrayList<>(set);
        result.sort(Comparator.reverseOrder());  // 내림차순 정렬

        // 3. 출력
        System.out.println(result);
    }
}
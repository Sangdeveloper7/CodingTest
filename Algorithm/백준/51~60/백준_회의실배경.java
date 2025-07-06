package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_회의실배경 {

    public static class Node{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Node(start, end);
        }

        // Arrays.sort(arr, (o1, o2) -> o1.end - o2.end);
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start; // 끝나는 시간이 같으면 시작 시간 오름차순
            }
            return o1.end - o2.end; // 기본은 끝나는 시간 오름차순
        });
        int end = 0;
        int count = 0;

        for(int i = 0; i < N; i++){
            Node now = arr[i];
            if(now.start >= end){
                count++;
                end = now.end;
            }
        }

        System.out.print(count);
    }
}

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 백준_연세워터파크 {

        private static class Stone{
            int index;
            int value;

            public Stone(int index, int value) {
                this.value = value;
                this.index = index;
            }
        }

        public static int solution(int[] stones, int k) {
            PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.value,o1.value));
            int i = 0;
            int answer = Integer.MIN_VALUE;
            for (i = 0; i < k; i++) {
                pq.add(new Stone(i, stones[i]));
                answer += stones[i];
            }

            while(i < stones.length) {
                pq.add(new Stone(stones[i], i));
                answer += stones[i];
                i++;
                while(pq.peek().index < i - k){
                    int e = pq.poll().value;
                    answer -= e;
                }
            }
            return answer;
        }

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 첫 줄 입력 받기
            String[] firstLine = br.readLine().split(" ");
            int Number = Integer.parseInt(firstLine[0]); // 징검다리 개수 N
            int k = Integer.parseInt(firstLine[1]);      // 점프 제한 거리 D

            // 두 번째 줄 징검다리 값들 입력
            int[] stones = new int[Number];
            String[] secondLine = br.readLine().split(" ");
            for (int i = 0; i < Number; i++) {
                stones[i] = Integer.parseInt(secondLine[i]);
            }

            // 디버깅용 출력 (나중에 지워도 됨)
            System.out.println("N: " + Number);
            System.out.println("D: " + k);
            System.out.println("Stones: " + Arrays.toString(stones));

            // 여기서 solution(Number, k, stones); 호출하면 됨
            int result = solution(stones, k);

            System.out.println(result);
        }
    }



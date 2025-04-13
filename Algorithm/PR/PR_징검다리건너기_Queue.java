import java.security.PublicKey;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PR_징검다리건너기_Queue {
    private static class Stone{
        int value;
        int index;

    public Stone(int value, int index) {
        this.value = value;
        this.index = index;
    }
    }

    public static int solution(int[] stones, int k) {
        PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.value,o1.value));
        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(new Stone(stones[i], i));
        }
        int answer = pq.peek().value;

        while(i < stones.length) {
            pq.add(new Stone(stones[i], i));
            i++;
            while(pq.peek().index < i - k){
                pq.poll();
            }
            answer = Math.min(answer, pq.peek().value);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] stone = {2, 7, -5, -4, 10, -5, -5, -5, 30, -10};
        int k = 2;
        System.out.println(solution(stone, k));
    }
}

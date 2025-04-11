import java.util.ArrayDeque;

public class PR_주식가격_Stack {

    public static class Price{
        int index;
        int price;

        public Price(int i, int price) {
            this.index = i;
            this.price = price;
        }
    }

    public static int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

//        for (int i = 0; i < N; i++) {
//            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
//                int top = stack.pop();
//                answer[top] = i - top;
//            }
//            stack.push(i);
//        }
//
//        while (!stack.isEmpty()) {
//            int top = stack.pop();
//            answer[top] = N - top - 1;
//        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = N - top - 1;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 1};
        int[] result = solution(arr);
        for(int i : result) {
            System.out.println(i);
        }

    }
}

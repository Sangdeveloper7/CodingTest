package PR.level1;

public class PR_자연수뒤집어_RE {

    public static int[] solution(long n) {
        int[] answer;

        String s = String.valueOf(n);


        String[] array = s.split("");
        int j = 0;

        answer = new int[s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            answer[j++] = Integer.parseInt(array[i]);
        }

        return answer;

    }
    public static void main(String args[]){
        long n = 12345;
        int[] arr = solution(n);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}

package PR.level1;

public class PR_3진법뒤집기 {

    public static String makeThree(int n){
        String k = "";
        int N = n;
        while(N >= 3){
            int mod = N % 3;
            N = N /3;
            k += String.valueOf(mod);
        }
        k += String.valueOf(N);

//        String[] arr = k.split("");
//        String answer = "";
//        System.out.println("k is " + k);
//
//        for(int i = arr.length-1; i >= 0; i--){
//            answer += arr[i];
//        }

        return k;
    }

    private static int ThreeMake(String k){
        int result = 0;
        String[] arr2 = k.split("");
        int t = 1;
        for(int i = k.length()-1; i >= 0; i--){
           result += Integer.parseInt(arr2[i]) * t;
           t *= 3;
        }

        return result;
    }

    public static int solution(int n) {
        String now = makeThree(n);
        return ThreeMake(now);
    }

    public static void main(String args[]){
        int n = 45;
        int now = solution(n);
        System.out.print(now);
    }
}

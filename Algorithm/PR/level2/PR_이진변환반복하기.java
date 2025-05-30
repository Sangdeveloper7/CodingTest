package PR.level2;

public class PR_이진변환반복하기 {

    private static int countZero = 0;


    public static String makeTwo(String n){
        // 주어진 문자를 이진수로 변환해 리턴하는 함수

        int N = Integer.parseInt(n);
        String result = "";
        while(N >= 2){
           result += String.valueOf(N % 2);
           N /= 2;
        }

        result += String.valueOf(N);

        String arr[] = result.split("");

        String result2 = "";
        for(int i = arr.length-1; i >= 0; i--){
            result2 += arr[i];
        }
        return result2;
    }

    public static String deleteZero(String n){ // 0을 제거한 문자열을 제공 해줌
        String arr[] = n.split("");
        String result = "";

        for(int i = arr.length-1; i >=0; i--){
            if(arr[i].equals("0")){
                countZero++;
            }else{
                result += arr[i];
            }
        }

        return result;
    }

    public static int[] solution(String s) {

        String k = s;
        int countRound = 0;

        while(!k.equals("1")){
            k = deleteZero(k);
            k = String.valueOf(k.length());
            k = makeTwo(k);
            countRound++;
        }
        int[] result = new int[2];
        result[0] = countRound;
        result[1] = countZero;

        return result;
    }

    public static void main(String[] args){
        String s = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        int[] arr = solution(s2);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}

package PR.level1;

public class PR_이상한문자만들기_문자열 {

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int count = 0;
        for(String now : arr){
            if(now.equals(" ")) { // 빈칸일경우
                count = 0;
                answer += " ";
            }
            else{
                if(count % 2 == 0){ // 짝수일 경우
                    answer += now.toUpperCase();
                    count++;
                }else{ // 홀수일 경우
                    answer += now.toLowerCase();
                    count++;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        String s = "try hello world";
        String result = solution(s);
        System.out.println(result);
    }
}

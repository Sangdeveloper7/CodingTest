package PR.level1;

public class PR_시저암호_RE {
    public static String solution(String s, int n) {
        char[] now = s.toCharArray();
        StringBuilder sb = new StringBuilder();


        for(char i : now){
            if(Character.isUpperCase(i)){
                sb.append((char) ((i - 'A' + n) % 26 + 'A'));
            }else if(Character.isLowerCase(i)){
                sb.append((char) ((i - 'a' + n) % 26 + 'a'));
            }else if(i == ' '){
                sb.append(' ');
            }else{
                sb.append(i);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args){
        String e = "z";
        String result = solution(e, 1);
        System.out.print(result);
    }
}

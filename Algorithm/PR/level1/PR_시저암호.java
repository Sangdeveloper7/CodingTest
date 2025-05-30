package PR.level1;

public class PR_시저암호 {
    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(' ');
            } else if (Character.isUpperCase(c)) {
                answer.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                answer.append((char) ((c - 'a' + n) % 26 + 'a'));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        String result = solution(s, 1);
        System.out.println(result);
    }
}

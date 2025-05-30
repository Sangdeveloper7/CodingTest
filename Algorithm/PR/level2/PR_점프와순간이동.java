package PR.level2;

public class PR_점프와순간이동 {

    public static int solution(int n) {
        int ans = 0;
        int N = n;

        while(N >= 1){
            if(N % 2 == 0)
                N /= 2;
            else{
                ans++;
                N -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int result = solution(5000);
        System.out.print(result);
    }
}

package 취업준비.저자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 저자_정렬_계수정렬구현하기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];

        String s = br.readLine();

        char[] string = s.toCharArray();

        for(int i = 0; i < string.length; i++){
            int alphano = string[i] - 'a';
            alphabet[alphano]++;
        }

        String news = "";
        for(int i = 0; i < 26; i++){
            if(alphabet[i] != 0){
                while(alphabet[i] != 0){
                    news += (char) ('a' + i);
                    alphabet[i]--;
                }
            }
        }

        System.out.println(news);

    }
}

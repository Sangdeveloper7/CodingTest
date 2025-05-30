package PR.level3;

import java.util.HashMap;

public class PR_다단계칫솔판매_Tree {

    class Solution {
        private static HashMap<String, String> referal;
        private static HashMap<String, Integer> moneyAll;

        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            referal = new HashMap<>();
            moneyAll = new HashMap<>();
            int[] answer = {};
            for(int i = 0; i < enroll.length; i++) {
                if(referral[i].equals("-"))
                    continue;
                else {
                    referal.put(enroll[i], referral[i]); // 부모 매칭
                }
            }

            for(int i = 0; i < seller.length; i++) {
                String sellerName = seller[i];
                int sellerMoney = amount[i] * 100;
                findmother(sellerName, sellerMoney);
            }

            answer = new int[enroll.length];

            int i = 0;
            for(String s : enroll) {
                answer[i] = moneyAll.getOrDefault(s, 0);
                i++;
            }

            return answer;
        }

        private static void findmother(String name ,int profit){
            int toParent = profit / 10;
            int myProfit = profit - toParent;

            moneyAll.put(name, moneyAll.getOrDefault(name, 0) + myProfit);

            if(!referal.containsKey(name)) return;

            String parentName = referal.get(name);
            if(toParent <= 0 || parentName.equals("-")) return;

            findmother(parentName ,toParent);
        }
    }
}

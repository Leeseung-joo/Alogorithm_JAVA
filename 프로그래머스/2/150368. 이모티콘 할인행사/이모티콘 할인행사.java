import java.util.*;

class Solution {
    static int[][] user;
    static int[] emoticon;
    static int serviceUser = 0;
    static int emoticonPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emoticon = emoticons;

        int[] discount = {10, 20, 30, 40};
        ArrayList<Integer> list = new ArrayList<>();
        dfs(discount, 0, list);

        return new int[]{serviceUser, emoticonPrice};
    }

    static void dfs(int[] discount, int depth, ArrayList<Integer> list) {
        // 이모티콘 개수만큼 할인율을 다 정했으면 계산
        if (depth == emoticon.length) {
            calculate(list);
            return;
        }

        // 현재 이모티콘에 대해 10,20,30,40 모두 선택 가능
        for (int i = 0; i < discount.length; i++) {
            list.add(discount[i]);
            dfs(discount, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }

    static void calculate(ArrayList<Integer> list) {
        int serviceNum = 0;
        int sum = 0;

        for (int i = 0; i < user.length; i++) {
            int temp = 0;

            for (int j = 0; j < list.size(); j++) {
                int percent = list.get(j);

                // 사용자의 기준 할인율 이상이면 구매
                if (percent >= user[i][0]) {
                    // 할인된 가격을 더해야 함
                    temp += emoticon[j] * (100 - percent) / 100;
                }
            }

            // 일정 금액 이상이면 플러스 가입
            if (temp >= user[i][1]) {
                serviceNum++;
            } else {
                sum += temp;
            }
        }

        // 가입자 수 우선, 같으면 매출 우선
        if (serviceNum > serviceUser) {
            serviceUser = serviceNum;
            emoticonPrice = sum;
        } else if (serviceNum == serviceUser) {
            emoticonPrice = Math.max(emoticonPrice, sum);
        }
    }
}
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] arr = new int[friends.length]; // 선물지수(준 개수 - 받은 개수)
        HashMap<String, Integer> map = new HashMap<>();   // "A B" -> A가 B에게 준 횟수
        HashMap<String, Integer> point = new HashMap<>(); // 다음달 받을 개수

        // point 0으로 초기화, 이게 킥
        for (String f : friends) point.put(f, 0);


        for (int idx = 0; idx < friends.length; idx++) {
            String friend = friends[idx];
            for (String gift : gifts) {
                String[] s = gift.split(" "); // s[0]=giver, s[1]=receiver
                if (friend.equals(s[0])) {
                    arr[idx]++; // 준 것 +1
                    map.put(gift, map.getOrDefault(gift, 0) + 1); // key는 "A B"
                } else if (friend.equals(s[1])) {
                    arr[idx]--; // 받은 것 -1
                }
            }
        }

        // 쌍별 비교
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) { 
                String a = friends[i];
                String b = friends[j];

               
                String st  = a + " " + b; // a가 b에게 준 횟수
                String st1 = b + " " + a; // b가 a에게 준 횟수

                int giveAB = map.getOrDefault(st, 0);
                int giveBA = map.getOrDefault(st1, 0);

                if (giveAB > giveBA) {
                    point.put(a, point.get(a) + 1);
                } else if (giveAB < giveBA) {
                    point.put(b, point.get(b) + 1);
                } else {
                    // 동률이면 선물지수 비교
                    if (arr[i] > arr[j]) {
                        point.put(a, point.get(a) + 1);
                    } else if (arr[i] < arr[j]) {
                        point.put(b, point.get(b) + 1);
                    }
                    // 같으면 변화 없음
                }
            }
        }

        // 최대값 도출
        for (String key : point.keySet()) {
            answer = Math.max(answer, point.get(key));
        }
        return answer;
    }
}

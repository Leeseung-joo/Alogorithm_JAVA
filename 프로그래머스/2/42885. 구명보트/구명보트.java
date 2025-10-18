import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 몸무게 오름차순 정렬
        int left = 0;                 // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int boats = 0;                // 필요한 보트 수

        while (left <= right) {
            // 가장 가벼운 사람 + 가장 무거운 사람 같이 탈 수 있으면
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람도 탑승 완료
            }
            // 무거운 사람은 항상 태움
            right--;
            boats++;
        }

        return boats;
    }
}

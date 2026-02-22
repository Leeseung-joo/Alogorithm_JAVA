import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < enemy.length; i++) {
            q.offer(enemy[i]);
            n -= enemy[i];

            if (n < 0) {
                if (k == 0) return answer; // 더 못 버팀
                n += q.poll();             // 지금까지 중 최대를 무적권으로 교체
                k--;
            }

            answer++; // i라운드를 버텼다
        }

        return answer; // 끝까지 버틴 경우 enemy.length
    }
}
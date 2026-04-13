import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            total += work;
            pq.offer(work);
        }

        if (total <= n) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            int max = pq.poll();
            pq.offer(max - 1);
        }

        long result = 0;

        while (!pq.isEmpty()) {
            long num = pq.poll();
            result += num * num;
        }

        return result;
    }
}
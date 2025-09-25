import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1) 요청 시간 오름차순
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // 2) 소요시간 기준 최소 힙: [요청, 소요]
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));

        int n = jobs.length;
        int idx = 0;        // 아직 힙에 넣지 않은 jobs 인덱스
        int time = 0;       // 현재 시각
        long total = 0;     // 총 처리시간(대기+실행)

        while (idx < n || !pq.isEmpty()) {
            // 현재 시각까지 도착한 작업을 모두 힙에 투입
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time += cur[1];                           // 소요시간만큼 진행
                total += (time - cur[0]);                // 대기+실행 = 완료시각 - 요청시각
            } else {
                // 대기열이 비었으면 다음 작업이 오는 시각으로 점프
                time = jobs[idx][0];
            }
        }
        return (int)(total / n);
    }
}

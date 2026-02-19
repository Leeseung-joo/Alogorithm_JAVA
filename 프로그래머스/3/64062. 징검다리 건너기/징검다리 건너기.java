class Solution {
    public static int solution(int[] stones, int k) {
        int n = stones.length;

        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lo = Math.min(lo, stones[i]);
            hi = Math.max(hi, stones[i]);
        }


        while (lo < hi) {
            // 깍이는 내구도
            int mid = (lo + hi) / 2;

            // mid 만큼 내구도를 깍았을 때, 건널 수 있는지 확인
            if (canCross(stones, k, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private static boolean canCross(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid <= 0) cnt++;
            else cnt = 0;

            // 0이 k개 만큼 반복되면 건널 수 없음
            if (cnt == k) return false;
        }
        return true;
    }
}
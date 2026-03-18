class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];

        // 직접 경기 결과 기록
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            win[winner][loser] = true;
        }

        // 플로이드-워셜
        // i가 k를 이기고, k가 j를 이기면 i가 j를 이김
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (i == j || j == k) continue;
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        // 각 선수마다 다른 모든 선수와 승/패 관계가 확정되는지 확인
        for (int i = 1; i <= n; i++) {
            int known = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                // i가 j를 이기거나, j가 i를 이기면 관계가 확정된 것
                if (win[i][j] || win[j][i]) {
                    known++;
                }
            }

            if (known == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
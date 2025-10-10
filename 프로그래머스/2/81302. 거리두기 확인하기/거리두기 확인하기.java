import java.util.*;

class Solution {

    public int[] solution(String[][] places) {
        int n = places.length; // 보통 5
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            char[][] a = new char[5][5];
            for (int r = 0; r < 5; r++) a[r] = places[i][r].toCharArray();

            answer[i] = checkPlaceBFS(a) ? 1 : 0;
        }
        return answer;
    }

    // 장소 하나(5x5) 검사: 모든 P에 대해 BFS로 거리 2 이내 충돌 여부 확인
    private boolean checkPlaceBFS(char[][] a) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (a[r][c] == 'P') {
                    if (!bfsOK(a, r, c)) return false;
                }
            }
        }
        return true;
    }

    // (sr,sc)에서 시작해서 거리 2까지만 BFS. 벽(X)은 막고, 그 안에서 P 발견 시 실패
    private boolean bfsOK(char[][] a, int sr, int sc) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean[][] visited = new boolean[5][5];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (d == 2) continue; // 더 멀리는 볼 필요 없음

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(nr, nc) || visited[nr][nc]) continue;
                if (a[nr][nc] == 'X') continue; // 파티션은 막힘

                // 거리 d+1에서 P를 만나면 규칙 위반
                if (a[nr][nc] == 'P') return false;

                // O(빈 자리)는 이동만 가능. (P는 위에서 걸러서 큐에 안 넣음)
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, d + 1});
            }
        }
        return true;
    }

    private boolean in(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}

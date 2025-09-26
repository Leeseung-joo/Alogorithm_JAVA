import java.util.*;

class Solution {
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int[][] visited; // 거리 저장(0이면 미방문)
    static int N, M;

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];

        // 시작이 벽이면 불가
        if (maps[0][0] == 0) return -1;

        bfs(new Point(0, 0), maps);

        return (visited[N-1][M-1] == 0) ? -1 : visited[N-1][M-1];
    }

    static void bfs(Point start, int[][] maps) {
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start.x][start.y] = 1; // 시작 거리 1

        while (!dq.isEmpty()) {
            Point cur = dq.poll();
            int x = cur.x, y = cur.y;

            // 목적지 도달 시 빠르게 종료하고 싶으면 주석 해제
            // if (x == N-1 && y == M-1) return;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위
                if (maps[nx][ny] == 0) continue;                      // 벽
                if (visited[nx][ny] != 0) continue;                   // 이미 방문(더 짧은 경로 존재)

                visited[nx][ny] = visited[x][y] + 1; // 거리 갱신
                dq.add(new Point(nx, ny));
            }
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}

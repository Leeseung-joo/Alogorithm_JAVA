import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {0, 1, 0, -1};   // 오른, 아래, 왼, 위
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<Point> q = new ArrayDeque<>();

        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 도착했으면 거리 리턴
            if (p.x == n - 1 && p.y == m - 1) {
                return p.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 밖
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽이거나 이미 방문
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, p.distance + 1));
            }
        }

        // 도착 못 하면 -1
        return -1;
    }

    static class Point {
        int x, y, distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

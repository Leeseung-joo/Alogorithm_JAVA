import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int max = 0;
        for (int depth = 0; depth <= maxHeight; depth++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > depth) {
                        cnt += dfs(i, j, depth);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    static int dfs(int x, int y, int depth) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] > depth) {
                dfs(nx, ny, depth);
            }
        }
        return 1;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;         // 0:빈칸, 1:벽
    static boolean[][] cleaned; // 청소 여부
    // 0:북, 1:동, 2:남, 3:서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = simulate(r, c, d);
        System.out.println(ans);
    }

    static int simulate(int r, int c, int d) {
        int cleanedCount = 0;

        while (true) {
            // 1) 현재 칸이 아직 청소되지 않았다면 청소
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                cleanedCount++;
            }

            // 2) 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                // 반시계(왼쪽) 회전
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (in(nx, ny) && map[nx][ny] == 0 && !cleaned[nx][ny]) {
                    // 전진
                    r = nx; c = ny;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 3) 네 방향 모두 청소 불가 → 뒤로 한 칸
            int backX = r - dx[d];
            int backY = c - dy[d];

            if (!in(backX, backY) || map[backX][backY] == 1) {
                // 뒤가 벽이면 작동 종료
                break;
            } else {
                // 뒤로 이동 (방향 유지)
                r = backX; c = backY;
            }
        }

        return cleanedCount;
    }

    static boolean in(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}

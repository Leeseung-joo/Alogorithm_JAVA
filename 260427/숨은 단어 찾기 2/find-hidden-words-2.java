import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static String target = "LEE";

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 8; d++) {
                    if (check(i, j, d)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(int x, int y, int dir) {
        for (int k = 0; k < target.length(); k++) {
            int nx = x + dx[dir] * k;
            int ny = y + dy[dir] * k;

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                return false;
            }

            if (grid[nx][ny] != target.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}
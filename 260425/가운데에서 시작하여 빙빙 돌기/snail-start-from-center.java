import java.util.Scanner;

public class Main {
    // 우, 상, 좌, 하
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        int x = n / 2;
        int y = n / 2;

        int num = 1;
        int len = 1;
        int dir = 0;

        map[x][y] = num++;

        while (num <= n * n) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < len; i++) {
                    x += dx[dir];
                    y += dy[dir];

                    if (x < 0 || x >= n || y < 0 || y >= n) continue;

                    map[x][y] = num++;

                    if (num > n * n) break;
                }

                dir = (dir + 1) % 4;

                if (num > n * n) break;
            }

            len++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
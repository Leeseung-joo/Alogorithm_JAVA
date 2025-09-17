import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int N;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Character> turns = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a - 1][b - 1] = 1; // 사과는 1
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turns.put(x, c);
        }

        int time = simulate(turns);
        bw.write(String.valueOf(time));
        bw.flush();
    }

    static int simulate(Map<Integer, Character> turns) {
        int time = 0;
        int dir = 0; // 처음엔 동쪽
        int x = 0, y = 0;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{x, y});
        board[x][y] = -1; // 뱀의 몸은 -1로 표시

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽에 부딪힘
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            // 자기 몸에 부딪힘
            if (board[nx][ny] == -1) break;

            // 사과 있는 경우 → 꼬리 안 줄임
            if (board[nx][ny] == 1) {
                board[nx][ny] = -1;
                snake.addFirst(new int[]{nx, ny});
            } else { // 빈칸인 경우 → 머리 늘리고 꼬리 줄임
                board[nx][ny] = -1;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }

            // 좌표 갱신
            x = nx;
            y = ny;

            // 방향 전환 확인
            if (turns.containsKey(time)) {
                char turn = turns.get(time);
                if (turn == 'D') { // 오른쪽 회전
                    dir = (dir + 1) % 4;
                } else if (turn == 'L') { // 왼쪽 회전
                    dir = (dir + 3) % 4;
                }
            }
        }
        return time;
    }
}

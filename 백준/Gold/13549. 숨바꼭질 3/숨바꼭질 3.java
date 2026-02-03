import java.io.*;
import java.util.*;

public class Main { // BOJ는 클래스명 Main 필수
    static final int LIMIT = 200000;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N >= K면 뒤로 걷기만 하는 게 최적
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int max = LIMIT; // 필요하면 Math.max(LIMIT, 2*K + 2)로 더 타이트하게
        int[] dist = new int[max + 1];
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[N] = 0;
        dq.add(N);

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            if (x == K) {
                System.out.println(dist[x]);
                return;
            }

            // 0초 간선: 순간이동
            int nx = x << 1; // 2*x
            if (nx <= max && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            // 1초 간선: x-1
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) { // 하한 체크 추가
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            // 1초 간선: x+1  ← 빠져있던 부분 추가
            nx = x + 1;
            if (nx <= max && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }
    }
}

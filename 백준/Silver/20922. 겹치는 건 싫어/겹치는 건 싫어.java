import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxVal = 100000; // 문제 범위
        int[] cnt = new int[maxVal + 1];

        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int l = 0, ans = 0;
        for (int r = 0; r < N; r++) {
            cnt[a[r]]++;

            while (cnt[a[r]] > K) {   // 현재 들어온 값이 K 초과면 왼쪽 줄이기
                cnt[a[l]]--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        System.out.println(ans);
    }
}

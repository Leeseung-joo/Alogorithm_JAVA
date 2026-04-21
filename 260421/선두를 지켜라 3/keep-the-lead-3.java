import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][2];
        int[][] b = new int[M][2];

        int totalA = 0, totalB = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            a[i][0] = v;
            a[i][1] = t;
            totalA += t;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            b[i][0] = v;
            b[i][1] = t;
            totalB += t;
        }

        int maxTime = Math.max(totalA, totalB);
        int[] posA = new int[maxTime + 1];
        int[] posB = new int[maxTime + 1];

        int timeA = 1;
        for (int i = 0; i < N; i++) {
            int v = a[i][0];
            int t = a[i][1];
            while (t-- > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for (int i = 0; i < M; i++) {
            int v = b[i][0];
            int t = b[i][1];
            while (t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int flag = 2;
        int cnt = 0;

        for (int time = 1; time <= maxTime; time++) {
            if (posA[time] > posB[time] && flag != 0) {
                flag = 0;
                cnt++;
            } else if (posA[time] < posB[time] && flag != 1) {
                flag = 1;
                cnt++;
            } else if (posA[time] == posB[time] && flag != 2) {
                flag = 2;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
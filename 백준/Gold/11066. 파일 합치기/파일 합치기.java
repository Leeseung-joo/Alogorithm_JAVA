import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int K = scanner.nextInt(); // 장의 수
            int[] files = new int[K];
            int[] sum = new int[K + 1];

            // 파일 크기 입력 및 누적 합 계산
            for (int i = 0; i < K; i++) {
                files[i] = scanner.nextInt();
                sum[i + 1] = sum[i] + files[i];
            }

            // DP 테이블 초기화
            int[][] dp = new int[K][K];

            // 길이에 따라 최소 비용 계산
            for (int len = 1; len < K; len++) {
                for (int i = 0; i + len < K; i++) {
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 
                                            dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                    }
                }
            }

            // 결과 출력
            System.out.println(dp[0][K - 1]);
        }
        scanner.close();
    }
}
import java.util.Arrays;

class Solution {
    private int bestDiff = Integer.MIN_VALUE; // 최적 점수차
    private int[] bestAns = new int[11];      // 최적 배치

    public int[] solution(int n, int[] info) {
        Arrays.fill(bestAns, -1);             // 기본값: 불가능 (-1)
        int[] scoreMap = new int[11];         // 현재 배치
        dfs(0, n, scoreMap, info);

        if (bestAns[0] == -1) return new int[]{-1};
        return bestAns;
    }

    // idx: 0..10 (10점~0점 칸), arrowLeft: 남은 화살
    private void dfs(int idx, int arrowLeft, int[] scoreMap, int[] info) {
        // 종료(모든 칸을 정했거나 화살이 다 떨어짐)
        if (idx == 11 || arrowLeft == 0) {
            if (arrowLeft > 0) {
                scoreMap[10] += arrowLeft; // 남은 화살 0점 칸에 몰아넣기
            }
            evaluate(scoreMap, info);
            if (arrowLeft > 0) {
                scoreMap[10] -= arrowLeft; // 원상복구
            }
            return;
        }

        // 1) 포기(0개) 분기
        dfs(idx + 1, arrowLeft, scoreMap, info);

        // 2) 이기는(need개 쏘기) 분기
        int need = info[idx] + 1;
        if (arrowLeft >= need) {
            scoreMap[idx] = need;
            dfs(idx + 1, arrowLeft - need, scoreMap, info);
            scoreMap[idx] = 0; // 원상복구
        }
    }

    private void evaluate(int[] scoreMap, int[] info) {
        int rion = 0, apeach = 0;
        for (int i = 0; i < 11; i++) {
            int s = 10 - i;
            if (scoreMap[i] > info[i]) {
                rion += s;
            } else if (info[i] > 0) {
                // 어피치는 해당 칸에 1발 이상 쐈고 라이언이 못 이긴 경우에만 점수
                apeach += s;
            }
        }

        int diff = rion - apeach;
        if (diff <= 0) return; // 이겨야만 후보

        if (diff > bestDiff) {
            bestDiff = diff;
            bestAns = Arrays.copyOf(scoreMap, 11);
        } else if (diff == bestDiff) {
            // 하위 점수(0점 쪽) 많이 맞춘 배치 우선: 인덱스 10→0 비교
            for (int i = 10; i >= 0; i--) {
                if (scoreMap[i] > bestAns[i]) {
                    bestAns = Arrays.copyOf(scoreMap, 11);
                    break;
                } else if (scoreMap[i] < bestAns[i]) {
                    break;
                }
            }
        }
    }
}

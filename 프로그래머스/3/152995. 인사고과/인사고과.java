import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int me = wanhoA + wanhoB;

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        int maxPeer = 0;
        int rank = 1;

        for (int i = 0; i < scores.length; i++) {
            int a = scores[i][0];
            int b = scores[i][1];

            if (b < maxPeer) {
                if (a == wanhoA && b == wanhoB) {
                    return -1;
                }
                continue;
            }

            maxPeer = Math.max(maxPeer, b);

            if (a + b > me) {
                rank++;
            }
        }

        return rank;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int kind = set.size();

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int bestL = 0, bestR = gems.length - 1;

        for (int right = 0; right < gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == kind) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    bestL = left;
                    bestR = right;
                }

                String lv = gems[left];
                int c = map.get(lv) - 1;
                if (c == 0) map.remove(lv);
                else map.put(lv, c);

                left++;
            }
        }

        return new int[]{bestL + 1, bestR + 1};
    }
}
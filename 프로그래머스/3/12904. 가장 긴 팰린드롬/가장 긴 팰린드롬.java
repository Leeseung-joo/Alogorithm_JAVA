class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬
            maxLen = Math.max(maxLen, expand(s, i, i));

            // 짝수 길이 팰린드롬
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }

        return maxLen;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 마지막 비교에서 한 칸씩 더 나간 상태이므로 -1 보정
        return right - left - 1;
    }
}
class Solution {
    public int solution(String s) {
        int answer = s.length(); // 초기값은 최대 길이
        
        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder result = new StringBuilder();
            String prev = s.substring(0, len);
            int cnt = 1;

            for (int i = len; i < s.length(); i += len) {
                String curr = s.substring(i, Math.min(i + len, s.length()));

                if (prev.equals(curr)) {
                    cnt++;
                } else {
                    if (cnt > 1) result.append(cnt);
                    result.append(prev);

                    prev = curr;
                    cnt = 1;
                }
            }

            // 마지막 처리
            if (cnt > 1) result.append(cnt);
            result.append(prev);

            // 최소 길이 갱신
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
class Solution {
    public int solution(String s) {
        if (s.length() == 1) return 1;

        int result = s.length();

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder sb = new StringBuilder();

            String prev = s.substring(0, len);
            int cnt = 1;

            for (int i = len; i + len <= s.length(); i += len) {
                String current = s.substring(i, i + len);

                if (prev.equals(current)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(prev);
                    } else {
                        sb.append(cnt).append(prev);
                    }
                    prev = current;
                    cnt = 1;
                }
            }

            if (cnt == 1) {
                sb.append(prev);
            } else {
                sb.append(cnt).append(prev);
            }

            if (s.length() % len != 0) {
                sb.append(s.substring(s.length() - (s.length() % len)));
            }

            result = Math.min(result, sb.length());
        }

        return result;
    }
}
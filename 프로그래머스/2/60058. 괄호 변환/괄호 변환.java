import java.util.*;

class Solution {

    public String solution(String p) {
        return solve(p);
    }

    // 올바른 괄호 문자열인지 체크
    private boolean isCorrect(String p) {
        int cnt = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    private String solve(String w) {
        // 1. 빈 문자열이면 그대로 반환
        if (w.equals("")) return "";

        // 2. w를 u, v로 분리 (u는 더 이상 분리 불가능한 균형잡힌 문자열)
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') cnt++;
            else cnt--;

            if (cnt == 0) { // 균형 맞는 최초 지점
                idx = i;
                break;
            }
        }

        String u = w.substring(0, idx + 1);
        String v = w.substring(idx + 1);

        // 3. u가 올바른 괄호 문자열이면
        if (isCorrect(u)) {
            return u + solve(v);
        }

        // 4. u가 올바르지 않으면
        // "(" + solve(v) + ")" + (u의 첫/마지막 제거 후 괄호 뒤집기)
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solve(v));
        sb.append(")");

        // u의 첫/마지막 제거
        String mid = u.substring(1, u.length() - 1);

        // 괄호 뒤집기
        for (int i = 0; i < mid.length(); i++) {
            char c = mid.charAt(i);
            sb.append(c == '(' ? ')' : '(');
        }

        return sb.toString();
    }
}

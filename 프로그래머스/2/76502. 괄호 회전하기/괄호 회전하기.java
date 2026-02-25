import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n % 2 == 1) return 0;

        String ss = s + s;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String temp = ss.substring(i, i + n);

            Stack<Character> stack = new Stack<>();
            boolean ok = true;

            for (int j = 0; j < n; j++) {
                char c = temp.charAt(j);

                if (c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) { ok = false; break; }

                    char top = stack.peek();
                    if ((c == ')' && top == '(') ||
                        (c == '}' && top == '{') ||
                        (c == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        ok = false; 
                        break;
                    }
                }
            }

            if (ok && stack.isEmpty()) cnt++;
        }

        return cnt;
    }
}
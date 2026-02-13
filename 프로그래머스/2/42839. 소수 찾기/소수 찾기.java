import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private boolean[] visited;
    private char[] digits;

    public int solution(String numbers) {
        digits = numbers.toCharArray();
        visited = new boolean[digits.length];

        dfs("");  // 빈 문자열에서 시작

        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    private void dfs(String cur) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur)); 
        }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(cur + digits[i]);     
            visited[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) { 
            if (n % i == 0) return false;
        }
        return true;
    }
}

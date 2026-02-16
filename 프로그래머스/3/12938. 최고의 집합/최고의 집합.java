import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (s < n) return new int[]{-1};
        
        int base = s / n;
        int remain = s % n;
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        // 뒤에서부터 +1 (오름차순 유지)
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}

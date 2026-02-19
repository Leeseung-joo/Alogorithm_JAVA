import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long max1 = 0, max2 = 0;
        long ans = 0;

        for (int i = 0; i < sequence.length; i++) {
            long a = (i % 2 == 0) ? sequence[i] : -sequence[i]; // + - + - ...
            long b = -a;                                        // - + - + ...

            max1 = Math.max(a, max1 + a);
            max2 = Math.max(b, max2 + b);

            ans = Math.max(ans, Math.max(max1, max2));
        }
        return ans;
    }
}

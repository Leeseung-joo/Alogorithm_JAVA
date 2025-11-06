class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1]; //n원을 거슬러주는 방법
        dp[0] = 1;
        for(int coin : money){
            for(int i = coin; i <= n; i++){
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[n] % 1000000007;
    }
}
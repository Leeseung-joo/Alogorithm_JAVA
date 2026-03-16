import java.util.*;
class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int m = hint.length;
        
        int answer = Integer.MAX_VALUE;
        
        //mask: 어떤 번들을 구매했는지 나타내는 비트마스크
        for(int mask = 0; mask < (1<<m); mask++){
            int[] hintCount = new int[n+1]; //stage번호 그대로 사용
            int total = 0;
            
            // 선택한 번들들의 가격 + 힌트권 개수 반영
            for(int b = 0; b < m; b++){
                if((mask & (1 << b)) != 0){
                    total += hint[b][0]; //번들 구매 비용
                    
                    for(int j = 1; j < hint[b].length; j++){
                        hintCount[hint[b][j]]++;
                    }
                }
            }
            
            //각 스테이지 해결 비용 추가
            for(int stage = 1; stage <= n; stage++){
                int used = Math.min(hintCount[stage], n-1);
                total += cost[stage-1][used];
            }
            
            answer = Math.min(answer, total);
            
        }
        return answer;
    }
}

//번들 부분집합 탐색
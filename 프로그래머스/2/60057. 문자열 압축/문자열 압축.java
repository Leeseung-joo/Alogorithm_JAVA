import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int N = s.length()/2;
        
        for(int i = 1; i<= N; i++){
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            
            int idx = 0;
            String prev = s.substring(idx, idx+i);
                idx = idx + i;
            while(idx+i <= s.length()){
                String cur = s.substring(idx, idx+i); //i단위로 자름
                
                if(prev.equals(cur)){
                    cnt++;
                }else{
                    if(cnt >=2){
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    cnt = 1;
                    prev = cur;
                }
                idx += i;
            }
                        // 마지막 덩어리 flush
            if (cnt >= 2) sb.append(cnt);
            sb.append(prev);
            sb.append(s.substring(idx));
            answer = Math.min(answer, sb.length());
            
            
        }
        
        
        
        
        
        
        return answer;
    }
}
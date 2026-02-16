import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
    
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int work: works){
            q.offer(work);
        }
        
        while(n>0){
            Integer num = q.poll();
            if(num == null) break;
            n--;
            if(num-1 <= 0) continue;
            else q.offer(num-1);
        }
        
        long result = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            result += temp*temp;
        }
        return result;
    }
}
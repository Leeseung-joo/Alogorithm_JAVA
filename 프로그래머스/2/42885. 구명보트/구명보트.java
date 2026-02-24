import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        int cnt = 0;
        while(left <= right){
            int temp = people[left] + people[right];
            
            if(temp > limit){
                right--;
                cnt++;
            }else{
                left++;
                right--;
                cnt++;
            }
        }
        return cnt;
        
        
    }
}
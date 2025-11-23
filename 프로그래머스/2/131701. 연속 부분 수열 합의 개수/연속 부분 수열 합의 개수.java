import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        
        int[] arr = new int[elements.length * 2];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = elements[i % elements.length];  //원형 수열이므로 한 번 더 이어 붙임
        }
        
        int[] prefix = new int[elements.length*2 + 1 ];
        
        for(int i = 0; i < arr.length; i++){
            prefix[i+1] = prefix[i] + arr[i];  //i까지의 누적 합 
        }
        
        for(int len = 1; len <= elements.length; len++){
            for(int start = 0; start < elements.length; start++){
                int end = start + len;
                int sum = prefix[end] - prefix[start];
                
                set.add(sum);
            }
        }
        return set.size();
        
        
        
    }
}
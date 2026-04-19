import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        int keep = number.length() - k;
        
        stack.push(number.charAt(0));
        
        for(int i = 1; i < number.length(); i++){
            char current = number.charAt(i);
            
            while(!stack.isEmpty() && k >0 && stack.peek() < current ){
                
                stack.pop();
                k--;
                }
                    stack.push(current);
                }
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().substring(0,keep);
                
    }
}
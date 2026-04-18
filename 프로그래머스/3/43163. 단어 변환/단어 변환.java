import java.util.*;
class Solution {
    static class Node{
        String word;
        int cnt;
        
        Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node current = q.poll();
            
            if(current.word.equals(target)) return current.cnt;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && canChange(current.word, words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i], current.cnt+1));
                }
            }
        }
        
        return 0;
    }
    
    static boolean canChange(String current, String target){
        int diff = 0;
        
        for(int i = 0; i < target.length(); i++){
            if(current.charAt(i) != target.charAt(i)) diff++;
        }
        return diff == 1 ? true : false;
    }
}
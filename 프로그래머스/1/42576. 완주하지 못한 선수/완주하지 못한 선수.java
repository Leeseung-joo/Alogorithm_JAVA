import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s: participant){
            map.put(s, map.getOrDefault(s,0)+ 1);
        }
        
        for(String s : completion){
            map.put(s,map.get(s)-1);
        }
        String result = "";
        for(String s : map.keySet()){
            if(map.get(s) > 0){
                return s;
            }
        
        }
        return "";
    }
}
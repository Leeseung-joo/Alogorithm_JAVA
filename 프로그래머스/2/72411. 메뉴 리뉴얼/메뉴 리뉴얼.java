import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
    
        ArrayList<String> list = new ArrayList<>();
        
        for(int length : course){
            map.clear();                    
            int maxCnt = 0;

            for(String order : orders){
                char[] chars = order.toCharArray(); //문자로 분리
                Arrays.sort(chars);                 
                dfs(length, 0, "", chars, order.length());
            }

            // 최빈값 계산 (2회 이상만 의미 있음)
            for(String s : map.keySet()){
                if(map.get(s) >= 2) {
                    maxCnt = Math.max(maxCnt, map.get(s));
                }
            }

            // 동률(최빈값) 모두 추가
            if(maxCnt >= 2) {
                for (String s : map.keySet()) {
                    if (map.get(s) == maxCnt) list.add(s);
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    static void dfs(int length, int index, String str, char[] chars, int maxL){
        if(str.length() == length){
            map.put(str, map.getOrDefault(str,0) + 1); //없으면 1, 있으면 기존꺼 + 1
            return;
        }
        if(index < maxL){
            dfs(length, index+1, str+String.valueOf(chars[index]), chars, maxL);
            dfs(length, index+1, str, chars, maxL);
        }
    }
}

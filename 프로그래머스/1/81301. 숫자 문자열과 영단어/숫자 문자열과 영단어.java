import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, String> map = Map.of(  //맵 한번에 정의
            "zero", "0",
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven","7",
            "eight", "8",
            "nine", "9"
        );
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                result.append(c);
            }else{
                 temp.append(c);
                if(map.containsKey(temp.toString())){
                    result.append(map.get(temp.toString()));
                    temp.setLength(0); //초기화
                }
                
            }
        }
                   return Integer.parseInt(result.toString());
    }
}
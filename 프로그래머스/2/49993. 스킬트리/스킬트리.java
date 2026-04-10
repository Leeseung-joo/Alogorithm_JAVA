

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    for(String cur : skill_trees){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cur.length(); i++){
            if(skill.contains(cur.charAt(i) + "")){
                sb.append(cur.charAt(i));  //sb는 항상 배운 스킬의 순서
            }
            
}       
        if(skill.indexOf(sb.toString()) == 0){ //0부터가 아니면 순서가 틀리므로 오류
            answer++;
        }
        
    }
        return answer;
}
}
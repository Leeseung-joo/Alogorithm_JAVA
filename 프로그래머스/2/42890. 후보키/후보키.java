import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int result = 0;
        
        int col = relation[0].length;
        int row = relation.length;
        ArrayList<Integer> candiateKeys = new ArrayList<>();
        
        for(int mask = 1; mask < (1 << col); mask++){ //모든 컬럼 조합에 대해 검사
            
            //1 최소성
            boolean minimal = true;
            for(int key : candiateKeys){
                if((key & mask) == key){
                    minimal = false;
                    break;
                }
            }
            if(!minimal) continue; //현재 조합은 최소성을 만족하지 않음
            
            //유일성
            Set<String> set = new HashSet<>();
            for(int r = 0; r < row; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < col; c++){
                    if((mask & (1<<c)) != 0){ //해당 컬럼이 현재 선택한 부분집합의 컬럼에 포함된다면, 해당하는 값을 빌더에 추가
                        sb.append(relation[r][c]).append("|");
                    
                    }
                    
                }
                set.add(sb.toString());
               
            }
             if(row == set.size()) candiateKeys.add(mask);
            
            
            
        }
        return candiateKeys.size();
        
       
    }
}
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        for(int i = 0; i < arr.length; i++){ //숫자를 문자열 배열로 변환
            arr[i] = String.valueOf(numbers[i]);
        }
        //내림차순
          Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        
        
        //이어 붙이기
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    
        
    }
}
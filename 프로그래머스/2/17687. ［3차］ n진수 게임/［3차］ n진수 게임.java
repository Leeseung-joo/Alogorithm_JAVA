class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int N = t*m; //전체 만들어야하는 개수
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= N; i++){
            sb.append(Integer.toString(i,n).toUpperCase()); 
        }
        String st = sb.toString();
        
        StringBuilder result = new StringBuilder();
        
        int cnt = 0; //반복횟수
        while(cnt != t){
            result.append(st.charAt(p-1 +m*cnt));
        
            cnt++;
        }
        return result.toString();
    }
}
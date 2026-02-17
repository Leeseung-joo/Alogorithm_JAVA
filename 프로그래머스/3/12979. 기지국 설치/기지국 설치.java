class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2*w +1;
        int idx = 1; //현재 탐색위치
        
        for(int station: stations){
            int left = station - w;
            if(idx < left){
                int gap = left - idx;
                answer += (gap + range - 1) / range;
            }
            idx = station + w + 1;   // 다음 탐색 시작 위치
        }
        

        // 마지막 기지국 이후 구간 처리
        if (idx <= n) {
            int gap = n - idx + 1;
            answer += (gap + range - 1) / range;
        }
        
        return answer;


    
    }
}
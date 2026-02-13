class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
            dfs(dungeons, k, 0); // 진행하려고 하는 던전과, 현재 남은 인덱스

        
        
        
        
        
        
        
        
        return answer;
    }

    static void dfs(int[][] list, int k,int temp){
        

        if(temp > answer){
            answer = temp;
        }
        
        for(int i = 0; i < list.length; i++){
            if(!visited[i] && k >= list[i][0]){
                visited[i] = true;
                dfs(list,k-list[i][1],temp+1);
                visited[i] = false;
            }
        }
            
        
        
        
        
        
        
        
    }
}
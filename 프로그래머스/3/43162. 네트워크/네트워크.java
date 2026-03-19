class Solution {
    static boolean[] visited;
    static int result = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n+1];
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i]&& computers[i][j] == 1){
                    result++;
                    dfs(i, computers);
                }
            }
        }
        return result;
        
        
        
    }
    
    static void dfs(int i, int[][] computers){
        visited[i] = true;
        
        int[] computer = computers[i];
        
        for(int x = 0; x < computer.length; x++){
            if(!visited[x] && computer[x] == 1){
                dfs(x, computers);
            }
        }
        return;
        
    }
}
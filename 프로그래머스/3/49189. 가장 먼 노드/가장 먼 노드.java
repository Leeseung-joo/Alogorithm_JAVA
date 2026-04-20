import java.util.*;
class Solution {
    static int answer = 0;
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i =0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            
            graph[from].add(to); //인접 리스트 완성
            graph[to].add(from);
        }
        
        dfs(n,1);
        
        
            
        return answer;
    }
    
    static void dfs(int n, int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        dist[start] = 0;
        q.offer(start);
        
        while(!q.isEmpty()){
            Integer now = q.poll();
            
            for(int next : graph[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        int max = 0;
        
        for(int i = 2; i <= n; i++){
            if(max < dist[i]){
                max = dist[i];
            }
        }
        for(int i = 1; i <= n; i++){
            if(max == dist[i]) answer++;
        }
        return;
    }
}
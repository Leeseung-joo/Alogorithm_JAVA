import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int maxDistance = 0;
for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);  //무방향이므로 양방향 간선 추가
            graph.get(b).add(a);
        }
        
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.offer(1);
        
        while(!q.isEmpty()){
            int current = q.poll();
            
            for(int num : graph.get(current)){
                if(dist[num] == -1){
                dist[num] = dist[current]+1;
                maxDistance = Math.max(maxDistance, dist[num]);
                
                q.offer(num);
                }
            }
            
            
        }
        int answer = 0;
        
        for(int i = 0; i< dist.length; i++){
            if(maxDistance == dist[i]){
                answer++;
            }
        }
        return answer;
        
        
    }

}
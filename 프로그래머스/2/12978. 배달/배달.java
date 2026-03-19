import java.util.*;
class Solution {
    
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
       
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList[N+1];
        
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] roads : road){
            int from = roads[0];
            int to = roads[1];
            int cost = roads[2];
            
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }
        
        int[] result = dij(N,1);
        int answer = 0;
        
        for(int i = 1; i <= N; i++){
            if(result[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    static int[] dij(int N, int start){
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.to]) continue;
            
            for(Node next : graph[cur.to]){
                int nextCost = cur.cost + next.cost;
                
                if(nextCost < dist[next.to]){
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        return dist;
        
        
    }
}
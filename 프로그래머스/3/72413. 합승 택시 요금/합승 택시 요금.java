import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        int[] distFromS = dijkstra(n, s);
        int[] distFromA = dijkstra(n, a);
        int[] distFromB = dijkstra(n, b);
        
        int answer = INF;
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.cost > dist[now.to]) continue;
            
            for (Node next : graph[now.to]) {
                int nextCost = now.cost + next.cost;
                
                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        
        return dist;
    }
}
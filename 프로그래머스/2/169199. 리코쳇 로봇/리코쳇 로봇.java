import java.util.*;
class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static int result = -1;
    
    static class Node{
        int x;
        int y;
        int cost;
        
        Node(int x,int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        
        N = board.length;
        M = board[0].length(); 
        
        for(int i = 0; i < board.length; i++){
            String line = board[i];
            for(int j = 0; j < line.length(); j++){
                map[i][j] = line.charAt(j);
            }
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 'R'){
                    bfs(i,j);
                }
            }
        }
        return result;
        
        
    }
    
    static void bfs(int x,int y){
        visited[x][y] = true;
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x;
                int ny = cur.y;
                
               while(true){
                   int fx = nx + dx[i];
                   int fy = ny + dy[i];
                   
                   if(!inRange(fx,fy) || map[fx][fy] == 'D') break;
                   
                   nx = fx;
                   ny = fy;
                   
               }
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny] == 'G'){
                    result = cur.cost + 1;
                    return;
                }
                
                visited[nx][ny] = true;
                q.offer(new Node(nx,ny, cur.cost + 1));
                
                
                
                
                
            }
}
        return;
    }
    
    static boolean inRange(int x,int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    
}
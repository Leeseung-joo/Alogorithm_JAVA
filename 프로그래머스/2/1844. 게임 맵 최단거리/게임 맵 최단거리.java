import java.util.*;
class Solution {
            
    static int[][] maps;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int n;
    static int m;
    
    static class Point{
        int x,y;
        int distance;
        
        Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        
    }
    public int solution(int[][] maps) {
        this.n = maps.length;
        this.m = maps[0].length;
        this.maps = maps;
        
        visited = new boolean[n][m];
        
        
        int distance = bfs(0,0,1);
        return distance;
        
    }
    
    static int bfs(int x, int y, int distance){
        ArrayDeque<Point> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Point(x,y,distance));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.x == n-1 && p.y == m-1) return p.distance;
            
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(!isRange(nx,ny)) continue;
               
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new Point(nx,ny, p.distance+1));
                    visited[nx][ny] = true;
                }
                
            }
        }
        return -1;
        
    }
    
    static boolean isRange(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
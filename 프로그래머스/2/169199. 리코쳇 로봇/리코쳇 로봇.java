import java.util.*;
class Solution {
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static String[][] map;
    static int result = Integer.MAX_VALUE;
    static int N;
    static int M;
        
    
    static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt){
            this.x= x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(String[] board) {
        
        N = board.length;
        M = board[0].length();
        
        map = new String[N][M];
        
        
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
                if(map[i][j].equals("R")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int answer = bfs(startX,startY);
        
        return answer;
        
    }
    
    
    static int bfs(int x, int y){
        int cnt = 0;
        
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[x][y] = true;
        q.offer(new Point(x,y,0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(map[p.x][p.y].equals("G")){
                return p.cnt;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = p.x;
                int ny = p.y;
                
                while(true){
                    int tx = nx + dx[i];
                     int ty = ny + dy[i];
                if(!isRange(tx,ty) || map[tx][ty].equals("D")){
                    break;
                }

                    nx = tx;
                    ny = ty;
                    
                }
                if(!visited[nx][ny]){
                q.offer(new Point(nx,ny,p.cnt+1));
                visited[nx][ny] = true;
                
                }
            }
        }
    
        return -1;
        
        
    }
    
    static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >=0 && y < M;
    }
}
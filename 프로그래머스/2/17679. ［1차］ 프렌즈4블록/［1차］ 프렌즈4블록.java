import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] map = new String[m][n];
        HashSet<Point> set = new HashSet<>();
       
    
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        
        while(true){
            
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    String str = map[i][j];
                    if(!str.isEmpty() && str.equals(map[i][j+1]) && str.equals(map[i+1][j+1]) && str.equals(map[i+1][j])){
                        set.add(new Point(i,j));
                        set.add(new Point(i,j+1));
                        set.add(new Point(i+1,j+1));
                        set.add(new Point(i+1, j));
                    }
                }
            }
            if(set.isEmpty()) break;
            
            answer += set.size();
            for(Point p : set){
                map[p.x][p.y] = ""; //빈칸으로
            }
            set.clear();
            
            
            for(int col = 0; col < n; col++){
                int write = m-1; //현재 쓰고 있는 row
                for(int row = m-1; row >=0; row--){
                    if(!map[row][col].isEmpty()){ //값이 비어있지 않으면
                        map[write][col] = map[row][col];
                        write--; 
                    }
                }
                for(int i = write; i >=0; i--)
                    map[i][col] = "";
            }
          
        }
      return answer;
    }
    
    
static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
      @Override public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    @Override public int hashCode(){
        return Objects.hash(x, y);
    }
    }
        
}



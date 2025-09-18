import java.util.*;
import java.io.*;

public class Main {
  static int[][] map;
  static int time = 0; //지난 시간
  static int cnt = 0; //주변 얼음 개수, 한 번 할떄마다 0으로 초기화
  static int component; //연결 요소가 몇개인지
  static int[] dx = new int[]{1,0,-1,0};
  static int[] dy = new int[]{0,1,0,-1};
  static boolean[][] visited; //얼음 개수 셀때 사용
  static boolean[][] visit; //연결요소 셀때 사용
  static int N;
  static int M;
  static boolean flag;

  


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

  while(true){
    flag = false;
    component = 0;
    time++;
    for(int i = 1; i < N-1; i++){
      for(int j = 1; j < M-1; j++){
        if(map[i][j] != 0){
          bfs(i,j); //얼음 녹이기
        }
      }
    }
    for(int i = 1; i < N-1; i++){
      for(int j = 1; j < M-1; j++){
        if(visited[i][j]) visited[i][j] = false; //초기화함으로서 찐 0으로 만들어줌
      }
    }
    visit = new boolean[N][M]; //할 때마다 새로 만들기 

    for(int i = 1; i < N-1; i++){
      for(int j = 1; j < M-1; j++){
        if(map[i][j] != 0 && !visit[i][j]){ //현재 위치를 방문하지 않고, 얼음이 있는 경우
          flag = true;
          dfs(i,j);
          component++;
        }
      }
    }
    if(component >= 2) break;

    if(flag == false){
      time = 0;
      break;
    }
  }
  bw.write(String.valueOf(time));
  bw.flush();
  bw.close();

  }

  static void bfs(int a, int b){ //얼음 녹이기 메서드
    
    for(int i = 0; i<4; i++){
      int nx = a + dx[i];
      int ny = b + dy[i];

      if(map[nx][ny] == 0 && !visited[nx][ny]) cnt++;

      if(cnt >= map[a][b]){
        visited[a][b] = true;
        map[a][b] = 0;
      }else{
        map[a][b] -= cnt;
      }
      cnt = 0; //다시 초기화
    }
    return;
  }

  public static void dfs(int x, int y){ //연결요소 개수 세기
    visit[x][y] = true;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
    
    if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1) continue;
    if(map[nx][ny] != 0 && !visit[nx][ny]) dfs(nx,ny);
  }

  }

  
}

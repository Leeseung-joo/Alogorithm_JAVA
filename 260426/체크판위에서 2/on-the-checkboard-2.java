import java.util.*;
import java.io.*;

public class Main {
    static String[][] map;
    static int N;
    static int M;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = st.nextToken();
            }
        }

        dfs(0,0,0);
        System.out.println(result);


        

    }

    static void dfs(int x,int y, int cnt){

        if(cnt > 3) return;

        if(x == N-1 && y == M-1 && cnt == 3){
            result += 1;
            return;
        }
        if(x == N-1 || y == M-1) return;

        for(int i = x+1; i < N; i++){
            for(int j = y+1; j < M; j++){
                if(!map[x][y].equals(map[i][j])){
                    dfs(i,j,cnt+1);
                }
            }
        }
    }
}

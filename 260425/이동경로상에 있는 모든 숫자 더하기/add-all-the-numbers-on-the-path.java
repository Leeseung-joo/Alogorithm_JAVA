import java.util.Scanner;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int x = n /2;
        int y = n /2;
        int dir = 0;

        int sum = board[x][y];

        for(int i = 0; i < t; i++){
            if(commands.charAt(i) == 'R'){
                dir = (dir+1)%4;
            }else if(commands.charAt(i) == 'L'){
                dir = (dir+3)%4;
            }else{
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > n-1) continue;

                sum += board[nx][ny];
                x = nx;
                y  = ny;
            }
        }
        System.out.println(sum);

    }
}
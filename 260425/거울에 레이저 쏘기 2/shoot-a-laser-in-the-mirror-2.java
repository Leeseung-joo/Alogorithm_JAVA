import java.util.Scanner;

public class Main {
    static int[] dx = {-1,0,1,0};   //북:0,동:1,남:2,서:3
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();
        
        int x,y,dir;

        if(startNum <= n){
            dir = 2;
            x = 0;
            y = startNum - 1;
        }else if(sstartNum <= 2*n){
            dir = 3;
            x = startNum-n-1;
            y = n-1;
        }else if(startNum <= 3*n){
            dir = 0;
            x = n-1;
            y = 3*n - startNum;
        }else {
             x = 4 * n - startNum;
             y = 0;
            dir = 1; // 동
}

        int cnt = 0;

        while (x >= 0 && x < n && y >= 0 && y < n) {
            cnt++;

            if(grid[x][y] == '/'){
                dir ^= 1;
            }else{
                dir += 3;

            }
            x += dx[dir];
            y += dy[dir];



    } 
    System.out.println(cnt);
}
}
//1에서 시작, / 만나면 4로감, \ 만나면  2로감
//2에서 시작 / 만나면 1로감, \만나면 3로감   -> /만나면,-1, \만나면 +1
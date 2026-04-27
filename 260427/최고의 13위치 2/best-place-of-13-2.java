import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-2; j++){
                for(int k = i; k < n; k++){
                    for(int l = 0; l < n-2; l++){
                        if(i == k && Math.abs(j - l) < 3) continue;
                        maxCnt = Math.max(maxCnt,arr[i][j] + arr[i][j+1] + arr[i][j+2] +arr[k][l] + arr[k][l+1]+ arr[k][l+2]);
                    }
                }
            }
        }
        System.out.println(maxCnt);


    }
}

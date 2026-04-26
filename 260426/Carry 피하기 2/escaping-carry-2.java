import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int max = 0;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        dfs(0,0,0);
        System.out.println(max);
        

    }

    static void dfs(int current, int length, int sum){

        if(length == 3){
            max = Math.max(max,sum);
        }

        for(int i = current; i < N; i++){
            if(length == 0){
                dfs(i+1, length+1,arr[i]);
            }else{
                if(enableCarry(sum, arr[i])){
                    dfs(i+1,length+1, sum+arr[i]);
                }

            }
        }
    }

    static boolean enableCarry(int a, int b){

        while(a > 0 || b >0){
            int d1 = a%10;
            int d2 = b%10;

            if(d1+d2 >= 10) return false;

            a /= 10;
            b /= 10;
        }
        return true;
    }
}

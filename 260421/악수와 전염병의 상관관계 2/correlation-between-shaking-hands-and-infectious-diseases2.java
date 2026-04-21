import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //전염시키는 횟수
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(P,K);

        int[][] arr = new int[T][3];
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1,o2) -> {
            return o1[0]-o2[0];
        });
        int answer = 0;
        for(int i = 0; i < T; i++){
            int[] current = arr[i];

            Integer a = map.get(current[1]);
            Integer b = map.get(current[2]);
            if(a != null && b != null){
                map.put(current[2],b-1);
                map.put(current[1],a-1);
                
            }else if(b != null && b >0){
                map.put(current[1],K);
                map.put(current[2],b-1);
            }else if(a != null && a >0){
                map.put(current[2],K);
                map.put(current[1],a-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(map.get(i) != null){
                sb.append("1");
            }else{
                sb.append("0");
            }
        }

        System.out.println(sb.toString());

    }
}
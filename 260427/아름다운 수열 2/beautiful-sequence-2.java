import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> bList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> aList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            aList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            bList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(bList);

        int answer = 0;

        for(int i = 0; i <= N - M; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = i; j < i + M; j++){
                temp.add(aList.get(j));
            }

            Collections.sort(temp);

            if(temp.equals(bList)){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main_8892 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i< n; i++){
            int k = Integer.parseInt(br.readLine());
            String[] arr = new String[k];
            boolean flag = false;

            for(int j = 0; j<k; j++){
                arr[j] = br.readLine();
            }

            for(int a = 0; a<arr.length; a++){
                if(flag) break;
                for(int b = a+1; b<arr.length; b++){
                    if(flag) break;

                    ArrayList<String> list = new ArrayList<>();
                    list.add(arr[a]+arr[b]);
                    list.add(arr[b]+arr[a]);
                    for(String s : list){
                        int cnt = 0;
                    for(int q = 0; q<(s.length()/2); q++){
                        if(s.charAt(q) != s.charAt(s.length()-1-q))
                            break;
                        else cnt++;
                    }
                    if(cnt == s.length()/2){
                        System.out.println(s);
                        flag = true;
                        break;
                    }

                }
            }
        }
        if(!flag) System.out.println(0);



    }



      

}
    }

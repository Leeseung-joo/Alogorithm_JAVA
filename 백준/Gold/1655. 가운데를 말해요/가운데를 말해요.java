import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
          int num = Integer.parseInt(br.readLine());

          if(maxHeap.size() == minHeap.size()){
            maxHeap.offer(num);
          }else{
            minHeap.offer(num);
          }

          //순서 정리
          if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            int a = maxHeap.poll();
            int b = minHeap.poll();
            maxHeap.offer(b);
            minHeap.offer(a);
          }

          sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
  }
}

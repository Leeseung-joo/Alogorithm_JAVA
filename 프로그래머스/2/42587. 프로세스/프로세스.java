import java.util.*;
class Solution {
    
    static class Point{
        int priority; //우선순위
        int location; //위치
        
        Point(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    public int solution(int[] priorities, int location) {
        int result = 1;
        
        
        //우선순위가 같은 숫자들이 있기 때문에 현재 우선순위와 location을 넣는다
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayDeque<Point> q = new ArrayDeque<>();
        int[] pri = new int[10];
        for(int i = 0; i <priorities.length; i++){
            map.put(i,priorities[i]); //현재 위치, 우선순위값
            q.offer(new Point(priorities[i], i));
            pri[priorities[i]] += 1;
        }
        
        while(true){
            Point point = q.poll();
            boolean flag = false;
            for(int i = point.priority+1; i < 10; i++){
                if(pri[i] >0){
                    flag = true;
                    q.add(point);
                    break;
                }
            }
            if(!flag){
                pri[point.priority] -= 1;
                if(point.location == location) return result;
                else result++;
            }
        }
    }
}
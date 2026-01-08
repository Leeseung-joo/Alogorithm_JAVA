import java.io.*;
import java.util.*;

class Solution {
    static Queue<int[]>[] record;
    static int answer = 0;
    static int size;
    
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        record = new LinkedList[size];
        for(int i = 0;i<size;i++){
            record[i] = new LinkedList<>();
        }
        recordRoute(points, routes);
        findCollision();

        return answer;
    }
    
    public static void findCollision() {
        int escapeRobots = 0;   // 탈출 로봇 개수 카운트하기 위한 변수 초기화
        while(escapeRobots != size){    //  모든 로봇이 탈출할 때까지
            int[][] map = new int[101][101];
            escapeRobots = 0;   //  매초마다 탈출한 로봇 수가 총 로봇 수와 같은지 비교를 해야하므로 0으로 초기화
            for(int i = 0; i < size; i++){  //  로봇 수 만큼
                if(record[i].isEmpty()){    //  이동 경로가 비어있다면 로봇이 탈출한 것임
                    escapeRobots++; 
                    continue;
                }
                int[] temp = record[i].poll();  //  탈출하지 못한 로봇들은 이동
                map[temp[0]][temp[1]] ++;   //  로봇이 이동한 위치를 표시
            }
            for(int i = 0;i<101;i++){
                for(int j = 0;j<101;j++){
                    if(map[i][j]>1){    //  특정 위치에 1보다 큰 수가 저장되어 있다는 것은 한 대 이상의 로봇이 위치해있다는 것
                        answer ++;
                    }
                }
            }
        }
        
    }
    
    public static void recordRoute(int[][] points, int[][] routes) {
        for(int i = 0; i < size; i++) {
            int from = routes[i][0] - 1;   //  출발 좌표 인덱스
            int fromR = points[from][0] -1;
            int fromC = points[from][1] -1;
            
            record[i].add(new int[]{fromR, fromC});    // 출발 좌표 기록
            
            for(int j = 1; j < routes[i].length; j++){
                int to = routes[i][j] - 1; //  도착 좌표 인덱스
                int toR = points[to][0]-1;
                int toC = points[to][1]-1;
            
                while(fromR != toR) {   //  도착지의 r좌표와 같아질 때까지 
                    if(fromR < toR) {   //  현재 r좌표와 도착지의 r좌표를 비교하면서 이동
                        fromR++;
                    } else {
                        fromR--;
                    }
                    record[i].add(new int[]{fromR, fromC});    //  r좌표 이동할 때마다 기록, c좌표에 대해서는 이동하지 않으므로 출발지의 c좌표
                }
            
                while(fromC != toC) {   //  도착지의 c좌표와 같아질 때까지 
                    if(fromC < toC) {   //  현재 c좌표와 도착지의 c좌표를 비교하면서 이동
                        fromC++;
                    } else {
                        fromC--;
                    }
                    record[i].add(new int[]{fromR, fromC});    //  c좌표 이동할 때마다 기록, r좌표는 이미 도착지점의 r좌표가 되어있을 것
                }
            }
        }    
    }
}
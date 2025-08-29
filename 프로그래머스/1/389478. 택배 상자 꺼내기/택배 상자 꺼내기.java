import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        
        // 높이 저장
        int height = (n / w) + 1;
        // height와 weight로 이차원 배열 선언
        int[][] arr = new int[height][w];
        // 1~N까지 값을 저장할 count
        int count = 1;
        // num의 위치를 저장할 column과 row
        int column = 0;
        int row = 0;
        
        for(int i = 0; i < height; i++) {
            // i가 0이거나 짝수면 정방향으로 배열 생성
            if(i % 2 == 0) {
                for(int j = 0; j < w; j++) {
                    if(count > n) break;
                    
                    if(count == num) {
                        column = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
                
            } else { // i가 홀수면 역방향으로 배열 생성
                for(int j = w-1; j >= 0; j--) {
                    if(count > n) break;
                    
                    if(count == num) {
                        column = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
            }
        }
        
        int answer = 0;
        
        // 저장된 위치부터 위에 상자가 있으면 상자를 빼야하므로 answer++
        for(int i = column; i < height; i++) {
            if(arr[i][row] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
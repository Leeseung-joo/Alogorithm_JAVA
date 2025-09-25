import java.util.*;

class Solution {
    boolean[] visited;
    List<String> path = new ArrayList<>();
    String[] answer;
    boolean finished = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]); // 출발 같으면 도착 기준
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        path.add("ICN"); // 항상 인천에서 시작
        
        dfs("ICN", tickets, 0);
        
        return answer;
    }
    
    void dfs(String cur, String[][] tickets, int count) {
        if (count == tickets.length) {
            answer = path.toArray(new String[0]);
            finished = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                if (finished) return; // 첫 해답이면 바로 종료 (사전순 보장)
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}

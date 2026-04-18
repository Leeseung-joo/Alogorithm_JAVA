import java.util.*;

class Solution {
    static boolean[] visited;
    static String[][] ticket;
    static ArrayList<String> result;

    public String[] solution(String[][] tickets) {
        ticket = tickets;

        Arrays.sort(ticket, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        visited = new boolean[ticket.length];
        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", 0, path);

        return result.toArray(new String[0]);
    }

    static void dfs(String current, int length, ArrayList<String> path) {
        if (result != null) return; // 이미 정답 찾았으면 종료

        if (length == ticket.length) {
            result = new ArrayList<>(path);
            return;
        }

        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && ticket[i][0].equals(current)) {
                visited[i] = true;
                path.add(ticket[i][1]);

                dfs(ticket[i][1], length + 1, path);

                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
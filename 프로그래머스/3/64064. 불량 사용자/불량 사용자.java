import java.util.*;

class Solution {
    String[] user_id;
    String[] banned_id;
    boolean[] visited;
    Set<Integer> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        this.visited = new boolean[user_id.length];

        dfs(0);
        return result.size();
    }

    private void dfs(int idx) {
        if (idx == banned_id.length) {
            int mask = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) mask |= (1 << i);
            }
            result.add(mask);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (!match(user_id[i], banned_id[idx])) continue;

            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    private boolean match(String user, String ban) {
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            char b = ban.charAt(i);
            if (b == '*') continue;
            if (user.charAt(i) != b) return false;
        }
        return true;
    }
}

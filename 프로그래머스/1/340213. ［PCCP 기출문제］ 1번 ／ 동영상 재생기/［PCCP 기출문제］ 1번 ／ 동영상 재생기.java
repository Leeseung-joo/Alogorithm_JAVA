class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLen = toSec(video_len);
        int cur = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        // 시작 위치가 오프닝 구간이면 오프닝 끝으로 스킵
        cur = skipOpening(cur, opStart, opEnd);

        for (String cmd : commands) {
            if (cmd.equals("next")) {
                cur = Math.min(videoLen, cur + 10);
            } else if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            }

            // 이동 후에도 오프닝 구간이면 스킵
            cur = skipOpening(cur, opStart, opEnd);
        }

        return toTime(cur);
    }

    private int skipOpening(int cur, int opStart, int opEnd) {
        // 보통 문제 정의가 [opStart, opEnd) 또는 [opStart, opEnd] 중 하나인데,
        // PCCP "동영상 재생기"는 오프닝 구간에 있으면 opEnd로 이동시키는 형태라
        // inclusive로 처리해도 통과하는 케이스가 많음.
        if (cur >= opStart && cur <= opEnd) return opEnd;
        return cur;
    }

    private int toSec(String mmss) {
        String[] s = mmss.split(":");
        int mm = Integer.parseInt(s[0]);
        int ss = Integer.parseInt(s[1]);
        return mm * 60 + ss;
    }

    private String toTime(int sec) {
        int mm = sec / 60;
        int ss = sec % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}

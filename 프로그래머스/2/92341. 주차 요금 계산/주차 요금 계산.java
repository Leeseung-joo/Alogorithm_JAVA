import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();      // 차량번호 -> 입차 시간
        Map<String, Integer> totalMap = new HashMap<>();   // 차량번호 -> 누적 주차 시간

        for (String r : records) {
            String[] record = r.split(" ");
            String timeStr = record[0];
            String car = record[1];
            String type = record[2];

            String[] times = timeStr.split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            // 문자열 비교는 == 말고 equals()
            if (type.equals("IN")) {
                inMap.put(car, time);
            } else {
                int inTime = inMap.get(car);
                int diff = time - inTime;

                totalMap.put(car, totalMap.getOrDefault(car, 0) + diff);
                inMap.remove(car);
            }
        }

        // 출차 기록 없는 차량 처리
        int endTime = 23 * 60 + 59;
        for (String car : inMap.keySet()) {
            int diff = endTime - inMap.get(car);
            totalMap.put(car, totalMap.getOrDefault(car, 0) + diff);
        }

        // 차량번호 정렬
        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int totalTime = totalMap.get(cars.get(i));
            answer[i] = calcFee(totalTime, fees);
        }

        return answer;
    }

    private int calcFee(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        }

        int extraTime = totalTime - baseTime;
        int extraFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;
        return baseFee + extraFee;
    }
}
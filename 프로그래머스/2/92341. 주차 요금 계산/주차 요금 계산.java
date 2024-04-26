import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        List<Record> list = new ArrayList<>();

        for (String r : records) {
            Record record = createRecord(r);

            if (list.isEmpty()) {
                list.add(record);
            } else { // 비어있지 않는 경우에는 입차된 차량 조회
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getNumber().equals(record.getNumber())) {
                        Record remove = list.remove(i);
                        int useTime = record.getTime() - remove.getTime();
                        map.put(record.getNumber(), map.getOrDefault(record.getNumber(), 0) + useTime);
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    list.add(record);
                }
            }
        }

        // 남아있는 차들은 11:59 기준으로 출차
        if (!list.isEmpty()) {
            for (Record record : list) {
                map.put(record.getNumber(), map.getOrDefault(record.getNumber(), 0) + 1439 - record.getTime());
            }
        }
        
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        
        List<Integer> answer = new ArrayList<>();
        for (Object key : keys) {
            Integer time = map.get(key); // 총 이용시간

            // 기본 시간을 초과한 경우 초과한 시간만큼 추가 요금 부과
            if (time > fees[0]) {
                int extraTime = (int) Math.ceil((double) (time - fees[0]) / fees[2]); // 초과시간
                answer.add(fees[1] + extraTime * fees[3]);
            } else {
                answer.add(fees[1]);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
    
    private static Record createRecord(String record) {
        String[] split = record.split(" ");
        String[] arr = split[0].split(":");

        int time = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        String number = split[1];
        String status = split[2];

        return new Record(time, number, status);
    }

    static class Record {
        private final int time;
        private final String number;
        private final String status;

        public Record(int time, String number, String status) {
            this.time = time;
            this.number = number;
            this.status = status;
        }

        public int getTime() {
            return time;
        }

        public String getNumber() {
            return number;
        }

        public String getStatus() {
            return status;
        }
    }
}
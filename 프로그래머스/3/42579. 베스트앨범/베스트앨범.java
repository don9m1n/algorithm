import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 재생 횟수
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> playInGerneMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

            List<int[]> list = playInGerneMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(new int[]{i, plays[i]});

            playInGerneMap.put(genres[i], list);
        }

        // 총 재생 횟수가 가장 많은 장르부터 시작
        List<Map.Entry<String, Integer>> entryList = genreMap.entrySet().stream()
                .sorted((x, y) -> y.getValue() - x.getValue())
                .collect(Collectors.toList());


        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entryList) {
            String genre = entry.getKey(); // 작업 할 장르

            // 재생 횟수가 많은 순서대로 정렬된 리스트
            List<int[]> sortedList = playInGerneMap.get(genre).stream()
                    .sorted((x, y) -> {

                        if (x[1] == y[1]) {
                            return x[0] - y[0];
                        }

                        return y[1] - x[1];
                    })
                    .collect(Collectors.toList());

            for (int i = 0; i < sortedList.size(); i++) {
                if(i == 2) break;
                answer.add(sortedList.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
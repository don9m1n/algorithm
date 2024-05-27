import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> list1 = getSliceWord(str1);
        List<String> list2 = getSliceWord(str2);

        return calculate(list1, list2);
    }

    private static int calculate(List<String> list1, List<String> list2) {

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (String value : list1) {
            if (list2.contains(value)) {
                intersection.add(value);
                list2.remove(value);
            }

            union.add(value);
        }

        union.addAll(list2);

        return union.isEmpty() ? 65536 : (int) (intersection.size() / (double) union.size() * 65536);
    }

    private static List<String> getSliceWord(String str) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);

            if (substring.matches("^[a-zA-Z]*$")) {
                list.add(substring.toUpperCase());
            }
        }

        return list;
    }
}
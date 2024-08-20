import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String exp = br.readLine();
        String[] arr = exp.split("-");

        /**
         * 접근 방법.
         * 1. '-'를 기준으로 문자열을 분리한다.
         * 2. 첫 번째 요소만 더해주고 이후의 요소들은 빼준다.
         */

        int answer = 0;
        String[] split = arr[0].split("\\+");
        for (int i = 0; i < split.length; i++) {
            answer += Integer.parseInt(split[i]);
        }

        for (int i = 1; i < arr.length; i++) {

            String[] split1 = arr[i].split("\\+");

            int sum = 0;
            for (String s : split1) {
                sum += Integer.parseInt(s);
            }

            answer -= sum;
        }

        System.out.println(answer);
    }
}

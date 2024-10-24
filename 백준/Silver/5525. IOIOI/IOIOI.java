import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int i = 1;
        int count = 0;
        int answer = 0;
        while (i < m - 1) {
            if(str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                count++;
                if (count == n) {
                    if (str.charAt(i - (count * 2 - 1)) == 'I') {
                        answer++;
                    }

                    count--;
                }

                i += 2;
            } else {
                count = 0;
                i++;
            }
        }
        System.out.println(answer);
    }
}

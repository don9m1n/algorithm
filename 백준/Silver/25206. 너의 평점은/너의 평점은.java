import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너의 평점은
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double total = 0;
        double totalScore = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            
            if (!grade.equals("P")) {
                totalScore += score;
            }

            switch (grade) {
                case "A+":
                    total += score * 4.5;
                    break;
                case "A0":
                    total += score * 4.0;
                    break;
                case "B+":
                    total += score * 3.5;
                    break;
                case "B0":
                    total += score * 3.0;
                    break;
                case "C+":
                    total += score * 2.5;
                    break;
                case "C0":
                    total += score * 2.0;
                    break;
                case "D+":
                    total += score * 1.5;
                    break;
                case "D0":
                    total += score;
                    break;
                case "F":
                    total += score * 0.0;
                    break;
            }
        }

        System.out.println(total / totalScore);
    }
}

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder answer = new StringBuilder();

        LocalDate now = LocalDate.now();

        answer.append(now.getYear()).append("\n");
        answer.append(now.getMonthValue()).append("\n");
        answer.append(now.getDayOfMonth()).append("\n");

        System.out.println(answer);
    }
}

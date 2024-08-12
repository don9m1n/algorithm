import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer= new StringBuilder();

        int i = 1;
        String input = "";
        while (!(input = br.readLine()).equals("0")) {

            int r = Integer.parseInt(input.split(" ")[0]);
            int w = Integer.parseInt(input.split(" ")[1]);
            int l = Integer.parseInt(input.split(" ")[2]);

            double diagonal = Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2));

            if (r * 2 >= diagonal) {
                answer.append("Pizza ").append(i).append(" fits on the table.").append("\n");
            } else {
                answer.append("Pizza ").append(i).append(" does not fit on the table.").append("\n");
            }

            i++;
        }

        System.out.println(answer);
    }
}

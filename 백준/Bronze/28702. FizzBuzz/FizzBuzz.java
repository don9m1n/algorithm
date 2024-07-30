import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        int index = 0; // 마지막으로 숫자가 나온 위치
        for (int i = 0; i < 3; i++) {
            String word = br.readLine();

            if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
                num = Integer.parseInt(word);
                index = i;
            }
        }

        int checkNumber = num + (3 - index);

        if (checkNumber % 3 == 0 && checkNumber % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (checkNumber % 3 == 0) {
            System.out.println("Fizz");
        } else if (checkNumber % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(checkNumber);
        }
    }
    
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 크로아티아 알파벳
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : arr) {
            if (str.contains(s)) {
                str = str.replaceAll(s, "O");
            }
        }

        System.out.println(str.length());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 5; i++) {

            int count = 0;
            
            for(int j = 0; j < 5; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }

            if(count % 2 == 1) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}

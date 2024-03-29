import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 이어쓰기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int temp = 0;
        int length = 10;

        for(int i = 1; i <= n; i++){
            if(i == length){
                cnt++;
                length = length * 10;
            }

            temp += cnt;
        }
        System.out.println(temp);
    }
}

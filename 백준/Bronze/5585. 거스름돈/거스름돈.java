import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        //거스름돈
        int n = 1000 - price;
        int[] coins = {500,100,50,10,5,1};
        int count = 0;

        for(int i = 0; i < coins.length; i++) {
            count += n / coins[i];
            //남은 잔돈만 다음으로
            n %= coins[i];
        }
        System.out.println(count);

    }
}

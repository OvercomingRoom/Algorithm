package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10]; // N번째 자리수, 0 ~ 9

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1; // 첫번째 자리 수 ( == 가장 오른쪽에 있는 수, 0 ~ 9 가능)
        }

        long result = 0;

        for (int i = 2; i < N + 1; i++) {

            dp[i][0] = dp[i - 1][1]; // 0 인 경우 - 0 + 1 (o), 0 - 1 (x)

            for (int j = 1; j <= 9; j++) {

                if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % 1_000_000_000; // 9 인 경우 - 9 - 1 (o) , 9 + 1 (x)
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % 1_000_000_000 + dp[i - 1][j + 1] % 1_000_000_000) % 1_000_000_000;
                }

            }
        }

        for (int i = 1; i <= 9; i++) { // 가장 왼쪽에 위치한 수, 0으로 시작하는 수는 제외 (010, 0123 등)
            result = (result + dp[N][i]) % 1_000_000_000;
        }

        System.out.println(result);
    }
}

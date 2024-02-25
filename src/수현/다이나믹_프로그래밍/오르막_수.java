package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 2][10];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N + 1; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][0] += dp[i - 1][j];
            }

            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + 10007 - dp[i - 1][j - 1]) % 10007;
            }
        }

        System.out.println(dp[N + 1][0] % 10007);
    }
}

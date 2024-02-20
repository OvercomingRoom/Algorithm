package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I23_더하기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        long[] dp = new long[1000001];

        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i <= 1000000; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[n[i]]);
        }
    }
}

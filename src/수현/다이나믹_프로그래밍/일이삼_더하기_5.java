package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼_더하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] n = new int[T];
        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 4; j < dp.length; j++) {
            dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % 1000000009;
            dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % 1000000009;
            dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % 1000000009;
        }

        for (int i = 0; i < T; i++) {
            long sum = (dp[n[i]][1] + dp[n[i]][2] + dp[n[i]][3]) % 1000000009;
            System.out.println(sum);
        }


    }

}

package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드_구매하기 {
    static int[] cost, dp;
    static int max, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        cost = new int[N + 1];
        dp = new int[N + 1];

        String[] line = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(line[i - 1]);
        }

        // cost[1] + cost[1] + cost[1] + cost[1]
        // cost[1] + cost[1] + cost[2]
        // cost[1] + cost[3]
        // cost[2] + cost[2]
        // cost[4]

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cost[j]);
//                System.out.println("i : "+ i + ", j : " + j);
            }
        }
        System.out.println(dp[N]);

    }

}

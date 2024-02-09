package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드_구매하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N + 1];
        int[] dp = new int[N + 1];
        String[] line = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(line[i - 1]);
            dp[i] = Integer.parseInt(line[i - 1]);
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cost[j]);
                // dp[i] 는 카드를 i 개 구매하는데 필요한 최소 비용이 저장
                // dp[i - j] 는 i - j 개 구매하는데 필요한 최소비용 +cost[j] 를 해서 dp[i] 구매에 필요한 금액을 새롭게 구함.
            }
        }

        System.out.println(dp[N]);
    }
}

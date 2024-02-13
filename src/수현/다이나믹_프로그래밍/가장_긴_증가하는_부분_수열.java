package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int result = 0;
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }


        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            // A[0] ~ A[i - 1] 까지 탐색
            for (int j = 0; j < i; j++) {
                // A[j] 가 A[i] 보다 작고,
                // dp[i] 가 dp[j] + 1 보다 작은 경우
                if(A[i] > A[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1; // 수열 길이를 늘려줌
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}

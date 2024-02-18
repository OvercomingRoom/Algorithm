package 인규.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 합분해 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] dp = new int[K + 1][N + 1];
    Arrays.fill(dp[1], 1);

    for (int k = 2; k <= K; k++) {
      for (int n = 0; n <= N; n++) {
        for (int i = 0; i <= n; i++) {
          dp[k][n] += dp[k - 1][i];
          dp[k][n] %= 1000000000;
        }
      }
    }

    System.out.println(dp[K][N]);
  }

}

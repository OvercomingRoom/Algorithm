package 인규.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 오르막수 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[N + 1][10];
    Arrays.fill(dp[1], 1);

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= 10007;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += dp[N][i];
      answer %= 10007;
    }
    System.out.println(answer);
  }

}

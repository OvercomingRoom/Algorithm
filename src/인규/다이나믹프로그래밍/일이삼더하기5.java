package 인규.다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    long[][] dp = new long[100001][4];
    dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

    for (int i = 4; i < dp.length; i++) {
      dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
      dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
      dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
    }

    while (T-- > 0) {
      int n = sc.nextInt();
      System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
    }
  }

}

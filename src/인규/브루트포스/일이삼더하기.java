package 인규.브루트포스;

import java.util.Scanner;

public class 일이삼더하기 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] dp = new int[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    while (T-- > 0) {
      int n = sc.nextInt();
      for (int i = 4; i <= n; i++) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
      }
      System.out.println(dp[n]);
    }

  }

}

package 인규.다이나믹프로그래밍;

import java.util.Scanner;

public class 카드구매하기2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] dp = new int[N + 1];
    int[] P = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      P[i] = sc.nextInt();
    }

    for (int i = 1; i <= N; i++) {
      dp[i] = P[i];
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
      }
    }

    System.out.println(dp[N]);
  }

}

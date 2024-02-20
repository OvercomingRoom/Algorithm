package 인규.다이나믹프로그래밍;

import java.util.Scanner;

public class RGB거리 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[N][3];

    for (int i = 0; i < 3; i++) {
      dp[0][i] = sc.nextInt();
    }

    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + sc.nextInt();
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + sc.nextInt();
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + sc.nextInt();
    }

    System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
  }

}

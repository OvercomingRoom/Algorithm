package 인규.다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    long[] dp = new long[1000001];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i < dp.length; i++) {
      dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
    }

    while (T-- > 0) {
      System.out.println(dp[sc.nextInt()]);
    }
  }

}

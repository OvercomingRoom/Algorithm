package 인규.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] dp = new int[N];
    Arrays.fill(dp, 1);
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      if (max < dp[i]) {
        max = dp[i];
      }
    }

    System.out.println(max);

  }

}

package 인규.다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열4 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] dp = new int[N];
    int[] prevIdx = new int[N];
    Arrays.fill(prevIdx, -1);

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    int maxLen = 1;
    int maxIdx = 0;

    for (int i = 0; i < N; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prevIdx[i] = j;
        }
      }
      if (maxLen < dp[i]) {
        maxLen = dp[i];
        maxIdx = i;
      }
    }

    List<Integer> list = new ArrayList<>();
    int idx = maxIdx;
    while (idx != -1) {
      list.add(A[idx]);
      idx = prevIdx[idx];
    }

    System.out.println(maxLen);
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.print(list.get(i) + " ");
    }
  }

}

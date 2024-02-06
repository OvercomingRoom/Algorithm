package 인규.브루트포스.N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과M8 {

  static int N, M;
  static int[] arr, nums;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[M];
    nums = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    dfs(0, 0);
    System.out.println(sb);

  }

  static void dfs(int current, int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(' ');
      }
      sb.append('\n');
      return;
    }
    for (int i = current; i < N; i++) {
      arr[depth] = nums[i];
      dfs(i, depth + 1);
    }
  }
}

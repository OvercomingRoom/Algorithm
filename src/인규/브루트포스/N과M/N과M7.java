package 인규.브루트포스.N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과M7 {

  public static int N, M;
  public static int[] arr, nums;

  public static StringBuilder sb = new StringBuilder();

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
    dfs(0);
    System.out.println(sb);

  }

  public static void dfs(int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(' ');
      }
      sb.append('\n');
      return;
    }
    for (int i = 0; i < N; i++) {
      arr[depth] = nums[i];
      dfs(depth + 1);
    }
  }
}

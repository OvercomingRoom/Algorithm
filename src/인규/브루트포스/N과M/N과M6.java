package 인규.브루트포스.N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과M6 {

  public static int[] arr, nums;
  public static boolean[] visit;
  public static int N, M;

  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[M];
    nums = new int[N];
    visit = new boolean[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    dfs(0, 0);
    System.out.println(sb);
  }

  public static void dfs(int current, int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    for (int i = current; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        arr[depth] = nums[i];
        dfs(i, depth + 1);
        visit[i] = false;
      }
    }
  }
}

package 인규.브루트포스;

import java.util.Scanner;

public class N과M4 {

  public static StringBuilder sb = new StringBuilder();
  public static int[] arr;
  public static int N, M;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[M];
    dfs(1, 0);
    System.out.println(sb);

  }

  public static void dfs(int current, int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }
    for (int i = current; i <= N; i++) {
      arr[depth] = i;
      dfs(i, depth + 1);
    }
  }

}

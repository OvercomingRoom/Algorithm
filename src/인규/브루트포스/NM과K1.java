package 인규.브루트포스;

import java.util.Scanner;

public class NM과K1 {

  static int[][] arr;
  static boolean[][] visit;
  static int N, M, K, max;

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    arr = new int[N][M];
    visit = new boolean[N][M];
    max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    dfs(0, 0, 0, 0);
    System.out.println(max);
  }

  static void dfs(int row, int col, int depth, int sum) {
    if (depth == K) {
      max = Math.max(max, sum);
      return;
    }
    for (int i = row; i < N; i++) {
      for (int j = col; j < M; j++) {
        if (check(i, j) && !visit[i][j]) {
          visit[i][j] = true;
          dfs(row, col, depth + 1, sum + arr[i][j]);
          visit[i][j] = false;
        }
      }
    }
  }

  public static boolean check(int row, int col) {
    boolean flag = true;
    for (int i = 0; i < 4; i++) {
      int x = row + dx[i];
      int y = col + dy[i];

      if (x >= 0 && x < N && y >= 0 && y < M) {
        if (visit[x][y]) {
          flag = false;
        }
      }
    }
    return flag;
  }

}

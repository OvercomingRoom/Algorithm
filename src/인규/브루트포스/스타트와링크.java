package 인규.브루트포스;

import java.util.Scanner;

public class 스타트와링크 {

  static int N;
  static int[][] arr;
  static boolean[] visit;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    arr = new int[N][N];
    visit = new boolean[N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    dfs(0, 0);
    System.out.println(min);
  }

  static void dfs(int idx, int depth) {
    if (depth == N / 2) {
      compare();
      return;
    }
    for (int i = idx; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        dfs(i + 1, depth + 1);
        visit[i] = false;
      }
    }
  }

  static void compare() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (visit[i] && visit[j]) {
          start += arr[i][j];
          start += arr[j][i];
        } else if (!visit[i] && !visit[j]) {
          link += arr[i][j];
          link += arr[j][i];
        }
      }
    }
    min = Math.min(Math.abs(start - link), min);
  }

}

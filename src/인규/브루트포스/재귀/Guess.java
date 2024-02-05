package 인규.브루트포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guess {

  static int N;
  static char[][] arr;
  static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    String str = br.readLine();
    int idx = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        arr[i][j] = str.charAt(idx++);
      }
    }
    answer = new int[N];
    dfs(0);
  }

  static void dfs(int depth) {
    if (depth == N) {
      for (int i = 0; i < N; i++) {
        System.out.printf("%d ", answer[i]);
      }
      System.exit(0);
      return;
    }

    for (int i = -10; i <= 10; i++) {
      answer[depth] = i;
      if (check(depth)) {
        dfs(depth + 1);
      }
    }
  }

  static boolean check(int idx) {
    for (int i = 0; i <= idx; i++) {
      int sum = 0;
      for (int j = i; j <= idx; j++) {
        sum += answer[j];
        if (arr[i][j] != (sum == 0 ? '0' : sum > 0 ? '+' : '-')) {
          return false;
        }
      }
    }
    return true;
  }

}

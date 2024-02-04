package 인규.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 외판원순회2 {

  static int N;
  static int[][] W;
  static boolean[] visit;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    visit = new boolean[N];

    for (int i = 0; i < N; i++) {
      W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    IntStream.range(0, N).forEach(start -> dfs(start, start, 1, 0));

    System.out.println(min);
  }

  static void dfs(int start, int current, int depth, int cost) {
    if (depth == N) {
      if (W[current][start] != 0) {
        min = Math.min(min, cost + W[current][start]);
      }
      return;
    }
    visit[current] = true;

    IntStream.range(0, N).filter(i -> !visit[i] && W[current][i] != 0)
        .forEach(i -> dfs(start, i, depth + 1, cost + W[current][i]));

    visit[current] = false;
  }

}

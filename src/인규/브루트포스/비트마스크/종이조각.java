package 인규.브루트포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 종이조각 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] paper = new int[N][M];
    for (int i = 0; i < N; i++) {
      paper[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

    int answer = 0;

    for (int bitmask = 0; bitmask < (1 << (N * M)); bitmask++) {
      int sum = 0;

      for (int i = 0; i < N; i++) {
        int cur = 0;
        for (int j = 0; j < M; j++) {
          int idx = i * M + j;
          if ((bitmask & (1 << idx)) == 0) {
            cur = cur * 10 + paper[i][j];
          } else {
            sum += cur;
            cur = 0;
          }
        }
        sum += cur;
      }

      for (int j = 0; j < M; j++) {
        int cur = 0;
        for (int i = 0; i < N; i++) {
          int idx = i * M + j;
          if ((bitmask & (1 << idx)) != 0) {
            cur = cur * 10 + paper[i][j];
          } else {
            sum += cur;
            cur = 0;
          }
        }
        sum += cur;
      }

      answer = Math.max(answer, sum);
    }

    System.out.println(answer);
  }
}

package 인규.브루트포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int cnt = 0;
    for (int bitmask = 1; bitmask < (1 << N); bitmask++) {
      int sum = 0;
      for (int i = 0; i < N; i++) {
        if ((bitmask & (1 << i)) != 0) {
          sum += arr[i];
        }
      }
      if (sum == S) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }

}

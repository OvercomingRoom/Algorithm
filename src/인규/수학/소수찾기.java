package 인규.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수찾기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();

    boolean[] isPrime = new boolean[1001];
    Arrays.fill(isPrime, true);
    isPrime[1] = false;
    for (int i = 2; i * i <= 1001; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < 1001; j += i) {
          isPrime[j] = false;
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;

    while (st.hasMoreTokens()) {
      if (isPrime[Integer.parseInt(st.nextToken())]) {
        answer++;
      }
    }
    System.out.println(answer);
  }

}

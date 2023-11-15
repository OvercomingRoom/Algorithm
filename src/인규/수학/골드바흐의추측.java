package 인규.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 골드바흐의추측 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] isPrime = new boolean[1000001];
    Arrays.fill(isPrime, true);
    for (int i = 2; i < Math.sqrt(isPrime.length); i++) {
      for (int j = i * i; j < isPrime.length; j += i) {
        isPrime[j] = false;
      }
    }

    int n;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      boolean flag = false;
      for (int i = 2; i <= n / 2; i++) {
        if (isPrime[i] && isPrime[n - i]) {
          System.out.println(n + " = " + i + " + " + (n - i));
          flag = true;
          break;
        }
      }
      if (!flag) {
        System.out.println("Goldbach's conjecture is wrong.");
      }
    }
    br.close();

  }
}

package 인규.수학;

import java.io.*;

public class 최대공약수와최소공배수 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] array = br.readLine().split(" ");
    br.close();

    int a = Integer.parseInt(array[0]);
    int b = Integer.parseInt(array[1]);

    sb.append(gcd(a, b)).append("\n").append(lcm(a, b));
    System.out.println(sb);
  }

  /**
   * 유클리드 호제법
   * gcd: 최대공약수
   * lcm: 최소공배수
   */
  public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }
}

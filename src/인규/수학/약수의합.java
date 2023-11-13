package 인규.수학;

import java.io.*;

public class 약수의합 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    long[] fA = new long[1000001];
    long[] gN = new long[1000001];

    for (int i = 1; i < 1000001; i++) {
      for (int j = 1; i * j < 1000001; j++) {
        fA[i * j] += i;
      }
    }

    for (int i = 1; i < 1000001; i++) {
      gN[i] += gN[i - 1] + fA[i];
    }
    while (T-- > 0) {
      sb.append(gN[Integer.parseInt(br.readLine())] + "\n");
    }
    System.out.print(sb);
    br.close();
  }
}


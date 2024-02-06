package 인규.브루트포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class 집합 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());
    BitSet bitSet = new BitSet();

    while (M-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String operation = st.nextToken();

      switch (operation) {
        case "add":
          bitSet.set(Integer.parseInt(st.nextToken()));
          break;

        case "remove":
          bitSet.clear(Integer.parseInt(st.nextToken()));
          break;

        case "check":
          sb.append(bitSet.get(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
          break;

        case "toggle":
          int index = Integer.parseInt(st.nextToken());
          bitSet.flip(index, index + 1);
          break;

        case "all":
          bitSet.set(1, 21);
          break;

        case "empty":
          bitSet.clear();
          break;
      }
    }

    System.out.println(sb);
  }
}

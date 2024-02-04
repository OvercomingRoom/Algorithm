package 인규.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {

  static int[] arr;
  static int k;
  static int[] lotto = new int[6];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());

      if (k == 0) {
        break;
      }

      arr = new int[k];
      for (int i = 0; i < k; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      dfs(0, 0);
      System.out.println();
    }

    br.close();
  }

  static void dfs(int index, int start) {
    if (index == 6) {
      for (int num : lotto) {
        System.out.print(num + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i < k; i++) {
      lotto[index] = arr[i];
      dfs(index + 1, i + 1);
    }
  }
}
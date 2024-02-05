package 인규.브루트포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 부등호 {

  static boolean[] visit = new boolean[10];
  static String[] inequalities;
  static int k;
  static List<String> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    inequalities = br.readLine().split(" ");
    dfs(0, "");
    Collections.sort(list);
    System.out.println(list.get(list.size() - 1));
    System.out.println(list.get(0));
    br.close();
  }

  static void dfs(int depth, String num) {
    if (depth == k + 1) {
      list.add(num);
      return;
    }
    for (int i = 0; i < 10; i++) {
      if (depth == 0 || !visit[i] && compare(
          Character.getNumericValue(num.charAt(num.length() - 1)), i, inequalities[depth - 1])) {
        visit[i] = true;
        dfs(depth + 1, num + i);
        visit[i] = false;
      }
    }
  }

  static boolean compare(int a, int b, String c) {
    return c.equals("<") ? a < b : a > b;
  }

}

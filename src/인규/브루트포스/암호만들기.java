package 인규.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {

  static int L, C;
  static char[] arr;
  static boolean[] visit;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    L = sc.nextInt();
    C = sc.nextInt();
    sc.nextLine();
    visit = new boolean[C];
    arr = sc.nextLine().replaceAll(" ", "").toCharArray();
    Arrays.sort(arr);

    dfs(0, 0);
    System.out.println(sb);

  }

  static void dfs(int current, int depth) {
    if (depth == L) {
      String pw = "";
      int vowel = 0;
      int consonant = 0;
      for (int i = 0; i < C; i++) {
        if (visit[i]) {
          pw += arr[i];

          if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
            vowel++;
          } else {
            consonant++;
          }
        }
      }
      if (vowel >= 1 && consonant >= 2) {
        sb.append(pw).append("\n");
      }
    }
    for (int i = current; i < C; i++) {
      visit[i] = true;
      dfs(i + 1, depth + 1);
      visit[i] = false;
    }
  }
}

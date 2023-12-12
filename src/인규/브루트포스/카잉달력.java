package 인규.브루트포스;

import java.util.Scanner;

public class 카잉달력 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int M = sc.nextInt();
      int N = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int answer = -1;

      for (int i = x - 1; i < M * N && answer == -1; i += M) {
        answer = i % N == y - 1 ? i + 1 : -1;
      }
      System.out.println(answer);
    }
  }
}

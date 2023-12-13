package 인규.브루트포스;

import java.util.Scanner;

public class 수이어쓰기1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int answer = 0;
    for (int i = 1; i <= N; i *= 10) {
      answer += N - i + 1;
    }
    System.out.println(answer);
  }
}

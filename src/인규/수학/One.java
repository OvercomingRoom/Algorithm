package 인규.수학;

import java.util.Scanner;

public class One {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int digits = 1;
      int answer = 1;
      while (digits % n != 0) {
        digits = (digits % n) * 10 + 1;
        answer++;
      }
      System.out.println(answer);
    }
  }

}

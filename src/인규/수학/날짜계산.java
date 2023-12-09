package 인규.수학;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 날짜계산 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

    int E = 0, S = 0, M = 0;
    int answer = 1;

    while (st.hasMoreTokens()) {
      E = Integer.parseInt(st.nextToken());
      S = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
    }

    while ((answer - E) % 15 != 0 || (answer - S) % 28 != 0 || (answer - M) % 19 != 0) {
      answer++;
    }

    System.out.println(answer);

  }
}

package 인규.브루트포스;

import java.util.Scanner;

public class 리모컨 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    boolean[] errBtn = new boolean[10];

    // 초기값 (현재 채널: 100)
    int answer = Math.abs(N - 100);

    // 고장버튼 저장
    for (int i = 0; i < M; i++) {
      errBtn[sc.nextInt()] = true;
    }

    // N의 최대값이 6자리 이므로 누를 수 있는 버튼의 범위는 999999 까지
    for (int i = 0; i <= 999999; i++) {
      String ch = String.valueOf(i);
      boolean isBreak = false;
      // 채널의 자리수 별로 고장 여부 탐색
      for (int j = 0; j < ch.length(); j++) {
        if (errBtn[Character.getNumericValue(ch.charAt(j))]) {
          isBreak = true;
          break;
        }
      }
      // 각 자리에 고장버튼이 있는 숫자가 없었다면 버튼의 클릭횟수를 최솟값으로 저장
      answer = isBreak ? answer : Math.min(Math.abs(N - i) + ch.length(), answer);
    }

    System.out.println(answer);
  }
}

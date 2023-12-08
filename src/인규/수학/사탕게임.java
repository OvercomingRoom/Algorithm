package 인규.수학;

import java.util.Scanner;

public class 사탕게임 {

  static String board[][];

  // 사탕의 최대 개수
  static int max;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    max = 0;
    board = new String[N][N];
    for (int i = 0; i < N; i++) {
      board[i] = sc.next().split("");
    }

    // 행교환
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        swap(i, j, i, j + 1);
        max = Math.max(max, candiesCnt());
      }
    }

    // 열교환
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N; j++) {
        swap(i, j, i + 1, j);
        max = Math.max(max, candiesCnt());
      }
    }
    System.out.println(max);

  }

  // 사탕 교환
  public static void swap(int x1, int y1, int x2, int y2) {
    String tmp = board[x1][y1];
    board[x1][y1] = board[x2][y2];
    board[x2][y2] = tmp;

    // 교환 후 연속되는 사탕 수
    int afterSwapCnt = candiesCnt();

    // 교환 후 연속되는 사탕 개수가 최대면 최대값 갱신
    if (max < afterSwapCnt) {
      max = afterSwapCnt;
    }

    // 원래상태로 교환
    tmp = board[x1][y1];
    board[x1][y1] = board[x2][y2];
    board[x2][y2] = tmp;
  }

  // 최대 사탕 개수 구하기
  public static int candiesCnt() {
    int max = 1;

    // 행의 연속된 사탕 개수
    for (int i = 0; i < board.length; i++) {
      int cnt = 1;
      for (int j = 1; j < board.length; j++) {
        cnt = board[i][j].equals(board[i][j - 1]) ? cnt + 1 : 1;
        max = Math.max(max, cnt);
      }
    }

    // 열의 연속된 사탕 개수
    for (int i = 0; i < board.length; i++) {
      int cnt = 1;
      for (int j = 1; j < board.length; j++) {
        cnt = board[j][i].equals(board[j - 1][i]) ? cnt + 1 : 1;
        max = Math.max(max, cnt);
      }
    }
    return max;
  }
}

package 인규.브루트포스;

import java.util.Scanner;

public class 테트로미노 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][][] tetrominos = {
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
        {{0, 0}, {0, -1}, {1, -1}, {1, -2}},
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
        {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 2}}
    };

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int[][] paper = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        paper[i][j] = scanner.nextInt();
      }
    }

    int max = 0;

    for (int[][] tetromino : tetrominos) {
      for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= M; j++) {
          int sum = 0;

          for (int[] position : tetromino) {
            int row = i + position[0];
            int col = j + position[1];

            if (row < 0 || row >= N || col < 0 || col >= M) {
              break;
            }

            sum += paper[row][col];
          }

          max = Math.max(max, sum);
        }
      }
    }

    System.out.println(max);
  }
}

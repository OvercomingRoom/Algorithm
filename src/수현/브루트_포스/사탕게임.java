package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class 사탕게임 {

    // 게임 입력 보드
    static String[][] board;

    static int N = 0;

    // 결과인 최댓값
    static int max = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new String[N][N];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            String[] split = readLine.split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = split[j];
            }
        }


        // 양 옆을 변경하고 확인하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) { // 범위를 초과하지 않도록 -1을 해주기

                // 스왑
                swap(i, j, i, j + 1);

                // 확인
                search();

                // 보드 복구
                swap(i, j + 1, i, j);
            }
        }

        // 위 아래를 변경하고 확인하기
        for (int i = 0; i < N - 1; i++) { // 범위를 초과하지 않도록 -1을 해주기
            for (int j = 0; j < N; j++) {

                // 스왑
                swap(i + 1, j, i, j);

                // 확인
                search();

                // 보드 복구
                swap(i, j, i + 1, j);
            }
        }

        System.out.println(max);

    }

    // 스왑
    private static void swap(int i, int j, int i2, int j2) {
        String temp = board[i][j];
        board[i][j] = board[i2][j2];
        board[i2][j2] = temp;
    }

    // 검색
    private static void search() {

        // 양 옆 검색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j].equals(board[i][j + 1])) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        // 아래 위 검색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {

                if (board[j][i].equals(board[j + 1][i])) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }

            }
        }
    }
}

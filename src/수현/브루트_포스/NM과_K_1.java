package 수현.브루트_포스;

import java.util.Scanner;

public class NM과_K_1 {

    static int[][] board;
    static int[] arr;
    static boolean[][] chk;
    static int N, M, K, max;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        board = new int[N][M];
        arr = new int[K];
        chk = new boolean[N][M];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int depth, int start) {

        if (depth == K) {
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += arr[i];
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!chk[i][j] // 방문하지 않았으며
                        && (i == 0 || !chk[i - 1][j]) // 윗 행을 확인. 가장 윗 행이거나, 인접한 곳을 방문한 적 없음.
                        && (j == 0 || !chk[i][j - 1]) // 왼쪽 열을 확인. 가장 왼쪽 열이거나, 인접한 곳을 반문한 적 없음.
                        && (i == N - 1 || !chk[i + 1][j]) // 아랫 행을 확인. 가장 아래쪽 행이거나, 인접한 곳을 방문한 적 없음
                        && (j == M - 1 || !chk[i][j + 1]) // 오른쪽 열을 확인. 가장 오른쪽 이거나, 인접한 곳을 방문한 적 없음
                ) {
                    chk[i][j] = true; // 방문처리
                    arr[depth] = board[i][j];
                    dfs(depth + 1, i);
                    chk[i][j] = false;
                }
            }
        }
    }
}

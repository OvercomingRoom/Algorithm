package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 외판원_순회 {
    private static int N, min;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0, 0);

        System.out.println(min);
    }

    public static void dfs(int current, int cost, int start) {
        if (current == N - 1 && board[start][0] != 0) {
            min = Math.min(min, cost + board[start][0]);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i] && board[start][i] != 0) { // 방문하지 않고 만약 이동 가능하다면
                visited[i] = true; // 방문 처리
                dfs(current + 1, cost + board[start][i], i); // 깊이를 +1 시킴. cost에 board 에 적힌 갑을 더함.
                visited[i] = false; // 방문 해제

            }
        }
    }
}

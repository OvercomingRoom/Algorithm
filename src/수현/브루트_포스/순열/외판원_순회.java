package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 외판원_순회 {
    private static int N, min, x, y;
    static int[][] board;
    static int[] data;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        data = new int[N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int current, int cost) {
        if (current == N) {
            min = Math.min(min, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && board[current][i] != 0) {
                visited[i] = true;
                dfs(current + 1, cost + board[current][i]);
                visited[i] = false;
            }
        }
    }
}

package 수현.브루트_포스.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_1 {

    static int N, M;
    static boolean[] chk;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        chk = new boolean[N + 1];
        arr = new int[M];

        dfs(N, M, 0);
    }

    static void dfs(int i, int j, int depth) {

        if (depth == j) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        for (int k = 1; k <= N; k++) {
            if (!chk[k]) {
                chk[i] = true;
                arr[depth] = k + 1;
                dfs(i, j, depth + 1);
                chk[i] = false;
            }
        }
    }
}

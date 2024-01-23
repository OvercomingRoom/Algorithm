package 수현.브루트_포스.순열;

import java.util.Scanner;

public class 모든순열 {
    static int N;
    static boolean[] chk;
    static int[] arr, result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chk = new boolean[N];
        arr = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!chk[i]) {
                chk[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                chk[i] = false;
            }
        }
    }
}

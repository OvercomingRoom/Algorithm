package 수현.브루트_포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1248
public class 맞춰바 {

    static String[][] S;
    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new String[N][N];

        A = new int[N];

        String[] split = br.readLine().split("");
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                S[i][j] = split[count++];
            }
        }

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i : A) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.exit(0);
        }

        for (int i = -10; i <= 10; i++) { // 최대, 최소 범위 -10 ~ 10
            A[depth] = i; // 반복문을 통해 -10 ~ 10 까지 확인해봄.
            if (chkSign(depth)) { // 부호를 확인해봄. 이때 depth 를 통해 확인.
                dfs(depth + 1); // 충족 시 depth 를 늘림
            }
        }
    }

    static boolean chkSign(int depth) {

        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += A[j]; //
                String sign = S[i][j];
                if (!sign.equals(sum == 0 ? "0" : (sum > 0 ? "+" : "-"))) {
                    return false;
                }
            }
        }
        return true;
    }
}

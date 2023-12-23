package 수현.브루트_포스.N과M;

import java.io.*;
import java.util.Arrays;

public class N과_M_5 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] resultArr, numArr;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        resultArr = new int[M + 1];
        numArr = new int[N + 1];
        chk = new boolean[N + 1];

        split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(numArr);

        dfs(0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(resultArr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!chk[i]) {
                chk[i] = true;
                resultArr[depth] = numArr[i + 1];
                dfs(depth + 1);
                chk[i] = false;
            }
        }
    }
}

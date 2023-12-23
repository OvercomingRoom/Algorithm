package 수현.브루트_포스.N과M;

import java.io.*;
import java.util.Arrays;

public class N과_M_6 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    private static int[] arr;
    private static boolean[] chk;
    private static int[] numArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M + 1];
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
        if(depth == M){
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!chk[i]){
                chk[i] = true;
                arr[depth] = numArr[i];
                dfs(depth + 1);
                for (int j = i + 1; j <= N; j++) {
                    chk[j] = false;
                }
            }
        }
    }


}

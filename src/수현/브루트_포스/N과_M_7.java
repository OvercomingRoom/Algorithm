package 수현.브루트_포스;

import java.util.Arrays;
import java.util.Scanner;

public class N과_M_7 {

    static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] arr, numArr;
    private static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M + 1];
        chk = new boolean[N + 1];
        numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);
        dfs(0);

        System.out.println(sb);
    }

    static void dfs (int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!chk[i]){
                arr[depth] = numArr[i - 1];
                dfs(depth + 1);
            }
        }
    }
}

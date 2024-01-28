package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로또 {

    static int[] lotto, allNum;
    static boolean[] chk;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String[] split = br.readLine().split(" ");

            k = Integer.parseInt(split[0]);

            if (k == 0) {
                break;
            }

            lotto = new int[6];
            allNum = new int[k];

            for (int i = 0; i < k; i++) {
                allNum[i] = Integer.parseInt(split[i + 1]);
            }

            chk = new boolean[allNum[allNum.length - 1] + 1];
            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {// i = start 로 다음 숫자를 선택할 때 현재 숫자 이후부터 선택 하도록 함.
            if (!chk[allNum[i]]) {
                chk[allNum[i]] = true;
                lotto[depth] = allNum[i];
                dfs(depth + 1, i + 1);
                chk[allNum[i]] = false;
            }
        }
    }
}

package 수현.브루트_포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class 암호만들기 {
    static int L, C;
    static char[] passwordArr;
    static char[] LArr;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        L = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[1]);
        passwordArr = new char[C];
        LArr = new char[L + 1];
        chk = new boolean[C];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < C; i++) {
            passwordArr[i] = split[i].charAt(0);
        }

        Arrays.sort(passwordArr);

        dfs(0);
    }

    static void dfs(int depth) {

        if (depth == L) {
            int count = 0;
            for (int i = 0; i < L; i++) {
                if(LArr[i] == 'a' || LArr[i] == 'e' || LArr[i] == 'i' || LArr[i] == 'o' || LArr[i] == 'u') {
                    count ++;
                }
                if(count > L - 2) return;
            }

            for (int i = 0; i < L; i++) {
                if(LArr[i] == 'a' || LArr[i] == 'e' || LArr[i] == 'i' || LArr[i] == 'o' || LArr[i] == 'u') {
                    for (int j = 0; j < L; j++) {
                        System.out.print(LArr[j]);
                    }
                    System.out.println();
                    break ;
                }
            }
            return;
        }

        for (int i = 0; i < C; i++) {
            if (!chk[i]) {
                chk[i] = true;
                LArr[depth] = passwordArr[i];
                dfs(depth + 1);
                for (int j = i + 1; j < C; j++) {
                    chk[j] = false;
                }
            }
        }
    }
}

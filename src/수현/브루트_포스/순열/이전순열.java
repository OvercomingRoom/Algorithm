package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이전순열 {
    static int N;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }

        boolean find = false;

        for (int i = N - 1; i > 0; i--) {
            int idx1 = 0, idx2 = 0, preNum = 0;
            if (numArr[i] < numArr[i - 1]) {
                idx1 = i - 1;
                preNum = numArr[idx1];
                while (!find) {
                    preNum--;
                    for (int j = idx1 + 1; j < N; j++) {
                        if (numArr[j] == preNum) {
                            idx2 = j;
                            find = true;
                            swap(idx1, idx2);
                            break;
                        }
                    }
                }

                for (int j = idx1 + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (numArr[j] < numArr[k]) {
                            swap(j, k);
                        }
                    }
                }
                break;
            }

        }

        if (!find) {
            System.out.println(-1);
            System.exit(0);
        }

        for (int j = 0; j < N; j++) {
            System.out.print(numArr[j] + " ");
        }
    }

    static void swap(int idx1, int idx2) {
        int temp = numArr[idx1];
        numArr[idx1] = numArr[idx2];
        numArr[idx2] = temp;
    }
}

package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://code.plus/course/51
public class 다음순열 {

    static int[] numArr, tempArr;

    static boolean[] chk;
    private static int N, 순열, 다음순열, 마지막순열;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numArr = new int[N];
        tempArr = new int[N];
        chk = new boolean[N];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }

        순열 = 0;
        for (int i = N - 1, digit = 1; i >= 0; i--, digit *= 10) {
            순열 += numArr[i] * digit;
        }

        Arrays.sort(numArr);

        for (int i = 0, digit = 1; i < N; i++, digit *= 10) {
            마지막순열 += numArr[i] * digit;
        }

        if (순열 == 마지막순열) {
            System.out.println(-1);
            System.exit(0);
        }

        findPermutation();

        for (int i = N - 1; i >= 0; i--) {
            System.out.print(numArr[i] + " ");
        }

    }


    static void findPermutation() {

        for (int i = 순열 + 1; i < 마지막순열; i++) {
            int temp = i;
            Arrays.fill(chk, false);

            for (int j = 0; j < N; j++) {
                tempArr[j] = temp % 10;
                temp /= 10;
            }

            boolean findNum = false;
            int count = 0;
            for (int j = 0; j < N; j++) {
                int index = Arrays.binarySearch(numArr, tempArr[j]);
                if (index >= 0 && !chk[index]) {
                    chk[index] = true;
                    findNum = true;
                    count++;
                } else if (index < 0 || (index >= 0 && chk[index])) {
                    findNum = false;
                    break;
                }
            }

            if (findNum && count == N) {
                다음순열 = i;
                numArr = tempArr;
                break;
            }

        }
    }

}

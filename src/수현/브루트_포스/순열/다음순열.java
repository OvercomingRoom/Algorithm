package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/10972
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

        tempArr = numArr.clone();;

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

        for (int i = 0; i < N; i++) {
            System.out.print(tempArr[i] + " ");
        }

    }

    static void findPermutation() {
        int index1, index2, nextNum = 0;
        for (int i = N - 1; i >= 1; i--) {
            // 1. 오른쪽 수, 왼쪽 수 비교
            if (tempArr[i] > tempArr[i - 1]) {
                // 2. 오른쪽 수가 왼쪽 수 보다 클 때 index1 저장
                index1 = i - 1;
                index2 = index1;
                // 3. tempArr[index1] 보다 큰 수를 다시 오른쪽 부터 찾고, index2 저장
                nextNum = tempArr[index1];
                boolean findIndex = false;
                while (!findIndex) {
                    nextNum++;
                    for (int j = index1 + 1; j < N; j++) {
                        if (tempArr[j] == nextNum) {
                            index2 = j;
                            findIndex = true;
                            // 4. tempArr[index1], tempArr[index2] 서로 swap
                            swap(index1, index2);
                            break;
                        }
                    }
                }

                // 5. tempArr[index1 + 1] 부터 tempArr[tempArr.length() - 1] 까지 수를 작은 수 부터 swap 시키기.
                for (int j = index1 + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (tempArr[j] > tempArr[k]) {
                            swap(j, k);
                        }
                    }
                }
                break;
            }
        }


    }

    static void swap(int index1, int index2) {
        int temp = tempArr[index1];
        tempArr[index1] = tempArr[index2];
        tempArr[index2] = temp;

    }

}

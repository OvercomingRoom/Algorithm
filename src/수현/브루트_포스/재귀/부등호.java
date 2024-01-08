package 수현.브루트_포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부등호 {
    static long max, min;
    static int inequalityCount;
    static String[] inequalityArr;
    static int[] numArr;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inequalityCount = Integer.parseInt(br.readLine());

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        chk = new boolean[10];
        numArr = new int[inequalityCount + 1];
        inequalityArr = br.readLine().split(" ");

        recursive(0);


        System.out.println(String.valueOf(max));
        System.out.println(String.valueOf(min).length() == inequalityCount + 1 ? min : "0" + min);
    }

    static void recursive(int count) {

        if (count == inequalityCount + 1) {
            String stringVal = "";
            for (int i = 0; i < inequalityCount + 1; i++) {
                stringVal += numArr[i] + "";
            }
            long val = Long.parseLong(stringVal);
            min = Math.min(min, val);
            max = Math.max(max, val);
            return;
        }

        for (int j = 0; j < 10; j++) {
            numArr[count] = j;
            if (count == 0 ||
                    (inequalityChk(inequalityArr[count - 1], count))
                            && !chk[j]) {
                chk[j] = true;
//                numArr[count + 1] = j;
                recursive(count + 1);
                chk[j] = false;
            }
        }

    }

    static boolean inequalityChk(String operation, int count) {

        int prev = numArr[count - 1];
        int next = numArr[count];
        boolean result = false;

        if (operation.equals(">")) {
            if (prev > next) {
                result = true;
            }
        } else if (operation.equals("<")) {
            if (prev < next) {
                result = true;
            }
        }

        return result;
    }

}

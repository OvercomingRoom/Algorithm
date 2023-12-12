package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 수_이어_쓰기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readLine = br.readLine();

        int length = readLine.length();

        int num = Integer.parseInt(readLine);

        int result = num > 10 ? 9 : num;

        // 1. 101 - (100 - 1) = 2
        //       2 * 3 = 6

        // 2. 99 - ( 10 - 1) = 90
        //      90 * 2 = 180

        // 3. 9

        int n = 0;

        for (int i = length; i >= 2; i--) {
            n = (int) Math.pow(10, i - 1) - 1;
            result += (num - n) * i;
            num = n;
        }

        System.out.println(result);

    }
}

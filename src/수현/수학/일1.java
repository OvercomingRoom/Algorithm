package 수현.수학;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class 일1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (sc.hasNextInt()) {

            BigInteger all1 = BigInteger.ONE;
            // 자리수
            int result = 1;

            int n = sc.nextInt();

            while (!(all1.mod(BigInteger.valueOf(n))).equals(BigInteger.ZERO)) {

                all1 = all1.multiply(BigInteger.TEN).add(BigInteger.ONE);
                // 자리수 증가
                result++;
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
}

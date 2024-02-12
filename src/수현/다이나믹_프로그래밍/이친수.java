package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] NArr = new long[N + 1];
        NArr[1] = 1;

        if( N > 1) {
            NArr[2] = 1;

            for (int i = 3; i <= N; i++) {
                NArr[i] = NArr[i - 1] + NArr[i - 2];
            }
        }

        System.out.println(NArr[N]);
    }
}

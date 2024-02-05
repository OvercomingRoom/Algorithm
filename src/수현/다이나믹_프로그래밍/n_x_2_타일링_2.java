package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_x_2_타일링_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] data = new long[N + 1];

        data[1] = 1;

        if (N > 1) {
            data[2] = 3;
            int idx = 2;
            while (idx != N){
                // 2a[n - 1] = a[n+1] - a[n];
                data[idx + 1] = (data[idx] + 2 * data[idx - 1]) % 10007;
                idx ++;
            }
        }
        System.out.println(data[N]);
    }
}


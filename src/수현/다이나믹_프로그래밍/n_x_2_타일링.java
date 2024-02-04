package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_x_2_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N + 1];

        data[1] = 1;

        if(N > 1){
            data[2] = 2;

            for (int i = 3; i <= N; i++) {
                data[i] = data[i - 2] + data[i - 1];
                data[i] %= 10007;
            }
        }
        System.out.println(data[N]);
    }
}

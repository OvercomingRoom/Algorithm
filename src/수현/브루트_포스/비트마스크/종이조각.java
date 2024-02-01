package 수현.브루트_포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이조각 {
    static int N, M, max;
    static int[][] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        max = 0;
        numArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 모든 경우의 수
        for (int i = 0; i < (1 << (N * M)); i++) {
            int sum = 0;
            // 가로 숫자
            for (int x = 0; x < N; x++) {
                int cur = 0;
                for (int y = 0; y < M; y++) {
                    int idx = x * M + y; // 0 ~ 2^(N * M) -1 까지의 수
                    // 가로 연결 확인. 0은 가로, 000 은 3 수가 가로로 이어짐
                    if ((i & (1 << idx)) == 0) {
                        cur = cur * 10 + numArr[x][y]; // 값을 저장
                    } else {
                        sum += cur; // 연결이 끊어졌을 때 sum 에 값을 더함.
                        cur = 0;
                    }
                }
                sum += cur;
            }

            // 세로 숫자
            for (int y = 0; y < M; y++) {
                int cur = 0;
                for (int x = 0; x < N; x++) {
                    int idx = x * M + y;
                    // 세로 연결 확인. 0이 아니라면 세로
                    if ((i & (1 << idx)) != 0) {
                        cur = cur * 10 + numArr[x][y];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

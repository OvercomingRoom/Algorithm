package 수현.브루트_포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스타트와_링크 {

    static int N, min;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < (1 << N); i++) { // 1 << N  == 2^N
            int count = Integer.bitCount(i); // i의 비트 중 1을 count함

            if (count == N / 2) { // 비트를 이용해 0과 1의 비율이 N/2와 같을 때를 찾기
                min = Math.min(min, calculateDifference(i));
            }
        }

        System.out.println(min);
    }

    static int calculateDifference(int bitmask) {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 팀원을 정확히 반으로 나눌 수 있을 경우, teamStart와 teamLink로 팀원을 나눔.

                // 결과 비트가 0보다 큰 경우
                if ((bitmask & (1 << i)) > 0 && (bitmask & (1 << j)) > 0) {
                    teamStart += S[i][j];
                }
                // 비트가 모두 일치하지 않아 0인 경우
                else if ((bitmask & (1 << i)) == 0 && (bitmask & (1 << j)) == 0) {
                    teamLink += S[i][j];
                }
            }
        }

        return Math.abs(teamStart - teamLink); // 두 팀의 능력치 차이 반환
    }
}

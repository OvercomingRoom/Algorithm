package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int min = 0;

        for (int i = 0; i < N; i++) {
            String[] rgb = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(rgb[j]);
            }
        }

        for (int i = 1; i < N; i++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][1], map[i - 1][0]);
        }

        min = Math.min(map[N - 1][0], map[N - 1][1]);
        min = Math.min(min, map[N - 1][2]);

        System.out.println(min);
    }
}

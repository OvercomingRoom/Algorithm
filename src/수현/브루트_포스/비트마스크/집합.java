package 수현.브루트_포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int target = 0, num;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            String cal = split[0];

            if ("add".equals(cal)) {
                num = Integer.parseInt(split[1]);
                target |= 1 << (num - 1); // 비트마스크를 1로 만듦
            } else if ("remove".equals(cal)) {
                num = Integer.parseInt(split[1]);
                target &= ~(1 << (num - 1)); // 비트마스크를 0으로 만듦
            } else if ("check".equals(cal)) {
                num = Integer.parseInt(split[1]);
                sb.append(((target & (1 << (num - 1))) != 0 ? 1 : 0) + "\n"); // 타겟이 1이라면 1, 아니면 0
            } else if ("toggle".equals(cal)) {
                num = Integer.parseInt(split[1]);
                target ^= (1 << (num - 1)); // xor 로 비트마스크가 1이면 0, 0이면 1로 변경
            } else if ("all".equals(cal)) {
                target |= ~0; // ~0으로 모든 비트를 1로 설정
            } else if ("empty".equals(cal)) {
                target &= 0;
            }
        }
        System.out.println(sb);
    }
}

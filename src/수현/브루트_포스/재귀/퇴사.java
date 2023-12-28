package 수현.브루트_포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사 {

    static int[][] schedule;
    static int N, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = 0;

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            schedule[i][0] = Integer.parseInt(split[0]);
            schedule[i][1] = Integer.parseInt(split[1]);
        }

        recursive(0, 0);

        System.out.println(max);
    }

    static void recursive(int day, int sum) {

        if (day > N) { // day 가 N 보다 크면 아무것도 하지 않고 return
            return;
        }
        if (day == N) {
            max = Math.max(sum, max);
            return;
        }

        recursive(day + schedule[day][0], sum + schedule[day][1]);
        recursive(day + 1, sum);

    }

}


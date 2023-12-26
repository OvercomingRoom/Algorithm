package 수현.브루트_포스.재귀;

import java.util.Scanner;

public class 스타트와_링크 {
    static int[][] board;
    static boolean[] chk;
    static int N, MIN, val;
    static int[] start, link;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];
        link = new int[N];
        start = new int[N];
        chk = new boolean[N];

        MIN = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        recursive(0, 0);
        System.out.println(MIN);
    }

    static void recursive(int depth, int index) {
        if (depth == N / 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (chk[i] && chk[j]) { // i, j 모두 선택 된 사람
                        val += board[i][j];
                    }else if(!chk[i] && !chk[j]) { // 선택 하지 않은 남은 사람들 끼리 팀
                        val -= board[i][j];
                    }
                }
            }
            MIN = Math.min(MIN, Math.abs(val));
            val = 0;
            return;
        }

        for (int i = index; i < N; i++) { // 0~N 까지 검사
            if (!chk[i]) {
                chk[i] = true;
                recursive(depth + 1, i + 1); // depth 가 N/2 일 때 까지 재귀 호출, 현재 index에서 1 씩 증가시켜 값을 확인
                chk[i] = false; // 방문 해제
            }
        }
    }
}

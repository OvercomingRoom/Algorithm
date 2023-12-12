package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {

    static int[][][] shape = {
            // ㅡ
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}
            // ㅣ
            , {{0, 0}, {1, 0}, {2, 0}, {3, 0}}
            // ㅏ
            , {{0, 0}, {1, 0}, {2, 0}, {1, 1}}
            // ㅓ
            , {{0, 1}, {1, 1}, {2, 1}, {1, 0}}
            // ㅜ
            , {{0, 0}, {0, 1}, {0, 2}, {1, 1}}
            // ㅗ
            , {{1, 0}, {1, 1}, {1, 2}, {0, 1}}
            // ㄱ
            , {{0, 0}, {0, 1}, {0, 2}, {1, 2}}
            , {{0, 0}, {0, 1}, {1, 1}, {2, 1}}
            // ㄴ
            , {{0, 0}, {1, 0}, {1, 1}, {1, 2}}
            , {{0, 0}, {1, 0}, {2, 0}, {2, 1}}
            // ┌
            , {{0, 0}, {0, 1}, {0, 2}, {1, 0}}
            , {{0, 0}, {0, 1}, {1, 0}, {2, 0}}
            // ┘
            , {{0, 2}, {1, 0}, {1, 1}, {1, 2}}
            , {{0, 1}, {1, 1}, {2, 1}, {2, 0}}
            // ㄹ
            , {{0, 0}, {0, 1}, {1, 1}, {1, 2}}
            // ㄹ 90도 회전
            , {{0, 1}, {1, 1}, {1, 0}, {2, 0}}
            // ㄹ 반전
            , {{1, 0}, {1, 1}, {0, 1}, {0, 2}}
            // ㄹ 반전 + 90도 회전
            , {{0, 0}, {1, 0}, {1, 1}, {2, 1}}
            // ㅁ
            , {{0, 0}, {1, 0}, {1, 1}, {0, 1}}

    };

    static int[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        int max = 0;

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < shape.length; i++) { // 모양 배열의 크기 만큼 반복
            for (int j = 0; j < N; j++) { // x
                roof:
                for (int k = 0; k < M; k++) { // y
                    int sum = 0; // 4개의 값을 더해 저장할 변수
                    for (int l = 0; l < shape[i].length; l++) { // shape[i].length == 4 (테트로미노는 정사각형 4개를 이어 붙임)
                        if (chk(j + shape[i][l][0], k + shape[i][l][1])) { // x, y를 모양 배열의 요소에 더해 범위를 초과 하지 않고 모양을 만들수 있는지 검사
                            sum += board[j + shape[i][l][0]][k + shape[i][l][1]]; // 만들 수 있다면 board 에 쓰인 정수를 더함
                        }else{
                            break roof; // 범위를 초과해 모양을 만들 수 없다면 루프를 벗어남
                        }
                    }
                    max = Math.max(sum, max);
                }
            }
        }

        System.out.println(max);
    }

    // 범위 체크
    public static boolean chk(int x, int y) {
        if (x >= N || x < 0 || y >= M || y < 0) {
            return false;
        }
        return true;
    }
}

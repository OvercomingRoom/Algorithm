package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과_M_2 {

    static int N, M;
    static boolean[] chk;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M + 1];

        chk = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int depth) {

        if (depth == M) { // 정해진 길이 만큼 이동을 완료 했을 때 출력
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) { // N 까지 순회
            if (!chk[i]) { // 이동한 노드인지 확인
                arr[depth] = i; // 이동한 경로에 노드 숫자를 저장
                chk[i] = true; // 이동한 노드 표시
                dfs(depth + 1); // 더 깊이 이동 가능한지 확인
                for (int j = i; j <= N; j++) {
                    if (i < j) { // 반볻문을 돌며 i 보다 j 가 커질때 만 false 로 변경하기
                        chk[j] = false;
                    }
                }
            }
        }
    }
}

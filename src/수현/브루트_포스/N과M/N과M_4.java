package 수현.브루트_포스.N과M;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M_4 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M + 1];
        chk = new boolean[N + 1];

        dfs(0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!chk[i]) { // 방문한적 없다면
                arr[depth] = i; // arr[depth] 에 현재 노드 저장.
                dfs(depth + 1); // 더 깊이 방문 가능한지 확인
                chk[i] = true;
                for (int j = i + 1; j <= N; j++) { // arr[0] <= arr[1] 형태로 출력하기 위함.
                                                // arr[j] 보다 arr[j + 1] 이 더 큰 값을 가지고 있기 때문에
                                                // chk[j] 를 false 로 만들어 방문을 ㅎㅓ용
                    chk[j] = false;
                }
            }
        }
    }
}

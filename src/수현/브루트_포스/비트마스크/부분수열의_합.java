package 수현.브루트_포스.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의_합 {
    private static int N, S, count;
    private static int[] arr;
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        chk = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) count -= 1; // S 가 0일 경우 연산을 하지 않아도 count 가 1이 되는것을 방지하기 위함
        System.out.println(count);
    }

    private static void dfs(int sum, int start) {

        if (sum == S) {
            count++;
        }


        for (int j = start; j < N; j++) {
            if (!chk[j]) {
                chk[j] = true;
                dfs(sum + arr[j], j + 1);
                chk[j] = false;
            }
        }
    }
}

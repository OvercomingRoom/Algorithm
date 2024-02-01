package 수현.브루트_포스.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 차이를_최대로 {
    private static int N, max;
    private static int[] numArr, resultArr;
    private static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        resultArr = new int[N]; // 자리를 재 배치한 배열을 저장하기 위함.
        chk = new boolean[N];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }

        dfs(0); // 0번째 index 부터 시작

        System.out.println(max);

    }

    static void dfs(int depth) { // 모든 경우의 수를 구하고, 더해 최댓값을 구함.
        if (depth == N) {  // index 가 N과 같아질 때 max 값을 구해봄.
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                // |(A[0] - A[1])| + |(A[1] - A[2])| + ... + |(A[N-2] - A[N-1])| 형식의 절댓값을 sum에 더함. => Math.abs 사용.
                sum += Math.abs(resultArr[i] - resultArr[i + 1]);
            }
            if (max < sum) max = sum; // 만약 max < sum 이라면 max 값을 변경함.
            return;
        }

        for (int k = 0; k < N; k++) {
            if (!chk[k]) {
                resultArr[depth] = numArr[k]; // result 의 인덱스 0번 부터 numArr의 k값으로 채움.
                chk[k] = true; // 방문처리
                dfs(depth + 1); // 다음 인덱스 탐색
                chk[k] = false; // depth == N 까지 탐색 후 방문 처리를 해제.
            }
        }
    }

    static void swap(int idx1, int idx2) {
        int temp = numArr[idx1];
        numArr[idx1] = numArr[idx2];
        numArr[idx2] = temp;
    }
}

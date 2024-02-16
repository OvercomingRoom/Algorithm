package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 가장_긴_증가하는_부분_수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        List<Integer> data = new ArrayList<>();
        int result = 0;
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }


        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(A[i] > A[j] && dp[i] <= dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            result = Math.max(result, dp[i]);
        }

        int idx = result;
        for (int i = N - 1; i >= 0 ; i--) {
            if(dp[i] == idx){
                data.add(A[i]);
                idx--;
            }
        }

        System.out.println(result);
        for (int i = data.size() - 1; i >= 0; i--) {
            System.out.print(data.get(i)+ " ");
        }
    }
}

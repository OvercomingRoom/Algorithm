package 수현.다이나믹_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N + 1];
        result[1] = 0;

        // i 가 6인 경우 2로 나눈 후 한번 더 3으로 나눠야 하기 때문에 %2, %3을 각각 처리해줘야함.
        // 틀린 답임
//        for (int i = 2; i <= N ; i++) {
//            result[i] = result[i - 1] + 1; // 1로 빼는 경우. +1로 연산 횟수를 더해줌.
//            if( i % 2 == 0 || i % 3 == 0){
//                // 1로 뺀 경우와 result의 인덱스에 2또는 3을 나눈 결과에 +1로 연산 횟루를 더한 값 중 최소인 값을 구함.
//                result[i] = Math.min(result[i], result[i / ((i % 3) == 0 ? 3 : 2)] + 1);
//                System.out.println(result[i] );
//            }
//        }

        for (int i = 2; i <= N; i++) {
            result[i] = result[i - 1] + 1;  // 1을 빼는 경우

            if (i % 2 == 0) {
                result[i] = Math.min(result[i], result[i / 2] + 1);  // 2로 나누는 경우
            }

            if (i % 3 == 0) {
                result[i] = Math.min(result[i], result[i / 3] + 1);  // 3으로 나누는 경우
            }
        }

        System.out.println(result[N]);
    }
}

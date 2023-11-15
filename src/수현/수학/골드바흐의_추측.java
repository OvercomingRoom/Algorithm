package 수현.수학;

import java.util.Scanner;

public class 골드바흐의_추측 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[1] = true;
        // 소수 : 3, 5, 7, 11 과 같이 1과 자기 자신으로만 나눌 수 있는 수
        // 소수가 아니면 true 로 변경하기

        for (int i = 2; i < isNotPrime.length; i++) {
            for (int j = 2; j * i < isNotPrime.length; j++) {
                isNotPrime[j * i] = true;
            }
        }

        // 0 이면 실행 종료
        while (true) {

            int N = sc.nextInt();

            if (N == 0) break;

            // b - a 가 큰 것 부터..
            for (int i = N - 1; i >= 2; i--) {
                if (!isNotPrime[i] && !isNotPrime[N - i]) {
                    sb.append(N + " = " + (N - i) + " + " + i + "\n");
                    break;
                    // b - a 가 큰 것을 출력할 예정
                    // N / 2 가 i 보다 크다면 이미 검증이 끝나 출력할수 있는게 없는것
                } else if ( N / 2 > i) {
                    sb.append("Goldbach's conjecture is wrong.\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] memoryArr = new int[11];

        memoryArr[1] = 1;
        memoryArr[2] = 2;
        memoryArr[3] = 4;

        for (int i = 4; i < 11; i++) {
            for (int j = 1; j <= 3; j++) {
                memoryArr[i] += memoryArr[i - j];
            }
        }

        for (int i = 0; i < num; i++) {
            int testCase = Integer.parseInt(br.readLine());
            System.out.println(memoryArr[testCase]);

        }
    }
}

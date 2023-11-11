package 수현.수학;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 약수의_합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] fYArr = new long[1000001];
        long[] gNArr = new long[1000001];


        Arrays.fill(fYArr, 1);
        Arrays.fill(gNArr, 1);
        //1. fyArr 에 1부터 약수의 합을 더하기.
        //2. gNArr 에 fyArr 의 이전 약수의 합과 현제 약수의 합을 더해 gNArr[i] 에 넣기
        // 입력받은 N을 이용해 gNArr[N] 을 반환하기.

        for (int i = 2; i < 1000001; i++) {
            for (int j = 1; j * i < 1000001; j++) {
                fYArr[j * i] += i;
            }
            gNArr[i] = gNArr[i-1] + fYArr[i];
        }

        System.out.println(gNArr[N]);
    }
}

package 수현.수학;

import java.io.*;
import java.util.Arrays;

public class 약수의_합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());

        // 자신과 같거나 작은 자연수의 약수의 합을 담을 배열
        long[] fAArr = new long[1000001];
        long[] gNArr = new long[1000001];

        // 1은 모든 수의 약수임. 모든 index 에 1 넣어주기
        Arrays.fill(fAArr, 1);
        Arrays.fill(gNArr, 1);

        // i의 배수( i * j )에 i 값을 넣는다. (더한다.)
        for (int i = 2; i < fAArr.length; i++) {
            for (int j = 1; j * i < fAArr.length; j++) {
                fAArr[i * j] += i;
            }
            // i와 같거나, 작은 자연수의 약수 합을 저장.
            // fAArr[i] 는 자연수 i의 약수의 합
            // gNArr[i - 1] 은 자연수 i보다 작은 자연수의 약수의 합.
            gNArr[i] = gNArr[i - 1] + fAArr[i];
        }

        for (int i = 0; i < len; i++) {
            int N = Integer.parseInt(br.readLine());
            long gN = gNArr[N];
            bw.write(gN + "\n");
        }
        bw.flush();
    }
}

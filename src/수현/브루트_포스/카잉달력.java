package 수현.브루트_포스;

import java.io.*;

/*
https://www.acmicpc.net/problem/6064
 */
public class 카잉달력 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int M;
        int N;
        int x;
        int y;

        //<x:y>가 유효하지 않은 표현이면, -1을 출력
        for (int i = 0; i < T; i++) {
            String readLine = br.readLine();
            String[] split = readLine.split(" ");
            boolean check = false;

            M = Integer.parseInt(split[0]);
            N = Integer.parseInt(split[1]);
            x = Integer.parseInt(split[2]);
            y = Integer.parseInt(split[3]);

            int gcd = gcd(M, N);

            int lmc = M * N / gcd;

            for (int j = x; j <= lmc; j+= M) {

                if((j - y) % N == 0){
                    bw.write(j+"\n");
                    check = true;
                    break;
                }

            }

            if(!check){
                bw.write(-1+"\n");
            }

        }
        bw.flush();
        bw.close();
    }

    private static int gcd(int num1, int num2) {
        if(num2 == 0) return num1;

        //GCD( num1, num2 ) = GCD ( num2, num1 % num2 )
        return gcd(num2, num1 % num2);
    }
}

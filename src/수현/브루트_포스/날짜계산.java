package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 날짜계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String esm = br.readLine();
        String[] esmArr = esm.split(" ");

        int e = Integer.parseInt(esmArr[0]);
        int s = Integer.parseInt(esmArr[1]);
        int m = Integer.parseInt(esmArr[2]);

        int maxE = 15;
        int maxS = 28;
        int maxM = 19;

        int result = 1;

        for (int i = 1; true; i++) {

            if( (result - e) % maxE == 0 && (result - s) % maxS == 0 && (result - m) % maxM == 0 ){
                break;
            }
            result ++;
        }

        System.out.println(result);

    }
}

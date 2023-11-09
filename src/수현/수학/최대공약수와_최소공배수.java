package 수현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numArr = br.readLine().split(" ");

        int num1 = Integer.parseInt(numArr[0]);
        int num2 = Integer.parseInt(numArr[1]);

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        int 최대공약수 = 1;

        for (int i = max; i >=2 ; i--) {
            if(min % i == 0 && max % i == 0) {
                최대공약수 = i;
                break;
            }
        }

        System.out.println(최대공약수);

        int 최소공배수 = (max / 최대공약수) * min;

        System.out.println(최소공배수);
    }
}

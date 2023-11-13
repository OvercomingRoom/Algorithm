package 수현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대공약수와_최소공배수_유클리드호제 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numArr = br.readLine().split(" ");

        int num1 = Integer.parseInt(numArr[0]);
        int num2 = Integer.parseInt(numArr[1]);

        int 최대공약수 = gcd(num1, num2);
        int 최소공배수 = num1 * num2 / 최대공약수;
        System.out.println(최대공약수);
        System.out.println(최소공배수);
    }

    private static int gcd(int num1, int num2) {
        if(num2 == 0) return num1;

        //GCD( num1, num2 ) = GCD ( num2, num1 % num2 )
        return gcd(num2, num1 % num2);
    }
}

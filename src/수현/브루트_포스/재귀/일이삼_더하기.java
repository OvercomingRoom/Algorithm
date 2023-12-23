package 수현.브루트_포스.재귀;

import java.util.Scanner;

public class 일이삼_더하기 {

    static StringBuilder sb = new StringBuilder();
    static int num, count, sum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfNumber = sc.nextInt();

        for (int i = 0; i < numOfNumber; i++) {
            num = sc.nextInt();
            count = 0;
            recursive(0);
            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    static void recursive(int sum) {

        if(sum == num){
            count++;
        }
        if(sum > num){
            return;
        }

        recursive(sum + 1);
        recursive(sum + 2);
        recursive(sum + 3);
    }

}

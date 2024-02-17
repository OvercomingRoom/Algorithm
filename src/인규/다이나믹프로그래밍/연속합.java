package 인규.다이나믹프로그래밍;

import java.util.Scanner;

public class 연속합 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int max = arr[0];
    int sum = arr[0];

    for (int i = 1; i < n; i++) {
      sum = Math.max(arr[i], arr[i] + sum);
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }

}

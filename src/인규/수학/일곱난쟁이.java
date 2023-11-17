package 인규.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[9];
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }

    loop:
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - (arr[i] + arr[j]) == 100) {
          arr[i] = arr[j] = 0;
          break loop;
        }
      }
    }

    Arrays.sort(arr);
    for (int i = 2; i < 9; i++) {
      System.out.println(arr[i]);
    }
  }
}

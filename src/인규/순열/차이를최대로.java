package 인규.순열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 차이를최대로 {
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      arr.add(scanner.nextInt());
    }

    permutation(arr);

    System.out.println(max);

    scanner.close();
  }

  private static void permutation(List<Integer> arr) {
    Collections.sort(arr);

    do {
      calculateMaxDifference(arr);
    } while (nextPermutation(arr));

  }

  private static void calculateMaxDifference(List<Integer> arr) {
    int diff = 0;
    for (int i = 1; i < arr.size(); i++) {
      diff += Math.abs(arr.get(i - 1) - arr.get(i));
    }

    max = Math.max(max, diff);
  }

  private static boolean nextPermutation(List<Integer> arr) {
    int i = arr.size() - 1;
    while (i > 0 && arr.get(i - 1) >= arr.get(i)) {
      i--;
    }

    if (i <= 0) {
      return false;
    }

    int j = arr.size() - 1;
    while (arr.get(j) <= arr.get(i - 1)) {
      j--;
    }

    Collections.swap(arr, i - 1, j);
    Collections.reverse(arr.subList(i, arr.size()));

    return true;
  }
}

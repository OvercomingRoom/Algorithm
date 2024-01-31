package 인규.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 다음순열 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(
        Collectors.toList());

    if (nextPermutation(list)) {
      list.forEach(num -> System.out.print(num + " "));
    } else {
      System.out.println(-1);
    }
  }

  static boolean nextPermutation(List<Integer> list) {
    int i = list.size() - 1;
    while (i > 0 && list.get(i - 1) >= list.get(i)) {
      i--;
    }

    if (i <= 0) {
      return false;
    }

    int j = list.size() - 1;
    while (list.get(j) <= list.get(i - 1)) {
      j--;
    }

    Collections.swap(list, i - 1, j);
    Collections.reverse(list.subList(i, list.size()));

    return true;
  }
}

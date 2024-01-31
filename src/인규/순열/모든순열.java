package 인규.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 모든순열 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Integer> list = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

    do {
      list.forEach(num -> System.out.print(num + " "));
      System.out.println();
    } while (nextPermutation(list));
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

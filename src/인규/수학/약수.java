package 인규.수학;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 약수 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    LinkedList<Integer> list = new LinkedList<>();
    while (n-- > 0) {
      list.add(sc.nextInt());
    }
    Collections.sort(list);
    System.out.println(list.getFirst() * list.getLast());
  }
}

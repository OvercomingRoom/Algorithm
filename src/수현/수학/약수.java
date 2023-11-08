package 수현.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 약수 {
    /*
    A 가 N 의 진짜 약수가 되려면
    N 이 A 의 배수
    A 가 1 또는 N 이 아니어야함.
    N 을 구해보기.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ACount = Integer.parseInt(br.readLine());

        String[] AArray = br.readLine().split(" ");

        List<Integer> collect = Arrays.stream(AArray).map(Integer::parseInt).collect(Collectors.toList());

        // 약수(A) List 를 정렬함.
        Collections.sort(collect);

        // 약수(A) 중 가장 작은 수
        Integer min = collect.get(0);

        // 약수(A) 중 가장 큰 수
        Integer max = collect.get(ACount - 1);

        // 두 수를 곲해서 나온 수가 N 일 것.
        System.out.println(min * max);

    }
}

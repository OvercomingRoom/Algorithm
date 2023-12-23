package 수현.브루트_포스.N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과_M_8 {

    static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] arr, numArr;
    private static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M + 1];
        chk = new boolean[N + 1];
        numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);
        dfs(0);

        System.out.println(sb);
    }

    static void dfs (int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!chk[i]){
                arr[depth] = numArr[i - 1];
                dfs(depth + 1);
                chk[i] = true;
                for (int j = i + 1; j <= N ; j++) {
                    chk[j] = false;
                }
            }
        }
    }

    // i = 1
    // !chk[1] ? arr[0] = numArr[0] : 1++ ;                                 // dfs(0), depth = 0, chk[1] == false, !chk[1]는 참으로 arr[0] = numArr[0] 로 arr[0] = 1
    // dfs(1) -> !chk[1] ? arr[1] = numArr[0] : 1++;                        // dfs(1), depth = 1, chk[1] == false, !chk[1]는 참으로 arr[1] = numArr[0] 로 arr[1] = 1
    // dfs(2) -> if( depth 2 == M 2 )                                       // dfs(2), depth = 2
    //        -> sb.append(arr[i])                                          // 출력 : 1 1
    //        -> return                                                     // return -> dfs(1), depth = 1, i = 1
    //        -> chk[1] = true;                                             // chk[1] = true
    //        -> for(j = 1 + 1 ; j <= N; j ++)
    //        -> chk[2 ~ 4] = false;
    //        -> i = 2                                                      // dfs(1), depth = 1, i = 2
    //        -> !chk[2] ? arr[1] = numArr[1] : 2++                         // chk[2] == false, !chk[2]는 참으로 arr[1] = numArr[1] 로 arr[1] = 7
    //                                                                          -> dfs(1 + 1) 로직 수행.
    // dfs(2) -> if( depth 2 == M 2 )                                       // dfs(2), depth = 2
    //        -> sb.append(arr[i])                                          // 출력 : 1 7
    //        -> return                                                     // return -> dfs(1), depth = 1, i = 2
    //        -> chk[2] = true;                                             // chk[2] = true;
    //        -> for(j = 2 + 1 ; j <= N; j ++)
    //        -> chk[3 ~ 4] = false;                                        // chk[3 ~ 4] = false;
    //        -> i = 3                                                      // dfs(1), depth = 1, i = 3
    //        -> !chk[3] -> arr[1] = numArr[2] : 3++;                       // chk[3] == false, !chk[3]는 참으로 arr[1] = numArr[2], arr[1] = 8
    // -> dfs(1 + 1) 로직 수행
    // dfs(2) -> if( depth 2 == M 2 )                                       // dfs(2), depth = 2
    //        -> sb.append(arr[i])                                          // 출력 : 1 8
    //        -> return                                                     // dfs(1), depth = 1, i = 3
    //        -> chk[3] = true;                                             // chk[3] = true;
    //        -> for(j = 3 + 1 ; j <= N; j ++)
    //        -> chk[4] = false;                                            // chk[4] = false;
    //        -> i = 4                                                      // dfs(1), depth = 1, i = 4
    //        -> !chk[4] -> arr[1] = numArr[3] : 4++;                       // chk[4] == false, !chk[4]는 참으로 arr[1] = numArr[3], arr[1] = 9
    //                                                                          -> dfs(1 + 1) 로직 수행.
    // dfs(2) -> if( depth 2 == M 2 )                                       // dfs(2), depth = 2
    //        -> sb.append(arr[i])                                          // 출력 : 1 9
    //        -> return                                                     // return -> dfs(1), depth = 1, i = 4
    //                                                                      // j와 i 가 N 보다 커져 반복문 실행 x
    // dfs(1) 종료로 dfs(0)으로 리턴
    //          chk[1] = true;                                              // chk[1] = true;
    //          for (int j = 1 + 1; j <= N ; j++)
    //          chk[2 ~ 4] = false;                                         //  chk[2 ~ 4] = false;
    //          i++;                                                        // dfs(0), depth = 0, i = 2
    //          -> !chk[2] ? arr[0] = numArr[1] : 2++                       // chk[2] == false, !chk[2]는 참으로 arr[0] = numArr[1] 로 arr[0] = 7
    //                                                                          -> dfs( 0 + 1) 로직 수행
    // dfs(1) -> !chk[1] ? arr[1] = numArr[0] : 1++;                        // dfs(1), depth = 1, i = 1, chk[1] == true, !chk[1]는 거짓으로 i++
    //          !chk[2] ? arr[1] = numArr[1] : 2++                          // dfs(1), depth = 1, i = 2, chk[2] == false, !chk[2]는 참으로으로 arr[1] = 7
    //          chk[2] = true;                                              // chk[2] = true;
    //          for (int j = 2 + 1; j <= N ; j++)
    //          chk[3 ~ 4] = false;                                         //  chk[3 ~ 4] = false;
    // dfs(2) -> if( depth 2 == M 2 )                                       // dfs(2), depth = 2
    //        -> sb.append(arr[i])                                          // 출력 : 7 7
    //        -> return                                                     // dfs(1), depth = 1, i = 2
    //          ... 반복. ...
}

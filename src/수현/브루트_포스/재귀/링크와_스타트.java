package 수현.브루트_포스.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 링크와_스타트 {

    static int N, min;
    static boolean[] chk;
    static int[][] ability;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        chk = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int numberOfTeamMembers = 1; numberOfTeamMembers < N; numberOfTeamMembers++) { // numberOfTeamMembers 는 팀원 수.
            dfs(0, numberOfTeamMembers, 0);
        }
        System.out.println(min);
    }

    static void dfs(int count // 현재 선택된 팀원 수
            , int numberOfTeamMembers // 양팀의 모든 팀원 수
            , int start) {

        if (numberOfTeamMembers == count) { // 팀 구성이 완료되었을 때
            int val = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (chk[i] && chk[j]) { // i 와 j 가 true 로 선택됐다면 start 팀
                        val += ability[i][j];
                    } else if (!chk[i] && !chk[j]) { // i 와 j 가 false 로 선택하지 않았다면 link 팀
                        val -= ability[i][j];
                    }
                }
            }

            min = Math.min(min, Math.abs(val));
            return;
        }

        for (int i = start; i < N; i++) {
            if (!chk[i]) {
                chk[i] = true; // start 팀원 선택
                dfs(count + 1, numberOfTeamMembers , i + 1); // 현재 선택된 팀원 수를 늘림. 양팀의 모든 팀원 수는 그대로, i를 증가시켜 팀 능력치 순회 횟수를 줄임.
                chk[i] = false; // 선택 해제

            }
        }
    }

}

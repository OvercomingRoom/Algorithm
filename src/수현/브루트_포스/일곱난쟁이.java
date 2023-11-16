package 수현.브루트_포스;

import java.io.*;
import java.util.Arrays;

public class 일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 9 명을 저장.
        int[] dwarfArr = new int[9];
        // 9명의 키를 합산함.
        int sum = 0;

        // 값 입력 받기
        for (int i = 0; i < dwarfArr.length; i++) {
            int dwarf = Integer.parseInt(br.readLine());
            dwarfArr[i] = dwarf;
            sum += dwarf;
        }

        // 출력을 위해 정렬
        Arrays.sort(dwarfArr);

        // 일곱 난쟁이가 아닌 인덱스를 저장함.
        int isNotDwarf1 = 0;
        int isNotDwarf2 = 0;

        boolean is100;

        roof:
        for (int j = dwarfArr.length - 1; j >= 1; j--) {
            for (int i = dwarfArr.length - 2; i >= 0; i--) {
                if (j != i) {
                    // 9명의 키 합산에서 2명의 키를 뺐을 때 100 인지 확인.
                    is100 = sum - dwarfArr[i] - dwarfArr[j] == 100 ? true : false;
                    if (is100) {
                        isNotDwarf1 = i;
                        isNotDwarf2 = j;
                        break roof;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == isNotDwarf1 || i == isNotDwarf2) {
                continue;
            } else {
                bw.write(dwarfArr[i] + "\n");
            }
        }

        bw.flush();
    }
}

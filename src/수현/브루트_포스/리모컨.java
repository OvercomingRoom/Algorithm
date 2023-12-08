package 수현.브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 리모컨 {

    static boolean[] breakdownKeyArr = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetChannel = Integer.parseInt(br.readLine());

        int breakdownCount = Integer.parseInt(br.readLine());

        int keyCount;

        // 고장난 키가 없다면 타겟 채널의 숫자 길이를 keyCount로 함.
        if (breakdownCount == 0) {
            keyCount = String.valueOf(targetChannel).length();
        } else {

            String breakdownNumber = br.readLine();
            String[] split = breakdownNumber.split(" ");

            // 고장난 버튼 입력받기 (고장이라면 true)
            for (int i = 0; i < breakdownCount; i++) {
                breakdownKeyArr[Integer.parseInt(split[i])] = true;
            }

            int breakKeyChk = isBreakdown(targetChannel);

            // 타겟 채널까지 이동하기
            // ( - 키, + 키 , 고장나지 않은 0 ~ 9 까지의 숫자 버튼 사용 가능 )

            // 키 사용 횟수 구하기
            // 1. 고장나지 않은 키 이용해 목표 번호에 근접하기
            // 2. 이후 targetChannel (목표 번호) - currentChannel (현재 번호)하면 - 또는 + 이동 횟수를 찾을 수 있다.
            // 3. 또한 currentChannel 로 이동할 때 눌렀던 키도 카운팅 해줘야함.
            //      예를 들면 String.valueOf(currentChannel).length() 로 길이를 구하고 나온 값을 자릿수로?

            if (targetChannel == 100) { // 만약 타겟 채널이 100 이면 채널을 움직일 필요가 없음
                keyCount = 0;
            } else if (breakKeyChk != 0) {// 만약 키가 고장나지 않았다면, 타겟채널을 숫자키를 이용해 바로 이동 가능.
                keyCount = breakKeyChk;
            } else { // 만약 키가 고장났다면
                
                int minKey = Math.abs(targetChannel - 100); // 가장 많이 눌러야 하는 경우 (목표 체널까지 + 또는 -로 이동하는 경우.)
                
                for (int currentChannel = 0; currentChannel <= 600000; currentChannel++) {

                    int currentChannelKeyChk = isBreakdown(currentChannel);

                    if( currentChannelKeyChk > 0) {
                        int currentChannelCount = Math.abs(targetChannel - currentChannel) + currentChannelKeyChk;//  | 타겟 채널 - 현재 채널 | + i의 키 입력 길이
                        minKey = Math.min(minKey, currentChannelCount); // 현재 minKwy 와 비교함.
                    }
                }

                keyCount = minKey;
            }
        }

        System.out.println(keyCount);

    }

    private static int isBreakdown(int channel) {
        int count = 0;

        if (channel == 0) {
            return breakdownKeyArr[0] ? 0 : 1;
        }

        while (channel != 0) {
            int chkKey = channel % 10;
            if (breakdownKeyArr[chkKey]) {
                return 0; // 숫자 키가 고장났기 때문에 타겟 채널을 완성하지 못함.
            }
            count++;
            channel /= 10;
        }
        return count;
    }
}

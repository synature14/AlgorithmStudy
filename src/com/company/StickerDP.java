package com.company;/*
*   https://www.acmicpc.net/problem/9465
* */

import java.util.Scanner;
import static java.lang.Math.max;

public class StickerDP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        int[] answer = new int[testCase];
        int index = 0;

        while(testCase > 0) {
            int nSticker = scan.nextInt();
            int[][] sticker = new int[3][nSticker+1];       //행(1행부터 시작함),열

            for(int i=1; i<3; i++) {
                for(int j=1; j<=nSticker; j++) {
                    sticker[i][j] = scan.nextInt();
                }
            }
            answer[index] = maxSum(sticker, nSticker);
            testCase--;
            index++;
        }

        for(int each : answer) {
            System.out.println(each);
        }
    }

    private static int maxSum(int[][] sticker, int nSticker) {
        int[][] dp = new int[nSticker + 1][3];      // n열의 상태는 총 3가지 (0,0) (0,1), (1,0)
        dp[1][0] = 0;   // sticker 어느것도 떼지 않은 상태
        dp[1][1] = sticker[1][1];   // sticker (1,1)을 똈을경우
        dp[1][2] = sticker[2][1];   // sticker (1,2)를 뗐을경우

        for(int i=2; i<=nSticker; i++) {
            for(int row=0; row<3; row++) {
                if (row == 0) {     // 아무것도 떼지 않을 경우.
                    // 그전의 상태에선 (1)스티커 아무것도 안뗐거나, (2) 1행에 있는것을 뗐거나 (3) 2행에 있는것을 뗐거나
                    dp[i][row] = max(max( dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                }

                if (row == 1) {     // sticker 배열의 i열의 위(1행)를 떼는 경우
                    // max(아무것도떼지 않은 경우 + sticker 가중치, 스티커배열의 두번째 행에 있는것을 뗴고 + sticker 가중치)
                    dp[i][row] = max(dp[i-1][0] + sticker[1][i], dp[i-1][2] + sticker[1][i]);
                }

                if (row == 2) {     // sticker 배열의 i열의 아래(2행)를 뗴는 경우.
                    // 그전 상태에선 (1) 1행에 있는것을 뗐거나, (2) 아무것도 떼지 않았거나
                    dp[i][row] = max(dp[i-1][1] + sticker[2][i], dp[i-1][0] + sticker[2][i]);
                }
            }
        }

        return max( max(dp[nSticker][0], dp[nSticker][1]),  dp[nSticker][2]);

    }

}
